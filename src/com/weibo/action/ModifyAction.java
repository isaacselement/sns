package com.weibo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.model.User;
import com.weibo.service.MainService;

public class ModifyAction extends ActionSupport{

	private User user;
	private User owner;

	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String execute(){
		
		ActionContext actionContext=ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		return "success";
	}
	public String userModify(){//修改用户的个人信息
		ActionContext actionContext=ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		user.setAddress(getOwner().getAddress());user.setAge(getOwner().getAge());
		user.setPassword(getOwner().getPassword());user.setPhone(getOwner().getPhone());
		user.setSex(getOwner().isSex());user.setUsername(getOwner().getUsername());
		MainService mainService=new MainService();
		mainService.modify(getUser());
		return "success";
	}

}

