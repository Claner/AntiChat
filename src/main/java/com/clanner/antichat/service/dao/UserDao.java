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

    @Query(value = "select a.token from AntiUser a where a.id = :id")
    String findTokenById(@Param("id") int userId);

    @Query(value = "select a.freeze from AntiUser a where a.account = :account")
    Integer findFreezeByAccount(@Param("account") String account);

    @Modifying
    @Query(value = "update AntiUser  a set a.freeze = (a.freeze + 1) where a.account = :account and (a.loginAt is null or a.logoutAt is not null)")
    void updateFreeze(@Param("account") String account);

    @Modifying
    @Query(value = "update AntiUser a set a.freeze = 0 where a.account = :account")
    void clearFreezeState(@Param("account") String account);

    @Modifying
    @Query(value = "update anti_user set token = null,logout_at = now() where id = :id", nativeQuery = true)
    void deleteTokenAndSetLogoutTime(@Param("id") int userId);

    @Modifying
    @Query(value = "update AntiUser a set a.shadow = :newShadow where a.id = :id and a.shadow = :oldShadow")
    Integer updateShadow(@Param("newShadow") String newShadow, @Param("id") int userId, @Param("oldShadow") String oldShadow);

    @Modifying
    @Query(value = "update AntiUser a set a.antiId = :antiId where a.id = :id")
    Integer updateAntiId(@Param("id") int userId, @Param("antiId") String antiId);

    @Query(value = "select a.modifyNum from AntiUser a where a.id = :id")
    Integer findModifyNumById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update AntiUser  a set a.modifyNum = (a.modifyNum - 1) where a.id = :id")
    void updateModifyNum(@Param("id") Integer id);
}
