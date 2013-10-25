package com.weibo.dao;

import java.util.List;

import com.weibo.model.Forward;

/**
 * 转发操作ForwardDAO接口
 * @author Administrator
 *
 */
public interface ForwardDAO {
	/**
	 * 删除一条转发信息
	 * @param forward 要删除转发信息的实体对象
	 */
	void delete(Forward forward);
	
	/**
	 * 发布一条转发的信息
	 * @param forward 转发信息的实体
	 * @return 发布成功返回true
	 */
	boolean insert(Forward forward);
	
	/**
	 * 得到一条转发的信息
	 * @param id 转发信息的标识符
	 * @return 返回转发的信息
	 */
	Forward getForward(int id);
	
	/**
	 * 得到附和条件的转发信息集
	 * @param HQL 查询条件
	 * @return  返回附和条件的转发信息集。
	 */
	List getForwards(String HQL);

}
