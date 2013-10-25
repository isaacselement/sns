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
 * 用户关注的人
 */
@Entity
@Table(name="following")
public class Following implements Serializable{
	private int id;
	private User user;//用户
	private User funs;//用户关注的人
	@Id
	@GeneratedValue
	public int getId() {
		return id; 
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	@JoinColumn(name="funsid")
	public User getFuns() {
		return funs;
	}
	public void setFuns(User funs) {
		this.funs = funs;
	}
	
}
