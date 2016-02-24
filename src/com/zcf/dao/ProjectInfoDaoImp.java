package com.zcf.dao;

import java.util.List;

import com.zcf.bean.BeanProjectInfo;

public interface ProjectInfoDaoImp {
	int addProject(BeanProjectInfo newProject);
	boolean modifyProject(BeanProjectInfo newProject);
	boolean deleteProject(BeanProjectInfo newProject);
	List<BeanProjectInfo> getAllProject();
	List<BeanProjectInfo> getProject(int stuId, int page, int rows);
	int count();
}
