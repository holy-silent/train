package com.unicom.service;

import com.unicom.model.CoureSel;
import com.unicom.model.Student;

import java.util.List;
import java.util.Map;

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

	//List<Map<String,List<Map<String,String>>>> scoreStatic();
	public  List<Map<String, String>> scoreStatic();
	String coureNameStr();

	String stuNameStr();


	//选课信息

	List<CoureSel> getCoureSelList(String id);


	void delCoureSel(String stuId,String couId);


	void addCoureSel(String stuId,String couId);
}
