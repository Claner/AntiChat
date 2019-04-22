package com.clanner.antichat.service;

import com.clanner.antichat.entity.po.AntiMomentDraft;
import com.clanner.antichat.entity.po.AntiUser;
import com.clanner.antichat.entity.po.AntiUserInfo;
import com.clanner.antichat.entity.po.AntiUserSetting;
import com.clanner.antichat.service.dao.DraftDao;
import com.clanner.antichat.service.dao.UserDao;
import com.clanner.antichat.service.dao.UserInfoDao;
import com.clanner.antichat.service.dao.UserSettingDao;
import com.clanner.antichat.utils.Constants;
import com.clanner.antichat.utils.JwtUtil;
import com.clanner.antichat.utils.ShadowUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @author Clanner
 * 用户服务
 */
@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserSettingDao userSettingDao;

    @Autowired
    private DraftDao draftDao;

    /**
     * 注册
     */
    @Transactional(rollbackFor = Exception.class)
    public AntiUser register(int userId, String account, String shadow, String username) {
        String pluSalt = userDao.findPubSaltByAccount(account);
        if (pluSalt == null) {
            //注册用户(后续添加其他操作)
            return registerUser(userId, account, shadow, username);
        }
        return null;
    }

    /**
     * 错误次数超过3次则冻结账号
     */
    public boolean freeze(String account) {
        Integer freeze = userDao.findFreezeByAccount(account);
        if (freeze == null) return false;
        return freeze >= 3;
    }

    /**
     * 记录登录失败次数
     */
    @Transactional
    public void recordLoginFail(String account) {
        //只有token为null时才记录登录失败的次数
        userDao.updateFreeze(account);
    }

    /**
     * 登录
     */
    public AntiUserInfo login(String account, String shadow) {
        String pubSalt = userDao.findPubSaltByAccount(account);
        String priSalt = userDao.findPriSaltByAccount(account);
        BigInteger decodePass = ShadowUtil.decrypt(new BigInteger(shadow), Base64.decodeInteger(priSalt.getBytes()), Base64.decodeInteger(pubSalt.getBytes()));
        Integer userId = userDao.findOneByAccountAndShadow(account, ShadowUtil.SHA1("" + decodePass));

        if (userId != null && userId != 0) {
            return userInfoDao.findOneByUserId(userId);
        }
        return null;
    }

    /**
     * 退出登录
     */
    @Transactional
    public void logout(Integer userId) {
        userDao.deleteTokenAndSetLogoutTime(userId);
    }

    /**
     * 生成token并设置登陆状态
     */
    @Transactional
    public String createAndSetLoginInfo(int userId, String account, String from) {
        String subject = userId + Constants.separator + account + Constants.separator + from;
        String token = JwtUtil.createJWT("" + userId, Constants.ISSUER, subject, "", Constants.EXP_MILLIS, Constants.LOGIN_KEY);
        userDao.clearFreezeState(account);
        userDao.updateLoginUserInfo(ShadowUtil.MD5(subject), from, userId);
        return token;
    }

    /**
     * 修改密码
     */
    @Transactional
    public boolean modifyPassword(int userId, String oldPassword, String newPassword) {
        String pubSalt = userDao.findPubSaltById(userId);
        String priSalt = userDao.findPriSaltById(userId);
        BigInteger pubKey = Base64.decodeInteger(pubSalt.getBytes());
        BigInteger priKey = Base64.decodeInteger(priSalt.getBytes());
        String oldShadow = ShadowUtil.SHA1("" + ShadowUtil.decrypt(new BigInteger(oldPassword), priKey, pubKey));
        String newShadow = ShadowUtil.SHA1(ShadowUtil.string2number(newPassword));
        return userDao.updateShadow(newShadow, userId, oldShadow) == 1;
    }

    /**
     * 修改anti_id
     */
    @Transactional
    public boolean modifyAntiId(int userId, String antiId) {
        Integer modifyNum = userDao.findModifyNumById(userId);
        if (modifyNum == null) return false;
        if (modifyNum > 0) {
            int row = userDao.updateAntiId(userId, antiId);
            if (row == 1) {
                userDao.updateModifyNum(userId);
                return true;
            }
        }
        return false;
    }

    /**
     * 获取剩余修改次数
     *
     * @param userId
     * @return
     */
    public Integer getModifyNum(int userId) {
        return userDao.findModifyNumById(userId);
    }

    private AntiUser registerUser(int userId, String account, String shadow, String username) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        AntiUser antiUser = initAntiUser(userId, account, shadow, now);
        userDao.save(antiUser);
        userInfoDao.save(new AntiUserInfo(userId, username, now));
        userSettingDao.save(new AntiUserSetting(userId, now));
        draftDao.save(new AntiMomentDraft(userId, now));
        return antiUser;
    }

    private AntiUser initAntiUser(int userId, String account, String shadow, Timestamp now) {
        long start = System.currentTimeMillis();
        BigInteger[] genKey = ShadowUtil.genKey();
        BigInteger pubKey = genKey[0];
        BigInteger priKey = genKey[1];
        String pubSalt = Base64.encodeBase64URLSafeString(pubKey.toByteArray());
        String priSalt = Base64.encodeBase64URLSafeString(priKey.toByteArray());
        logger.info("生成密钥对耗时" + (System.currentTimeMillis() - start) + "毫秒");
        AntiUser user = new AntiUser();
        user.setId(userId);
        user.setAccount(account);
        user.setShadow(ShadowUtil.SHA1(ShadowUtil.string2number(shadow)));
        user.setPubSalt(pubSalt);
        user.setPriSalt(priSalt);
        user.setMaxLimit((short) 200);
        user.setModifyNum((byte) 3);
        user.setAntiId("anti_" + account);
        user.setRegisterAt(now);
        return user;
    }
}
