package com.news.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.news.entity.News;
@Repository
public class NewsDaoImpl extends BaseDao implements NewsDao{
	public void insertNews(News news) {
		getSession().save(news);
	}
	public void updateNews(News news) {
		getSession().update(news);
	}
	public void deleteNews(News news) {
		getSession().delete(news);
	}
	@SuppressWarnings("unchecked")
	public List<News> queryNews(int page, int pageSize,String search) {
		String hql="from News c where c.title like :title";
		List<News> list=getSession().createQuery(hql)
				.setString("title", "%"+search+"%")
				.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		return list;
	}
	public News getNewsById(int id) {
		return getSession().get(News.class, id);
	}
	public int allCount(String title) {
		if(title==null){
			title="";
		}
		String hql="select count(*) from News where title like:title";
	    Long count=(Long)this.getSession().createQuery(hql)
	    		.setString("title", "%"+title+"%")
	    		.uniqueResult();
		return count.intValue();
	}


}
