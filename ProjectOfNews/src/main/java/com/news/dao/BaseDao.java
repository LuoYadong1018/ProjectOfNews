package com.news.dao;
/*
 * @title  基础dao层类
 */
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public  class BaseDao{	
	//依赖属性  
	@Resource
	private  SessionFactory  sessionFactory;
	/*
	 * 获取session的方法 
	 * @return   session 对象
	 */
	public  Session   getSession(){
		return sessionFactory.getCurrentSession();
	}
}
