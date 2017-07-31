package com.heitian.ssm.controller;

import com.heitian.ssm.model.Course;
import com.heitian.ssm.model.Student;
import com.heitian.ssm.service.CourseService;
import com.heitian.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Resource
    private CourseService courseService;

    @RequestMapping("/showCourses")
    public String showCourses(HttpServletRequest request, Model model){
        List<Course> courseList = courseService.getCourses();
        model.addAttribute("courseList",courseList);
        System.out.println("dddd");
        return "/course";
    }
    @RequestMapping("/searchOne")
    public String searchOne(HttpServletRequest request, Model model){
        String str_id = request.getParameter("oneCourseId");
        int id = Integer.parseInt(str_id);
        Course course = courseService.getById(id);
        model.addAttribute("course",course);
        return "/onecourse";
    }
    @RequestMapping("/addCourse")
    public String addCourse(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/plain;charset='utf-8'");
        Course course = new Course();
        String name = request.getParameter("name");

        System.out.println("In CourseController addCourse ---name = "+ name);

        course.setName(name);
        courseService.insert(course);
        return "redirect:/course/showCoursesPages";
    }

    @RequestMapping("/delCourse")
    public String delCourse(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        courseService.delete(id);
        return "redirect:/course/showCoursesPages";
    }

    @RequestMapping("/updateShow")
    public String updateShow(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Course course = courseService.getById(id);
        model.addAttribute("course",course);
        return "/upcourse";
    }

    @RequestMapping("/updateCourse")
    public String updateCourse(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Course course = courseService.getById(id);
        course.setName(name);
        courseService.update(course);
        return "redirect:/course/showCoursesPages";
    }

    @RequestMapping("/showCoursesPages")
    public String showCoursesPages(HttpServletRequest request, Model model){
        String str_currentPage=request.getParameter("currentPage");
        int currentPage = 1;
        if(str_currentPage!=null&&str_currentPage!=""){
            currentPage = Integer.parseInt(str_currentPage);
        }
        int count_every_page = 5;
        int sum_course = courseService.getCourses().size();
        int totalPages = (int)Math.ceil(sum_course*1.0/count_every_page);

        List<Course> courseList = courseService.getCoursesByPage((currentPage-1)*count_every_page,count_every_page);

//        System.out.println("In Student Controller studentList.size="+studentList.size());
        System.out.println("In Course Controller currentPage="+currentPage);
        System.out.println("In Course Controller totalPages="+totalPages);

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("courseList",courseList);

        return "/course";
    }
}
