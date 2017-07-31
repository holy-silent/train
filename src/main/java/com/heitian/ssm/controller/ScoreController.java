package com.heitian.ssm.controller;

import com.heitian.ssm.model.Course;
import com.heitian.ssm.model.Score;
import com.heitian.ssm.model.Student;
import com.heitian.ssm.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    @RequestMapping("/showScores")
    public String showScores(HttpServletRequest request, Model model){
        List<Score> scoresList = scoreService.getScores();
        model.addAttribute("scoresList",scoresList);
        return "/score";
    }

    @RequestMapping("/searchOne")
    public String searchOne(HttpServletRequest request, Model model){
        String str_id = request.getParameter("oneScoreId");
        int id = Integer.parseInt(str_id);
        Score score = scoreService.getById(id);
        model.addAttribute("score",score);
        return "/onescore";
    }

    @RequestMapping("/addScore")
    public String  addScore(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/plain;charset='utf-8'");
        Score score = new Score();
        int stuId = Integer.parseInt(request.getParameter("stuId"));
        int couId = Integer.parseInt(request.getParameter("couId"));
        int stu_score = Integer.parseInt(request.getParameter("score"));
        score.setStuId(stuId);
        score.setCouId(couId);
        score.setScore(stu_score);
        scoreService.insert(score);
        return "redirect:/score/showScoresPages";
    }

    @RequestMapping("/delScore")
    public String delScore(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        scoreService.delete(id);
        return "redirect:/score/showScoresPages";
    }

    @RequestMapping("/updateShow")
    public String updateShow(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        Score score = scoreService.getById(id);
        model.addAttribute("score",score);
        return "/updatescore";
    }

    @RequestMapping("/updateScore")
    public String updateScore(HttpServletRequest request, Model model){
        int id = Integer.parseInt(request.getParameter("id"));
        int stu_score = Integer.parseInt(request.getParameter("score"));
        Score score = scoreService.getById(id);
        score.setScore(stu_score);
        scoreService.update(score);
        return "redirect:/score/showScoresPages";
    }

    @RequestMapping("/showScoresPages")
    public String showScoresPages(HttpServletRequest request, Model model){
        String str_currentPage=request.getParameter("currentPage");
        int currentPage = 1;
        if(str_currentPage!=null&&str_currentPage!=""){
            currentPage = Integer.parseInt(str_currentPage);
        }
        int count_every_page = 5;
        int sum_score = scoreService.getScores().size();
        int totalPages = (int)Math.ceil(sum_score*1.0/count_every_page);

        List<Score> scoresList = scoreService.getScoresByPage((currentPage-1)*count_every_page,count_every_page);

//        System.out.println("In Student Controller studentList.size="+studentList.size());
//        System.out.println("In Student Controller totalPages="+totalPages);
//        System.out.println("In Student Controller sum_student="+sum_student);

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("scoresList",scoresList);

        return "/score";
    }

}
