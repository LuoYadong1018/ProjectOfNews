package com.news.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.news.entity.Channel;
@Repository
public class ChannelDaoImpl extends  BaseDao implements ChannelDao {
	public void insertUser(Channel channel) {
		getSession().save(channel);
	}
	public void updateUser(Channel channel) {
		getSession().update(channel);
	}
	public void deleteUser(Channel channel) {
		getSession().delete(channel);
	}

	@SuppressWarnings("unchecked")
	public List<Channel> queryUser(int page, int pageSize,String search) {
		if(search==null){
			search="";
		}
		String hql="from Channel c where c.name like :name";
		
		List<Channel> list=getSession().createQuery(hql)
				.setString("name", "%"+search+"%")
				.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		return list;
	}
	public int allCount(String name) {
		if(name==null){
			name="";
		}
		String hql="select count(*) from Channel where name like :name";
	    Long count=(Long)this.getSession().createQuery(hql)
	    		.setString("name", "%"+name+"%")
	    		.uniqueResult();
		return count.intValue();
	}

}
