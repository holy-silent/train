package com.chinaunicom.sms.controller;

import java.nio.file.attribute.UserPrincipalLookupService;

import javax.annotation.Resource;

import org.apache.http.HttpRequest;
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
		System.out.println("三次哈哈哈...");
		System.out.println(studentService.getStudentById(1).getName());
		return "first";
	}

}
