package com.weibo.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.dao.impl.UserDAOTMP;
import com.weibo.model.Comment;
import com.weibo.model.Following;
import com.weibo.model.Forward;
import com.weibo.model.Message;
import com.weibo.model.PrivMes;
import com.weibo.model.User;
import com.weibo.model.UserUpdate;
import com.weibo.service.MainService;


public class ProfileAction extends ActionSupport {
	private User user;//用户
	private int userMessagesOrForwards;//用户微博数量
	private int followersNum;//粉丝的数量
	private int followingsNum;//关注人的数量
	private List<PrivMes> privMeses;//私信集合
	private List<Message> userMessages;//得到用户微博集合
	private List<Forward> userForwards;//得到用户转发集合
	private int userWeiboNum;//得到微博数量
	private List<Comment> comments;//得到评论集合
	private int messageid;//根据JSON方法得到的微博ID
	private int forwardid;//根据JSON方法得到的转发ID
	private Comment commentToMessage;//为一条微博添加一条评论
	private Comment commentToForward;//为一条转发添加一条评论
	private boolean b;//标记发一条评论是否成功
	private int commentToMessageid;//json方法得到的微博或者转发的ID
	private int deleteMessageid;//根据message的ID删除一条微博或者转发
	private Forward forwardToMessage;//保存转发一条微博
	private String fanid;//得到进入微博所属用户的id
	MainService mainService = new MainService();
	private int flag;//标识进入的微博所属的用户以被主用户关注
	
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getFanid() {
		return fanid;
	}
	public void setFanid(String fanid) {
		this.fanid = fanid;
	}
	public Forward getForwardToMessage() {
		return forwardToMessage;
	}
	public void setForwardToMessage(Forward forwardToMessage) {
		this.forwardToMessage = forwardToMessage;
	}
	public int getDeleteMessageid() {
		return deleteMessageid;
	}
	public void setDeleteMessageid(int deleteMessageid) {
		this.deleteMessageid = deleteMessageid;
	}
	public int getCommentToMessageid() {
		return commentToMessageid;
	}
	public void setCommentToMessageid(int commentToMessageid) {
		this.commentToMessageid = commentToMessageid;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public Comment getCommentToMessage() {
		return commentToMessage;
	}
	public void setCommentToMessage(Comment commentToMessage) {
		this.commentToMessage = commentToMessage;
	}
	
	public Comment getCommentToForward() {
		return commentToForward;
	}
	public void setCommentToForward(Comment commentToForward) {
		this.commentToForward = commentToForward;
	}
	public int getForwardid() {
		return forwardid;
	}
	public void setForwardid(int forwardid) {
		this.forwardid = forwardid;
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public int getUserWeiboNum() {
		return userWeiboNum;
	}
	public void setUserWeiboNum(int userWeiboNum) {
		this.userWeiboNum = userWeiboNum;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	public List<PrivMes> getPrivMeses() {
		return privMeses;
	}
	public void setPrivMeses(List<PrivMes> privMeses) {
		this.privMeses = privMeses;
	}
	
	public String loadUserMessagesOrForwards(){//得到用户微博的数量
		userMessagesOrForwards=mainService.userForwardsNum(getUser())+mainService.userMessagesNum(getUser());
		return NONE;
	}
	public String loadFollowersNum(){//得到粉丝数量
		followersNum=mainService.followerNum(getUser());
		return NONE;
	}

	public String laodFollowingsNum(){//得到关注他人的数量
		followingsNum=mainService.funsNum(getUser())-1;
		return NONE;
	}
	
	 public int loadUserMessages(){//得到用户的微博集合数量
		 userMessages=mainService.userMessages(getUser());//得到用户的微博集合
		 return userMessages.size();
	 }
	 public int laodUserForwards(){//得到用户转发集合数量
		 userForwards=mainService.userForwards(getUser());//得到用户转发集合
		 return userForwards.size();
	 }
	 public String loadComments(){//根据微博ID得到评论集合
		 comments=mainService.getComments(getMessageid());
		 //在这里添加一个时间处理的类
		 return SUCCESS;
	 }
	 public String loadCommentsByForwardid(){//根据转发的ID得到评论集合
		 comments=mainService.getCommentsByForwardid(getForwardid());
		
		 //在这里要添加一个时间处理的类
		 return SUCCESS;
	 }
	 public String deleteMessage(){//删除一条微博(对应的评论集自动删除)
		 comments=mainService.getComments(getDeleteMessageid());
		 userForwards=mainService.getForwardsByMessageid(getDeleteMessageid());
		 for(int i=0,size=comments.size();i<size;i++){
				mainService.deleteComment(comments.get(i).getId());//先删除微博对应的评论
			}
		 for(int i=0,size=userForwards.size();i<size;i++){//修改要删除微博对应的评论
			 forwardToMessage=userForwards.get(i);forwardToMessage.setMessage(null);
			 mainService.modify(forwardToMessage);
		 }
		 mainService.deleteMessage(getDeleteMessageid());
		 return SUCCESS;
	 }
	 
	 public String deleteForward(){//删除一条转发(对应的评论集自动删除)
		 comments=mainService.getCommentsByForwardid(getDeleteMessageid());
		 for(int i=0,size=comments.size();i<size;i++){
				mainService.deleteComment(comments.get(i).getId());//先删除微博对应的评论
			}
		 mainService.deleteForward(getDeleteMessageid());
		 return SUCCESS;
	 }
	 
	 public String saveForwardToMessage()throws UnsupportedEncodingException{//保存一条转发
		 ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		Message message2=new Message();
		Forward forward2=new Forward();
		b=false;
		message2=mainService.getMessage(getCommentToMessageid());
		forward2.setComment(getForwardToMessage().getComment());
		forward2.setForwarder(user);
		forward2.setMessage(message2);
		forward2.setTime(new Timestamp(System.currentTimeMillis()));
		b=mainService.ForwardSave(forward2);
		return SUCCESS;
	 }
	 
	 public String saveCommentToMessage() throws UnsupportedEncodingException{//保存微博的一条记录
			ActionContext actionContext =ActionContext.getContext();
			user=(User)actionContext.getSession().get("userSessionKey");
			Comment comment2=new Comment();
			Message message2=new Message();
			UserUpdate userUpdate=new UserUpdate();//在userUpdate表中保存一条新增加的评论
			b= false;
			messageid=getCommentToMessageid();//将微博对应的评论ID通过JSON方法返回到页面
			message2=mainService.getMessage(getCommentToMessageid());
			comment2.setMessage(message2);
			comment2.setUser(user);//得到当前用户
			comment2.setContext(getCommentToMessage().getContext());
			comment2.setTime(new Timestamp(System.currentTimeMillis()));//发微博时间
			b=mainService.commentSave(comment2);
			
			//在userUpdate表中保存一条新增加的评论
			userUpdate.setComment(comment2);
			userUpdate.setSender(user);
			userUpdate.setUserToReceiver(message2.getUser());
			mainService.saveUserUpdate(userUpdate);
			return SUCCESS;
			}
	 
	 public String saveCommentToForward() throws UnsupportedEncodingException{//保存转发的一条记录
			ActionContext actionContext =ActionContext.getContext();
			user=(User)actionContext.getSession().get("userSessionKey");
			Comment comment2=new Comment();
			Forward forward2=new Forward();//将转发对应的评论ID通过JSON方法返回到页面
			UserUpdate userUpdate=new UserUpdate();//在userUpdate表中保存一条新增加的评论
			b= false;	
			forwardid=getCommentToMessageid();
			forward2=mainService.getForward(getCommentToMessageid());
			comment2.setForward(forward2);
			comment2.setUser(user);//得到当前用户
			comment2.setContext(getCommentToForward().getContext());
			comment2.setTime(new Timestamp(System.currentTimeMillis()));//发微博时间
			b=mainService.commentSave(comment2);
			//在userUpdate表中保存一条新增加的评论
			userUpdate.setComment(comment2);
			userUpdate.setSender(user);
			userUpdate.setUserToReceiver(forward2.getForwarder());
			mainService.saveUserUpdate(userUpdate);
			return SUCCESS;
		}
	 
	// public String mainPage(){
	//	 user=new UserDAOTMP().getUser(1);
	//	 return "success";
	// }
	 public String execute(){
		 ActionContext actionContext =ActionContext.getContext();
		 if(getFanid()==null){
			user=(User)actionContext.getSession().get("userSessionKey");
			loadUserMessagesOrForwards();loadFollowersNum();
			laodFollowingsNum();
			userWeiboNum=loadUserMessages()+laodUserForwards();
			return "success";
		 }
		 else {
			 User owner=new User();List<Following> following=new ArrayList<Following>();
			 owner=(User)actionContext.getSession().get("userSessionKey");//得到微博用户实体对象
			 user=mainService.getUser(Integer.parseInt(getFanid()));//得到要进入的微博用户对象
			 loadUserMessagesOrForwards();loadFollowersNum();
				laodFollowingsNum();
				userWeiboNum=loadUserMessages()+laodUserForwards();
				following=mainService.getFollowings(owner.getId(), user.getId());
				 flag=following.size();
				return "fanProfileSuccess";
		 }
	 }
}
