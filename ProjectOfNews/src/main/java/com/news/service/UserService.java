package com.news.service;

import java.util.List;

import com.news.entity.User;

/*
 * 用户服务层接口.
 */
public interface UserService {

	/*
	 * 根据用户的名字获取数据库中用户对象
	 * @param name  用户的名字    
	 * @return   获取到的用户对象
	 */
	
	 public  User  loginUser(String name);
	
		/*
		 * 查询所有用户的方法
		 * @return  保存所有用户的集合
		 */
		
		public  List<User> queryUser();
		
		/*
		 * 保存用户信息的方法
		 * 
		 * 
		 * @param user   用户信息对象
		 */
		
		
		public  void   addUser(User user);
		
		/*
		 * 修改用户信息的方法
		 * 
		 * @param user   修改的用户信息对象
		 */
		
		public  void   updateUser(User user);
		
		    /*
		     * 删除用户信息的方法
		     * @param user  要删除的用户信息对象
		     */

		public  void   delUser(User user);
		/*
		 * 分页查询所有用户的方法
		 * @param  page    当前的页面
		 * @param  pageSize  每页显示多少条记录
		 * @param  search   模糊查询字段
		 * @return  保存所有用户的集合
		 */
		
		public  List<User> queryUser(int page,int pageSize,String search);
		
		
		/*
		 *  获取一共有多少条记录 
		 * @param  search   模糊查询字段
		 * @return  总数
		 */
		
		public  int    allCount(String search);
		
		
		/*
		 * 修改用户级别的方法
		 * 
		 * @param user   修改的用户信息对象
		 */
		
		public  void   levUser(User user);
	 
}
