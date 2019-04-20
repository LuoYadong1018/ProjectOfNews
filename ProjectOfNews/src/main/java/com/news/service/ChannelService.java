package com.news.service;

import java.util.List;

import com.news.entity.Channel;
/*
 *  ��Ŀ�ķ�����.
 */
public interface ChannelService {
	/*
	 * �����Ŀ�ķ���
	 * @param channel  ��ӵ���Ŀ����
	 */
	public void insertChannel(Channel channel);
	/*
	 *  ������Ŀ�ķ���
	 * @param channel  ���µ���Ŀ����
	 */
	public void updateChannel(Channel channel);
	
	/*
	 *   ɾ����Ŀ�ķ���
	 * @param channel   ɾ����  ��Ŀ����
	 */
	public void deleteChannel(Channel channel);
	/*
	 * ģ����ѯ                         ��ҳ���� 
	 * @param page      ҳ��
	 * @param pageSize  ÿҳ��ʾ����
	 * @param search    ģ����ѯ�ؼ���
	 * @return          ��Ŀ���϶���
	 */
	public List<Channel> queryChannel(int page,int pageSize,String search);
	/*
	 * ��ѯ���ݿ���һ������������
	 * @param name    ģ����ѯ�ؼ���
	 * @return        ��������������
	 */
	public int  allCount(String name);                 
}
