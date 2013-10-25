package com.weibo.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.weibo.dao.UserUpdateDAO;
import com.weibo.init.HibernateUtil;
import com.weibo.model.UserUpdate;
import com.weibo.util.HibernateDAO;

/**
 * 提示新的用户私信、发布评论信息的记录表UserUpdateDAO接口的实现
 * @author Administrator
 *
 */
public class UserUpdateDAOTMP extends HibernateDAO implements UserUpdateDAO {

	//删除一条私信、评论信息记录表的一条记录
	public void delete(UserUpdate userUpdate) {
		super.deleteObject(userUpdate);

	}

	//删除符合hql条件的所有记录
	public void deletes(String HQL) {
		Iterator itaratorUserUpdate = getUserUpdates(HQL).iterator();
		if(itaratorUserUpdate.hasNext()){
			super.deleteObject((UserUpdate)itaratorUserUpdate.next());
		}

	}
	public void deleteBysql(String sql){
		HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	//根据记录表的ID得到一条记录实体
	public UserUpdate getUserUpdate(int uid) {
		return (UserUpdate)super.getObject(UserUpdate.class, uid);
	}

	//根据HQL语句得到所有附和条件的记录
	public List getUserUpdates(String HQL) {
		return (List)super.getObjects(HQL);
	}

	//用户发一条私信或评论会同步更新记录表(增加一条记录)
	public boolean insert(UserUpdate userUpdate) {
		return super.saveObject(userUpdate);
	}

}
