package com.weibo.dao.impl;

import java.util.List;

import com.weibo.dao.UserDAO;
import com.weibo.model.User;
import com.weibo.util.HibernateDAO;
/*
 * 
 *UserDAO接口的实现 
 *
 */
public class UserDAOTMP extends HibernateDAO implements UserDAO {

	/*
	 * 删除一个用户实体对象
	 */
	public void delete(User user) {
		
		super.deleteObject(user);
	}

	/*
	 * 注册一个用户实体对象
	 * return 返回注册是否成功，true为成功.
	 */
	public boolean isReg(User user) {
		
		return super.saveObject(user);
	}

	/*
	 * 修改用户信息
	 */
	public void modify(User user) {
		super.updateObject(user);

	}

	/*
	 * return 返回一个用户的实例
	 */
	public User getUser(int id) {
		
		return (User)super.getObject(User.class, id);
	}

	public User getUser(String email){
		return (User)super.getObject("from User Where email= '"+email+"'");
	}
	
	public List<User> getUsers(String hql){
		return (List<User>)super.getObjects(hql);
		
	}

}
