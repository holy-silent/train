package com.chinaunicom.sms.service;

import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Course;

import java.util.List;

public interface CourseService {

    Course get(Integer id);

    TransDTO<Course> getCourseByPage(Integer pageNumber);

    int save(Course course);

    int remove(Integer id);

    int update(Course course);

}
