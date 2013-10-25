package com.weibo.action;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.dao.impl.*;
import com.weibo.model.*;
import com.weibo.service.MainService;


public class MainAction extends ActionSupport {

	private Message message;//发布的微博
	private  User user;//用户
	private String followersid;//得到进入粉丝所属用户的ID
	private String followingid;//得到进入好友页面所属用户的ID
	private List<Message> messages;//微博集合
	private List<Forward> forwards;//转发集合
	private List<Comment> comments;//评论集合
	private List<User> followers;//得到粉丝的集合
	private List<User> followings;//得到用户关注人的集合
	private List<PrivMes> privMeses;//私信集合
	private List<UserUpdate> userUpdates;//刷表，得到最新的私信和评论 ,还没实现
	private int userUpdatesSize;//私信或评论数量
	boolean b;//用来返回到主页提示发布微博是否成功.
	private List<Message> userMessages;//得到用户微博集合
	private List<Forward> userForwards;//得到用户转发集合
	private List<User> choUser;//搜索到附和的用户
	private int choUserSize;//搜索到符合的用户数量
	private String searchUser;//得到要搜索的内容
	
	private int userMessagesOrForwards;//用户微博数量
	private int followersNum;//粉丝的数量
	private int followingsNum;//关注人的数量
	private int followingToUserid;//得到要关注人的ID

	private String content;
	
	MainService mainService = new MainService();
	
	
	
