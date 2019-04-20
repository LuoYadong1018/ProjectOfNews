package com.news.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
/*
 *  aciton的基础类.
 */
public class BaseAction extends  ActionSupport  implements  ServletRequestAware{

	public final  String  LIST="list";
	/*
	 * 分页的 信息  
	 */
	private  int  page=1;  // 当前页面 
	
	private  int  pageSize=5; //  每页显示的条数
	
	private  int  maxCount;  // 一共有多少条记录
	
	private  int  maxPage;   // 一共有多少页
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
	
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getMaxPage() {
		setMaxPage(1);  // 获取所有的页面  先设置一下页面的值
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		// 计算一共有多少页
		maxPage=(maxCount+pageSize-1)/pageSize;
		this.maxPage = maxPage;
	}
	private  HttpServletRequest  request;
	public void setServletRequest(HttpServletRequest request) {
	this.request=request;	
	}
	/*
	 *  获取 web中request对象的方法
	 * @return  request对象
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/*
	 * 获取  web中session对象的方法 
	 * @return  session  对象
	 */
	public  HttpSession  getSession(){
		
		return request.getSession();
	}

}
