package com.clanner.antichat.service.dao;

import com.clanner.antichat.entity.po.AntiUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Clanner
 */
@Repository
public interface UserInfoDao extends JpaRepository<AntiUserInfo, Long>, JpaSpecificationExecutor<AntiUserInfo> {

    AntiUserInfo findOneByUserId(int userId);
}
