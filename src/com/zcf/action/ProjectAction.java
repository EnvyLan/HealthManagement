package com.zcf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zcf.bean.BeanProjectInfo;
import com.zcf.dao.ProjectInfoDao;
import com.zcf.dao.ProjectRecordDao;
import com.zcf.dao.StudentInfoDao;
import com.zcf.util.JSONDateFormat;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import sun.misc.Compare;

public class ProjectAction extends ActionSupport{
	
	private String rows;
	private String page;
	private String stuId;
	private String projectId;
	private String projectName;
	private String projectLevel;
	private String projectTeacher;
	private String projectAddress;
	private ProjectInfoDao projectDao = new ProjectInfoDao();
	
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
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectLevel() {
		return projectLevel;
	}
	public void setProjectLevel(String projectLevel) {
		this.projectLevel = projectLevel;
	}
	public String getProjectTeacher() {
		return projectTeacher;
	}
	public void setProjectTeacher(String projectTeacher) {
		this.projectTeacher = projectTeacher;
	}
	public String getProjectAddress() {
		return projectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}
	public String execute(){
		System.out.println(stuId);
		ActionContext.getContext().put("stuId", stuId);
		return "showStuProject";
	}
	
	public String addStudentProject(){
		BeanProjectInfo project = new BeanProjectInfo();
		project.setProjectAddress(projectAddress);
		project.setProjectLevel(projectLevel);
		project.setProjectName(projectName);
		project.setProjectTeacher(projectTeacher);
		JSONObject json = new JSONObject();
		try{
			System.out.println(project.getProjectName());
			new StudentInfoDao().modifyStudentInfo(stuId, project);
			json.put("success", "true");
		}catch(Exception e){
			json.put("errorMsg", "���ʧ��");
			e.printStackTrace();
		}
		writeJson(json);
		return null;
	}
	
	public String loadRecord(){
		ActionContext.getContext().put("stuId", stuId);
		ActionContext.getContext().put("projectId", projectId);
		return "showRecord";
	}
	//����ѧԱѵ����¼
	public String searchStuProjectRecord(){
		//fromObject ��ת��ʱ���ʱ�򣬻��ʱ���ֿ���Ϊһ��������json�������½�һ��jsonconfig�Զ������ת��
		//����û���ã����
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JSONDateFormat("yyyy-MM-dd"));
		JSONObject json = new JSONObject();
		try{
			JSONArray jArray = JSONArray.fromObject(new ProjectRecordDao().searchRecord(stuId, projectId, page,rows), jsonConfig);
			int recordSize = new ProjectRecordDao().countRecord(stuId, projectId);
			json.put("rows", jArray);
			json.put("total", recordSize);
			System.out.println("��һ��date��"+jArray.toString());
		}catch(Exception e){
			System.out.println("���ؼ�¼�����쳣");
			e.printStackTrace();
		}
		writeJson(json);
		return null;
	}
	
	//����ѧԱ��������Ŀ
	public String searchStuProject(){
		System.out.println("this.stuId = "+this.stuId);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		List<BeanProjectInfo> list = this.projectDao.getProject(Integer.parseInt(stuId.trim()), Integer.parseInt(page.trim()), Integer.parseInt(rows.trim()));
		JSONObject json = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		int total = projectDao.countProject(Integer.parseInt(stuId.trim()));
		if(list.size()==0){
			json.put("errorMsg", "û�в�ѯ���");
		}else{
			System.out.println("ѧԱ��Ϊ "+stuId+"����Ŀ��Ϊ "+total);
			json.put("total", total);
			json.put("rows", jsonArray);
			System.out.println(json.toString());
		}
		writeJson(json);
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
		ProjectAction pa = new ProjectAction();
		pa.stuId = "1";
		pa.searchStuProject();
	}
}
