package com.news.dao;
/*
 * @title 栏目的接口类
 * */
import java.util.List;

import com.news.entity.Channel;
public interface ChannelDao {
	/*
	 * 添加栏目的方法
	 * @param channel  添加的栏目对象
	 */
	public void insertUser(Channel channel);
	/*
	 * 更新栏目的方法
	 * @param channel  更新的栏目对象
	 */
	public void updateUser(Channel channel);
	
	/*
	 *  删除栏目的方法
	 * @param channel   删除的  栏目对象
	 */
	public void deleteUser(Channel channel);
	/*
	 * 模糊查询                         分页数据 
	 * @param page      页码
	 * @param pageSize  每页显示条数
	 * @param search    模糊查询关键字
	 * @return          栏目集合对象
	 */
	public List<Channel> queryUser(int page,int pageSize,String search);
	/*
	 * 查询数据库中一共多少条数据
	 * @param name    模糊查询关键字
	 * @return        整数类型总条数
	 */
	public int  allCount(String name);                 
}
