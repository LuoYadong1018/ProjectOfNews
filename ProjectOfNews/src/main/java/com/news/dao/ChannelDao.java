package com.news.dao;
/*
 * @title ��Ŀ�Ľӿ���
 * */
import java.util.List;

import com.news.entity.Channel;
public interface ChannelDao {
	/*
	 * �����Ŀ�ķ���
	 * @param channel  ��ӵ���Ŀ����
	 */
	public void insertUser(Channel channel);
	/*
	 * ������Ŀ�ķ���
	 * @param channel  ���µ���Ŀ����
	 */
	public void updateUser(Channel channel);
	
	/*
	 *  ɾ����Ŀ�ķ���
	 * @param channel   ɾ����  ��Ŀ����
	 */
	public void deleteUser(Channel channel);
	/*
	 * ģ����ѯ                         ��ҳ���� 
	 * @param page      ҳ��
	 * @param pageSize  ÿҳ��ʾ����
	 * @param search    ģ����ѯ�ؼ���
	 * @return          ��Ŀ���϶���
	 */
	public List<Channel> queryUser(int page,int pageSize,String search);
	/*
	 * ��ѯ���ݿ���һ������������
	 * @param name    ģ����ѯ�ؼ���
	 * @return        ��������������
	 */
	public int  allCount(String name);                 
}
