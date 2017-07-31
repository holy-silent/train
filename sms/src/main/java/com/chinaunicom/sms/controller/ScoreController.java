package com.chinaunicom.sms.controller;

import com.chinaunicom.sms.dto.ScoreDTO;
import com.chinaunicom.sms.dto.TransDTO;
import com.chinaunicom.sms.entity.Score;
import com.chinaunicom.sms.service.ScoreService;
import com.chinaunicom.sms.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/score")
public class ScoreController {

    @Resource
    ScoreService scoreService;

    @RequestMapping("/{pageNumber}")
    public String score(HttpServletRequest request, @PathVariable("pageNumber") Integer pageNumber) {
        TransDTO<ScoreDTO> dto = scoreService.getScoreByPages(pageNumber);
        List<ScoreDTO> scoreDTOs = dto.getList();
        PageUtil page = dto.getPage();
        request.setAttribute("scoreDTOs", scoreDTOs);
        request.setAttribute("page", page);
        return "score";
    }

}
