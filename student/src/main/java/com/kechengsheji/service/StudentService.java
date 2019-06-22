package com.kechengsheji.service;

import com.kechengsheji.model.Student;
import com.kechengsheji.service.dto.StudentDTO;

/**
 * 学生接口
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
public interface StudentService {

    StudentDTO findById(Integer id);

    StudentDTO findByUsernameAndPass(String username, String password);

    StudentDTO findByUsername(String username);

    int updateByPrimaryKeySelective(Student student);
}
