package com.chinaunicom.sms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chinaunicom.sms.dao.StudentMapper;
import com.chinaunicom.sms.entity.Student;
import com.chinaunicom.sms.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
	
	@Resource
	StudentMapper studentMapper;
	

	public Student getStudentById(int id) {
		return studentMapper.selectByPrimaryKey(id);
	}

}
