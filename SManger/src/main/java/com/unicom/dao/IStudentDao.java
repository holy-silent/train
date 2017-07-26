package com.unicom.dao;

import com.unicom.model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    /*int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
*/

    /**
     * 获取学生列表
     * @param map 起始行  页面大小
     * @return
     */
    List<Student> getStuList(Map<String,Object> map);

    /**
     * 获得总记录数
     * @return
     */
    String getTotalCount(Map<String,Object> map);

    /**
     * 检查学号是否存在
     * @param map 学号
     * @return
     */
    String noIsExist(Map<String,Object> map);

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