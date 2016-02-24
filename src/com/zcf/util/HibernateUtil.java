package com.zcf.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sf = null;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	@SuppressWarnings("deprecation")
	public static Session getSession(){
		Session session = threadLocal.get();
		if(session != null && session.isOpen())
			return session;
		if(sf == null){
			Configuration cfg = new Configuration();
			cfg.configure();
			sf = cfg.buildSessionFactory();
		}
		session = sf.openSession();
		threadLocal.set(session);
		return session;
		
	}
	public static void closeSession(){
		Session session = threadLocal.get();
		threadLocal.set(null);
		if(session != null)
			session.close();
	}
}
