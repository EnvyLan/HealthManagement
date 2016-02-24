package com.zcf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.zcf.bean.BeanStudentInfo;
import com.zcf.dao.StudentInfoDao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

public class StudentAction extends ActionSupport{
	
	private String stuName;
	private String stuPhone;
	private String stuAddress;
	private String stuMedicalHistory;
	private String stuFatherName;
	private String stuFatherPhone;
	private String result;
	private String rows;
	private String page;
	private StudentInfoDao stuDao = new StudentInfoDao();
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuPhone() {
		return stuPhone;
	}
	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuMedicalHistory() {
		return stuMedicalHistory;
	}
	public void setStuMedicalHistory(String stuMedicalHistory) {
		this.stuMedicalHistory = stuMedicalHistory;
	}
	public String getStuFatherName() {
		return stuFatherName;
	}
	public void setStuFatherName(String stuFatherName) {
		this.stuFatherName = stuFatherName;
	}
	public String getStuFatherPhone() {
		return stuFatherPhone;
	}
	public void setStuFatherPhone(String stuFatherPhone) {
		this.stuFatherPhone = stuFatherPhone;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String addStudent(){
		BeanStudentInfo s = new BeanStudentInfo();
		s.setStuAddress(stuAddress);
		s.setstuFatherName(stuFatherName);
		s.setstuFatherPhone(stuFatherPhone);
		s.setStuMedicalHistory(stuMedicalHistory);
		s.setStuName(stuName);
		s.setStuPhone(stuPhone);
		System.out.println(stuName);
		stuDao.addStudentInfo(s);
		JSONObject json = new JSONObject();
		json.put("success", "true");
		writeJson(json);
		return null;
	}
	
	public String loadStudent(){
		System.out.println("现在开始加载学员数据");
		System.out.println("学员姓名为："+ stuName);
		System.out.println(rows+" : "+page);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONObject result1=new JSONObject();
		List<BeanStudentInfo> list = stuDao.getStudentInfo(stuName, Integer.parseInt(page.trim()), Integer.parseInt(rows.trim()));
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		result1.put("rows", jsonArray);
		if(stuName==null || stuName==""){
			result1.put("total", stuDao.count());
		}else{
			result1.put("total", stuDao.getStudentInfoLength(stuName));
		}
		System.out.println(result1.get("total"));
		writeJson(result1);
		return null;
	}
	
	public static void writeJson(JSONObject json){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		StudentAction s = new StudentAction();
		s.setPage("1");
		s.setStuName(null);
		s.setRows("10");
		s.loadStudent();
	}
}
