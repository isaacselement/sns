package com.weibo.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import com.weibo.dao.MessageDAO;
import com.weibo.init.HibernateUtil;
import com.weibo.model.Message;
import com.weibo.util.HibernateDAO;

/**
 * MessagerDAO接口的实现
 * @author Administrator
 *
 */
public class MessageDAOTMP extends HibernateDAO implements MessageDAO {

	/*
	 * 删除一条发布过的信息
	 */
	public void delete(Message message) {
		super.deleteObject(message);

	}
	
	public void delete(String sql){
		HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	/*
	 * return 返回一条发布的信息
	 */
	public Message getMessage(int id) {
		
		return (Message)super.getObject(Message.class, id);
	}

	/*
	 * 发布一条微博信息
	 * return 返回发布是否成功，true为是。
	 */
	public boolean insert(Message message) {
		
		return super.saveObject(message);
	}

	/*
	 * 查找附和条件的微博
	 * return 返回微博集
	 */
	public List getMessages(String HQL) {
		return (List)super.getObjects(HQL);
		
	}
	
	//通过sql语句要查询到微博的集合
	public List<Message> getMessagesBySQL(String sql){
		SQLQuery sqlquery = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		sqlquery.addEntity(Message.class);
		return (List<Message>)sqlquery.list();
	}

}
