package com.kechengsheji.service.Impl;

import com.kechengsheji.dao.ManagerMapper;
import com.kechengsheji.model.Manager;
import com.kechengsheji.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: songshoubin
 * @date: 2019-06-22
 */
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Manager findByUsername(String username) {
        return managerMapper.selectByUsername(username);
    }
}
