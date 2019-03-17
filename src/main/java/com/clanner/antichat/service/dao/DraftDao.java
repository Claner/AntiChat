package com.clanner.antichat.service.dao;

import com.clanner.antichat.entity.po.AntiMomentDraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Clanner
 */
@Repository
public interface DraftDao extends JpaRepository<AntiMomentDraft, Long>, JpaSpecificationExecutor<AntiMomentDraft> {
}
