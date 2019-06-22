package com.kechengsheji.service;

import com.kechengsheji.model.Course;
import com.kechengsheji.service.dto.StudentCourseDTO;

import java.util.List;

/**
 * 学生课程接口
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
public interface StudentCourseService {
    List<StudentCourseDTO> findByStudendId(Integer studentId);
}
