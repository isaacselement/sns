package com.weibo.service;

import java.util.ArrayList;
import java.util.List;

import com.weibo.dao.CollectionDAO;
import com.weibo.dao.CommentDAO;
import com.weibo.dao.UserUpdateDAO;
import com.weibo.dao.impl.*;
import com.weibo.model.*;

public class MainService {
	MessageDAOTMP messagedaotmp = new MessageDAOTMP();
	FollowingDAOTMP followingdaotmp = new FollowingDAOTMP();
	FollowerDAOTMP followerdaotmp = new FollowerDAOTMP();
	ForwardDAOTMP forwarddaotmp = new ForwardDAOTMP();
//	List<User> funs=null;
	
	/**
	 *  通过用户实体对象得到关注人的微博集合
	 * @param user 用户实体对象
	 * @return 得到用户关注的人微博集合
	 */
	public List<Message> messages(User user,int first,int last){
		//通过sql语句得到用户关注人的微博集合
	//	return (List<Message>)messagedaotmp.getMessagesBySQL("select message.* from following,message where following.funsid=message.ownerid and following.userid= "+user.getId()+"  order by message.mesTime desc");
		// for test
		return (List<Message>)messagedaotmp.getMessagesBySQL("select message.* from following,message where following.funsid=message.ownerid and following.userid= "+user.getId()+"  order by message.mesTime desc limit "+first+","+last);
		}
	
	//通过用户的实体对象得到用户微博集合
	public List<Message> userMessages(User user){
		return (List<Message>)messagedaotmp.getMessages("from Message where user.id="+user.getId()+"order by mesTime desc");
	}
	
	//通过用户的实体对象得到用户微博数量
	public int userMessagesNum(User user){
		return userMessages(user).size();
	}
	
	//通过用户的实体对象得到用户转发的集合
	public List<Forward> userForwards(User user){
		return (List<Forward>)forwarddaotmp.getForwards("from Forward where forwarder.id="+user.getId()+"order by time desc");
	}
	
	//通过用户实体对象得到用户转发的数量
	public int userForwardsNum(User user){
		return userForwards(user).size();
	}
	
	/**
	 * 通过用户实体对象得到关注人的转发集合
	 * @param user 用户实体对象
	 * @return 得到用户关注的人转发集合
	 */
	public List<Forward> forwards(User user,int first,int last){
		return forwarddaotmp.getForwardsBySQL("select forward.* from following,forward where following.funsid=forward.forwarderid and following.userid="+user.getId()+ " order by forward.time desc limit "+first+","+last);
	}
	
	/**
	 * 通过用户得到关注人的集合
	 * @param user 要得到本人关注人集合的用户
	 * @return 关注人的集合
	 */
	public List<User> getfollowings(User user){//得到关注他人的集合
		return (List<User>)followingdaotmp.getFollowings("SELECT funs FROM Following as f where f.user.id="+user.getId());
	}
	
	/**
	 * 得到user用户关注他人的数目
	 * @param user 用户
	 * @return 关注人的数目
	 */
	public int funsNum(User user){
		return getfollowings(user).size();
	}
	
	/**
	 * 得到user用户粉丝的数目
	 * @param user 用户
	 * @return 粉丝数目
	 */
	public int followerNum(User user){
	//	FollowerDAOTMP followerdaotmp = new FollowerDAOTMP();
		return followerdaotmp.getFollowerNum("select count(*) from Follower as f where f.follower.id="+user.getId());
	}
	
	/**
	 * 通过用户得到用户粉丝的集合
	 * @param user 要得到粉丝的用户
	 * @return 用户粉丝的集合
	 */
	public List<User> getfollowers(User user){
		return(List<User>)followerdaotmp.getFollowers("SELECT befollowed from Follower as f where f.follower.id="+user.getId());
	}
	
	//保存微博
	public boolean messageSave(Message message){
		return messagedaotmp.insert(message);
	}
	//保存转发
	public boolean ForwardSave(Forward forward){
		return forwarddaotmp.insert(forward);
	}
	
	//保存微博的评论 
	public boolean commentSave(Comment comment){
		CommentDAOTMP commentdaotmp=new CommentDAOTMP();
		return commentdaotmp.insert(comment);
	}
	
	//保存转发的评论
	public boolean forwardSave(Comment comment){
		CommentDAOTMP commentdaotmp=new CommentDAOTMP();
		return commentdaotmp.insert(comment);
	}
	
	//得到用户没看的私信集合
	public List<PrivMes> getPrivMeses(User user){
		PrivMesDAOTMP privMesdaotmp = new PrivMesDAOTMP();
		return (List<PrivMes>)privMesdaotmp.getPrivMeseses("from PrivMes where flag=1 and userToReceiver.id="+user.getId());
	}
	
	
	//修改用户的资料
	public void modify(User user){
		UserDAOTMP userdaotmp=new UserDAOTMP();
		userdaotmp.modify(user);
	}
	//修改转发的内容
	public void modify(Forward forward){
		forwarddaotmp.modify(forward);
	}
	
