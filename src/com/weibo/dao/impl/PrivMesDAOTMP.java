package com.weibo.dao.impl;

import java.util.List;

import com.weibo.dao.PrivMesDAO;
import com.weibo.model.PrivMes;
import com.weibo.util.HibernateDAO;

/**
 * 私信PrivMesDAO接口的实现
 * @author Administrator
 *
 */
public class PrivMesDAOTMP extends HibernateDAO implements PrivMesDAO {

	//删除一条私信
	public void delete(PrivMes privMes) {
		super.deleteObject(privMes);
	}

	//根据私信ID得到该私信
	public PrivMes getPrivMes(int id) {
		return (PrivMes)super.getObject(PrivMes.class, id);
	}

	//根据查询条件得到私信集
	public List getPrivMeseses(String HQL) {
		return (List)super.getObjects(HQL);
	}

	//发送一条私信
	public boolean insert(PrivMes privMes) {
		return super.saveObject(privMes);
	}

}
