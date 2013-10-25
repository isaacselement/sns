package com.weibo.dao;

import java.util.List;

import com.weibo.model.Message;

/**
 * 信息操作MessageDAO接口
 * @author Administrator
 *
 */
public interface MessageDAO {
	/**
	 * 用户发布一条信息的实体
	 * @param message 要发布的信息信息实体
	 * @return 返回发布成功，true为成功.
	 */
	boolean insert(Message message);
	
	
	/**
	 * 删除发布过的信息实体对象
	 * @param message 要删除信息的实体
	 */
	void delete(Message message);
	
	/**
	 * 通过ID得到一条发布信息的实体对象
	 * @param id 信息实体对象的标识符
	 * @return 返回标识符相匹配的发布信息实体对象
	 */
	Message getMessage(int id);
	
	/**
	 * 通过HQL语句查找多条发布信息的实体对象集
	 * @param HQL 查找的条件语句
	 * @return 返回信息实体对象集
	 */
	List getMessages(String HQL);
	
	
	
}
