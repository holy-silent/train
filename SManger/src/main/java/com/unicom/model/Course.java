package com.unicom.model;


public class Course {
    private Integer id;

    private String name;

    private String reserved1;

    private Integer reserved2;
    public Course() {
    }

    public Course(Integer id,String name) {
        this.id=id;
        this.name = name;
    }


    public Course(Integer id, String name, String reserved1, Integer reserved2) {
        this.id = id;
        this.name = name;
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