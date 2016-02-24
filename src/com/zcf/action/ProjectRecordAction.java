package com.zcf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sun.jmx.snmp.Timestamp;
import com.zcf.bean.BeanProjectRecord;
import com.zcf.dao.ProjectRecordDao;

import net.sf.json.JSONObject;

public class ProjectRecordAction {

	private String stuId;
	private String projectId;
	private String stuHeight;
	private String stuWeight;
	private String stuArmSize;
	private String stuHandSize;
	private String stu100mSpeed;
	private String stuRunBack;
	private String stuRunWithBall;
	private String stuResponseTime;
	private String stuJump;
	private String stuShootBall;
	private String stuHeart;
	private String stuGrade;
	private String stuTouchHeight;
	
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
	public String getStuHeight() {
		return stuHeight;
	}
	public void setStuHeight(String stuHeight) {
		this.stuHeight = stuHeight;
	}
	public String getStuWeight() {
		return stuWeight;
	}
	public void setStuWeight(String stuWeight) {
		this.stuWeight = stuWeight;
	}
	public String getStuArmSize() {
		return stuArmSize;
	}
	public void setStuArmSize(String stuArmSize) {
		this.stuArmSize = stuArmSize;
	}
	public String getStuHandSize() {
		return stuHandSize;
	}
	public void setStuHandSize(String stuHandSize) {
		this.stuHandSize = stuHandSize;
	}
	public String getStu100mSpeed() {
		return stu100mSpeed;
	}
	public void setStu100mSpeed(String stu100mSpeed) {
		this.stu100mSpeed = stu100mSpeed;
	}
	public String getStuRunBack() {
		return stuRunBack;
	}
	public void setStuRunBack(String stuRunBack) {
		this.stuRunBack = stuRunBack;
	}
	public String getStuRunWithBall() {
		return stuRunWithBall;
	}
	public void setStuRunWithBall(String stuRunWithBall) {
		this.stuRunWithBall = stuRunWithBall;
	}
	public String getStuResponseTime() {
		return stuResponseTime;
	}
	public void setStuResponseTime(String stuResponseTime) {
		this.stuResponseTime = stuResponseTime;
	}
	public String getStuJump() {
		return stuJump;
	}
	public void setStuJump(String stuJump) {
		this.stuJump = stuJump;
	}
	public String getStuShootBall() {
		return stuShootBall;
	}
	public void setStuShootBall(String stuShootBall) {
		this.stuShootBall = stuShootBall;
	}
	public String getStuHeart() {
		return stuHeart;
	}
	public void setStuHeart(String stuHeart) {
		this.stuHeart = stuHeart;
	}
	public String getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(String stuGrade) {
		this.stuGrade = stuGrade;
	}
	public String getStuTouchHeight() {
		return stuTouchHeight;
	}
	public void setStuTouchHeight(String stuTouchHeight) {
		this.stuTouchHeight = stuTouchHeight;
	}
	public String addProjectRecord(){
		BeanProjectRecord pr = new BeanProjectRecord();
		pr.setProjectId(Integer.parseInt(projectId.trim()));
		pr.setStu100mSpeed(Double.parseDouble(stu100mSpeed.trim()));
		pr.setStuArmSize(Double.parseDouble(stuArmSize.trim()));
		pr.setStuGrade(Double.parseDouble(stuGrade.trim()));
		pr.setStuHandSize(Double.parseDouble(stuHandSize.trim()));
		pr.setStuHeart(Double.parseDouble(stuHeart.trim()));
		pr.setStuHeight(Double.parseDouble(stuHeight.trim()));
		pr.setStuWeight(Double.parseDouble(stuWeight.trim()));
		pr.setStuId(Integer.parseInt(stuId.trim()));
		pr.setStuToughHeight(Double.parseDouble(stuTouchHeight.trim()));
		pr.setStuJump(Double.parseDouble(stuJump.trim()));
		pr.setStuResponseTime(Double.parseDouble(stuResponseTime.trim()));
		pr.setStuRunBack(Double.parseDouble(stuRunBack.trim()));
		pr.setStuRunWithBall(Double.parseDouble(stuRunWithBall.trim()));
		pr.setStuShootBall(Double.parseDouble(stuShootBall.trim()));
		pr.setGradeTime(new java.sql.Timestamp(System.currentTimeMillis()));
		JSONObject json = new JSONObject();
		try{
			new ProjectRecordDao().addRecord(pr);
			json.put("success", "添加成功");
		}catch(Exception e){
			e.printStackTrace();
			json.put("errorMsg", "数据错误，添加失败");
		}
		writeJson(json);
		return null;
	}
	
	public String loadRecord(){
		
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
}
