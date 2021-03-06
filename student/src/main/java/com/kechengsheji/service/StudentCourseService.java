package com.kechengsheji.service;

import com.kechengsheji.model.Course;
import com.kechengsheji.service.dto.ManagerViewCourseDTO;
import com.kechengsheji.service.dto.StudentCourseDTO;

import java.util.List;

/**
 * 学生课程接口
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
public interface StudentCourseService {
    List<StudentCourseDTO> findByStudendId(Integer studentId,String courseName,String teacherName);

    List<ManagerViewCourseDTO> findcourses(String courseName, String teacherName);

    int deleteBycourseIdAndStudentId(Integer courseId,Integer studentId);

    int addStudentCourse(Integer studentId,Integer courseId);


}
