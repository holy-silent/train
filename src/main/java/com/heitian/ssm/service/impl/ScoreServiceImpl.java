package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.ScoreMapper;
import com.heitian.ssm.model.Score;
import com.heitian.ssm.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("scoreService")
@Transactional(rollbackFor = Exception.class)
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    public List<Score> getScores() {
        return scoreMapper.getScores();
    }

    public List<Score> getScoresByPage(Integer currentPage, Integer count_every_page) {
        return scoreMapper.getScoresByPage(currentPage,count_every_page);
    }

    public Score getById(Integer id) {
        return scoreMapper.selectByPrimaryKey(id);
    }

    public void insert(Score sc) {
        scoreMapper.insert(sc);
    }

    public void delete(int id) {
        scoreMapper.deleteByPrimaryKey(id);
    }

    public void update(Score sc) {
        scoreMapper.updateByPrimaryKey(sc);
    }
}
