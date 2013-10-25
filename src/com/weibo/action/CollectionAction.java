package com.weibo.action;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.model.Collection;
import com.weibo.model.Forward;
import com.weibo.model.Message;
import com.weibo.model.User;
import com.weibo.service.MainService;

public class CollectionAction extends ActionSupport {
	private User user;
	private int collectionToMessageid;//收藏微薄的id
	private int collectionToForwardid;//收藏转发的id
	private boolean b;//收藏微薄是否成功
	MainService mainService = new MainService();
	
	public int getCollectionToForwardid() {
		return collectionToForwardid;
	}
	public void setCollectionToForwardid(int collectionToForwardid) {
		this.collectionToForwardid = collectionToForwardid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getCollectionToMessageid() {
		return collectionToMessageid;
	}
	public void setCollectionToMessageid(int collectionToMessageid) {
		this.collectionToMessageid = collectionToMessageid;
	}
	public String execute(){
		user = getOwner();
		return null;
	}
	//收藏微薄
	public String saveCollection(){
		user = getOwner();
		b = false;
		Message message1 = mainService.getMessage(getCollectionToMessageid());
		Collection collection  = new Collection();
		collection.setDate(new Timestamp(System.currentTimeMillis()));
		collection.setForward(null);
		collection.setMark(null);
		collection.setUser(user);
		collection.setMessage(message1);
		b = mainService.saveCollection(collection);
		if(b = true) return SUCCESS;
		else return ERROR;
	}
	//取消微薄的收藏
	public String deleteCollectMess(){
		user = getOwner();
		Collection collection = mainService.getCollectMess(getCollectionToMessageid()+"", user);
		mainService.deleteCollectMess(collection);
		return SUCCESS;
	}
	//收藏转发
	public String saveForwardCollection(){
		user = getOwner();
		b = false;
		Forward forward1 = mainService.getForward(getCollectionToForwardid());
		Collection collection  = new Collection();
		collection.setDate(new Timestamp(System.currentTimeMillis()));
		collection.setForward(forward1);
		collection.setMark(null);
		collection.setUser(user);
		collection.setMessage(null);
		b = mainService.saveCollection(collection);
		if(b = true) return SUCCESS;
		else return ERROR;
	}
	//取消转发的收藏
	public String deleteCollectForw(){
		user = getOwner();
		Collection collection = mainService.getCollectionForw(getCollectionToForwardid()+"", user);
		mainService.deleteCollectMess(collection);
		return SUCCESS;
	}
	
	private User getOwner(){
		ActionContext actionContext=ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		return user;
	}
}
