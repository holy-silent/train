package com.chinaunicom.sms.dao;

import com.chinaunicom.sms.entity.Score;
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

    Score getScoreByStudentId(Integer stuId);

    Score getScoreByCourseId(Integer couId);

    Score getScoreByStudentIdAndCourseId(@Param("stuId") Integer stuId, @Param("couId") Integer couId);

    List<Score> getScores();

    int count();

    List<Score> getScoresByPage(@Param("startNumber") Integer startNumber
            , @Param("pageSize") Integer pageSize);
}