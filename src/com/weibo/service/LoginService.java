package com.weibo.service;

import java.util.List;

import com.weibo.dao.impl.MessageDAOTMP;
import com.weibo.dao.impl.UserDAOTMP;
import com.weibo.model.Message;
import com.weibo.model.User;

public class LoginService {
	UserDAOTMP userdaotmp = new UserDAOTMP();
	MessageDAOTMP messagedaotmp= new MessageDAOTMP();
//	@SuppressWarnings("unchecked")
	public List<User> getUsers(){//得到粉丝数最多的用户集
		return (List<User>)userdaotmp.getUsers("SELECT f.follower  from Follower f group by f.follower");
	}
//	@SuppressWarnings("unchecked")
	public List<Message> getMessages(){//得到最新的微博集合
		return (List<Message>)messagedaotmp.getMessages("FROM Message order by mesTime asc");
	}

}
