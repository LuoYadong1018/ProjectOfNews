package com.news.dao;
import java.util.List;
import com.news.entity.User;
/* 
 *    �û������� �ӿ���.
 */
public interface UserDao {
	
	 /*
	  * ��½�ķ���
	  * @param name   ����Ϊ�û���
	  * @return       �����û��������ݿ��� ���ҵĶ���
	  */
	public  User  loginUser(String name);
	
	
	/*
	 * ��ѯ�����û��ķ���
	 * @return  ���������û��ļ���
	 */
	
	public  List<User> queryUser();
	
	
	/*
	 * ��ҳ��ѯ�����û��ķ���
	 * @param  page    ��ǰ��ҳ��
	 * @param  pageSize  ÿҳ��ʾ��������¼
	 * @param  search    ģ����ѯ����
	 * @return  ���������û��ļ���
	 */
	
	public  List<User> queryUser(int page,int pageSize,String search);
	
	
	/*
	 *  ���ݲ��� ��ȡһ���ж�������¼ 
	 * @param search ģ����ѯ������
	 * @return ����
	 */
	
	public  int    allCount(String search);
	
	/*
	 * �����û���Ϣ�ķ���
	 * 
	 * 
	 * @param user   �û���Ϣ����
	 */
	
	
	public  void   addUser(User user);
	
	/*
	 * �޸��û���Ϣ�ķ���
	 * 
	 * @param user   �޸ĵ��û���Ϣ����
	 */
	
	public  void   updateUser(User user);
	
	    /*
	     * ɾ���û���Ϣ�ķ���
	     * @param user  Ҫɾ�����û���Ϣ����
	     */

	public  void   delUser(User user);
	
	
	
	/*
	 * �޸��û�����ķ���
	 * 
	 * @param user   �޸ĵ��û���Ϣ����
	 */
	
	public  void   levUser(User user);
	
	
}
