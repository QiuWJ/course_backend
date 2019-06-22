package com.kechengsheji.dao;

import com.kechengsheji.model.StudentCourse;
import com.kechengsheji.service.dto.StudentCourseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StudentCourseMapper {

    /**
     * 根据学生id查看选课信息
     *
     * @param studentId
     * @return
     */
    List<StudentCourseDTO> findByStudendId(Integer studentId, @Param("courseName") String courseName, @Param("teacherName") String teacherName);

    int deleteByPrimaryKey(Integer id);

    int deleteBycourseIdAndStudentId(Integer courseId,Integer studentId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}