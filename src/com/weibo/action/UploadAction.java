package com.weibo.action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weibo.model.User;
import com.weibo.service.MainService;

public class UploadAction extends ActionSupport {
	private File image;//得到上传的文件
	private String imageFileName;//得到文件的名称
	private User user;//当前的用户
	MainService mainService = new MainService();
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	
	public String execute() throws Exception{
		String uploadPicturePath=new String();
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		String realpath=ServletActionContext.getServletContext().getRealPath("/pictures");
		String rename=new String();
	//	rename=rename.valueOf(System.currentTimeMillis());//得到时间的字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dt = new Date(System.currentTimeMillis());
		rename = user.getId()+"_"+sdf.format(dt);
		rename=rename+imageFileName.substring(imageFileName.lastIndexOf("."));//得到以时间为图片文件名
		if(image!=null){
			File savefile=new File(new File(realpath),rename);
			if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(image, savefile);
			if(user!=null){
			user.setPhoto(ServletActionContext.getRequest().getContextPath()+"/pictures"+File.separator+rename);//保存图片路径
			mainService.modify(user);
			}
		}
	
		return "success";
	}
	public String upload() throws Exception{
		String uploadPicturePath=new String();
		ActionContext actionContext =ActionContext.getContext();
		user=(User)actionContext.getSession().get("userSessionKey");
		String realpath=ServletActionContext.getServletContext().getRealPath("/drawings");
		String rename=new String();
	//	rename=rename.valueOf(System.currentTimeMillis());//得到时间的字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dt = new Date(System.currentTimeMillis());
		rename = user.getId()+"_"+sdf.format(dt);
		rename=rename+imageFileName.substring(imageFileName.lastIndexOf("."));//得到以时间为图片文件名
		if(image!=null){
			File savefile=new File(new File(realpath),rename);
			if(!savefile.getParentFile().exists()){
				savefile.getParentFile().mkdirs();
			}
			FileUtils.copyFile(image, savefile);
			//将发布微博的上传图片保存在SESSION中。
			uploadPicturePath=ServletActionContext.getRequest().getContextPath()+"/drawings"+File.separator+rename;
			actionContext.getSession().put("getUploadPicturePath", uploadPicturePath);
		}
		return "success";
	}
}
