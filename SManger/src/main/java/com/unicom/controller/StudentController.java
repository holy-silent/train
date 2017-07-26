package com.unicom.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import com.unicom.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unicom.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping("/getStuList")
	public String student(HttpServletRequest request) {
		String currPage = request.getParameter("currPage");
		List<Student> stus = studentService.getStuList();
		for(Student stu:stus){
			System.out.println(stu.getName());
		}
		request.setAttribute("students", stus);
		return "studentList";
	}

}
