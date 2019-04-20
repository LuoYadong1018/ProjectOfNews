package com.news.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
/*
 *  aciton�Ļ�����.
 */
public class BaseAction extends  ActionSupport  implements  ServletRequestAware{

	public final  String  LIST="list";
	/*
	 * ��ҳ�� ��Ϣ  
	 */
	private  int  page=1;  // ��ǰҳ�� 
	
	private  int  pageSize=5; //  ÿҳ��ʾ������
	
	private  int  maxCount;  // һ���ж�������¼
	
	private  int  maxPage;   // һ���ж���ҳ
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
		setMaxPage(1);  // ��ȡ���е�ҳ��  ������һ��ҳ���ֵ
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		// ����һ���ж���ҳ
		maxPage=(maxCount+pageSize-1)/pageSize;
		this.maxPage = maxPage;
	}
	private  HttpServletRequest  request;
	public void setServletRequest(HttpServletRequest request) {
	this.request=request;	
	}
	/*
	 *  ��ȡ web��request����ķ���
	 * @return  request����
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/*
	 * ��ȡ  web��session����ķ��� 
	 * @return  session  ����
	 */
	public  HttpSession  getSession(){
		
		return request.getSession();
	}

}
