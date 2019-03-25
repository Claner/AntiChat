package com.clanner.antichat.service;

import com.clanner.antichat.service.dao.AntiModuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Clanner
 */
@Service
public class ModuleIdService {

    @Autowired
    private AntiModuleDao antiModuleDao;

    @Transactional
    public Integer incrementAndGetUserId() {
        Integer userId = antiModuleDao.findCurIdById(2);
        antiModuleDao.increaseCurIdById(2);
        return userId;
    }
}
