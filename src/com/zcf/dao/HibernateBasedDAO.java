package com.zcf.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zcf.util.HibernateUtil;


public class HibernateBasedDAO {
	public SimpleDateFormat myDate = new SimpleDateFormat("yyyy-MM-dd");
	public Session getSession(){
		return HibernateUtil.getSession();
	}
	public void beginThransaction(){
		this.getSession().beginTransaction();
	}
	public void commitThrasaction(){
		this.getSession().getTransaction().commit();
	}
	public void rollbackThransaction(){
		this.getSession().getTransaction().rollback();
	}
	public List<?> query(String hql){
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}
	public void closeSession(){
		HibernateUtil.closeSession();
	}
}
