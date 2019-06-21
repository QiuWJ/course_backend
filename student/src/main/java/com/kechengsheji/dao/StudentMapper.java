package com.kechengsheji.dao;

import com.kechengsheji.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student findByUsernameAndPass(@Param("username") String username, @Param("password")String password);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}