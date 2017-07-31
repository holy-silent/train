package com.heitian.ssm.controller;

import com.heitian.ssm.model.Student;
import com.heitian.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/showStudents")
    public String showStudents(HttpServletRequest request, Model model){
        List<Student> studentList = studentService.getStudents();
        model.addAttribute("studentList",studentList);
        return "/user";
    }

    @RequestMapping("/searchOne")
    public String searchOne(HttpServletRequest request, Model model){
        String str_id = request.getParameter("oneUserId");
        int id = Integer.parseInt(str_id);
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        return "/oneuser";
    }

    @RequestMapping("/addStudent")
    public String addStudent(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/plain;charset='utf-8'");
        Student student = new Student();
        String name = request.getParameter("name");
        String no = request.getParameter("no");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");
        String stuclass = request.getParameter("stuclass");
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);
        student.setNo(no);
        student.setStuclass(stuclass);
        studentService.insert(student);
        return "redirect:/student/showStudentsPages";
    }

    @RequestMapping("/delStudent")
    public String delStudent(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        return "redirect:/student/showStudentsPages";
    }

    @RequestMapping("/updateShow")
    public String updateShow(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getById(id);
        model.addAttribute("student",student);
        return "/upstudent";
    }

    @RequestMapping("/updateStudent")
    public String updateStudent(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String no = request.getParameter("no");
        int age = Integer.parseInt(request.getParameter("age"));
        String grade = request.getParameter("grade");
        String stuclass = request.getParameter("stuclass");
        Student student = studentService.getById(id);
        student.setName(name);
        student.setNo(no);
        student.setGrade(grade);
        student.setStuclass(stuclass);
        student.setAge(age);
        studentService.update(student);
        return "redirect:/student/showStudentsPages";
    }

    @RequestMapping("/showStudentsPages")
    public String showStudentsPages(HttpServletRequest request, Model model){
        String str_currentPage=request.getParameter("currentPage");
        int currentPage = 1;
        if(str_currentPage!=null&&str_currentPage!=""){
            currentPage = Integer.parseInt(str_currentPage);
        }
        int count_every_page = 5;
        int sum_student = studentService.getStudents().size();
        int totalPages = (int)Math.ceil(sum_student*1.0/count_every_page);

        List<Student> studentList = studentService.getStudentsByPage((currentPage-1)*count_every_page,count_every_page);

//        System.out.println("In Student Controller studentList.size="+studentList.size());
//        System.out.println("In Student Controller totalPages="+totalPages);
//        System.out.println("In Student Controller sum_student="+sum_student);

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("studentList",studentList);

        return "/user";
    }
}
