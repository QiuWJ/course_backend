package com.kechengsheji.dao;

import com.kechengsheji.model.Manager;

public interface ManagerMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    Manager selectByUsername(String username);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
}