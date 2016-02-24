package com.zcf.bean;

import java.util.Set;

public class BeanStudentInfo {
	private int stuId;
	private String stuName;
	private String stuMedicalHistory;
	private String stuFatherName;
	private String stuFatherPhone;
	private String stuPhone;
	private String stuAddress;
	private Set<BeanProjectInfo> project;
	public Set<BeanProjectInfo> getProject() {
		return project;
	}
	public void setProject(Set<BeanProjectInfo> project) {
		this.project = project;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuMedicalHistory() {
		return stuMedicalHistory;
	}
	public void setStuMedicalHistory(String stuMedicalHistory) {
		this.stuMedicalHistory = stuMedicalHistory;
	}
	public String getstuFatherName() {
		return stuFatherName;
	}
	public void setstuFatherName(String stuFatherName) {
		this.stuFatherName = stuFatherName;
	}
	public String getstuFatherPhone() {
		return stuFatherPhone;
	}
	public void setstuFatherPhone(String stuFatherPhone) {
		this.stuFatherPhone = stuFatherPhone;
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
	
}
