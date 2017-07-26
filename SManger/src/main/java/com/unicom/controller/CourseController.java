package com.unicom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import com.unicom.model.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unicom.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @RequestMapping("/getCouList")
    public String course(HttpServletRequest request) {
        String currPage = request.getParameter("currPage");
        List<Course> cous = courseService.getCouList();
        for(Course course:cous){
            System.out.println(course.getName());
        }
        request.setAttribute("courses", cous);
        return "courseList";
    }

}
