package com.news.service;

import java.util.List;

import com.news.entity.Channel;
/*
 *  栏目的服务类.
 */
public interface ChannelService {
	/*
	 * 添加栏目的方法
	 * @param channel  添加的栏目对象
	 */
	public void insertChannel(Channel channel);
	/*
	 *  更新栏目的方法
	 * @param channel  更新的栏目对象
	 */
	public void updateChannel(Channel channel);
	
	/*
	 *   删除栏目的方法
	 * @param channel   删除的  栏目对象
	 */
	public void deleteChannel(Channel channel);
	/*
	 * 模糊查询                         分页数据 
	 * @param page      页码
	 * @param pageSize  每页显示条数
	 * @param search    模糊查询关键字
	 * @return          栏目集合对象
	 */
	public List<Channel> queryChannel(int page,int pageSize,String search);
	/*
	 * 查询数据库中一共多少条数据
	 * @param name    模糊查询关键字
	 * @return        整数类型总条数
	 */
	public int  allCount(String name);                 
}
