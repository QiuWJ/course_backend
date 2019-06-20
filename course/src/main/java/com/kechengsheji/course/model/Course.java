package com.kechengsheji.course.model;

public class Course {
    private int id;
    private String number;//课程编号
    private String name;
    private int credit;//学分
    private int studentNum;//学生数量
    private int teacherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Course(int id, String number, String name, int credit, int studentNum, int teacherId) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.credit = credit;
        this.studentNum = studentNum;
        this.teacherId = teacherId;
    }
}
