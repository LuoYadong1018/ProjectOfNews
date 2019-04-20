package com.news.action;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.news.entity.User;
import com.news.service.UserService;
/*
 * 用户的请求操作类  .
 */
@Controller
public class UserAction extends  BaseAction{
   //传递参数  
	 private  User user;
	 public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

   //依赖属性 
	@Resource
	private  UserService  userService;
    /*
     * 用户登陆的方法
     * @return  用户登陆是否成功
     */
	public  String  userLogin(){
		User u=userService.loginUser(user.getName());
		if(u!=null){
			//如果 数据库中的密码  和用户传递的密码一致  说明登陆成功
			 if(u.getPwd().equals(user.getPwd())){
				 
				  getSession().setAttribute("user", u);
				 return SUCCESS;
			 }
		}
		return "no";
	}
	   
	
	
	
}
