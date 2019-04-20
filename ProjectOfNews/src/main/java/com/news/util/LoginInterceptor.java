package com.news.util;

import com.news.action.UserAction;

import com.news.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor  implements  Interceptor{

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		
		
        Object object = arg0.getAction();
		
        
        if(object instanceof UserAction){
        	return arg0.invoke();
        }else{
        	
          User	user=(User) arg0.getInvocationContext().getSession().get("user");
           if(user==null){
        	   
        	   return "loginOut";
           }else{
        	   
        	   return arg0.invoke();
           }
        
        }
        
        		
	}

}
