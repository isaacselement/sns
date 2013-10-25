package com.weibo.dao;

import java.util.List;

import com.weibo.model.Following;


/**
 * 关注操作FollowingDAO接口
 * @author Administrator
 *
 */
public interface FollowingDAO {
	
	/**
	 * 用户删除一条关注实体
	 * @param following 关注实体对象
	 */
	void delete(Following following);
	
	/**
	 * 增加一条关注实体对象
	 * @param following 关注实体对象
	 * @return 成功增加返回true
	 */
	boolean insert(Following following);
	
	/**
	 * 根据关注实体ID得到关注实体对象
	 * @param fid 关注实体对象的标识符
	 * @return 成功得到实体对象返回true
	 */
	Following getFollowing(int fid);
	
	/**
	 * 根据条件得到关注实体对象集
	 * @param HQL 条件查询语句
	 * @return 成功得到实体集返回true
	 */
	List getFollowings(String HQL);

}
