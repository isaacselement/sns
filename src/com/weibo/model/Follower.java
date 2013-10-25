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
 * 被关注表，统计用户的粉丝情况
 */
@Entity
@Table(name="follower")
public class Follower implements Serializable{
	private int id;
	private User follower;//用户关注的人
	private User befollowed;//关注某一用户的是有哪些人
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="followerid")
	public User getFollower() {
		return follower;
	}
	public void setFollower(User follower) {
		this.follower = follower;
	}
	@ManyToOne
	@JoinColumn(name="befollowedid")
	public User getBefollowed() {
		return befollowed;
	}
	public void setBefollowed(User befollowed) {
		this.befollowed = befollowed;
	}
	
}
