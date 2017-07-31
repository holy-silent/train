package com.unicom.service;

import com.unicom.model.Course;

import java.util.List;

public interface CourseService {

    /**
     * 获取学生列表
     * @param currPage 起始行
     * @param pagesize 页面大小
     * @return
     */
    List<Course> getCouList(String couName,int currPage,int pagesize);
    /**
     * 获得总记录数
     * @return
     */
    String getTotalCount(String couName);

    /**
     * /**
     * 检查学号是否存在
     * @param id 课程号
     * @return
     */
    int noIsExist(String id);

    /**
     * 插入新课程信息
     * @param cou
     */
    void Add(Course cou);

    /**
     * 根据id得到学生信息
     * @param id
     * @return
     */
    Course getCouById(String id);

    /**
     * 更新学生信息
     * @param cou
     */
    void courseUpdate(Course cou);

    /**
     * 删除一条学生信息
     * @param id
     */
    void delCouList(String id);
}
