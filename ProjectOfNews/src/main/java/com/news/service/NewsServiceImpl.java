package com.news.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.news.dao.NewsDao;
import com.news.entity.News;

@Service
public class NewsServiceImpl implements NewsService{
    @Resource
	private  NewsDao  newsDao;
	public void insertNews(News news) {
		// TODO Auto-generated method stub
		newsDao.insertNews(news);
	}

	public void updateNews(News news) {
		// TODO Auto-generated method stub
		newsDao.updateNews(news);
	}

	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		newsDao.deleteNews(news);
	}

	public List<News> queryNews(int page, int pageSize,String search) {
		// TODO Auto-generated method stub
		return newsDao.queryNews(page, pageSize,search);
	}

	public News getNewsById(int id) {
		// TODO Auto-generated method stub
		return newsDao.getNewsById(id);
	}

	public int allCount(String title) {
		// TODO Auto-generated method stub
		return newsDao.allCount(title);
	}

	

	    
}
