package com.weibo.dao;

import java.util.List;

import com.weibo.model.PrivMes;

/**
 * 私信操作MessageDAO接口
 * @author Administrator
 *
 */
public interface PrivMesDAO {
	/**
	 * 用户发一条私信的对象实体
	 * @param privMes 要发一条私信实体
	 * @return 返回发送私信成功，true为成功.
	 */
	boolean insert(PrivMes privMes);
	
	/**
	 * 删除私信实体对象
	 * @param privMes 要删除私信的实体
	 */
	void delete(PrivMes privMes);
	
	/**
	 * 通过ID得到一条私信的实体对象
	 * @param id 私信实体对象的标识符
	 * @return 返回标识符相匹配的私信论实体对象
	 */
	PrivMes getPrivMes(int id);
	
	/**
	 * 通过HQL语句查找多条私信的实体对象集
	 * @param HQL 查找的条件语句
	 * @return 返回私信实体对象集
	 */
	List getPrivMeseses(String HQL);

}
