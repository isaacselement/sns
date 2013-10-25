package com.weibo.action;

import java.util.List;

import org.hibernate.mapping.Map;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.dao.impl.UserDAOTMP;
import com.weibo.model.Message;
import com.weibo.model.User;
import com.weibo.service.LoginService;

public class LoginAction extends ActionSupport {
	
	private String password;
	private String email;
	private User user;
	private List<User> users;//得到粉丝数最多的用户
	private List<Message> messages;//得到最新的微博集合
		
	UserDAOTMP userdaotmp = new UserDAOTMP();
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String execute(){
		loadTopFans();
		loadMessages();
		user=userdaotmp.getUser(getEmail());
		if(user!=null){
			if(user.getEmail().equals(getEmail())&&user.getPassword().equals(getPassword())){
				ActionContext actionContext =ActionContext.getContext();
				actionContext.getSession().put("userSessionKey", user);
				
				return "success";//返回到用户的主界面
			}
			else {
					this.addFieldError("fielderror.user", "用户或密码错误，请重新输入！");
					return "userOrPasswordError";//输入错误
			}
		}
			this.addFieldError("fielderror.user", "用户不存在");
			return "userNONE";//用户不存在
		
	}
	
	public String loadMessages(){//得到最新的微博集合，由于还没进行时间的处理，所以暂时不以时间先后来排序.
	messages=new LoginService().getMessages();	
		return SUCCESS;
	}
	
	public String loadTopFans(){//得到粉丝多的用户
		users=new LoginService().getUsers();
		return SUCCESS;
	}
	

}
