package com.news.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.news.dao.ChannelDao;
import com.news.entity.Channel;
/*
 * 栏目的服务类
 */
@Service
public class ChannelServiceImpl implements ChannelService{

	 @Resource
	private ChannelDao  channelDao;
	 
	 
	public void insertChannel(Channel channel) {
		// TODO Auto-generated method stub
		channelDao.insertUser(channel);
	}

	public void updateChannel(Channel channel) {
		// TODO Auto-generated method stub
		channelDao.updateUser(channel);
	}

	public void deleteChannel(Channel channel) {
		// TODO Auto-generated method stub
		channelDao.deleteUser(channel);
	}

	public List<Channel> queryChannel(int page, int pageSize,String search) {
		// TODO Auto-generated method stub
		return channelDao.queryUser(page, pageSize,search);
	}

	public int allCount(String name) {
		// TODO Auto-generated method stub
		return channelDao.allCount(name);
	}
	             
}
