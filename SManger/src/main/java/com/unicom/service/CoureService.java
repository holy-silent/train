package com.unicom.service;

import com.unicom.model.Coure;
import com.unicom.model.CoureSel;
import com.unicom.model.Student;

import java.util.List;
import java.util.Map;

public interface CoureService {

	/**
	 * 获取学生列表
	 * @param currPage 起始行
	 * @param pagesize 页面大小
	 * @return
	 */
	List<Coure> getStuList(String stuName, int currPage, int pagesize);
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
	 * @param
	 */
	void studentAdd(Coure cou);

	/**
	 * 根据id得到学生信息
	 * @param id
	 * @return
	 */
	Coure getStuById(String id);

	/**
	 * 更新学生信息
	 * @param stu
	 */
	void studentUpdate(Coure stu);

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

    /**
     * 退选课程
	 * @param stuId  学生id
	 * @param couId  课程id
	 */
	void delCoureSel(String stuId, String couId);

	/**
	 * 选课
	 * @param stuId  学生id
	 * @param couId  课程id
	 */
	void addCoureSel(String stuId, String couId);
}
