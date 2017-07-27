package com.unicom.dao;

import com.unicom.model.Coure;
import com.unicom.model.CoureSel;
import com.unicom.model.StuScore;
import com.unicom.model.Student;

import java.util.List;
import java.util.Map;

public interface IScoreDao {
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
    List<StuScore> getStuList(Map<String, Object> map);

    /**
     * 获得总记录数
     * @return
     */
    String getTotalCount(Map<String, Object> map);

    /**
     * 检查学号是否存在
     * @param map 学号
     * @return
     */
    String noIsExist(Map<String, Object> map);

    /**
     * 插入新学生信息
     * @param stu
     */
    void studentAdd(StuScore stu);
    /**
     * 根据id得到学生信息
     * @return
     */
    StuScore getStuById(Map<String, Object> map);
    /**
     * 更新学生信息
     * @param stu
     */
    void studentUpdate(StuScore stu);
    /**
     * 删除一条学生信息
     */
    void delStuList(Map<String, Object> map);

    List<StuScore> getStuScore(String coureName);

    List<Coure> getCoureList();

    List<Student> getStuList2();


    //选课信息
    List<CoureSel> getCoureSelList(String id);


    /**
     * 退选课程
     * MAP： stuId  学生id
     *  couId  课程id
     */
    void delCoureSel(Map<String, Object> map);


    /**
     * 选课
     * MAP： stuId  学生id
     *  couId  课程id
     */
    void addCoureSel(Map<String, Object> map);



    List<StuScore> getGzq(String couId);
}