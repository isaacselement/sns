package com.weibo.dao;


import java.util.List;

import com.weibo.model.User;
/*
 * 用户 操作UserDAO的接口
 * */
public interface UserDAO {
	/**
	 * 	注册一个用户实体
	 * @param user 被注册的用户对象
	 * @return 改用户是否被注册成功
	 */
	boolean  isReg(User user);//用户注册功能
	
	/**
	 * 	修改一个用户信息
	 * @param user 被修改的用户对象
	 */
	void  modify(User user);//修改用户的资料
		
		/**
		 * 删除用户实体对象
		 * @param user 要删除用户的实体
		 */
		void delete(User user);
		
		/**
		 * 通过ID得到一个用户的实体对象
		 * @param id 实体对象的标识符
		 * @return 返回标识符相匹配的用户实体对象
		 */
		User getUser(int id);
		
		/**
		 * 通过email语句得到一个用户的实体对象
		 * @param email 唯一的email
		 * @return 返回一个实体对象
		 */
		User getUser(String email);
		
		/**
		 * 通过sql语句得到多个实体对象
		 * @param hql 查询语句
		 * @return 返回多个实体对象
		 */
		List getUsers(String hql);
		
}
