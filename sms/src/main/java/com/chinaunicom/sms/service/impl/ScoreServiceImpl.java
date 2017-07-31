package com.chinaunicom.sms.service.impl;

import com.chinaunicom.sms.dao.CourseMapper;
import com.chinaunicom.sms.dao.ScoreMapper;
import com.chinaunicom.sms.dao.StudentMapper;
import com.chinaunicom.sms.dto.ScoreDTO;
import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Course;
import com.chinaunicom.sms.entity.Score;
import com.chinaunicom.sms.entity.Student;
import com.chinaunicom.sms.service.ScoreService;
import com.chinaunicom.sms.util.PageUtil;
import com.chinaunicom.sms.util.Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{

    @Resource
    ScoreMapper scoreMapper;
    @Resource
    StudentMapper studentMapper;
    @Resource
    CourseMapper courseMapper;

    public Score get(Student student) {
        return scoreMapper.getScoreByStudentId(student.getId());
    }

    public Score get(Course course) {
        return scoreMapper.getScoreByCourseId(course.getId());
    }

    public Score get(Student student, Course course) {
        return scoreMapper.getScoreByStudentIdAndCourseId(student.getId(), course.getId());
    }

    public TransDTO<ScoreDTO> getScoreByPages(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        PageUtil page = new PageUtil(pageNumber, Util.PAGE_SIZE, scoreMapper.count());
        TransDTO<ScoreDTO> dto = new TransDTO<ScoreDTO>();

        List<ScoreDTO> scoreDTOs = new ArrayList<ScoreDTO>();
        List<Score> scores = scoreMapper.getScoresByPage(page.getStartNumber(), Util.PAGE_SIZE);
        Iterator<Score> iterator = scores.iterator();
        while(iterator.hasNext()) {
            Score score = iterator.next();
            Student student = studentMapper.selectByPrimaryKey(score.getStuId());
            Course course = courseMapper.selectByPrimaryKey(score.getCouId());
            ScoreDTO scoreDTO = new ScoreDTO();
            scoreDTO.setScore(score.getScore());
            scoreDTO.setStudent(student);
            scoreDTO.setCourse(course);
            scoreDTOs.add(scoreDTO);
        }
        dto.setList(scoreDTOs);
        dto.setPage(page);
        return dto;
    }

    public int save(Score score) {
        return scoreMapper.insert(score);
    }

    public int remove(Integer id) {
        return scoreMapper.deleteByPrimaryKey(id);
    }

    public int update(Score score) {
        return scoreMapper.updateByPrimaryKey(score);
    }

    public List<ScoreDTO> getScoreDTOs() {
        List<ScoreDTO> scoreDTOs = new ArrayList<ScoreDTO>();
        List<Score> scores = scoreMapper.getScores();
        Iterator<Score> iterator = scores.iterator();
        while(iterator.hasNext()) {
            Score score = iterator.next();
            Student student = studentMapper.selectByPrimaryKey(score.getStuId());
            Course course = courseMapper.selectByPrimaryKey(score.getCouId());
            ScoreDTO scoreDTO = new ScoreDTO();
            scoreDTO.setScore(score.getScore());
            scoreDTO.setStudent(student);
            scoreDTO.setCourse(course);
            scoreDTOs.add(scoreDTO);
        }
        return scoreDTOs;
    }

}
