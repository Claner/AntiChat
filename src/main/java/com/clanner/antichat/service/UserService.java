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

    @Transactional(rollbackFor = Exception.class)
    public AntiUser register(int userId, String account, String shadow, String username) {
        String pluSalt = userDao.findPubSaltByAccount(account);
        if (pluSalt == null) {
            //注册用户(后续添加其他操作)
            AntiUser antiUser = registerUser(userId, account, shadow, username);
            return antiUser;
        }
        return null;
    }

    public AntiUserInfo login(String account, String shadow) {
        String pubSalt = userDao.findPubSaltByAccount(account);
        String priSalt = userDao.findPriSaltByAccount(account);
        BigInteger pubKey = Base64.decodeInteger(pubSalt.getBytes());
        BigInteger priKey = Base64.decodeInteger(priSalt.getBytes());
        BigInteger decodePass = ShadowUtil.decrypt(new BigInteger(shadow), priKey, pubKey);
        Integer userId = userDao.findOneByAccountAndShadow(account, ShadowUtil.SHA1("" + decodePass));

        if (userId != null && userId != 0) {
            return userInfoDao.findOneByUserId(userId);
        }
        return null;
    }

    @Transactional
    public String createAndSetLoginInfo(int userId, String account, String from) {
        String subject = userId + Constants.separator + account + Constants.separator + from;
        System.out.println(subject);
        System.out.println(ShadowUtil.MD5(subject));
        String token = JwtUtil.createJWT("" + userId,
                Constants.ISSUER, subject, "", Constants.EXP_MILLIS, Constants.LOGIN_KEY);
        userDao.updateLoginUserInfo(ShadowUtil.MD5(subject), from, userId);
        return token;
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
        logger.info("获取密钥对耗时" + (System.currentTimeMillis() - start) + "毫秒");
        BigInteger pubKey = genKey[0];
        BigInteger priKey = genKey[1];
        String pubSalt = Base64.encodeBase64URLSafeString(pubKey.toByteArray());
        String priSalt = Base64.encodeBase64URLSafeString(priKey.toByteArray());
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
