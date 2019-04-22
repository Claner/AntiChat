package com.clanner.antichat.service;

import com.clanner.antichat.entity.po.AntiUserInfo;
import com.clanner.antichat.service.dao.UserInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 修改用户信息
     */
    @Transactional
    public boolean modifyUserInfo(AntiUserInfo userInfo) {
        userInfo.setUpdAt(new Timestamp(System.currentTimeMillis()));
        int row = userInfoDao.updateUserInfoById(userInfo);
        return row == 1;
    }

    /**
     * 获取用户信息
     */
    public AntiUserInfo getUserInfo(int userId) {
        AntiUserInfo userInfo = userInfoDao.findOneByUserId(userId);
        return userInfo;
    }
}
