package com.unicom.dao;

import com.unicom.model.Course;
import java.util.List;


public interface ICourseDao {
    /*int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
*/
    List<Course> getCouList();
}