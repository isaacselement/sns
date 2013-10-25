package com.weibo.dao.impl;

import java.util.List;

import com.weibo.dao.FollowingDAO;
import com.weibo.model.Following;
import com.weibo.util.HibernateDAO;

public class FollowingDAOTMP extends HibernateDAO implements FollowingDAO {

	//用户删出一条关注其他人的信息
	public void delete(Following following) {
		super.deleteObject(following);

	}

	//根据关注ID得到一条关注信息
	public Following getFollowing(int fid) {
		return (Following)super.getObject(Following.class, fid);
	}

	//根据条件查找关注信息集
	public List getFollowings(String HQL) {
		return (List)super.getObjects(HQL);
	}

	//用户增加一条关注其他人的信息
	public boolean insert(Following following) {
		return super.saveObject(following);
	}

}
