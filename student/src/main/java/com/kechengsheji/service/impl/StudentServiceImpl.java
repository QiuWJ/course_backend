package com.kechengsheji.service.impl;

import com.kechengsheji.dao.StudentMapper;
import com.kechengsheji.model.Student;
import com.kechengsheji.service.StudentService;
import com.kechengsheji.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: songshoubin
 * @date: 2019-06-21
 */
@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentDTO findById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public StudentDTO findByUsernameAndPass(String username, String password) {
        return studentMapper.findByUsernameAndPass(username,password);
    }

    @Override
    public StudentDTO findByUsername(String username) {
        return studentMapper.findByUsername(username);
    }

    @Override
    public int updateByPrimaryKeySelective(Student student) {
        return studentMapper.updateByPrimaryKeySelective(student);
    }
}
