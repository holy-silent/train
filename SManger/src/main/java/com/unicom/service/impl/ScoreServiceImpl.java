package com.unicom.service.impl;

import com.unicom.dao.IScoreDao;
import com.unicom.model.Coure;
import com.unicom.model.CoureSel;
import com.unicom.model.StuScore;
import com.unicom.model.Student;
import com.unicom.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {

	@Resource
	private IScoreDao studentDao;

	public List<StuScore> getStuList(String couId,String stuName,int currPage, int pagesize) {
		int startCount = (currPage-1)*pagesize;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("couId",couId);
		map.put("stuName",stuName);
		map.put("pstart",startCount);
		map.put("psize",pagesize);
		return studentDao.getStuList(map);
	}

	public String getTotalCount(String couId,String stuName) {

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("couId",couId);

		map.put("stuName",stuName);
		return studentDao.getTotalCount(map);
	}

	public int noIsExist(String no) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("no",no);
		String rs = studentDao.noIsExist(map);
		return Integer.parseInt(rs);
	}

	public void studentAdd(StuScore stu) {
		studentDao.studentAdd(stu);
	}

	public StuScore getStuById(String stuId,String couId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stuId",stuId);
		map.put("couId",couId);
		return studentDao.getStuById(map);
	}

	public void studentUpdate(StuScore stu) {
		studentDao.studentUpdate(stu);
	}

	public void delStuList(String stuId,String couId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stuId",stuId);
		map.put("couId",couId);
		studentDao.delStuList(map);
	}

	//public List<Map<String, List<Map<String, String>>>> scoreStatic() {
	public  List<Map<String, String>> scoreStatic() {
		List<Coure> coureList = studentDao.getCoureList();
		List<StuScore> list = null;
		List<Map<String,String>> ll = new ArrayList<Map<String, String>>();
		//学生+成绩集合列表
		//List<Map<String,String>> listScore = new ArrayList<Map<String, String>>();
		//科目Map
		//Map<String,List<Map<String,String>>> mapCoure = new HashMap<String, List<Map<String, String>>>();
		//总体集合List<Map<String,List<Map<String,String>>>>
		//List<Map<String,List<Map<String,String>>>> listTotal = new ArrayList<Map<String, List<Map<String, String>>>>();
		for(Coure c:coureList){
			String coureName = c.getName();
			Map<String,String> mm = new HashMap<String, String>();
			mm.put("rowname",coureName);
			list = studentDao.getStuScore(coureName);
			System.out.println(list.size());

			for(StuScore s:list){
				//System.out.println(s.getStuName()+"--"+s.getScore());
				mm.put(s.getStuName(),s.getScore());
			}
			if(list.size()!=0)
				ll.add(mm);
		}
		return ll;
	}

	public String coureNameStr() {
		List<Coure> coureList = studentDao.getCoureList();
		String rs = "";
		for(Coure c:coureList){
			rs = rs +c.getName()+",";
		}
		rs = rs.substring(0,rs.length()-1);
		return rs;
	}

	public String stuNameStr() {
		List<Student> list = studentDao.getStuList2();
		String rs = "";
		for(Student s:list){
			rs = rs +s.getName()+",";
		}
		rs = rs.substring(0,rs.length()-1);
		return rs;
	}

	public List<CoureSel> getCoureSelList(String id) {

		List<CoureSel> list = studentDao.getCoureSelList(id);
		return list;
	}

	public void delCoureSel(String stuId, String couId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stuId",stuId);
		map.put("couId",couId);

		studentDao.delCoureSel(map);
	}


	public void addCoureSel(String stuId, String couId) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stuId",stuId);
		map.put("couId",couId);

		studentDao.addCoureSel(map);
	}

	public List<StuScore> getGzq(String couId) {
		return studentDao.getGzq(couId);
	}
}
