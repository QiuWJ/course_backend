package com.kechengsheji.dto;

import com.kechengsheji.model.Course;
import com.kechengsheji.model.Dept;

import java.util.List;

public class CourseDeptDto extends Course {
    private Integer id;

    private String number;

    private String name;

    private Integer credit;

    private Integer studentNum;


    private Integer teacherId;

    private String teacherName;

    private List<Integer>  deptId;

    private List<String> deptName;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getCredit() {
        return credit;
    }

    @Override
    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public Integer getStudentNum() {
        return studentNum;
    }

    @Override
    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public Integer getTeacherId() {
        return teacherId;
    }

    @Override
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public List<Integer> getDeptId() {
        return deptId;
    }

    public void setDeptId(List<Integer> deptId) {
        this.deptId = deptId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<String> getDeptName() {
        return deptName;
    }

    public void setDeptName(List<String> deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "CourseDeptDto{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", studentNum=" + studentNum +
                ", teacherId=" + teacherId +
                ", deptId=" + deptId +
                '}';
    }
}
