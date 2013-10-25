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
 * 私信
 */
@Entity
@Table(name="privMes")
public class PrivMes implements Serializable{
	private int pid;//主键
	//private int ownerid;//发送信息用户的ID
	//private int receiverid;//接收信息的ID
	private String context;//私信内容
	private Date time;//发私信的时间
	private int flag;//记录私信是否已看,1没看
	private User user;
	private User userToReceiver;
	
	@Id 
	@GeneratedValue
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
//	public int getOwnerid() {
//		return ownerid;
//	}
//	public void setOwnerid(int ownerid) {
//		this.ownerid = ownerid;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	
	//与私信的接收者是多对一的单向关系
	@ManyToOne
	@JoinColumn(name="receiverid")
	public User getUserToReceiver() {
		return userToReceiver;
	}
	public void setUserToReceiver(User userToReceiver) {
		this.userToReceiver = userToReceiver;
	}
}
