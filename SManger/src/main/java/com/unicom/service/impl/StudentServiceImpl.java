package com.unicom.service.impl;

import com.unicom.dao.IStudentDao;
import com.unicom.model.Student;
import com.unicom.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private IStudentDao studentDao;

	public List<Student> getStuList(String stuName,int currPage, int pagesize) {
		int startCount = (currPage-1)*pagesize;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stuName",stuName);
		map.put("pstart",startCount);
		map.put("psize",pagesize);
		return studentDao.getStuList(map);
	}

	public String getTotalCount(String stuName) {

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stuName",stuName);
		return studentDao.getTotalCount(map);
	}

	public int noIsExist(String no) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("no",no);
		String rs = studentDao.noIsExist(map);
		return Integer.parseInt(rs);
	}

	public void studentAdd(Student stu) {
		studentDao.studentAdd(stu);
	}

	public Student getStuById(String id) {
		return studentDao.getStuById(id);
	}

	public void studentUpdate(Student stu) {
		studentDao.studentUpdate(stu);
	}

	public void delStuList(String id) {
		studentDao.delStuList(id);
	}

}
