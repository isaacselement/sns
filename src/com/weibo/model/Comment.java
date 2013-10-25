package com.weibo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




/**
 * 每条信息的评论
 * */
@Entity
@Table(name="comment")
public class Comment implements Serializable{
	private int id;//主键
	//private int ownerid;//用户的ID
	//private int messageid;//被评论信息的ID
	private String context;//评论的内容
	private Date time;//评论的时间
	private User user;
	private Message message;
	private Forward forward;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	public int getOwnerid() {
//		return ownerid;
//	}
//	public void setOwnerid(int ownerid) {
//		this.ownerid = ownerid;
//	}
//	public int getMessageid() {
//		return messageid;
//	}
//	public void setMessageid(int messageid) {
//		this.messageid = messageid;
//	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	//与用户是多对一的单向关系
	@ManyToOne
	@JoinColumn(name="ownerid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//与发布的信息是多对一的单向关系
	@ManyToOne
	@JoinColumn(name="messageid")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	//与转发的信息是多对一的单向关系
	@ManyToOne
	@JoinColumn(name="forwardid")
	public Forward getForward() {
		return forward;
	}
	public void setForward(Forward forward) {
		this.forward = forward;
	}
}
