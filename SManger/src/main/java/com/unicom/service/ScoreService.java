package com.unicom.service;

import com.unicom.model.CoureSel;
import com.unicom.model.StuScore;
import com.unicom.model.Student;

import java.util.List;
import java.util.Map;

public interface ScoreService {

	/**
	 * 获取学生列表
	 * @param currPage 起始行
	 * @param pagesize 页面大小
	 * @return
	 */
	List<StuScore> getStuList(String couId,String stuName, int currPage, int pagesize);
	/**
	 * 获得总记录数
	 * @return
	 */
	String getTotalCount(String couId,String stuName);

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
	void studentAdd(StuScore stu);

	/**
	 * 根据id得到学生信息
	 * @return
	 */
	StuScore getStuById(String stuId,String couId);

	/**
	 * 更新学生信息
	 * @param stu
	 */
	void studentUpdate(StuScore stu);

	/**
	 * 删除一条学生信息
	 * @param id
	 */
	void delStuList(String stuId,String couId);

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


	List<StuScore> getGzq(String couId);
}
