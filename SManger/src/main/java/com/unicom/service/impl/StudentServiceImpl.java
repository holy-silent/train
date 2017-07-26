package com.unicom.service.impl;

import com.unicom.dao.IStudentDao;
import com.unicom.model.Student;
import com.unicom.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	/**
	 *
	 */
	@Resource
	private IStudentDao studentDao;



	public List<Student> getStuList() {
		return studentDao.getStuList();
	}



}
