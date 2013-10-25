package com.weibo.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.weibo.dao.FollowerDAO;
import com.weibo.init.HibernateUtil;
import com.weibo.model.Follower;
import com.weibo.util.HibernateDAO;

/**
* 被关注FollowerDAO接口的实现
* @author Administrator
*
*/
public class FollowerDAOTMP extends HibernateDAO implements FollowerDAO {

	//用户被取消一条关注（粉丝减少）
	public void delete(Follower follower) {
		super.deleteObject(follower);

	}

	//根据被关注ID得到一条被关注的实体
	public Follower getFollower(int fid) {
		
		return (Follower)super.getObject(Follower.class, fid);
	}

	//根据条件得到被关注实体的实体集
	public List getFollowers(String HQL) {
		return (List)super.getObjects(HQL);
	}
	
	//返回粉丝数
	public int getFollowerNum(String hql){
		return ((Number)(HibernateUtil.getSessionFactory().getCurrentSession().createQuery(hql).uniqueResult())).intValue();
	}

	//增加一条被关注的实体
	public boolean insert(Follower follower) {
		return super.saveObject(follower);
	}
	

}
