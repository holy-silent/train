package com.chinaunicom.sms.controller;

import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Course;
import com.chinaunicom.sms.service.CourseService;
import com.chinaunicom.sms.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource
    CourseService courseService;

    @RequestMapping("/{pageNumber}")
    public String course(HttpServletRequest request, @PathVariable("pageNumber") Integer pageNumber) {
        TransDTO<Course> dto = courseService.getCourseByPage(pageNumber);
        List<Course> courses = dto.getList();
        PageUtil page = dto.getPage();
        request.setAttribute("courses", courses);
        request.setAttribute("page", page);
        return "course";
    }

    @RequestMapping("/insert")
    public String insert(@ModelAttribute("form") Course course) {
        courseService.save(course);
        return "redirect:/course/1";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute("form") Course course) {
        System.out.println(course);
        courseService.update(course);
        return "redirect:/course/1";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        courseService.remove(id);
        return "redirect:/course/1";
    }




}
