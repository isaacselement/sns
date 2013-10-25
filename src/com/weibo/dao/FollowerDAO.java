package com.weibo.dao;

import java.util.List;

import com.weibo.model.Follower;

/**
 * 被关注FollowerDAO接口
 * @author Administrator
 *
 */
public interface FollowerDAO {
	/**
	 * 用户被取消关注(即粉丝减少)
	 * @param follower 用户被关注的实体
	 */
	void delete(Follower follower);
	
	/**
	 * 用户增加一条被关注信息(即粉丝增加)
	 * @param follower
	 * @return 成功增加被关注信息返回true
	 */
	boolean insert(Follower follower);
	
	/**
	 * 根据被关注ID得到一条被关注信息
	 * @param fid 被关注实体的标识符
	 * @return 一条被关注的实体
	 */
	Follower getFollower(int fid);
	
	/**
	 * 根据条件得到被关注实体集
	 * @param HQL 条件语句
	 * @return 返回被关注实体集
	 */
	List getFollowers(String HQL);
	

}
