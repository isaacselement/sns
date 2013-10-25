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
 * 转发的信息
 * @author Administrator
 *
 */

@Entity
@Table(name="forward")
public class Forward implements Serializable{
	private int Fid;
	private Message message;
	private User forwarder;//转发者
	private String comment; 
	private Date time;
	private String flag;//自定义，暂用来定义该信息是否没收藏,数据库不需要
	
	@Id
	@GeneratedValue
	public int getFid() {
		return Fid;
	}
	public void setFid(int fid) {
		Fid = fid;
	}
	
	@ManyToOne
	@JoinColumn(name="messageid")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	@ManyToOne
	@JoinColumn(name="forwarderid")
	public User getForwarder() {
		return forwarder;
	}
	public void setForwarder(User forwarder) {
		this.forwarder = forwarder;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
