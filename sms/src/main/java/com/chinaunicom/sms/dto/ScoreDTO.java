package com.chinaunicom.sms.dto;

import com.chinaunicom.sms.entity.Course;
import com.chinaunicom.sms.entity.Student;

public class ScoreDTO {

    private Student student;
    private Course course;
    private Integer score;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
                "student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }
}
