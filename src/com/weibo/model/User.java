package com.weibo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户的信息*/
@Entity
@Table(name="user")
public class User implements Serializable{
	private int uid ;//主键
	private String username;//用户的名字
	private String password;//密码
	private String email;//邮箱（唯一的）
	private int phone;//电话
	private String photo;//上传头像照片路径
	private String address;//地址
	private boolean sex;//性别，true表示男，false表示女
	private int age;//年龄
	
	@Id
	@GeneratedValue
	public int getId() {
		return uid;
	}
	public void setId(int id) {
		this.uid = id;
	}
	@Column(length=1000)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(length=1000)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=1000)
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Column(length=1000)
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
