package com.kechengsheji.service.dto;

import com.kechengsheji.model.Course;

/**
 * 学生课程DTO  返回给前端使用
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
public class ManagerViewCourseDTO extends Course {
    //课程老师
    String teacherName;

    //已选课程人数
    Integer checkedNum;

    public Integer getCheckedNum() {
        return checkedNum;
    }

    public void setCheckedNum(Integer checkedNum) {
        this.checkedNum = checkedNum;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
