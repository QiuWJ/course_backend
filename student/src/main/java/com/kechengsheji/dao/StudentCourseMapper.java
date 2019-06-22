package com.kechengsheji.dao;

import com.kechengsheji.model.StudentCourse;
import com.kechengsheji.service.dto.ManagerViewCourseDTO;
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

    List<ManagerViewCourseDTO> findcourses( @Param("courseName") String courseName, @Param("teacherName") String teacherName);

    ManagerViewCourseDTO findCourseCheckedNum(Integer courseId);

    int deleteByPrimaryKey(Integer id);

    int deleteBycourseIdAndStudentId(Integer courseId,Integer studentId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    int isCanSelecte(Integer studentId,Integer courseId);

    int insertStudentCourse(Integer studentId,Integer courseId);

    StudentCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}