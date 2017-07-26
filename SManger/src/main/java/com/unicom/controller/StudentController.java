package com.unicom.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.unicom.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unicom.service.StudentService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Resource
	private StudentService studentService;

	@RequestMapping("/getStuList")
	public String getStuList(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		ServletContext servletContext = request.getSession().getServletContext();
		int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
		//获得列表
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		String stuName = request.getParameter("stuName");
		if(stuName!=null)
			stuName = new String(stuName.getBytes("iso8859-1"),"UTF-8");

		List<Student> stus = studentService.getStuList(stuName,currPage,page_size);

		//获得总行数
		String count = studentService.getTotalCount(stuName);

		request.setAttribute("students", stus);
		request.setAttribute("countN", count);
		request.setAttribute("stuName", stuName);
		return "studentList";
	}


	@RequestMapping("/getStuListPaging")
	@ResponseBody
	public List<Student> getStuListPaging(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		ServletContext servletContext = request.getSession().getServletContext();
		int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
		//获得列表
		int currPage = Integer.parseInt(request.getParameter("currPage"));

		String stuName = request.getParameter("stuName");
		stuName= URLDecoder.decode(stuName, "UTF-8");

		List<Student> list = studentService.getStuList(stuName,currPage,page_size);

		//获得总行数
		String count = studentService.getTotalCount(stuName);

		request.setAttribute("countN", count);

		return list;
	}


	@RequestMapping("/studentAdd")
	@ResponseBody
	public int studentAdd(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		Integer age =  Integer.valueOf(request.getParameter("age"));
		String grade = request.getParameter("grade");
		String clazz = request.getParameter("clazz");

		int flag = studentService.noIsExist(no);
		//如果学号不存在，执行插入操作
		if(flag==0){
			//插入入库
			Student stu = new Student(name,no,age,grade,clazz);
			studentService.studentAdd(stu);
			return 1;
		}else{
			return -1;
		}
	}


	@RequestMapping("/getStuById")
	public String getStuById(HttpServletRequest request) throws Exception {

		String id = request.getParameter("id");
		Student stu = studentService.getStuById(id);

		request.setAttribute("stu", stu);
		return "studentUpdate";
	}

	@RequestMapping("/studentUpdate")
	@ResponseBody
	public int studentUpdate(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		Integer id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String no = request.getParameter("no");
		Integer age =  Integer.valueOf(request.getParameter("age"));
		String grade = request.getParameter("grade");
		String clazz = request.getParameter("clazz");

		Student stu = new Student(id,name,no,age,grade,clazz);
		//执行更新操作
		studentService.studentUpdate(stu);

		return 1;
	}


	@RequestMapping("/delStuList")
	@ResponseBody
	public int delStuList(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		//执行更新操作
		studentService.delStuList(id);

		return 1;
	}
}
