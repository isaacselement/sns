package com.weibo.dao.impl;

import java.util.List;

import com.weibo.dao.CommentDAO;
import com.weibo.init.HibernateUtil;
import com.weibo.model.Comment;
import com.weibo.model.Message;
import com.weibo.util.HibernateDAO;

/**
* CommentDAO接口的实现
* @author Administrator
*
*/
public class CommentDAOTMP extends HibernateDAO implements CommentDAO {

	//删除一条评论
	public void delete(Comment comment) {
		super.deleteObject(comment);

	}
	//根据SQL删除一条评论
	public void delete(String sql){
		HibernateUtil.getSessionFactory().getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	//得到一条评论
	public Comment getComment(int id) {
		return (Comment)super.getObject(Comment.class, id);
	}

	//根据条件得到一条微博的评论集
	public List getComments(String HQL) {	
		return (List)super.getObjects(HQL);
	}
	
//	//根据微博的id得到一条该微博的评论集
//	public List getComments(int Mesid) {
//		return (List)super.get;
//	}

	//发布一条评论
	//返回为true评论成功
	public boolean insert(Comment comment) {
		return super.saveObject(comment);
	}


}
