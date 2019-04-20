package com.news.dao;
import java.util.List;
import com.news.entity.News;
public interface NewsDao {
	public void insertNews(News news);
	public void updateNews(News news);
	public void deleteNews(News news);
	public List<News> queryNews(int page,int pageSize,String search);
	public News  getNewsById(int id);
	public int  allCount(String title);                 
}
