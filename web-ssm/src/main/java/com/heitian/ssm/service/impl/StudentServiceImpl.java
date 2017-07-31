package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.StudentMapper;
import com.heitian.ssm.model.Student;
import com.heitian.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }

    public List<Student> getStudentsByPage(Integer currentPage,Integer count_every_page) {
        return studentMapper.getStudentsByPage(currentPage,count_every_page);
    }

    public Student getById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void insert(Student stu) {
        studentMapper.insert(stu);
    }

    public void delete(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public void update(Student stu) {
        studentMapper.updateByPrimaryKey(stu);
    }
}
