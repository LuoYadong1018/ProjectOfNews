package com.news.dao;
/*
 * @title  ����dao����
 */
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public  class BaseDao{	
	//��������  
	@Resource
	private  SessionFactory  sessionFactory;
	/*
	 * ��ȡsession�ķ��� 
	 * @return   session ����
	 */
	public  Session   getSession(){
		return sessionFactory.getCurrentSession();
	}
}
