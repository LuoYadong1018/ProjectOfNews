package com.news.action;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.news.entity.User;
import com.news.service.ChannelService;
import com.news.service.UserService;

/**
 * 用户管理的类 .
 */

@Controller
public class AccountAction  extends  BaseAction {

	 //依赖属性 
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
	
	//模糊查询参数获取 
    private  String search;
    public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
/**
    * 
    *  根据请求查询所有用户 对象   
    * @return  跳转名称
    */
	public  String   queryUser(){
		//  将查询到的  记录放置到    请求对象的 共享属性中去
		//getRequest().setAttribute("userList", userService.queryUser());
		
		if(search==null){
			search="";
		}
		
		// 设置一共有多少条记录  
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
   * 添加用户对象 
   *@return  跳转名称
   */
	public  String  addUser(){
		user.setCrtime(new Date());
		userService.addUser(user);
		return LIST;
	}
	
	/*
	 * 编辑用户对象
	 * @return  跳转名称
	 */
	public  String updateUser(){
		user.setCrtime(new Date());
		userService.updateUser(user);
		return LIST;
	}
	
	/*
	 * 删除用户对象
	 * @return  跳转名称
	 */
	public String delUser(){
		userService.delUser(user);
		return LIST;
	}
	
	/*
	 * 授权
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
