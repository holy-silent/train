package com.chinaunicom.sms.service.impl;

import com.chinaunicom.sms.dao.StudentMapper;
import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Student;
import com.chinaunicom.sms.service.StudentService;
import com.chinaunicom.sms.util.PageUtil;
import com.chinaunicom.sms.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;

	public Student getStudentById(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	public TransDTO<Student> getStudents(Integer pageNumber) {
		if (pageNumber == null) {
			pageNumber = 1;
		}
		PageUtil page = new PageUtil(pageNumber, Util.PAGE_SIZE, studentMapper.count());
		TransDTO<Student> dto = new TransDTO<Student>();
		List<Student> students = studentMapper.getStudentsByPage(page.getStartNumber(), Util.PAGE_SIZE);
		dto.setList(students);
		dto.setPage(page);
		return dto;
	}

	public int save(Student student) {
		return studentMapper.insert(student);
	}

	public int remove(Integer id){
		return studentMapper.deleteByPrimaryKey(id);
	}

	public int update(Student student) {
		return studentMapper.updateByPrimaryKeySelective(student);
	}

}
