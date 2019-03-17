package com.clanner.antichat.service.dao;

import com.clanner.antichat.entity.po.AntiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Clanner
 */
@Repository
public interface UserDao extends JpaRepository<AntiUser, Long> {

    @Query(value = "select a.pubSalt from AntiUser a where a.account = ?1")
    String findPubSaltByAccount(String account);

    @Query(value = "select a.priSalt from AntiUser a where a.account = ?1")
    String findPriSaltByAccount(String account);

    @Query(value = "select a.id from AntiUser a where a.account = ?1 and a.shadow = ?2")
    Integer findOneByAccountAndShadow(String account, String shadow);

    @Modifying
    @Query(value = "update AntiUser u set u.token = ?1, u.mvDevice = ?2 where u.id = ?3")
    void updateLoginUserInfo(String token, String mvDevice, int userId);
}
