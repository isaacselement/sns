package com.weibo.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.model.Following;
import com.weibo.model.User;
import com.weibo.service.MainService;
import com.weibo.dao.impl.*;

public class RegisterAction extends ActionSupport {
	
	private String repeatedPassword;//确认的密码
	private User user ;
	
	public String getRepeatedPassword() {
		return repeatedPassword;
	}
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute(){
		if(getUser().getEmail()!=null&&(!getUser().getPassword().equals(""))&&!getRepeatedPassword().equals(""))
		{
			User userExit=new User();
			UserDAOTMP userdaotmp = new UserDAOTMP();
			Following following=new Following();
			userExit=userdaotmp.getUser(getUser().getEmail());
			if(userExit==null){
				if(getUser().getPassword().equals(getRepeatedPassword())){
					boolean b= userdaotmp.isReg(getUser());
					//添加自己关注自己的记录，方便首页展示微博
					following.setFuns(getUser());
					following.setUser(getUser());
					MainService mainService=new MainService();
					mainService.saveFollowing(following);
					ActionContext actionContext =ActionContext.getContext();
					actionContext.getSession().put("userSessionKey", user);
					
					if(b)
						return "success";
					else {
						this.addFieldError("fielderror.register", "注册失败！");
						return "registerFail";
					}
				}
				else {
					this.addFieldError("fielderror.register", "密码不一致，请重新输入！");
					return "passwordRepeat";//密码不一致
				}
			}
			else{//用户已存在
				this.addFieldError("fielderror.register", "该邮箱已注册，请换一个注册！");
				return "userExit";
			}
		}
		else{ 
			this.addFieldError("fielderror.register", "邮件或密码不能为空！");
			return "fail";//不能为空值。
		}
	}
}
