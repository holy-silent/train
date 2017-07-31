package com.unicom.service.impl;

import com.unicom.dao.ICourseDao;
import com.unicom.model.Course;
import com.unicom.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class CourseServiceImpl implements CourseService {

    @Resource
    private ICourseDao courseDao;

    public List<Course> getCouList(String couName,int currPage, int pagesize) {
        int startCount = (currPage-1)*pagesize;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("couName",couName);
        map.put("pstart",startCount);
        map.put("psize",pagesize);
        return courseDao.getCouList(map);
    }

    public String getTotalCount(String couName) {

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("couName",couName);
        return courseDao.getTotalCount(map);
    }

    public int noIsExist(String no) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("no",no);
        String rs = courseDao.noIsExist(map);
        return Integer.parseInt(rs);
    }

    public void courseAdd(Course cou) {
        courseDao.courseAdd(cou);
    }

    public Course getCouById(String id) {
        return courseDao.getCouById(id);
    }

    public void courseUpdate(Course stu) {
        courseDao.courseUpdate(stu);
    }

    public void delCouList(String id) {
        courseDao.delCouList(id);
    }

}
