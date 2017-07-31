package com.unicom.controller;

import com.unicom.model.Course;
import com.unicom.model.Student;
import com.unicom.service.CourseService;
import com.unicom.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    @RequestMapping("/getCouList")
    public String getCouList(HttpServletRequest request) throws Exception {
        request.setCharacterEncoding("utf-8");

        ServletContext servletContext = request.getSession().getServletContext();
        int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
        //获得列表
        int currPage = Integer.parseInt(request.getParameter("currPage"));
        String couName = request.getParameter("couName");
        if(couName!=null)
            couName = new String(couName.getBytes("iso8859-1"),"UTF-8");

        List<Course> cous = courseService.getCouList(couName,currPage,page_size);

        //获得总行数
        String count = courseService.getTotalCount(couName);

        request.setAttribute("courses", cous);
        request.setAttribute("countN", count);
        request.setAttribute("couName", couName);
        return "courseList";
    }


    @RequestMapping("/getCouListPaging")
    @ResponseBody
    public List<Course> getCouListPaging(HttpServletRequest request,Model model)throws Exception{
        request.setCharacterEncoding("UTF-8");
        ServletContext servletContext = request.getSession().getServletContext();
        int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
        //获得列表
        int currPage = Integer.parseInt(request.getParameter("currPage"));

        String couName = request.getParameter("couName");
        couName= URLDecoder.decode(couName, "UTF-8");

        List<Course> list = courseService.getCouList(couName,currPage,page_size);

        //获得总行数
        String count = courseService.getTotalCount(couName);

        request.setAttribute("countN", count);

        return list;
    }


    @RequestMapping("/courseAdd")
    @ResponseBody
    public int courseAdd(HttpServletRequest request,Model model)throws Exception{
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");



        int flag = courseService.noIsExist(id);
        //如果学号不存在，执行插入操作
        if(flag==0){
            //插入入库
            Course cou = new Course(Integer.valueOf(id),name);
            courseService.courseAdd(cou);
            return 1;
        }else{
            return -1;
        }
    }


    @RequestMapping("/getCouById")
    public String getStuById(HttpServletRequest request) throws Exception {

        String id = request.getParameter("id");
        Student stu = courseService.getCouById(Integer.valueOf(id));

        request.setAttribute("cou", cou);
        return "courseUpdate";
    }

    @RequestMapping("/courseUpdate")
    @ResponseBody
    public int courseUpdate(HttpServletRequest request,Model model)throws Exception{
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String name = request.getParameter("name");

        Course stu = new Course(Integer.valueOf(id),name);
        //执行更新操作
        courseService.courseUpdate(cou);

        return 1;
    }


    @RequestMapping("/delCouList")
    @ResponseBody
    public int delCouList(HttpServletRequest request,Model model)throws Exception{
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        //执行更新操作
        courseService.delCouList(id);

        return 1;
    }
}
