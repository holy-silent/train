package com.unicom.controller;
import java.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.unicom.model.Coure;
import com.unicom.model.CoureSel;
import com.unicom.model.Student;
import com.unicom.service.CoureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

/*
import org.json.JSONArray;
import org.json.JSONObject;
*/

@Controller
@RequestMapping("/coure")
public class CoureController {

	@Resource
	private CoureService coureService;

	@RequestMapping("/getCoureList")
	public String getCoureList(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		ServletContext servletContext = request.getSession().getServletContext();
		int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
		//获得列表
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		String stuName = request.getParameter("stuName");
		if(stuName!=null)
			stuName = new String(stuName.getBytes("iso8859-1"),"UTF-8");

		List<Coure> cou = coureService.getStuList(stuName,currPage,page_size);

		//获得总行数
		String count = coureService.getTotalCount(stuName);

		request.setAttribute("coures", cou);
		request.setAttribute("countN", count);
		request.setAttribute("stuName", stuName);
		return "coureList";
	}


	@RequestMapping("/getStuListPaging")
	@ResponseBody
	public List<Coure> getStuListPaging(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		ServletContext servletContext = request.getSession().getServletContext();
		int page_size = Integer.parseInt(servletContext.getInitParameter("pagesize"));
		//获得列表
		int currPage = Integer.parseInt(request.getParameter("currPage"));

		String stuName = request.getParameter("stuName");
		stuName= URLDecoder.decode(stuName, "UTF-8");

		List<Coure> list = coureService.getStuList(stuName,currPage,page_size);

		//获得总行数
		String count = coureService.getTotalCount(stuName);

		request.setAttribute("countN", count);

		return list;
	}


	@RequestMapping("/coureAdd")
	@ResponseBody
	public int coureAdd(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");


		int flag = coureService.noIsExist(name);
		//如果学号不存在，执行插入操作
		if(flag==0){
			//插入入库
			Coure cou = new Coure(name);
			coureService.studentAdd(cou);
			return 1;
		}else{
			return -1;
		}
	}


	@RequestMapping("/getStuById")
	public String getStuById(HttpServletRequest request) throws Exception {

		String id = request.getParameter("id");
		Coure stu = coureService.getStuById(id);

		request.setAttribute("cou", stu);
		return "coureUpdate";
	}

	@RequestMapping("/studentUpdate")
	@ResponseBody
	public int studentUpdate(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");


		Coure cou = new Coure(id,name);
		//执行更新操作
		coureService.studentUpdate(cou);

		return 1;
	}


	@RequestMapping("/delStuList")
	@ResponseBody
	public int delStuList(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		//执行更新操作
		coureService.delStuList(id);

		return 1;
	}



	@RequestMapping("/scoreStatic")
	public String scoreStatic(HttpServletRequest request) throws Exception {

		List<Map<String, String>> list = coureService.scoreStatic();
		String coureNameStr = coureService.coureNameStr();
		String stuNameStr = coureService.stuNameStr();

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
		for(int i=0;i<array.size();i++){
			//System.out.println(array.get(i).toString());
			String s = array.get(i).toString();
			s = s.substring(1,s.length()-1);
			split = s.split(",");
		}
		String str = "";
		for(int i=0;i<split.length;i++){
			String s = split[i];
			//"rowname":"数学"
			s = s.substring(0,s.indexOf(":"));
			str = str +s+",";
		}
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
		Coure stu = coureService.getStuById(id);
		List<CoureSel> list = coureService.getCoureSelList(id);
		request.setAttribute("cou", stu);
		request.setAttribute("list", list);


		return "coureSel";
	}


	@RequestMapping("/delCoureSel")
	@ResponseBody
	public int delCoureSel(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");

		coureService.delCoureSel(stuId,couId);
		return 1;
	}


	@RequestMapping("/addCoureSel")
	@ResponseBody
	public int addCoureSel(HttpServletRequest request,Model model)throws Exception{
		request.setCharacterEncoding("UTF-8");

		String stuId = request.getParameter("stuId");
		String couId = request.getParameter("couId");
		coureService.addCoureSel(stuId,couId);
		return 1;
	}

}
