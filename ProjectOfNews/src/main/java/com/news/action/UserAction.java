package com.news.action;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.news.entity.User;
import com.news.service.UserService;
/*
 * �û������������  .
 */
@Controller
public class UserAction extends  BaseAction{
   //���ݲ���  
	 private  User user;
	 public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

   //�������� 
	@Resource
	private  UserService  userService;
    /*
     * �û���½�ķ���
     * @return  �û���½�Ƿ�ɹ�
     */
	public  String  userLogin(){
		User u=userService.loginUser(user.getName());
		if(u!=null){
			//��� ���ݿ��е�����  ���û����ݵ�����һ��  ˵����½�ɹ�
			 if(u.getPwd().equals(user.getPwd())){
				 
				  getSession().setAttribute("user", u);
				 return SUCCESS;
			 }
		}
		return "no";
	}
	   
	
	
	
}
