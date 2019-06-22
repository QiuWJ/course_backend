package com.kechengsheji.service;

import com.kechengsheji.dto.CourseDeptDto;
import com.kechengsheji.model.Course;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CourseService {

    public int insert(CourseDeptDto courseDeptDto);

   /* public Course insertSelective(Course course);*/

    public void deleteById(int id);





    public  int  update(CourseDeptDto courseDeptDto);

   /* public  CourseDeptDto updateSelective(CourseDeptDto courseDeptDto);*/




}
