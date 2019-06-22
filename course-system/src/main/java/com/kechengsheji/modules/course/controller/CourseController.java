package com.kechengsheji.modules.course.controller;


import com.kechengsheji.dto.CourseDeptDto;
import com.kechengsheji.model.Course;
import com.kechengsheji.service.CourseService;
import com.kechengsheji.utils.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(value="course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @GetMapping(value = "insert")
    public ResponseEntity insertCourse(@Validated @RequestBody  CourseDeptDto courseDeptDto){
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setData(courseService.insert(courseDeptDto));

        return  new ResponseEntity(resultUtil, HttpStatus.OK);
    }

    @GetMapping(value = "delete")
    public  ResponseEntity deleteCourse(@Validated @RequestBody Course course){
        Integer courseId=course.getId();
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "update")
    public  ResponseEntity  updateCourse(@Validated @RequestBody CourseDeptDto courseDeptDto){
            return new ResponseEntity(courseService.update(courseDeptDto),HttpStatus.OK);
    }

}
