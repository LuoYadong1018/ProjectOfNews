package com.news.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.news.dao.UserDao;
import com.news.entity.User;
/*
 *   用户服务的实现类.
 */

@Service
public class UserServiceImpl  implements  UserService{

	  //依赖属性 --dao层
	@Resource
	private  UserDao  userDao;
	public User loginUser(String name) {
		return userDao.loginUser(name);
	}

	public List<User> queryUser() {
		return userDao.queryUser();
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public void delUser(User user) {
		userDao.delUser(user);
	}

	public List<User> queryUser(int page, int pageSize,String search) {
		// TODO Auto-generated method stub
		return userDao.queryUser(page, pageSize,search);
	}

	public int allCount(String search) {
		// TODO Auto-generated method stub
		return userDao.allCount(search);
	}

	public void levUser(User user) {
		userDao.levUser(user);
		
	}



}
