package com.chinaunicom.sms.dao;

import com.chinaunicom.sms.entity.Course;
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

    int count();

    List<Course> getCourseByPage(@Param("startNumber") Integer startNumber
            , @Param("pageSize") Integer pageSize);
}