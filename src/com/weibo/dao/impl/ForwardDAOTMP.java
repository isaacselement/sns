package com.weibo.dao.impl;

import java.util.List;

import org.hibernate.SQLQuery;

import com.weibo.dao.ForwardDAO;
import com.weibo.init.HibernateUtil;
import com.weibo.model.Forward;
import com.weibo.model.Message;
import com.weibo.util.HibernateDAO;

/**
 * 转发微博ForwardDAO接口的实现
 * @author Administrator
 *
 */
public class ForwardDAOTMP extends HibernateDAO implements ForwardDAO {

	//删除一条转发微博
	public void delete(Forward forward) {
		super.deleteObject(forward);

	}
	public void delete(String sql){
		HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}
	
	//修改转发的内容
	public void modify(Forward forward){
		super.updateObject(forward);
	}

	//根据转发微博id得到一条转发记录
	public Forward getForward(int id) {
		return (Forward)super.getObject(Forward.class, id);
	}

	//根据条件得到转发记录集
	public List getForwards(String HQL) {
		return (List)super.getObjects(HQL);
	}
	
	//通过sql语句得到转发记录集合
	public List<Forward> getForwardsBySQL(String sql){
		SQLQuery sqlquery = HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql);
		sqlquery.addEntity(Forward.class);
		return (List<Forward>)sqlquery.list();
	}

	//发布一条转发信息
	public boolean insert(Forward forward) {
		return super.saveObject(forward);
	}

}
