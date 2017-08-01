package com.chinaunicom.sms.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinaunicom.sms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Resource
	private StudentService studentService;
	
	@RequestMapping("/first")
	public String toFirstPage() {
		System.out.println("This is first...");
		System.out.println("我再测     试一次");
		System.out.println("我再测试一次");
		System.out.println("我再测试一次");
		System.out.println(studentService.getStudentById(1).getName());
		return "first";
	}

}