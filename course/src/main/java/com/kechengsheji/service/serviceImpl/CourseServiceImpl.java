package com.kechengsheji.service.serviceImpl;

import com.kechengsheji.dao.CourseDeptMapper;
import com.kechengsheji.dao.CourseMapper;
import com.kechengsheji.dao.TeacherMapper;
import com.kechengsheji.dto.CourseDeptDto;
import com.kechengsheji.model.Course;
import com.kechengsheji.model.CourseDept;
import com.kechengsheji.model.Teacher;
import com.kechengsheji.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private CourseDeptMapper courseDeptMapper;

    @Resource
    private TeacherMapper teacherMapper;

   /* @Override
    public Course insertSelective(Course course) {
        return 0;
    }*/

    @Override
    public CourseDeptDto insert(CourseDeptDto courseDeptDto) {
        Course course=new Course();
        course.setNumber(courseDeptDto.getNumber());
        course.setName(courseDeptDto.getName());
        course.setCredit(courseDeptDto.getCredit());
        course.setStudentNum(courseDeptDto.getStudentNum());

        //根据老师名称查询老师id
        int id=teacherMapper.queryIdByName(courseDeptDto.getTeacherName());
        course.setTeacherId(id);

        int insertCount=courseMapper.insert(course);

        List<Integer> dept_id= courseDeptDto.getDeptId();
        for (Integer i:dept_id){
            CourseDept courseDept=new CourseDept();
            courseDept.setCourseId(course.getId());
            courseDept.setDeptId(i);
            courseDeptMapper.insert(courseDept);
        }



        return courseDeptDto;
    }

    /*@Override
    public int insertSelective(Course course) {
        return 0;
    }*/



    @Override
    public void deleteById(int id) {
        courseMapper.deleteByPrimaryKey(id);
        courseDeptMapper.deleteByCourseId(id);

    }


   @Override
    public CourseDeptDto update(CourseDeptDto courseDeptDto) {
       Course course=new Course();
       course.setId(courseDeptDto.getId());
       course.setNumber(courseDeptDto.getNumber());
       course.setName(courseDeptDto.getName());
       course.setCredit(courseDeptDto.getCredit());
       course.setStudentNum(courseDeptDto.getStudentNum());

       //根据老师名称查询老师id
       int id=teacherMapper.queryIdByName(courseDeptDto.getTeacherName());
       course.setTeacherId(id);

       int updateCount= courseMapper.update(course);

       CourseDept courseDept=new CourseDept();
       List<Integer> dept_id= courseDeptDto.getDeptId();
       courseDept.setCourseId(courseDeptDto.getId());
       for (Integer i:dept_id){
           courseDept.setDeptId(i);
           courseDeptMapper.update(courseDept);
       }


        return courseDeptDto;
    }

   /* @Override
    public CourseDeptDto updateSelective(CourseDeptDto courseDeptDto) {
        return 0;
    }*/
}
