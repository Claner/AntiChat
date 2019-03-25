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

    @Query(value = "select a.pubSalt from AntiUser a where a.id = ?1")
    String findPubSaltById(int userId);

    @Query(value = "select a.priSalt from AntiUser a where a.id = ?1")
    String findPriSaltById(int userId);

    @Query(value = "select a.id from AntiUser a where a.account = ?1 and a.shadow = ?2")
    Integer findOneByAccountAndShadow(String account, String shadow);

    @Modifying
    @Query(value = "update AntiUser u set u.token = ?1, u.mvDevice = ?2 where u.id = ?3")
    void updateLoginUserInfo(String token, String mvDevice, int userId);

    @Query(value = "select u.token from AntiUser u where u.id = ?1")
    String findTokenById(int userId);

    @Query(value = "select u.freeze from AntiUser u where u.account = ?1")
    Integer findFreezeByAccount(String account);

    @Modifying
    @Query(value = "update AntiUser  u set u.freeze = (u.freeze + 1) where u.account=?1 and u.token is null")
    void incrementAndSetFreeze(String account);

    @Modifying
    @Query(value = "update AntiUser  u set u.freeze = 0 where u.account=?1")
    void clearFreezeState(String account);

    @Modifying
    @Query(value = "update AntiUser u set u.token = null where u.id = ?1")
    void deleteTokenById(int userId);

    @Modifying
    @Query(value = "update AntiUser u set u.shadow = ?1 where u.id = ?2 and u.shadow = ?3")
    Integer updateShadow(String newShadow, int userId, String oldShadow);
}
