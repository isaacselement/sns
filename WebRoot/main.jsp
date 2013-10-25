<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="/sns/css/boxy.css" type="text/css" rel="stylesheet"
	charset="utf-8" />
<link href="/sns/css/bootstrap.css" type="text/css" rel="stylesheet"
	charset="utf-8" />


<script type="text/javascript" src="sendMessage.js"></script>
<script type="text/javascript" src="addComments.js"></script>
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="jquery.boxy.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="js/content_zoom.js"></script>

<script type="text/javascript">
window.onload = function(){setTimeout("tipsToUser()",800);}
	$(document).ready(function() {
		$('div.small_pic a').fancyZoom({scaleImg: true, closeOnClick: true});
		
		(function() {
		    var $backToTopTxt = "返回顶部", $backToTopEle = $('<div class="backToTop"></div>').appendTo($("body"))
		        .text($backToTopTxt).attr("title", $backToTopTxt).click(function() {
		            $("html, body").animate({ scrollTop: 0 }, 120);
		    }), $backToTopFun = function() {
		        var st = $(document).scrollTop(), winh = $(window).height();
		        (st > 0)? $backToTopEle.show(): $backToTopEle.hide();    
		        //IE6下的定位
		        if (!window.XMLHttpRequest) {
		            $backToTopEle.css("top", st + winh - 166);    
		        }
		    };
		    $(window).bind("scroll", $backToTopFun);
		    $(function() { $backToTopFun(); });
		})();
	});
	
	
</script>

<title>我的首页 I微博 - 随时随地分享身边的新鲜事儿</title>

<style type="text/css">
.backToTop {
	display: none;
	width: 18px;
	line-height: 1.2;
	padding: 5px 0;
	background-color: #000;
	color: #fff;
	font-size: 12px;
	text-align: center;
	position: fixed;
	_position: absolute;
	right: 10px;
	bottom: 100px;
	_bottom: "auto";
	cursor: pointer;
	opacity: .6;
	filter: Alpha(opacity =     60);
}

.sizenum {
	font-size: 25px;
}

.sizefont {
	font-size: 16px;
}

.textfield {
	text-align: center;
}

.float {
	width: 150px;
	padding: 10px;
	border: 1px solid #ffecb0;
	background-color: #fffee0;
	-moz-box-shadow: 1px 1px 2px rgba(0, 0, 0, .2);
	-webkit-box-shadow: 1px 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 1px 1px 2px rgba(0, 0, 0, .2);
	position: absolute;
	right: 10%;
	top: 131px;
}

.upload_image_btn:HOVER {
	background-color: white;
	opacity: 0.5;
}

#fabu_button {
	background: url(images/startpage.png);
	width: 100px;
	height: 28px;
	background-position: -310px -130px;
}
#fabu_button:HOVER {
	background-position: -310px -10px;
	opacity:0.5;
}
</style>
</head>

