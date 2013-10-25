<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="replyComment.js"></script>
<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="jquery.boxy.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('div.small_pic a').fancyZoom({scaleImg: true, closeOnClick: true});
	});
	
	
</script>
<title>收到的消息</title>
<style type="text/css">
</style>
</head>

<body>
	
	<jsp:include page="main_nav.jsp" />
	
	<div class="body">

	<table width="731" height="979" border="0" align="center" cellspacing="1">
		<tr>
			<td width="497" height="56">&nbsp;&nbsp; 已收到<font
				color="#66FF00">${userUpdatesSize}</font>条新消息
				<hr />
			</td>
			<td width="218" rowspan="2" valign="top"
				style="background-image: url(images/followRight.png);"><p>
					<img src="<s:property value="user.photo"/>" alt="" name="userPhoto"
						width="85" height="82" id="userPhoto"
						style="background-color: #EBE9ED" />
				</p>
				<p>${user.username}</p>
				<p>${user.address}</p>
				<p>&nbsp;</p></td>
		</tr>
		<tr>
			<td height="765" align="left" valign="top"><s:iterator
					value="userUpdates" var="c">
					<div>
						<img src="<s:property value='#c.sender.photo'/>" width="40"
							height="40" align="left" /> <a
							href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.sender.id"/>"><font
							color="#CC99FF"><s:property value='#c.sender.username' />
						</font>
						</a> 回复<a
							href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="user.id"/>"><font
							color="#CC99FF">@<s:property value='user.username' />
						</font>
						</a>(
						<s:property value='#c.comment.time' />
						) <br /> 评论内容：<font color="#CC99FF"><s:property
								value='#c.comment.context' />
						</font>
						<div align="right">
							<input type="button" value="回复"
								onclick="toggleReply('replayComment<s:property value="#c.comment.id"/>',<s:property value="#c.comment.id"/>)" />
						</div>

						<div id="replayComment<s:property value='#c.comment.id'/>"
							class="replayComment<s:property value='#c.comment.id'/>"
							style="display: none;"></div>
						<hr />
					</div>
				</s:iterator>
			</td>
		</tr>
		<tr>
			<td height="83" colspan="2">&nbsp;</td>
		</tr>
	</table>
	</div>
</body>
</html>
