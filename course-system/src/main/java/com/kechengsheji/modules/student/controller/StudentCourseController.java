package com.kechengsheji.modules.student.controller;

import com.kechengsheji.base.BaseController;
import com.kechengsheji.model.Course;
import com.kechengsheji.service.StudentCourseService;
import com.kechengsheji.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生课程Controller
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
@RestController
public class StudentCourseController extends BaseController {

    @Autowired
    StudentCourseService studentCourseService;
    /**
     * 查询选课情况,可以根据课程名或者角色名称进行筛选
     *
     * @return
     */
    @GetMapping(value = "/studentCourse")
    public ResponseEntity getStudentCourse(String courseName,String teacherName,Boolean is_superuser){
        ResultUtil result;

//        is_superuser = false;//默认学生登录
        if(is_superuser==true){//管理员登录
            result = new ResultUtil(200,studentCourseService.findcourses(courseName,teacherName));

        }
        else{
            //获取此登录会员id
            Integer id = getMemberId();
            result = new ResultUtil(200,studentCourseService.findByStudendId(id,courseName,teacherName));
        }

        return new ResponseEntity(result, HttpStatus.OK);
    }

    /**
     * 学生选课
     *
     * @param course
     * @return
     */
    @PostMapping(value = "/studentCourse")
    public ResponseEntity insertStudentCourse(@Validated @RequestBody Course course){
        Integer studentId = getMemberId();
        Integer courseId = course.getId();
        if(courseId == null)
            return new ResponseEntity(new ResultUtil(401,"课程信息不能为空"),HttpStatus.OK);
        ResultUtil result = new ResultUtil(200,studentCourseService.addStudentCourse(studentId,courseId));
        return new ResponseEntity(result,HttpStatus.OK);
    }

    /**
     * 学生退课
     *
     * @param course
     * @return
     */
    @DeleteMapping(value = "/studentCourse")
    public ResponseEntity deleteStudentCourse(@Validated @RequestBody Course course){
        Integer studentId = getMemberId();
        Integer courseId = course.getId();
        if(courseId == null){
            return new ResponseEntity(new ResultUtil(401,"课程信息不能为空"),HttpStatus.OK);
        }

        ResultUtil result = new ResultUtil(200,studentCourseService.deleteBycourseIdAndStudentId(courseId,studentId));
        return new ResponseEntity(result,HttpStatus.OK);

    }


}
