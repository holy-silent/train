package com.heitian.ssm.dao;

import com.heitian.ssm.model.Score;
import com.heitian.ssm.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> getScores();

    List<Score> getScoresByPage(@Param("currentPage") Integer currentPage, @Param("count_every_page") Integer count_every_page);
}