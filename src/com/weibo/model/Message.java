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
 * 发布信息类
 * */
@Entity
@Table(name="message")
public class Message implements Serializable {
	private int mid;//主健
	//private int ownerid;//外键，用户的ID
	private String image;//图片的路径
	private String video;//视频的路径
	private String context;//发布的内容
	private Date mesTime;//发布的时间
	private User user;
	private String flag;//自定义，暂用来定义该信息是否没收藏,数据库不需要,flag=0表示没收藏,1为收藏
	
	@Id
	@GeneratedValue
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
//	public int getOwnerid() {
//		return ownerid;
//	}
//	public void setOwnerid(int ownerid) {
//		this.ownerid = ownerid;
//	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMesTime() {
		return mesTime;
	}
	public void setMesTime(Date mesTime) {
		this.mesTime = mesTime;
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
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
