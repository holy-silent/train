package com.unicom.model;

public class StuScore {
    private String stuId;
    private String couId;
    private String stuName;
    private String score;

    public StuScore() {
    }

    public StuScore(String stuName, String score) {
        this.stuName = stuName;
        this.score = score;
    }

    public StuScore(String stuId, String couId, String stuName, String score) {
        this.stuId = stuId;
        this.couId = couId;
        this.stuName = stuName;
        this.score = score;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCouId() {
        return couId;
    }

    public void setCouId(String couId) {
        this.couId = couId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
