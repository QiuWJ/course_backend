package com.kechengsheji.service;

import com.kechengsheji.model.Manager;

/**
 * 管理员接口
 *
 * @author: songshoubin
 * @date: 2019-06-22
 */
public interface ManagerService {
    Manager findByUsername(String username);
}
