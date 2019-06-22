package com.kechengsheji.dao;

import com.kechengsheji.model.Student;
import com.kechengsheji.service.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    StudentDTO selectByPrimaryKey(Integer id);

    StudentDTO findByUsernameAndPass(@Param("username") String username, @Param("password")String password);

    StudentDTO findByUsername(String username);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}