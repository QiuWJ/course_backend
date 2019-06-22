package com.kechengsheji.service.dto;

import com.kechengsheji.model.Course;

import java.util.List;

/**
 * 学生课程DTO  返回给前端使用
 *
 * @author: songshoubin
 * @date: 2019-06-21
 */
public class StudentCourseDTO extends Course {
    //课程老师
    private String teacherName;

    //已选课程人数
    private Integer checkedNum;

    //该课程是否已选
    private boolean isChecked;

    //学院限制
    private List<String> deptList;

    public List<String> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<String> deptList) {
        this.deptList = deptList;
    }

    public Integer getCheckedNum() {
        return checkedNum;
    }

    public void setCheckedNum(Integer checkedNum) {
        this.checkedNum = checkedNum;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
