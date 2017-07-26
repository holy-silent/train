package com.unicom.model;


public class Student {
    private Integer id;

    private String name;

    private String no;

    private Integer age;

    private String grade;

    private String stuClass;

    private String reserved1;

    private Integer reserved2;

    public Student() {
    }

    public Student(String name, String no, Integer age, String grade, String stuClass) {
        this.name = name;
        this.no = no;
        this.age = age;
        this.grade = grade;
        this.stuClass = stuClass;
    }

    public Student(Integer id, String name, String no, Integer age, String grade, String stuClass) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.age = age;
        this.grade = grade;
        this.stuClass = stuClass;
    }

    public Student(Integer id, String name, String no, Integer age, String grade, String stuClass, String reserved1, Integer reserved2) {
        this.id = id;
        this.name = name;
        this.no = no;
        this.age = age;
        this.grade = grade;
        this.stuClass = stuClass;
        this.reserved1 = reserved1;
        this.reserved2 = reserved2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public Integer getReserved2() {
        return reserved2;
    }

    public void setReserved2(Integer reserved2) {
        this.reserved2 = reserved2;
    }
}