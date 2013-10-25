package com.weibo.dao;

import java.util.List;

import com.weibo.model.Collection;

/**
 * 收藏操作接口
 * @author zou
 *
 */
public interface CollectionDAO {
	/**
	 * 用户收藏一条信息的对象实体
	 * @param collection 要收藏一条信息收藏实体
	 * @return 返回评论成功，true为成功.
	 */
	boolean insert(Collection collection);
	
	
	/**
	 * 删除收藏实体对象
	 * @param collection 要删除收藏的实体
	 */
	void delete(Collection collection);
	
	/**
	 * 删除收藏实体对象
	 * @param sql sql操作
	 */
	public void delete(String sql);
	
	/**
	 * 通过ID得到一条收藏的实体对象
	 * @param id 收藏实体对象的标识符
	 * @return 返回标识符相匹配的收藏实体对象
	 */
	Collection getCollection(int id);
	
	/**
	 * 通过HQL语句查找多条收藏的实体对象集
	 * @param HQL 查找的条件语句
	 * @return 返回收藏实体对象集
	 */
	List getCollections(String HQL);

}
