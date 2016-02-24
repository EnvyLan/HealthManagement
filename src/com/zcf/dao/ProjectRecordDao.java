package com.zcf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zcf.bean.BeanProjectRecord;

public class ProjectRecordDao extends HibernateBasedDAO implements ProjectRecordImp {

	@Override
	public boolean addRecord(BeanProjectRecord p) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		this.beginThransaction();
		session.save(p);
		session.getTransaction().commit();
		return false;
	} 

	@Override
	public boolean deleteRecord(BeanProjectRecord p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyRecord(BeanProjectRecord p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BeanProjectRecord> searchRecord(String stuId, String projectId, String page, String rows) {
		// TODO Auto-generated method stub
		int r = Integer.parseInt(rows.trim());
		int start = (Integer.parseInt(page.trim())-1)*r;
		Session session = this.getSession();
		session.beginTransaction();
		String hql = "from BeanProjectRecord where stuId = ? and projectId = ? order by gradeTime";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, Integer.parseInt(stuId.trim()));
		query.setInteger(1, Integer.parseInt(projectId.trim()));
		query.setMaxResults(r);
		query.setFirstResult(start);
		List<BeanProjectRecord> list = query.list();
		session.flush();
		session.getTransaction().commit();
		return list;
	}
	
	public int countRecord(String stuId, String projectId){
		Session session = this.getSession();
		session.beginTransaction();
		String hql = "select count(*) from BeanProjectRecord where stuId = ? and projectId = ? order by gradeTime";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, Integer.parseInt(stuId.trim()));
		query.setInteger(1, Integer.parseInt(projectId.trim()));
		int result = ((Number)query.uniqueResult()).intValue();
		session.flush();
		session.getTransaction().commit();
		return result;
	}
	
	public static void main(String[] args) {
	
	}

}
