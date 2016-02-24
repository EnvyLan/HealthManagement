package com.zcf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.zcf.bean.BeanProjectInfo;

public class ProjectInfoDao extends HibernateBasedDAO implements ProjectInfoDaoImp {

	@Override
	public int addProject(BeanProjectInfo newProject) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		this.beginThransaction();
		session.save(newProject);
		session.getTransaction().commit();
		return newProject.getProjectId();
	}

	@Override
	public boolean modifyProject(BeanProjectInfo newProject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProject(BeanProjectInfo newProject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BeanProjectInfo> getAllProject() {
		// TODO Auto-generated method stub
		return (List<BeanProjectInfo>) this.query("from BeanProjectInfo");
	}
	
	//这里使用了原生的sql，没有用hibernate的映射关系
	@Override
	public List<BeanProjectInfo> getProject(int stuId, int page, int rows) {
		// TODO Auto-generated method stub
		String hql = "select p.project_Id, p.project_name, p.project_Level, p.project_Teacher, p.project_Address"
				+ " from stu_project as s left join Project_info as p on(s.project_id = p.project_id) "
				+ "where s.stu_Id = ?";
		//addEntity,这里把结果集和对象进行映射，
		Session session = this.getSession();
		session.beginTransaction();
		Query query = this.getSession().createSQLQuery(hql).addEntity(BeanProjectInfo.class);
		query.setInteger(0, stuId);
		query.setMaxResults(rows);
		query.setFirstResult((page-1)*rows);
		List<BeanProjectInfo> list = query.list();
		session.flush();
		session.getTransaction().commit();
		return  list;
	}
	//这里同样使用了原生的sql，又用了关联查询，效率不高
	public int countProject(int stuId) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.beginTransaction();
		String hql = "select count(*)"
				+ "from stu_project as s left join Project_info as p on(s.project_id = p.project_id) "
				+ "where s.stu_id = ?";
		
		Query query = this.getSession().createSQLQuery(hql);
		query.setInteger(0, stuId);
		int result = ((Number)query.uniqueResult()).intValue();
		session.flush();
		session.getTransaction().commit();
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BeanProjectInfo> list = new ProjectInfoDao().getProject(1, 1, 10);
		System.out.println(list.size());
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
