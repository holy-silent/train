package com.chinaunicom.sms.service;

import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Student;

public interface StudentService {
	
	Student getStudentById(Integer id);

	TransDTO<Student> getStudents(Integer pageNumber);

	int save(Student student);

	int remove(Integer id);

	int update(Student student);

}
