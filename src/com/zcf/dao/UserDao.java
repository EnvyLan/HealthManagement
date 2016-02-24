package com.zcf.dao;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zcf.bean.BeanUser;


public class UserDao extends HibernateBasedDAO implements UserDaoImp{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserDao().getUser(new BeanUser());
	}
	@Override
	public boolean getUser(BeanUser myUser){
		Session session = this.getSession();
		this.beginThransaction();
		Query query = session.createQuery("from BeanUser where userName = ?");
		//User tempUser = (User)session.get(User.class, 1);
		//System.out.println(tempUser.getUserName()+"  :  "+tempUser.getUserPwd());
		
		query.setString(0, myUser.getUserName());
		Iterator iterator = query.list().iterator();
		BeanUser tempUser =  new BeanUser();
		while(iterator.hasNext()){
			tempUser = (BeanUser)iterator.next();
			break;
		}
		session.getTransaction().commit();
		
		if(tempUser.getUserPwd() == null || !tempUser.getUserPwd().equals(myUser.getUserPwd()))
			return false;
		
		return true;
	}
	@Override
	public boolean modifyUser(BeanUser myUser) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteUser(BeanUser myUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
