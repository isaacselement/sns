package com.weibo.dao;

import java.util.List;

import com.weibo.model.Comment;
//import com.weibo.model.Message;


/**
 * 评论操作MessageDAO接口
 * @author Administrator
 *
 */
public interface CommentDAO {
	/**
	 * 用户评论一条信息的对象实体
	 * @param comment 要评论一条信息评论实体
	 * @return 返回评论成功，true为成功.
	 */
	boolean insert(Comment comment);
	
	
	/**
	 * 删除评论实体对象
	 * @param comment 要删除评论的实体
	 */
	void delete(Comment comment);
	
	/**
	 * 通过ID得到一条评论的实体对象
	 * @param id 评论实体对象的标识符
	 * @return 返回标识符相匹配的评论实体对象
	 */
	Comment getComment(int id);
	
	/**
	 * 通过HQL语句查找多条评论的实体对象集
	 * @param HQL 查找的条件语句
	 * @return 返回评论实体对象集
	 */
	List getComments(String HQL);
	
//	/**
//	 * 通过微博的ID找到评论的对象集
//	 * @param Mesid 微博的ID
//	 * @return 返回评论实体的对象集
//	 */
//	List getComments(int Mesid);
	
	
	

}