<body>
	<jsp:include page="main_nav.jsp" />
	<%--
	<%@include file="main_nav.jsp" %>
	--%>

	<div class="body">
		<div class="float" id="float" style="display: none;">
			收到<a href="<%=request.getContextPath()%>/showComments.action">几条</a>新评论！
		</div>

		<table width="800px" height="1130" border="0" align="center"
			cellspacing="0" style="">

			<tr>
				<td width="550px" height="189" valign="top" nowrap="nowrap"><div
						id="text_input_body">
						<table width="588" height="170" border="0" cellspacing="0">
							<tr>
								<td height="31" colspan="4"></td>
							</tr>
							<tr>
								<td width="6" height="85"></td>
								<td colspan="2" valign="top">
									<div class="textfield">
										<div style="text-align:left;">想说点什么?</div>
										<textarea name="post_content" id="post_content" cols="65"
											rows="4" style="height: 100%;resize: none;width:100%"></textarea>
									</div></td>
								<td width="42"></td>
							</tr>
							<tr>
								<td height="34"></td>
								<td width="323" valign="top"><div id="uplaod_picture">
										<form id="fileform" name="fileform" method="post"
											action="<%=request.getContextPath()%>/uploadAction.action"
											enctype="multipart/form-data" target="upload-target">
											<input type="file" value="浏览" name="image" /> <input
												class="upload_image_btn" type="submit" value="图片上传" />
										</form>
										<iframe id="upload-target" name='upload-target'
											style="display:none"></iframe>
									</div></td>
								<td width="156" align="right" valign="top"><div>
										<input id="fabu_button" type="button" onclick="submitPost()" value="发布" />
									</div>
								</td>
								<td></td>
							</tr>
						</table>
					</div></td>
				<td width="26%" rowspan="2" valign="top"
					style="text-align: left"><table
						border="0" cellspacing="0">
						<tr>
							<td><img src="<s:property value="user.photo"/>" width="130"
								height="120" hspace="10" vspace="10" align="left"
								class="picturemyself" />
								<p></p>
							</td>
						</tr>
						<tr>
							<td><table width="100%" height="60" border="0"
									cellspacing="0">
									<tr>
										<td height="21" align="center"><a class="sizenum"
											href="<%=request.getContextPath()%>/following.action?followingid=<s:property value="user.id"/>"">${followingsNum}</a>
										</td>
										<td height="21" align="center"><a class="sizenum"
											href="<%=request.getContextPath()%>/follow.action?followersid=<s:property value="user.id"/>"">${followersNum}</a>
										</td>
										<td height="21" align="center"><a class="sizenum"
											href="<%=request.getContextPath()%>/profile.action">${userMessagesOrForwards}</a>
										</td>
									</tr>
									<tr>
										<td height="21" align="center"><a class="sizefont"
											href="<%=request.getContextPath()%>/following.action?followingid=<s:property value="user.id"/>""><font
												color="#000000">关注</font> </a>
										</td>
										<td height="21" align="center"><a class="sizefont"
											href="<%=request.getContextPath()%>/follow.action?followersid=<s:property value="user.id"/>""><font
												color="#000000">粉丝</font> </a>
										</td>
										<td height="21" align="center"><a class="sizefont"
											href="<%=request.getContextPath()%>/profile.action"><font
												color="#000000">微博</font> </a>
										</td>
									</tr>
									<tr>
										<td colspan="3" width="70" height="30"></td>
									</tr>
									<tr>
										<td colspan="3" height="31"
											style="font-size: 20px;text-align: left;">用户:${user.username}</td>
									</tr>
									<tr>
										<td colspan="3" height="31"
											style="font-size: 20px;text-align: left;">地区:${user.address}</td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="772" valign="top"
					style="margin-left: 10px; margin-bottom: 10px; margin-right: 10px; margin-top: 10px; background-color: #cccccc; text-align: left">&nbsp;

					<div class="feedList" id="feedList">
						<div id="addMessage" class="addMessage"></div>
						<s:set name="userid" value="user.id"></s:set>
						<s:iterator value="messages" var="c">
							<div id="mesdelete<s:property value="#c.mid"/>">
								<table>
									<tr>
										<td nowrap="nowrap" valign="top">
											<div class="avatar">
												<img title="<s:property value="#c.user.username"/>"
													src="<s:property value="#c.user.photo"/>" width="53"
													height="60" />
											</div></td>
										<td valign="top">

											<div class="oriTxt">
												<p>
													<span class="spanUsermessage<s:property value='#c.mid'/>"
														title="<s:property value="#c.user.username"/>" onclick=""
														style="color:#03F;font-size: 20px;"> <a
														href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.user.id"/>">
															<s:property value="#c.user.username" /> </a> </span>：<span
														class="spanmessage<s:property value='#c.mid'/>"
														id="spanmessage<s:property value='#c.mid'/>"
														style="color: #000;"><s:property value="#c.context" />
													</span>
												</p>
											</div> <s:set name="pictureExit" value="#c.image"></s:set> <s:if
												test="#pictureExit!=null">
												<div class="small_pic">
													<p>
														&nbsp;&nbsp;<a href='.picture<s:property value="#c.mid"/>'><img
															src="<s:property value="#c.image"/>" width="100"
															height="80" /> </a>
													</p>
												</div>
												<div class="picture<s:property value="#c.mid"/>"
													style="display:none;">
													<img src="<s:property value="#c.image"/>" />
												</div>
											</s:if></td>
									</tr>
								</table>
								<div class="from" align="right">
									<div>
										<small> <span class="option"> <cite
												class="delete"> <s:set name="mainid"
														value="#c.user.id"></s:set> <s:if test="#mainid==#userid">
														<a href="javascript:void(0);"
															onclick="toggle3('delete<s:property value="#c.mid"/>',<s:property value="#c.mid"/>)">删除</a>|</s:if>
											</cite> <cite class="forward"><a href="javascript:void(0);"
													onclick="toggleForward('message<s:property value="#c.mid"/>',<s:property value="#c.mid"/>)">转发</a>
											</cite> | <cite class="collect"> <s:set name="flag"
														value="#c.flag"></s:set> <s:if test="#flag!=1">
														<a href="javascript:void(0);"
															onclick='toggleCollection(<s:property value="#c.mid"/>)'
															id="collect<s:property value="#c.mid"/>">收藏</a>
													</s:if> <s:else>
														<a
															href="javascript:deleteCollectMess(<s:property value="#c.mid"/>)"
															style="color: #787878;"
															id="collect<s:property value="#c.mid"/>">取消收藏</a>
													</s:else> </cite> | <cite class="reply"> <a
													href="javascript:void(0);"
													onclick="toggle1('message<s:property value="#c.mid"/>',<s:property value="#c.mid"/>)">评论
												</a> &nbsp; </cite> </span> </small>
									</div>
									<div>
										<span class="mycome"><cite>时间：20<s:property
													value="#c.mesTime" /> </cite> </span>
									</div>
								</div>
								<div id="message<s:property value='#c.mid'/>"
									class="message<s:property value='#c.mid'/>"
									style="display: none;"></div>
								<hr />
							</div>
						</s:iterator>
					</div>




					<div id="" class=""></div> <span> <s:iterator
							value="forwards" var="c">

							<div id="fordeleteForward<s:property value="#c.Fid"/>">
								<div class="">
									<p>
										<a title="<s:property value="#c.forwarder.username"/>"
											href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.forwarder.id"/>"">
											<span class="forwardUserforward<s:property value='#c.Fid'/>"><s:property
													value="#c.forwarder.username" /> </span> </a>：<span
											class="forwardContextforward<s:property value='#c.Fid'/>"><s:property
												value="#c.comment" /> </span>
									</p>
								</div>

								<div>
									<table width="87%" height="58" border="0" align="center">
										<tr align="center" valign="top">
											<td height="58"
												style="text-align: left;">&nbsp;
												<div>
													<span
														class="spanForwarderforward<s:property value='#c.Fid'/>"><a
														title="<s:property value="#c.message.user.username"/>"
														href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.message.user.id"/>">@<s:property
																value="#c.message.user.username" /> </a> </span>：<span
														class="spanforward<s:property value='#c.Fid'/>"
														id="spanforward<s:property value='#c.Fid'/>"><s:property
															value="#c.message.context" /><br /> <br /> </span>
												</div> <s:set name="forwardPictureExit" value="#c.message.image"></s:set>
												<s:if test="#forwardPictureExit!=null">
													<div class="small_pic">
														<p>
															&nbsp;&nbsp;<a
																href='.forwardPicture<s:property value="#c.Fid"/>'><img
																src="<s:property value="#c.message.image"/>" width="100"
																height="80" /> </a>
														</p>
													</div>
													<div class="forwardPicture<s:property value="#c.Fid"/>"
														style="display:none;">
														<img src="<s:property value="#c.message.image"/>" />
													</div>
												</s:if></td>
										</tr>
									</table>
								</div>



								<div align="right">
									<div>
										<small><span class="option"> <cite
												class="deleteForward"> <s:set name="ForwardUserid"
														value="#c.forwarder.id"></s:set> <s:if
														test="#ForwardUserid==#userid">
														<a href="javascript:void(0);"
															onclick="toggle4('deleteForward<s:property value="#c.Fid"/>',<s:property value="#c.Fid"/>)">删除</a>|</s:if>
											</cite> <cite class="forward"><a href="javascript:void(0);"
													onclick="toggleForwardTofor('forward<s:property value="#c.Fid"/>',<s:property value="#c.message.mid"/>)">转发</a>
											</cite> | <cite class="collect"> <s:set name="flag"
														value="#c.flag"></s:set> <s:if test="#flag!=1">
														<a href="javascript:void(0);"
															onclick="farwardCollection(<s:property value="#c.Fid"/>)"
															id="forwardCollect<s:property value="#c.Fid"/>">收藏</a>
													</s:if> <s:else>
														<a
															href="javascript:deleteCollectForw(<s:property value="#c.Fid"/>)"
															style="color: #787878;"
															id="collect<s:property value="#c.Fid"/>">取消收藏</a>
													</s:else> </cite> | <cite class="reply"> <a
													href="javascript:void(0);" id="" class=""
													onclick="toggle2('forward<s:property value="#c.Fid"/>',<s:property value="#c.Fid"/>)">评论</a>
											</cite> </span> </small>
									</div>
									<div align="right">
										<small><span class="mycome"><cite>时间：20<s:property
														value="#c.time" /> </cite> </span> </small>
									</div>
								</div>
								<div id="forward<s:property value='#c.Fid'/>"
									class="forward<s:property value='#c.Fid'/>"
									style="display: none;"></div>
								<hr />
							</div>

						</s:iterator> </span></td>
			</tr>
		</table>
	</div>
</body>
</html>
