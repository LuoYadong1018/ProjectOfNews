package com.news.action;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.news.entity.User;
import com.news.service.ChannelService;
import com.news.service.UserService;

/**
 * �û�������� .
 */

@Controller
public class AccountAction  extends  BaseAction {

	 //�������� 
	@Resource
	private  UserService  userService;
	private  User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Resource
	private ChannelService   channelService;
	
	//ģ����ѯ������ȡ 
    private  String search;
    public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
/**
    * 
    *  ���������ѯ�����û� ����   
    * @return  ��ת����
    */
	public  String   queryUser(){
		//  ����ѯ����  ��¼���õ�    �������� ����������ȥ
		//getRequest().setAttribute("userList", userService.queryUser());
		
		if(search==null){
			search="";
		}
		
		// ����һ���ж�������¼  
		setMaxCount(userService.allCount(search));
		
		if(getPage()<0){
			setPage(1);
		}
		if(getPage()>getMaxPage()){
			setPage(getMaxPage());
		}
		getRequest().setAttribute("csList", channelService.queryChannel(1, 100, ""));
		getRequest().setAttribute("userList", userService.queryUser(getPage(), getPageSize(),search));
		return  "queryList";
	}
  /*
   * 
   * ����û����� 
   *@return  ��ת����
   */
	public  String  addUser(){
		user.setCrtime(new Date());
		userService.addUser(user);
		return LIST;
	}
	
	/*
	 * �༭�û�����
	 * @return  ��ת����
	 */
	public  String updateUser(){
		user.setCrtime(new Date());
		userService.updateUser(user);
		return LIST;
	}
	
	/*
	 * ɾ���û�����
	 * @return  ��ת����
	 */
	public String delUser(){
		userService.delUser(user);
		return LIST;
	}
	
	/*
	 * ��Ȩ
	 */
	private String[] level;

    public String[] getLevel() {
		return level;
	}
 
	public void setLevel(String[] level) {
		this.level = level;
	}
	public  String levUser(){
        StringBuffer sbf=new StringBuffer();
    	for(String a:level){
    		sbf.append(a+",");
    	}
    	user.setLev(sbf.toString());
    	userService.levUser(user);
    	return LIST;
    }	
}
