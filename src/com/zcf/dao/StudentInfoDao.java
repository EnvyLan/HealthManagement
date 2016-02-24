package com.zcf.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zcf.bean.BeanProjectInfo;
import com.zcf.bean.BeanStudentInfo;

public class StudentInfoDao extends HibernateBasedDAO implements StudentInfoDaoImp {

	
	public List<BeanStudentInfo> getStudentInfo(String stuName, int page, int rows) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		int start = (page-1)*rows;
		Query query = null;
		String hql = "from BeanStudentInfo";
		session.beginTransaction();
		if(stuName == null || stuName==""){
			System.out.println("非模糊查询的hql为："+hql);
			query = this.getSession().createQuery(hql);
		}else{
			hql += " where stuName like :name ";
			query = this.getSession().createQuery(hql);
			query.setString("name", "%"+stuName+"%");
			System.out.println("模糊查询的hql为："+hql);
		}
		query.setMaxResults(rows);
		query.setFirstResult(start);
		List<BeanStudentInfo> list = query.list();
		session.flush();
		session.getTransaction().commit();
		return list ;
	}
	
	public int getStudentInfoLength(String stuName){
		String hql = "select count(*) from BeanStudentInfo where stuName like '%"+stuName+"%'";
		return ((Number)this.getSession().createQuery(hql).uniqueResult()).intValue();
		
	}
	
	public boolean modifyStudentInfo(String stuId, BeanProjectInfo p) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		this.beginThransaction();
		BeanStudentInfo s = (BeanStudentInfo) session.get(BeanStudentInfo.class, Integer.parseInt(stuId));
		s.getProject().add(p);
		session.save(s);
		session.flush();
		session.getTransaction().commit();
		return false;
	}

	public boolean deleteStudentInfo(BeanStudentInfo myStu) {
		// TODO Auto-generated method stub
		return false;
	}

	public int addStudentInfo(BeanStudentInfo myStu) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		this.beginThransaction();
		session.save(myStu);
		session.getTransaction().commit();
		return myStu.getStuId();
	}
	public BeanStudentInfo getStudent(int stuId){
		Session session = this.getSession();
		this.beginThransaction();
		BeanStudentInfo b = (BeanStudentInfo) session.get(BeanStudentInfo.class, stuId);
		session.getTransaction().commit();
		return b;
		
	}
	@Override
	public boolean modifyStudentInfo(BeanStudentInfo myStu) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery("select count(*) from BeanStudentInfo");
		return ((Number)query.uniqueResult()).intValue();
	}
	public static void main(String[] args) {
		BeanStudentInfo s = new BeanStudentInfo();
		s.setStuName("ww");
		int c = new StudentInfoDao().count();
		System.out.println(c);
	}
	
}
