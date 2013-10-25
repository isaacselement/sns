<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="icon" type="image/png" href="/sns/images/ico/twitter_32.png">
<link href="/sns/css/main/main_nav.css" type="text/css" rel="stylesheet"
	charset="utf-8" />
</head>

<body>
	<!--导航栏-->
	<div class="navbar">
		<div class="container" style="border: 0px solid red;">
			<div class="content" style="border: 0px solid green;">
				<ul class="left">
					<li><a href="<%=request.getContextPath()%>/main.action">首页</a>
					</li>
					<li><a
						href="<%=request.getContextPath()%>/following.action?followingid=<s:property value="user.id"/>">好友</a>
					</li>
					<li><a href="#">私信</a></li>

				</ul>

				<form method="post"
					action="<%=request.getContextPath()%>/searchUser.action">
					<input type="text" name="searchUser" placeholder="Search" /> <input
						type="submit" class="nav_search_btn" value="搜索" />
				</form>

				<ul class="right">
					<li>
						<%--
						<a href="<%=request.getContextPath()%>/profile.action"><s:property value="user.username" />
						--%>
						<a href="<%=request.getContextPath()%>/profile.action">我的微博</a>
					</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/modify.action">账号设置</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/logout.action">退出</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
