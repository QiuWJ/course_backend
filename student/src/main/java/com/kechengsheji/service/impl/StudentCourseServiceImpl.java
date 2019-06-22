package com.kechengsheji.service.Impl;

import com.kechengsheji.dao.StudentCourseMapper;
import com.kechengsheji.service.StudentCourseService;
import com.kechengsheji.service.dto.StudentCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生课程接口实现类
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    StudentCourseMapper studentCourseMapper;

    @Override
    public List<StudentCourseDTO> findByStudendId(Integer studentId,String courseName,String teacherName) {
        return studentCourseMapper.findByStudendId(studentId,courseName,teacherName);
    }

    @Override
    public int deleteBycourseIdAndStudentId(Integer courseId, Integer studentId) {
        return studentCourseMapper.deleteBycourseIdAndStudentId(courseId,studentId);
    }
}
