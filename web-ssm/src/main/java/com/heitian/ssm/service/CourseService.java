package com.heitian.ssm.service;

import com.heitian.ssm.model.Course;
import com.heitian.ssm.model.Student;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();
    List<Course> getCoursesByPage(Integer currentPage,Integer count_every_page);
    Course getById(Integer id);
    void insert(Course cou);
    void delete(Integer id);
    void update(Course cou);
}
