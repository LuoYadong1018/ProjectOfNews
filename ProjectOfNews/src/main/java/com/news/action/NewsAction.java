package com.news.action;

import java.util.Date;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.news.entity.News;
import com.news.service.ChannelService;
import com.news.service.NewsService;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class NewsAction extends BaseAction implements ModelDriven<News>{
    private  News news;
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	private String search;
	
    public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	@Resource
    private  NewsService  newsService;
	public  String insertNews(){
		news.setCrtime(new Date());
		newsService.insertNews(news);
		return "list";
	}
	public String queryNews(){
		this.setMaxCount(newsService.allCount(search));
		this.getRequest().setAttribute("newsList", newsService.queryNews(getPage(), getPageSize(),search));
		return SUCCESS;
	}
	public String updateNews(){
		news.setCrtime(new Date());
		newsService.updateNews(news);
		return "list";
	}
	public String deleteNews(){
		newsService.deleteNews(news);
		return "list";
	}
	@Resource
	private  ChannelService   channelService;
	public String showInsertNews(){
		getRequest().setAttribute("channelList",channelService.queryChannel(1, 100,search));
		return "showNews";
	}
	
	public String showUpdateNews(){
		getRequest().setAttribute("channelList",channelService.queryChannel(1, 100,search));
		getRequest().setAttribute("news",newsService.getNewsById(news.getId()));
		return "showupdateNews";
	}
	public News getModel() {
		news =new News();
		return news;
	}
	
	
}
