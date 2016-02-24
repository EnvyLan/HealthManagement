package com.zcf.dao;

import java.util.List;

import com.zcf.bean.BeanStudentInfo;

public interface StudentInfoDaoImp {
	List<BeanStudentInfo> getStudentInfo(String name, int page, int rows);
	boolean modifyStudentInfo(BeanStudentInfo myStu);
	boolean deleteStudentInfo(BeanStudentInfo myStu);
	int addStudentInfo(BeanStudentInfo myStu);
	int count();
}
