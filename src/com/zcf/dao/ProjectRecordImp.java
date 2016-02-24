package com.zcf.dao;

import java.util.List;

import com.zcf.bean.BeanProjectRecord;

public interface ProjectRecordImp {
	public boolean addRecord(BeanProjectRecord p);
	public boolean deleteRecord(BeanProjectRecord p);
	public boolean modifyRecord(BeanProjectRecord p);
	public List<BeanProjectRecord> searchRecord(String stuId, String projectId, String page, String rows);
}
