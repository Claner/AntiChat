package com.clanner.antichat.service.dao;

import com.clanner.antichat.entity.po.AntiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Clanner
 */
@Repository
public interface UserDao extends JpaRepository<AntiUser, Long> {

    @Query(value = "select a.pubSalt from AntiUser a where a.account = :account")
    String findPubSaltByAccount(@Param("account") String account);

    @Query(value = "select a.priSalt from AntiUser a where a.account = :account")
    String findPriSaltByAccount(@Param("account") String account);

    @Query(value = "select a.pubSalt from AntiUser a where a.id = :id")
    String findPubSaltById(@Param("id") int userId);

    @Query(value = "select a.priSalt from AntiUser a where a.id = :id")
    String findPriSaltById(@Param("id") int userId);

    @Query(value = "select a.id from AntiUser a where a.account = :account and a.shadow = :shadow")
    Integer findOneByAccountAndShadow(@Param("account") String account, @Param("shadow") String shadow);

    @Modifying
    @Query(value = "update anti_user  set token = :token, mv_device = :mvDevice, login_at = now() where id = :id", nativeQuery = true)
    void updateLoginUserInfo(@Param("token") String token, @Param("mvDevice") String mvDevice, @Param("id") int userId);

    @Query(value = "select u.token from AntiUser u where u.id = :id")
    String findTokenById(@Param("id") int userId);

    @Query(value = "select u.freeze from AntiUser u where u.account = :account")
    Integer findFreezeByAccount(@Param("account") String account);

    @Modifying
    @Query(value = "update AntiUser  u set u.freeze = (u.freeze + 1) where u.account = :account and (u.loginAt is null or u.logoutAt is not null)")
    void incrementAndSetFreeze(@Param("account") String account);

    @Modifying
    @Query(value = "update AntiUser  u set u.freeze = 0 where u.account = :account")
    void clearFreezeState(@Param("account") String account);

    @Modifying
    @Query(value = "update anti_user set token = null,logout_at = now() where id = :id", nativeQuery = true)
    void deleteTokenAndSetLogoutTime(@Param("id") int userId);

    @Modifying
    @Query(value = "update AntiUser u set u.shadow = :newShadow where u.id = :id and u.shadow = :oldShadow")
    Integer updateShadow(@Param("newShadow") String newShadow, @Param("id") int userId, @Param("oldShadow") String oldShadow);
}
