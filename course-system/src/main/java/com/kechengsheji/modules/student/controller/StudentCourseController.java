package com.kechengsheji.modules.student.controller;

import com.kechengsheji.base.BaseController;
import com.kechengsheji.model.Course;
import com.kechengsheji.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class StudentCourseController extends BaseController {

    @Autowired
    StudentCourseService studentCourseService;
    /**
     * 查询选课情况,可以根据课程名或者角色名称进行筛选
     *
     * @return
     */
    @GetMapping(value = "/studentCourse")
    public ResponseEntity getStudentCourse(String courseName,String teacherName){
        //获取此登录会员id
        Integer id = getMemberId();
        return new ResponseEntity(studentCourseService.findByStudendId(id,courseName,teacherName), HttpStatus.OK);
    }

//    @DeleteMapping(value = "/studentCourse")


}
