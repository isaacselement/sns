package com.weibo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 提示新的用户私信、发布评论信息的记录表
 * */
@Entity
@Table(name="userUpdate")
public class UserUpdate implements Serializable{
	private int id;//主键
	//private int messageid;//还没读取最新发布信息
	//private int privmesid;//还没读取最新的私信
	//private int commentid;//还没读取最新的评论
	//private int sendid;//发私信用户的ID
//	private Message message;
	private PrivMes priMes;
	private Comment comment;
	private User sender;//新纪录发布者
	private User userToReceiver;//此记录的归属者
	
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
//	@ManyToOne
//	@JoinColumn(name="messageid")
//	public Message getMessage() {
//		return message;
//	}
//	public void setMessage(Message message) {
//		this.message = message;
//	}
	
	@ManyToOne
	@JoinColumn(name="privMesid")
	public PrivMes getPriMes() {
		return priMes;
	}
	public void setPriMes(PrivMes priMes) {
		this.priMes = priMes;
	}
	
	@ManyToOne
	@JoinColumn(name="commentid")
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	@ManyToOne
	@JoinColumn(name="senderid")
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	@ManyToOne
	@JoinColumn(name="userToReiverid")
	public User getUserToReceiver() {
		return userToReceiver;
	}
	public void setUserToReceiver(User userToReceiver) {
		this.userToReceiver = userToReceiver;
	}
	
	
/*	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getPrivmesid() {
		return privmesid;
	}
	public void setPrivmesid(int privmesid) {
		this.privmesid = privmesid;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int comment) {
		this.commentid = comment;
	}
	public int getSendid() {
		return sendid;
	}
	public void setSendid(int sendid) {
		this.sendid = sendid;
	}
	*/

}
