package com.kechengsheji.dao;

import com.kechengsheji.model.CourseDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseDeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_dept
     *
     * @mbggenerated
     */
    //int deleteByPrimaryKey(Integer id);
    int deleteByCourseId(Integer courseId);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_dept
     *
     * @mbggenerated
     */
    int insert(CourseDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_dept
     *
     * @mbggenerated
     */
    int insertSelective(CourseDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_dept
     *
     * @mbggenerated
     */
    CourseDept selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_dept
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CourseDept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_dept
     *
     * @mbggenerated
     */
    int update(CourseDept record);
}