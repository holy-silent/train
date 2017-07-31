package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.CourseMapper;
import com.heitian.ssm.model.Course;
import com.heitian.ssm.model.Student;
import com.heitian.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("courseService")
@Transactional(rollbackFor = Exception.class)
public class CourseImpl implements CourseService{
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> getCourses() {
        return courseMapper.getCourses();
    }

    public List<Course> getCoursesByPage(Integer currentPage,Integer count_every_page) {
        return courseMapper.getCoursesByPage(currentPage,count_every_page);
    }

    public Course getById(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public void insert(Course cou) {
        courseMapper.insert(cou);
    }

    public void delete(Integer id) {
        courseMapper.deleteByPrimaryKey(id);
    }

    public void update(Course cou) {
        courseMapper.updateByPrimaryKey(cou);
    }
}