	public int getUserUpdatesSize() {
		return userUpdatesSize;
	}
	public void setUserUpdatesSize(int userUpdatesSize) {
		this.userUpdatesSize = userUpdatesSize;
	}
	public int getFollowingToUserid() {
		return followingToUserid;
	}
	public void setFollowingToUserid(int followingToUserid) {
		this.followingToUserid = followingToUserid;
	}
	public int getChoUserSize() {
		return choUserSize;
	}
	public void setChoUserSize(int choUserSize) {
		this.choUserSize = choUserSize;
	}
	public List<User> getChoUser() {
		return choUser;
	}
	public void setChoUser(List<User> choUser) {
		this.choUser = choUser;
	}
	public String getSearchUser() {
		return searchUser;
	}
	public void setSearchUser(String searchUser) {
		this.searchUser = searchUser;
	}
	public String getFollowingid() {
		return followingid;
	}
	public void setFollowingid(String followingid) {
		this.followingid = followingid;
	}
	public String getFollowersid() {
		return followersid;
	}
	public void setFollowersid(String followersid) {
		this.followersid = followersid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public int getUserMessagesOrForwards() {
		return userMessagesOrForwards;
	}
	public void setUserMessagesOrForwards(int userMessagesOrForwards) {
		this.userMessagesOrForwards = userMessagesOrForwards;
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
	
	
	public List<Message> getUserMessages() {
		return userMessages;
	}
	public void setUserMessages(List<Message> userMessages) {
		this.userMessages = userMessages;
	}
	public List<Forward> getUserForwards() {
		return userForwards;
	}
	public void setUserForwards(List<Forward> userForwards) {
		this.userForwards = userForwards;
	}
	public Message getMessage() {
		return message;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Forward> getForwards() {
		return forwards;
	}
	public void setForwards(List<Forward> forwards) {
		this.forwards = forwards;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<User> getFollowers() {
		return followers;
	}
	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	public List<User> getFollowings() {
		return followings;
	}
	public void setFollowings(List<User> followings) {
		this.followings = followings;
	}
	public List<PrivMes> getPrivMeses() {
		return privMeses;
	}
	public void setPrivMeses(List<PrivMes> privMeses) {
		this.privMeses = privMeses;
	}
	public List<UserUpdate> getUserUpdates() {
		return userUpdates;
	}
	public void setUserUpdates(List<UserUpdate> userUpdates) {
		this.userUpdates = userUpdates;
	}
	
	public String saveMessage() throws UnsupportedEncodingException{//保存发布的微博
		String picturePath=new String();
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		picturePath=(String)actionContext.getSession().get("getUploadPicturePath");
		Message message2=new Message();
		b= false;
		message2.setUser(user);//得到当前用户
		//System.out.println(getMessage().getContext().getBytes("gbk"));
		message2.setContext(getMessage().getContext());
		message2.setImage(picturePath);//图片的路径
		actionContext.getSession().put("getUploadPicturePath", null);
		message2.setVideo(null);//视频的地址（还没实现）
		message2.setMesTime(new Timestamp(System.currentTimeMillis()));//发微博时间
		b=mainService.messageSave(message2);message=message2;
		return SUCCESS;
	}
	
	public String loadMessages(){//得到用户关注人的微博集合
		messages = mainService.messages(getUser(),0,10);
		Collection collection = null;
		for(int i=0;i<messages.size();i++){
			collection = mainService.getCollectMess(messages.get(i).getMid()+"", getUser());
			if(collection!=null){
				messages.get(i).setFlag("1");
			}
			else messages.get(i).setFlag("0");
			collection = null;
		}
		return NONE;
	}
	
	public String loadForwards(){//得到用户关注他人的转发集合
		forwards=mainService.forwards(getUser(),0,10);
		Collection collection = null;
		for(int i=0;i<forwards.size();i++){
			collection = mainService.getCollectionForw(forwards.get(i).getFid()+"", getUser());
			if(collection!=null){
				forwards.get(i).setFlag("1");
			}
			else forwards.get(i).setFlag("0");
			collection = null;
		}
		return NONE;
	}
	
	public String loadFollowers(){//得到粉丝的集合
		followers=mainService.getfollowers(getUser());
		followersNum=followers.size();////得到粉丝数量,不算自己
		return NONE;
	}
	
	public String loadFollowings(){//得到关注他人的集合
		followings=mainService.getfollowings(getUser());
		followingsNum=followings.size()-1;//得到关注他人的数量
		return NONE;
	}
	
	public String loadPrivMeses(){//得到还没看的私信集合
		privMeses=mainService.getPrivMeses(getUser());
		return NONE;
		
	}
	public String loadUserMessages(){//得到用户微博的集合
		userMessages=mainService.userMessages(getUser());
		return NONE;
	}
	public String loadUserForwards(){//得到用户转发的集合
		userForwards=mainService.userForwards(getUser());
		return NONE;
	}
	
//	public String userPage(){//转到用户的微博主页(即我的微博)
//		user=new UserDAOTMP().getUser(2);
//		if(getUser()!=null)
//		{
//			return "success";
//		}
//		else return "userNotExit";
//	}
	
	
	public String loadUserMessagesOrForwards(){//得到用户微博的数量
		userMessagesOrForwards=userMessages.size()+userForwards.size();
		return NONE;
	}
	
	
	public String execute(){
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		loadMessages();loadForwards();loadFollowers();
		loadFollowings();
		loadPrivMeses();
		loadUserMessages();loadUserForwards();
		loadUserMessagesOrForwards();getTips();
		
		return "success";
	}
	public String getFollows(){//得到粉丝页面的数据
	//	ActionContext actionContext =ActionContext.getContext();
		//user=(User)actionContext.getSession().get("userSessionKey");
		user=mainService.getUser(Integer.parseInt(getFollowersid()));
		loadFollowers();
		loadFollowings();
		loadUserMessages();loadUserForwards();loadUserMessagesOrForwards();
		return "success";
	}
	public String getMyFollowings(){//得到我的关注（好友）页面的数据
		user=mainService.getUser(Integer.parseInt(getFollowingid()));
		loadFollowings();
		loadFollowers();
		loadUserMessages();loadUserForwards();loadUserMessagesOrForwards();
		return "success";
	}
	
	public String getEchoUser(){//得到符合查询条件的用户
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		loadFollowers();
		loadFollowings();
		loadUserMessages();loadUserForwards();
		loadUserMessagesOrForwards();
		choUser=mainService.getUsers(getSearchUser());
		choUserSize=choUser.size();
		return "success";
	}
	
	public String addFollowing(){//关注他人
		User followingToUser=new User();
		Following following=new Following();
		Follower follower=new Follower();
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		followingToUser=mainService.getUser(getFollowingToUserid());//根据ID得到要关注人的实体对象
		following.setUser(getUser());
		following.setFuns(followingToUser);
		mainService.saveFollowing(following);
		follower.setBefollowed(user);
		follower.setFollower(followingToUser);
		mainService.saveFollower(follower);
		return SUCCESS;
	}
	public String getTips(){
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		userUpdates=mainService.getFloatComments(user.getId());userUpdatesSize=userUpdates.size();
		return SUCCESS;
	}
	
	
	public String logout(){
		Map session=ActionContext.getContext().getSession(); 
		session.clear(); 
		return "success";
	}
}
