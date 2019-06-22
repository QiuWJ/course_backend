package com.kechengsheji.modules.student.controller;

import com.kechengsheji.base.BaseController;
import com.kechengsheji.model.Student;
import com.kechengsheji.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学生Controller
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */

@RestController
public class StudentController extends BaseController {
    @Autowired
    StudentService studentService;

    /**
     * 根据id查看个人信息
     *
     * @return
     */
    @GetMapping(value = "/students")
    public ResponseEntity getStudent(){
        return new ResponseEntity(studentService.findById(1), HttpStatus.OK);

    }

    /**
     * 用户名密码登录
     *
     * @param student
     * @return
     */
    @PostMapping(value = "/students")
    public ResponseEntity getStudentByUsernameAndPass(@Validated @RequestBody Student student){
        String username = student.getUsername();
        String password = student.getPassword();
        System.out.println(username);
        System.out.println(password);
        return new ResponseEntity(studentService.findByUsernameAndPass(username,password), HttpStatus.OK);

    }

    /**
     * 修改用户信息，包括修改密码
     *
     * @param student
     * @return
     */
    @PutMapping(value = "/students")
    public ResponseEntity updateStudent(@Validated @RequestBody Student student){
        Integer id = getMemberId();
        student.setId(id);//当前登录id
        return new ResponseEntity(studentService.updateByPrimaryKeySelective(student),HttpStatus.OK);
    }

}
