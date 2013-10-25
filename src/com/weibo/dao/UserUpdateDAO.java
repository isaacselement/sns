package com.weibo.dao;

import java.util.List;

import com.weibo.model.UserUpdate;

/**
 * 用户新私信、新评论操作UserUpdateDAO接口
 * @author Administrator
 *
 */
public interface UserUpdateDAO {
	/**
	 * 删除已经阅读一条的私信或者评论
	 * @param userUpdate
	 */
	void delete(UserUpdate userUpdate);
	
	/**
	 *删除已经阅读的所有私信以及评论
	 * @param HQL 条件语句
	 */
	void deletes(String HQL);
	
	/**
	 *增加一条新的私信或评论
	 */
	boolean insert(UserUpdate userUpdate);
	
	/**
	 * 得到一条新的私信或评论
	 * @param uid	私信或评论的实体对象标识符
	 * @return	成功返回私信或评论实体对象
	  */
	UserUpdate getUserUpdate(int uid);
	
	
	/**
	 * 得到一个用户的所有私信或评论
	 * @param HQL 条件语句
	 * @return 成功返回附和条件的所有私信或评论
	 */
	List getUserUpdates(String HQL);

}
