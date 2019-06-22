package com.kechengsheji.service.Impl;

import com.kechengsheji.dao.StudentCourseMapper;
import com.kechengsheji.exception.MyException;
import com.kechengsheji.service.StudentCourseService;
import com.kechengsheji.service.dto.ManagerViewCourseDTO;
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
    public List<ManagerViewCourseDTO> findcourses(String courseName, String teacherName) {
        return studentCourseMapper.findcourses(courseName,teacherName);
    }

    @Override
    public int deleteBycourseIdAndStudentId(Integer courseId, Integer studentId) {
        return studentCourseMapper.deleteBycourseIdAndStudentId(courseId,studentId);
    }

    @Override
    public int addStudentCourse(Integer studentId, Integer courseId) {
        //判断已选人数和课程人数
        ManagerViewCourseDTO managerViewCourseDTO = studentCourseMapper.findCourseCheckedNum(courseId);
        if(managerViewCourseDTO.getCheckedNum() >= managerViewCourseDTO.getStudentNum()){
            throw new MyException(401,"课程已满");
        }

        //判断学院限制
        int temp = studentCourseMapper.isCanSelecte(studentId,managerViewCourseDTO.getId());
        if(temp==0){
            throw new MyException(401,"该学院不能选");
        }

        return studentCourseMapper.insertStudentCourse(studentId,managerViewCourseDTO.getId());
    }
}
