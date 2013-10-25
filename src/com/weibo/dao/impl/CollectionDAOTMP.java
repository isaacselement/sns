package com.weibo.dao.impl;

import java.util.List;

import com.weibo.dao.CollectionDAO;
import com.weibo.init.HibernateUtil;
import com.weibo.model.Collection;
import com.weibo.model.Comment;
import com.weibo.util.HibernateDAO;

public class CollectionDAOTMP extends HibernateDAO implements CollectionDAO {
	//删除一条收藏
	public void delete(Collection collection) {
		super.deleteObject(collection);
	}
	//根据SQL删除一条收藏
	public void delete(String sql){
		HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
	//得到一条收藏
	public Collection getCollection(int id) {
		return (Collection)super.getObject(Collection.class, id);
	}
	//根据条件得到一条微博的收藏集
	public List getCollections(String HQL) {
		return (List)super.getObjects(HQL);
	}
	
	//发布一条收藏
	//返回为true收藏成功
	public boolean insert(Collection collection) {
		return super.saveObject(collection);
	}

}
