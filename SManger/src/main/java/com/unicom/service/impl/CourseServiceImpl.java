package com.unicom.service.impl;

import com.unicom.dao.ICourseDao;
import com.unicom.model.Course;
import com.unicom.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private ICourseDao courseDao;



    public List<Course> getCouList() {
        return courseDao.getCouList();
    }



}
