package com.zcf.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BeanProjectRecord {
	private int detailId;
	private int stuId;
	private int projectId;
	private double stuHeight;
	private double stuWeight;
	private double stu100mSpeed;
	private double stuToughHeight;
	private double stuRunBack;
	private double stuRunWithBall;
	private double stuResponseTime;
	private double stuHandSize;
	private double stuJump;
	private double stuShootBall;
	private double stuHeart;
	private double stuGrade;
	private Date gradeTime;
	private String formatDate;
	private double stuArmSize;
	
	
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public double getStuArmSize() {
		return stuArmSize;
	}
	public void setStuArmSize(double stuArmSize) {
		this.stuArmSize = stuArmSize;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public double getStuHeight() {
		return stuHeight;
	}
	public void setStuHeight(double stuHeight) {
		this.stuHeight = stuHeight;
	}
	public double getStuWeight() {
		return stuWeight;
	}
	public void setStuWeight(double stuWeight) {
		this.stuWeight = stuWeight;
	}
	public double getStu100mSpeed() {
		return stu100mSpeed;
	}
	public void setStu100mSpeed(double stu100mSpeed) {
		this.stu100mSpeed = stu100mSpeed;
	}
	public double getStuToughHeight() {
		return stuToughHeight;
	}
	public void setStuToughHeight(double stuToughHeight) {
		this.stuToughHeight = stuToughHeight;
	}
	public double getStuRunBack() {
		return stuRunBack;
	}
	public void setStuRunBack(double stuRunBack) {
		this.stuRunBack = stuRunBack;
	}
	public double getStuRunWithBall() {
		return stuRunWithBall;
	}
	public void setStuRunWithBall(double stuRunWithBall) {
		this.stuRunWithBall = stuRunWithBall;
	}
	public double getStuResponseTime() {
		return stuResponseTime;
	}
	public void setStuResponseTime(double stuResponseTime) {
		this.stuResponseTime = stuResponseTime;
	}
	public double getStuHandSize() {
		return stuHandSize;
	}
	public void setStuHandSize(double stuHandSize) {
		this.stuHandSize = stuHandSize;
	}
	public double getStuJump() {
		return stuJump;
	}
	public void setStuJump(double stuJump) {
		this.stuJump = stuJump;
	}
	public double getStuShootBall() {
		return stuShootBall;
	}
	public void setStuShootBall(double stuShootBall) {
		this.stuShootBall = stuShootBall;
	}
	public double getStuHeart() {
		return stuHeart;
	}
	public void setStuHeart(double stuHeart) {
		this.stuHeart = stuHeart;
	}
	public double getStuGrade() {
		return stuGrade;
	}
	public void setStuGrade(double stuGrade) {
		this.stuGrade = stuGrade;
	}
	public Date getGradeTime() {
		return gradeTime;
	}
	public void setGradeTime(Date gradeTime) {
		setFormatDate(new SimpleDateFormat("yyyy-MM-dd ").format(gradeTime));
		this.gradeTime = gradeTime;
	}
	public String getFormatDate() {
		return formatDate;
	}
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	
	
}
