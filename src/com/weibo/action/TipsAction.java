package com.weibo.action;

import java.sql.Timestamp;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.model.Comment;
import com.weibo.model.User;
import com.weibo.model.UserUpdate;
import com.weibo.service.MainService;

public class TipsAction extends ActionSupport {
	private  User user;//用户
	private List<UserUpdate> userUpdates;
	private int userUpdatesSize;//私信或评论数量
	private List<UserUpdate> userUpdate;//用户的新消息
	private String context;//通过json方法得到回复评论内容
	private int commentid;;//通过JSON方法得到要回复评论的ID
	
	MainService mainService = new MainService();
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public List<UserUpdate> getUserUpdate() {
		return userUpdate;
	}
	public void setUserUpdate(List<UserUpdate> userUpdate) {
		this.userUpdate = userUpdate;
	}
	public int getUserUpdatesSize() {
		return userUpdatesSize;
	}
	public void setUserUpdatesSize(int userUpdatesSize) {
		this.userUpdatesSize = userUpdatesSize;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<UserUpdate> getUserUpdates() {
		return userUpdates;
	}
	public void setUserUpdates(List<UserUpdate> userUpdates) {
		this.userUpdates = userUpdates;
	}

	public String getTips(){//提示用户得到新评论和私信
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		userUpdates=mainService.getFloatComments(user.getId());userUpdatesSize=userUpdates.size();
		return SUCCESS;
	}
	public String showComments(){//展示新消息的内容
		getTips();
		mainService.deleteUserUpdate(user.getId());//删除在UserUpdate表里看过的信息
		return "success";
	}
	
	public String replyComment(){//回复评论
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		Comment comment=new Comment();
		Comment saveComment=new Comment();
		UserUpdate userUpdate=new UserUpdate();
		
		//保存一条回复的评论
		comment=mainService.getComment(commentid);//根据评论ID得到要回复的-评论实体对象
		saveComment.setContext(context);
		saveComment.setTime(new Timestamp(System.currentTimeMillis()));
		saveComment.setUser(user);
		if(comment.getForward()==null){
			saveComment.setMessage(comment.getMessage());
			saveComment.setForward(null);
		}
		else {
			saveComment.setForward(comment.getForward());
			saveComment.setMessage(null);
		}
		mainService.commentSave(saveComment);
		
		//更新一条回复的评论
		userUpdate.setComment(saveComment);
		userUpdate.setSender(user);
		userUpdate.setUserToReceiver(comment.getUser());
		userUpdate.setPriMes(null);
		mainService.saveUserUpdate(userUpdate);
		return SUCCESS;
	}

}
