package com.weibo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.weibo.model.User;

public class PrivateMessAction extends ActionSupport {
	private User user;//用户
	private int followersNum;//粉丝的数量
	private int followingsNum;//关注人的数量
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFollowersNum() {
		return followersNum;
	}
	public void setFollowersNum(int followersNum) {
		this.followersNum = followersNum;
	}
	public int getFollowingsNum() {
		return followingsNum;
	}
	public void setFollowingsNum(int followingsNum) {
		this.followingsNum = followingsNum;
	}
	public String showPrivateMess(){
		
		return null;
	}

}
