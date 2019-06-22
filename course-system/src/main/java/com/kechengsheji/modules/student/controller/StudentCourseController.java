package com.kechengsheji.modules.student.controller;

import com.kechengsheji.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生课程Controller
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
@RestController
@RequestMapping(value = "api")
public class StudentCourseController {

    @Autowired
    StudentCourseService studentCourseService;
    /**
     * 查询选课情况
     *
     * @return
     */
    @GetMapping(value = "/studentCourse")
    public ResponseEntity getStudentCourse(){
        Integer studentId = 1;
        return new ResponseEntity(studentCourseService.findByStudendId(studentId), HttpStatus.OK);
    }


}
