package com.heitian.ssm.service;

import com.heitian.ssm.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    List<Student> getStudentsByPage(Integer currentPage,Integer count_every_page);
    Student getById(Integer id);
    void insert(Student stu);
    void delete(Integer id);
    void update(Student stu);
}
