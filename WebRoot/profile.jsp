<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/bootstrap.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="jquery.boxy.js"></script>
<script type="text/javascript" src="addComments.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="js/content_zoom.js"></script>
<script type="text/javascript">
window.onload = function(){setTimeout("tipsToUser()",800);}
	$(document).ready(function() {
		$('div.small_pic a').fancyZoom({scaleImg: true, closeOnClick: true});
	});
</script>

<title>我的微博  I微博  - 随时随地分享身边的新鲜事儿</title>


<style type="text/css">
<!--
.main {
	color: #000;
}

.number {
	color: #0CF;
	font-size: 16px;
}

.demo {
	height: 1500px;
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
-->
</style>
</head>

<body>
	<!--菜单栏-->
	<jsp:include page="main_nav.jsp" />

	<div class="body">
	<div class="float" id="float" style="display: none;">
		收到<a href="<%=request.getContextPath()%>/showComments.action">几条</a>新评论！
	</div>
	<table width="850px" height="1156" border="0" align="center"
		cellspacing="0" style="">
		<tr>
			<td width="74%" height="181" valign="top" nowrap="nowrap"
				style="text-indent: 10px;  text-align: left"><p>
					<img src="<s:property value="user.photo"/>" width="187"
						height="188" hspace="10" vspace="10" align="left" />
				</p>
				<p>${user.username}</p>
				<p>${user.address}</p>
				<p>
					性别:
					<s:set name="sex" value="user.sex"></s:set>
					<s:if test="#sex==true">男</s:if>
					<s:else>女</s:else>
				</p>
				<p>邮箱：${user.email}</p>
				<p>快来介绍一下自己，让更多人关注你！</p>
			</td>
			<td width="26%" rowspan="2" valign="top"
				style="text-align: left"><h2>
					<span style=""><a
						href=" <%=request.getContextPath()%>/following.action?followingid=<s:property value="user.id"/>""><font
							color="#000000"><span class="k">关注</span>
						</font>
					</a>：</span><span class="number">${followingsNum}</span>
				</h2>
				<h2>
					<a
						href="<%=request.getContextPath()%>/follow.action?followersid=<s:property value="user.id"/>""><font
						color="#000000"><span class="k">粉丝</span>
					</font>
					</a>：<span class="number">${followersNum}</span>
				</h2>
				<h2>
					<a href="<%=request.getContextPath()%>/profile.action"><font
						color="#000000"><span class="k">微博</span>
					</font>
					</a>：<span class="number">${userWeiboNum}</span>
				</h2>
			</td>
		</tr>
		<tr>
			<td height="772" valign="top"
				style=" background-color:#cccccc; margin-left: 10px; margin-bottom: 10px; margin-right: 10px; margin-top: 10px; text-align: left">&nbsp;

				<div id="addMessage" class="addMessage"></div>
				<span class="k"> <s:iterator value="userMessages" var="c">
						<div id="mesdelete<s:property value="#c.mid"/>">
							<div class="Contant">
								<div class="oriTxt">
									<p>
										<span class="spanUsermessage<s:property value='#c.mid'/>">
											<a title="<s:property value="#c.user.username"/>"
											href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.user.id"/>"><s:property
													value="#c.user.username" /> </a>
										</span>：<span class="spanmessage<s:property value='#c.mid'/>"
											id="spanmessage<s:property value='#c.mid'/>"><s:property
												value="#c.context" />
										</span>
									</p>
								</div>
								<s:set name="pictureExit" value="#c.image"></s:set>
								<s:if test="#pictureExit!=null">
									<div class="small_pic">
										<p>
											&nbsp;&nbsp;<a href='.picture<s:property value="#c.mid"/>'><img
												src="<s:property value="#c.image"/>" width="140"
												height="120" />
											</a>
										</p>
									</div>
									<div class="picture<s:property value="#c.mid"/>"
										style="display:none;">
										<img src="<s:property value="#c.image"/>" />
									</div>
								</s:if>
								<div class="from" align="right">
									<div>
										<small> <span class="option"> <cite
												class="delete"><a href="javascript:void(0);"
													onclick="toggle3('delete<s:property value="#c.mid"/>',<s:property value="#c.mid"/>)">删除</a>
											</cite> | <cite class="forward"><a
													href="javascript:void(0);"
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
													href="javascript:void(0);" id="" class=""
													onclick="toggle1('message<s:property value="#c.mid"/>',<s:property value="#c.mid"/>)">评论
												</a> &nbsp; </cite> </span>
										</small>
									</div>
									<div>
										<span class="mycome"><cite>时间：20<s:property
													value="#c.mesTime" />
										</cite> </span>
									</div>
								</div>
								<div id="message<s:property value='#c.mid'/>"
									class="message<s:property value='#c.mid'/>"
									style="display: none;"></div>
							</div>
							<hr />
						</div>
					</s:iterator>
			</span>




				<div id="" class=""></div>
				<span> <s:iterator value="userForwards" var="c">

						<div id="fordeleteForward<s:property value="#c.Fid"/>">
							<div class="">
								<p>
									<a title="<s:property value="#c.forwarder.username"/>"
										href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.forwarder.id"/>">
										<span class="forwardUserforward<s:property value='#c.Fid'/>"><s:property
												value="#c.forwarder.username" />
									</span> </a>：<span
										class="forwardContextforward<s:property value='#c.Fid'/>"><s:property
											value="#c.comment" />
									</span>
								</p>
							</div>


							<table width="87%" height="58" border="0" align="center">
								<tr align="center" valign="top">
									<td height="58" style="text-align: left; ">&nbsp;
										<div>
											<span
												class="spanForwarderforward<s:property value='#c.Fid'/>"><a
												title="<s:property value="#c.message.user.username"/>"
												href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.message.user.id"/>">@<s:property
														value="#c.message.user.username" /> </a>
											</span>：<span class="spanforward<s:property value='#c.Fid'/>"
												id="spanforward<s:property value='#c.Fid'/>"><s:property
													value="#c.message.context" /><br />
											<br />
											</span>
										</div> <s:set name="forwardPictureExit" value="#c.message.image"></s:set>
										<s:if test="#forwardPictureExit!=null">
											<div class="small_pic">
												<p>
													&nbsp;&nbsp;<a
														href='.forwardPicture<s:property value="#c.Fid"/>'><img
														src="<s:property value="#c.message.image"/>" width="140"
														height="120" />
													</a>
												</p>
											</div>
											<div class="forwardPicture<s:property value="#c.Fid"/>"
												style="display:none;">
												<img src="<s:property value="#c.message.image"/>" />
											</div>
										</s:if></td>
								</tr>
							</table>



							<div align="right">
								<div>
									<small><span class="option"> <cite
											class="delete"><a href="javascript:void(0);"
												onclick="toggle4('deleteForward<s:property value="#c.Fid"/>',<s:property value="#c.Fid"/>)">删除</a>
										</cite> | <cite class="forward"><a href="javascript:void(0);"
												onclick="toggleForwardTofor('forward<s:property value="#c.Fid"/>',<s:property value="#c.Fid"/>)">转发</a>
										</cite> | <cite class="collect"> <s:set name="flag"
													value="#c.flag"></s:set>
												<s:if test="#flag!=1">
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
										</cite> </span>
									</small>
								</div>
								<div align="right">
									<small><span class="mycome"><cite>时间：20<s:property
													value="#c.time" />
										</cite> </span>
									</small>
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
