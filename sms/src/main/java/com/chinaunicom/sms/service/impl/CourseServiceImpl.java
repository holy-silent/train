package com.chinaunicom.sms.service.impl;

import com.chinaunicom.sms.dao.CourseMapper;
import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Course;
import com.chinaunicom.sms.entity.Student;
import com.chinaunicom.sms.service.CourseService;
import com.chinaunicom.sms.util.PageUtil;
import com.chinaunicom.sms.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper courseMapper;

    public Course get(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public TransDTO<Course> getCourseByPage(Integer pageNumber){
        if (pageNumber == null) {
            pageNumber = 1;
        }
        PageUtil page = new PageUtil(pageNumber, Util.PAGE_SIZE, courseMapper.count());
        TransDTO<Course> dto = new TransDTO<Course>();
        List<Course> course = courseMapper.getCourseByPage(page.getStartNumber(), Util.PAGE_SIZE);
        dto.setList(course);
        dto.setPage(page);
        return dto;
    }

    public int save(Course course) {
        return courseMapper.insert(course);
    }

    public int remove(Integer id) {
        return courseMapper.deleteByPrimaryKey(id);
    }

    public int update(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

}
