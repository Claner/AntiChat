package com.clanner.antichat.service.dao;

import com.clanner.antichat.entity.po.AntiModuleId;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

/**
 * @author Clanner
 * 主键表
 */
@Repository
public interface AntiModuleDao extends JpaRepository<AntiModuleId, Long>, JpaSpecificationExecutor<AntiModuleId> {

    @Lock(value = LockModeType.WRITE)
    @Query(value = "select a.curId from AntiModuleId a where a.id =:id ")
    Integer findCurIdById(@Param("id") int id);

    @Modifying
    @Query(value = "update AntiModuleId a set a.curId = a.curId + 1 where a.id = :id ")
    void increaseCurIdById(@Param("id") int id);
}
