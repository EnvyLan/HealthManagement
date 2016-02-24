package com.zcf.bean;

import java.util.Set;

public class BeanProjectInfo implements Comparable<BeanProjectInfo>{
	private int projectId;
	private String projectName;
	private String projectLevel;
	private String projectTeacher;
	private String projectAddress;
	private Set<BeanStudentInfo> stu;
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
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
	
	public Set<BeanStudentInfo> getStu() {
		return stu;
	}
	public void setStu(Set<BeanStudentInfo> stu) {
		this.stu = stu;
	}
	@Override
	public int compareTo(BeanProjectInfo o) {
		// TODO Auto-generated method stub
		if(this.getProjectId() > o.getProjectId()){
			return -1;
		}else if(this.getProjectId() < o.getProjectId()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
