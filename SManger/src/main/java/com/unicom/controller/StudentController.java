package com.unicom.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


/*
import org.json.JSONArray;
import org.json.JSONObject;
*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.unicom.model.CoureSel;
import com.unicom.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unicom.service.StudentService;
import org.springframework.web.bind.annotation.ResponseBody;

import static javafx.scene.input.KeyCode.T;

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
		//学生列表
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



	@RequestMapping("/scoreStatic")
	public String scoreStatic(HttpServletRequest request) throws Exception {

		List<Map<String, String>> list = studentService.scoreStatic();
		String coureNameStr = studentService.coureNameStr();
		String stuNameStr = studentService.stuNameStr();

		//System.out.println(coureNameStr+"---"+stuNameStr);


		//JSONArray json = new JSONArray();
		/*for(Map<String, List<Map<String, String>>> m:list){
			JSONObject jo = new JSONObject();
			String[] split = coureNameStr.split(",");
			for(String s:split){
				List<Map<String, String>> list1 = m.get(s);
				jo.put("rowname",s);
				for(Map<String, String> map:list1){
					String[] split2 = stuNameStr.split(",");
					for(String stuName:split){
						String score = map.get(stuName);
						jo.put(stuName,score);
					}
				}
			}
			json.put(jo);
		}*/
		String json = JSON.toJSONString(list);
		JSONArray array = JSON.parseArray(json);

		String[] split = null;
		int len=0;
		List<String[]> l = new ArrayList<String[]>();
		for(int i=0;i<array.size();i++){
			//System.out.println(array.get(i).toString());
			//{"rowname":"数学","小强":"86","小明":"89","张明":"90","李四":"55","赵五":"94"}
			String s = array.get(i).toString();
			s = s.substring(1,s.length()-1);
			String[] split2 = s.split(",");
			l.add(split2);
			if (split2.length>len){
				len = split2.length;
				split=split2;
			}
		}

		String str = "";
		for(int i=0;i<split.length;i++){
			String s = split[i];
			//"rowname":"数学"
			s = s.substring(0,s.indexOf(":"));
			str = str +s+",";
		}
		System.out.println(str);
		//"rowname,"小强,"小明,"张明,"李四,"赵五,
		str=str.substring(str.indexOf(",")+1,str.lastIndexOf(","));
		str = str.replace("\"","");
		System.out.println(str);
		System.out.println(json);
		request.setAttribute("jsonStr", json);
		request.setAttribute("coureNameStr", coureNameStr);
		request.setAttribute("stuNameStr", str);

		return "scoreStatic";
	}




	@RequestMapping("/getCoureSelList")
	public String getCoureSelList(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		Student stu = studentService.getStuById(id);
		List<CoureSel> list = studentService.getCoureSelList(id);
		request.setAttribute("stu", stu);
		request.setAttribute("list", list);


		return "coureSel";
	}


	@RequestMapping("/delCoureSel")
	@ResponseBody
	public int delCoureSel(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");

		studentService.delCoureSel(stuId,couId);
		return 1;
	}


	@RequestMapping("/addCoureSel")
	@ResponseBody
	public int addCoureSel(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");
		studentService.addCoureSel(stuId,couId);
		return 1;
	}

}
