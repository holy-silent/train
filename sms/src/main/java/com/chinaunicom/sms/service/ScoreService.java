package com.chinaunicom.sms.service;

import com.chinaunicom.sms.dto.ScoreDTO;
import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Course;
import com.chinaunicom.sms.entity.Score;
import com.chinaunicom.sms.entity.Student;

import java.util.List;

public interface ScoreService {

    Score get(Student student);

    Score get(Course course);

    Score get(Student student, Course course);

    TransDTO<ScoreDTO> getScoreByPages(Integer pageNumber);

    int save(Score score);

    int remove(Integer id);

    int update(Score score);

    List<ScoreDTO> getScoreDTOs();

}
