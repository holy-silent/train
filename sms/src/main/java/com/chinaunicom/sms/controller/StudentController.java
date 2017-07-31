package com.chinaunicom.sms.controller;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Size;

import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Student;
import com.chinaunicom.sms.util.PageUtil;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaunicom.sms.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping("/{pageNumber}")
	public String student(HttpServletRequest request, @PathVariable("pageNumber") Integer pageNumber) {
		TransDTO<Student> dto = studentService.getStudents(pageNumber);
		List<Student> students = dto.getList();
		PageUtil page = dto.getPage();
		request.setAttribute("students", students);
		request.setAttribute("page", page);
		return "student";
	}

	@RequestMapping("/insert")
	public String insert(@ModelAttribute("form") Student student) {
		System.out.println(student);
		studentService.save(student);
		return "redirect:/student/1";
	}

	@RequestMapping("/update")
	public String update(@ModelAttribute("form") Student student) {
		System.out.println(student);
		int c = studentService.update(student);
		System.out.println(c);
		return "redirect:/student/1";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		studentService.remove(id);
		return "redirect:/student/1";
	}


}
