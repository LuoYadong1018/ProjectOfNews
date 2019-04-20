package com.news.dao;
import java.util.List;
import org.springframework.stereotype.Component;

import com.news.entity.User;
/**
 *   用户实现类.
 */

@Component
public class UserDaoImpl extends BaseDao implements UserDao {
  //依赖属性 
	public User loginUser(String name) {
     String hql=" from User u where u.name =:name";
		
	  User user=(User) getSession()
	  .createQuery(hql)
	  .setString("name", name)
	  .uniqueResult();
	  return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> queryUser() {
		String  hql="from User";
		List<User> list=getSession().createQuery(hql).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<User> queryUser(int  page,int pageSize,String search) {
		String  hql="from User u  where u.name like :name";
		List<User> list=getSession().createQuery(hql)
				.setString("name", "%"+search+"%")
				.setFirstResult((page-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		return list;
	}
	
	
	
	public void addUser(User user) {
		getSession().save(user);
	}

	public void updateUser(User user) {
		getSession().update(user);
	}

	public void delUser(User user) {
		getSession().delete(user);
	}

	public int allCount(String search) {
		String   hql="select count(*) from User u where u.name like :name ";
		Long  count=(Long) getSession().createQuery(hql)
				.setString("name", "%"+search+"%")
				.uniqueResult();
		return count.intValue();
	}

	public void levUser(User user) {
		String  hql="update User u  set u.lev = :lev where u.id=:id";
		getSession().createQuery(hql).setInteger("id", user.getId()).setString("lev", user.getLev()).executeUpdate();
	}

}
