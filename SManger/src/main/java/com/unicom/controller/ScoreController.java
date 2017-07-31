package com.unicom.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.unicom.model.CoureSel;
import com.unicom.model.StuScore;
import com.unicom.model.Student;
import com.unicom.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
import org.json.JSONArray;
import org.json.JSONObject;
*/

@Controller
@RequestMapping("/score")
public class ScoreController {

	@Resource
	private ScoreService scoreService;

	@RequestMapping("/getStuList")
	public String getStuList(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		ServletContext servletContext = request.getSession().getServletContext();
		int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
		//获得列表
		int currPage = Integer.parseInt(request.getParameter("currPage"));

		String couId = request.getParameter("couId");
		String stuName = request.getParameter("stuName");

		if(stuName!=null)
			stuName = new String(stuName.getBytes("iso8859-1"),"UTF-8");

		List<StuScore> stus = scoreService.getStuList(couId,stuName,currPage,page_size);

		//获得总行数123456
		String count = scoreService.getTotalCount(couId,stuName);

		request.setAttribute("students", stus);
		request.setAttribute("countN", count);
		request.setAttribute("stuName", stuName);
		request.setAttribute("couId", couId);
		return "scoreList";
	}


	@RequestMapping("/getStuListPaging")
	@ResponseBody
	public List<StuScore> getStuListPaging(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		ServletContext servletContext = request.getSession().getServletContext();
		int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
		//获得列表
		int currPage = Integer.parseInt(request.getParameter("currPage"));

		String stuName = request.getParameter("stuName");
		stuName= URLDecoder.decode(stuName, "UTF-8");
		String couId = request.getParameter("couId");
		List<StuScore> list = scoreService.getStuList(couId,stuName,currPage,page_size);

		//获得总行数
		String count = scoreService.getTotalCount(couId,stuName);

		request.setAttribute("countN", count);

		return list;
	}


	@RequestMapping("/studentAdd")
	@ResponseBody
	public int studentAdd(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");

		String score = request.getParameter("score");


		StuScore stu = new StuScore(stuId,couId,"",score);
		scoreService.studentAdd(stu);
		return 1;
	}


	@RequestMapping("/getStuById")
	public String getStuById(HttpServletRequest request) throws Exception {

		String stuId = request.getParameter("stuId");

		String couId = request.getParameter("couId");

		StuScore stu = scoreService.getStuById(stuId,couId);

		request.setAttribute("stu", stu);
		return "scoreUpdate";
	}

	@RequestMapping("/studentUpdate")
	@ResponseBody
	public int studentUpdate(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");
		String name = request.getParameter("name");
		String score = request.getParameter("score");


		StuScore stu = new StuScore(stuId,couId,name,score);
		//执行更新操作
		scoreService.studentUpdate(stu);

		return 1;
	}


	@RequestMapping("/delStuList")
	@ResponseBody
	public int delStuList(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");
		//执行更新操作
		scoreService.delStuList(stuId,couId);

		return 1;
	}



	@RequestMapping("/scoreStatic")
	public String scoreStatic(HttpServletRequest request) throws Exception {

		List<Map<String, String>> list = scoreService.scoreStatic();
		String coureNameStr = scoreService.coureNameStr();
		String stuNameStr = scoreService.stuNameStr();

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
		/*request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		Student stu = scoreService.getStuById(id);
		List<CoureSel> list = scoreService.getCoureSelList(id);
		request.setAttribute("stu", stu);
		request.setAttribute("list", list);*/


		return "coureSel";
	}


	@RequestMapping("/delCoureSel")
	@ResponseBody
	public int delCoureSel(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");

		scoreService.delCoureSel(stuId,couId);
		return 1;
	}


	@RequestMapping("/addCoureSel")
	@ResponseBody
	public int addCoureSel(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");
		scoreService.addCoureSel(stuId,couId);
		return 1;
	}


	@RequestMapping("/getGzq")
	public String getGzq(HttpServletRequest request) throws Exception {
		String couId = request.getParameter("couId");
		List<StuScore> list = scoreService.getGzq(couId);

		request.setAttribute("list", list);
		request.setAttribute("couId", couId);

		return "scoreAdd";
	}
}
