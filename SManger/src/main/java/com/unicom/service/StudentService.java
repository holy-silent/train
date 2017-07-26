package com.unicom.service;

import com.unicom.model.Student;

import java.util.List;

public interface StudentService {

	/**
	 * 获取学生列表
	 * @param currPage 起始行
	 * @param pagesize 页面大小
	 * @return
	 */
	List<Student> getStuList(String stuName,int currPage,int pagesize);
	/**
	 * 获得总记录数
	 * @return
	 */
	String getTotalCount(String stuName);

	/**
	 * /**
	 * 检查学号是否存在
	 * @param no 学号
	 * @return
	 */
	int noIsExist(String no);

	/**
	 * 插入新学生信息
	 * @param stu
	 */
	void studentAdd(Student stu);

	/**
	 * 根据id得到学生信息
	 * @param id
	 * @return
	 */
	Student getStuById(String id);

	/**
	 * 更新学生信息
	 * @param stu
	 */
	void studentUpdate(Student stu);

	/**
	 * 删除一条学生信息
	 * @param id
	 */
	void delStuList(String id);
}
