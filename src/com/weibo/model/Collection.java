package com.weibo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 收藏信息
 * @author zou
 *
 */
@Entity
@Table(name="collection")
public class Collection implements Serializable {
	private int id;//主键
	private String mark;//标签
	private Date date;//收藏时间
	private User user;//收藏者
	private Message message;//收藏微薄
	private Forward forward;//收藏的转发
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