	//根据微博的ID得到评论的集合
	public List<Comment> getComments(int messageid){
		CommentDAOTMP commentdaotmp=new CommentDAOTMP();
		return (List<Comment>)commentdaotmp.getComments("from Comment where message.id="+messageid+"  order by time desc");
	}
	//根据转发的ID得到评论的集合
	public List<Comment> getCommentsByForwardid(int forwardid){
		CommentDAOTMP commentdaotmpForward=new CommentDAOTMP();
		return (List<Comment>)commentdaotmpForward.getComments("from Comment where forward.id="+forwardid+"  order by time desc");
	}
	public List<Forward> getForwardsByMessageid(int messageid){
		return (List<Forward>)forwarddaotmp.getForwards("from Forward where message.id="+messageid);
	}
	//根据微博ID得到一条微博
	public Message getMessage(int messageid){
		return messagedaotmp.getMessage(messageid);
	}
	//根据转发id得到一条转发
	public Forward getForward(int forwardid){
		return forwarddaotmp.getForward(forwardid);
	}
	//根据微博id删除微博
	public void deleteMessage(int messageid){
		messagedaotmp.delete("delete from message where message.mid="+messageid);
	}
	//根据评论ID删除评论
	public void deleteComment(int commentid){
		CommentDAOTMP commentdaotmp=new CommentDAOTMP();
		commentdaotmp.delete("delete from comment where comment.id="+commentid);
	}
	//根据转发ID删除转发
	public void deleteForward(int forwardid){
		forwarddaotmp.delete("delete from forward where forward.fid="+forwardid);
	}
	
	//用户添加关注他人的记录
	public void saveFollowing(Following following){
		FollowingDAOTMP followingdaotmp=new FollowingDAOTMP();
		followingdaotmp.insert(following);
	}
	//
	public void saveFollower(Follower follower){
		FollowerDAOTMP followerDAOTMP=new FollowerDAOTMP();
		followerdaotmp.insert(follower);
		
	}
	//根据用户ID得到用户实体对象
	public User getUser(int userid){
		UserDAOTMP userdaotmp=new UserDAOTMP();
		return userdaotmp.getUser(userid);
	}
	
	//根据搜索的字符搜索用户
	public List<User> getUsers(String str){
		UserDAOTMP userdaotmp=new UserDAOTMP();
		return (List<User>)userdaotmp.getUsers("from User where username like '%"+ str+"%'");
	}
	
	//得到用户收到的新评论
	public List<UserUpdate> getFloatComments(int userid){
		UserUpdateDAOTMP userUpdatedaotmp=new UserUpdateDAOTMP();
		return (List<UserUpdate>)userUpdatedaotmp.getUserUpdates("from UserUpdate where userToReceiver.id="+userid);
	}
	//得到关注的对象
	public List<Following> getFollowings(int ownerid,int followingid){
		FollowingDAOTMP followingdaotmp=new FollowingDAOTMP();
		return (List<Following>)followingdaotmp.getFollowings("from Following where user.id="+ownerid+" and funs.id="+followingid);
	}
	//删除在userUpdate表中已经看过的信息
	public void deleteUserUpdate(int receiver){
		UserUpdateDAOTMP userUpdatedaotmp=new UserUpdateDAOTMP();
		userUpdatedaotmp.deleteBysql("delete from userupdate where userupdate.userToReiverid="+receiver);
	}
	//保存一条评论到UserUpdate表
	public void saveUserUpdate(UserUpdate userUpdate){
		UserUpdateDAO userUpdatedaotmp=new UserUpdateDAOTMP();
		userUpdatedaotmp.insert(userUpdate);
	}
	
	//根据评论ID得到一条评论实体对象
	public Comment getComment(int commentid){
		CommentDAO commentdaotmp=new CommentDAOTMP();
		return commentdaotmp.getComment(commentid);
	}
	
	//保存收藏一条微薄
	public boolean saveCollection(Collection collection){
		CollectionDAO collectiondaotmp =  new CollectionDAOTMP();
		return collectiondaotmp.insert(collection);
	}
	
	//根据微薄ID得到指定用户一条微薄的收藏
	public Collection getCollectMess(String messageid,User user){
		CollectionDAO collectiondaotmp =  new CollectionDAOTMP();
		Collection collection = null;
		try{
			collection = (Collection)collectiondaotmp.getCollections("from Collection where message.id="+messageid+" and user.id="+user.getId()).get(0);
		}catch(Exception e){
			return null;
		}
		return collection;
	}
	//根据转发ID得到指定用户一条微薄的收藏
	public Collection getCollectionForw(String forwardid,User user){
		CollectionDAO collectiondaotmp =  new CollectionDAOTMP();
		Collection collection = null;
		try{
			collection = (Collection)collectiondaotmp.getCollections("from Collection where forward.id="+forwardid+" and user.id="+user.getId()).get(0);
		}
		catch(Exception e){
			return null;
		}
		return collection;
	}
	//删除微薄的一条收藏
	public void deleteCollectMess(Collection collection){
		CollectionDAO collectiondaotmp =  new CollectionDAOTMP();
		collectiondaotmp.delete(collection);
	}
}
