package com.kechengsheji.service.serviceImpl;

import com.kechengsheji.dao.CourseDeptMapper;
import com.kechengsheji.dao.CourseMapper;
import com.kechengsheji.dao.DeptMapper;
import com.kechengsheji.dao.TeacherMapper;
import com.kechengsheji.dto.CourseDeptDto;
import com.kechengsheji.model.Course;
import com.kechengsheji.model.CourseDept;
import com.kechengsheji.model.Dept;
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

    @Resource
    private DeptMapper deptMapper;

   /* @Override
    public Course insertSelective(Course course) {
        return 0;
    }*/

    @Override
    public int insert(CourseDeptDto courseDeptDto) {
        Course course=new Course();
        course.setNumber(courseDeptDto.getNumber());
        course.setName(courseDeptDto.getName());
        course.setCredit(courseDeptDto.getCredit());
        course.setStudentNum(courseDeptDto.getStudentNum());

        //根据老师名称查询老师id
        int id=teacherMapper.queryByName(courseDeptDto.getTeacherName()).getId();
        course.setTeacherId(id);

         int effectNum=courseMapper.insert(course);

       List<String> dept_name=courseDeptDto.getDeptName();
        for (String i:dept_name){
            CourseDept courseDept=new CourseDept();
            courseDept.setCourseId(courseMapper.queryByNumber(courseDeptDto.getName()).getId());
            //根据学院名称查找学院id
            courseDept.setDeptId(deptMapper.selectByName(i).getId());
            courseDeptMapper.insert(courseDept);
        }


        return effectNum;
    }

    /*@Override
    public int insertSelective(Course course) {
        return 0;
    }*/



    @Override
    public void deleteById(int id) {
        System.out.println("邱文劲好帅");
        courseMapper.deleteByPrimaryKey(id);
        System.out.println("邱文劲好丑");
        courseDeptMapper.deleteByCourseId(id);
        System.out.println("qwjqwj");
    }


   @Override
    public int update(CourseDeptDto courseDeptDto) {
       Course course=new Course();
       course.setId(courseDeptDto.getId());
       course.setNumber(courseDeptDto.getNumber());
       course.setName(courseDeptDto.getName());
       course.setCredit(courseDeptDto.getCredit());
       course.setStudentNum(courseDeptDto.getStudentNum());

       //根据老师名称查询老师id
       int id=teacherMapper.queryByName(courseDeptDto.getTeacherName()).getId();
       course.setTeacherId(id);

       int effectCount= courseMapper.update(course);

       CourseDept courseDept=new CourseDept();
       //根据前端传过来的deptName更新course_dept表
       List<String> dept_name=courseDeptDto.getDeptName();
         for (String i:dept_name){

           courseDept.setCourseId(courseMapper.queryByNumber(courseDeptDto.getName()).getId());
           //根据学院名称查找学院id
           courseDept.setDeptId(deptMapper.selectByName(i).getId());
           courseDeptMapper.insert(courseDept);
       }


        return effectCount;
    }

   /* @Override
    public CourseDeptDto updateSelective(CourseDeptDto courseDeptDto) {
        return 0;
    }*/
}
