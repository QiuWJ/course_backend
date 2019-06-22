package com.kechengsheji.service.dto;

import com.kechengsheji.model.Student;

/**
 * @author: songshoubin
 * @date: 2019-06-21
 */
public class StudentDTO extends Student {
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    //学院名称
    String deptName;
}
