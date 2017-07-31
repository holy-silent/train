package com.heitian.ssm.service;

import com.heitian.ssm.model.Score;
import com.heitian.ssm.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreService {
    List<Score> getScores();
    List<Score> getScoresByPage(Integer currentPage,Integer count_every_page);
    Score getById(Integer id);
    void insert(Score sc);
    void delete(int id);
    void update(Score sc);
}
