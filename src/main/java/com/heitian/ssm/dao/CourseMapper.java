package com.heitian.ssm.dao;

import com.heitian.ssm.model.Course;
import com.heitian.ssm.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> getCourses();
    List<Course> getCoursesByPage(@Param("currentPage") Integer currentPage, @Param("count_every_page") Integer count_every_page);
}