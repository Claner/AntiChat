package com.clanner.antichat.service.dao;

import com.clanner.antichat.entity.po.AntiUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Clanner
 */
@Repository
public interface UserInfoDao extends JpaRepository<AntiUserInfo, Long>, JpaSpecificationExecutor<AntiUserInfo> {

    AntiUserInfo findOneByUserId(int userId);

    @Modifying
    @Query(value = "update AntiUserInfo u " +
            "set u.username = case when :#{#userInfo.username} is null then u.username else :#{#userInfo.username} end, " +
            "u.gender = case when :#{#userInfo.gender} is null then u.gender else :#{#userInfo.gender} end," +
            "u.sign = case when :#{#userInfo.sign} is null then u.sign else :#{#userInfo.sign} end," +
            "u.location = case when :#{#userInfo.location} is null then u.location else :#{#userInfo.location} end, " +
            "u.avatarName = case when :#{#userInfo.avatarName} is null then u.avatarName else :#{#userInfo.avatarName} end," +
            "u.coverName = case when :#{#userInfo.coverName} is null then u.coverName else :#{#userInfo.coverName} end," +
            "u.musicName = case when :#{#userInfo.musicName} is null then u.musicName else :#{#userInfo.musicName} end," +
            "u.updAt = :#{#userInfo.updAt} where u.userId = :#{#userInfo.userId}")
    Integer updateUserInfoById(@Param("userInfo") AntiUserInfo userInfo);
}
