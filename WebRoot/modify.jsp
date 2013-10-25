<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/png" href="/sns/images/ico/twitter_32.png">
<title>设置基本信息 i微博</title>

<style type="text/css">
html,body,ul,li {
	margin: 0;
	padding: 0;
	text-align:center; 
}

ul {
	list-style: none;
}

a {
	text-decoration: none;
}

.navigation {
	background: url("images/navmodify.png") repeat-x scroll 0 0 transparent;
	min-height: 57px;
	position: relative;
	z-index: 3;
}

.menu li {
	float: left;
	width: 100px;
	text-align: center;
	line-height: 24px;
	margin: 15px 20px 0 0 ;
}

.menu li a {
	color:#EEEEEE;
	font-weight: bold;
	font: 18px 'Helvetica Neue',Helvetica,Arial,Sans-serif;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
}

.menu li a:HOVER {
	color:#FFFFFF;
	text-decoration: none;
}

.table a{
	color:#FFFFFF;
	font-weight: bold;
	font: 18px 'Helvetica Neue',Helvetica,Arial,Sans-serif;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
}
.table a:HOVER{
	color:#0066ff;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 1);
}
table p {
	color:#333333;
	font-family: 'Helvetica Neue', Arial, 'Liberation Sans', FreeSans,
		'Hiragino Sans GB', sans-serif;
	text-shadow: 0 1px 0px rgba(0, 0, 0, 0.5);
}
form input {
	padding: 5px 5px;
	margin: 0 0 5px;
	font-size: 12px;
	background: #e8f4fc;
	border: 1px solid #0d7bd5;
	color: #888;
	cursor: text;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .3), 0 1px 3px rgba(0, 0, 0, .3)
		inset;
	border-radius: 2px;
}

#submit{
	margin-left:50px;
	width: 98px;
	height: 42px;
	background: url("images/startpage.png");
	background-position: -400px -200px;
}

#submit:HOVER , #submit:FOCUS {
	cursor:pointer;
	background-position: -400px -290px;
}


</style>

</head>

<body>

	<div class="navigation">
		<div class="menu">

			<ul>
				<li style="margin-left:40%"><a href="<%=request.getContextPath()%>/main.action">我的首页</a>
				</li>
				<li style="margin-left:40px"><a href="<%=request.getContextPath()%>/profile.action">我的微博</a>
				</li>
				<%--
				<a href="<%=request.getContextPath()%>/following.action?followingid=<s:property value='user.id'/>">好友</a>
				--%>
			</ul>

		</div>
	</div>
	
	<table width="800" height="600" border="0" align="center" class="table">
		<tr>
			<td height="44" colspan="2">
			<a href="<%=request.getContextPath()%>/modify.action">修改基本资料 </a> |
				<a href="upload.jsp">修改头像</a>
				<hr />
			</td>
		</tr>
		<tr>
			<td width="300"></td>
		
			<td valign="top" style="text-align: left;">
			<p>帐号：${user.email}</p>
			
				<form id="form2" name="form1" method="post" action="<%=request.getContextPath()%>/modify_submit.action">
					<p>
						<span style="text-align: left"> <label for="username2">昵称：</label>
							<input type="text" name="owner.username" id="owner.username"
								value="${user.username}" />  
						</span>
					</p>
					
					<p>
						<span style="text-align: left"> <label for="address">地址：</label>
							<input type="text" name="owner.address" id="owner.address" value="${user.address }" />
						</span>
					</p>
					
					<p>
						<span style="text-align: left"> <label for="sex">性别：</label>
						</span> 
						<label> 
						<input name="owner.sex" type="radio" id="owner.sex" value="true" /> 男</label> 
						<label>
						<input type="radio" name="owner.sex" value="false" id="owner.sex" /> 女</label>
						<br /> 
					</p>
					
					<p>
						<span style="text-align: left"> <label for="age">年龄：</label>
						<input type="text" name="owner.age" id="owner.age" value="${user.age }" />
						</span>
					</p>
					
					<p>
						<span style="text-align: left"> <label for="phone">电话：</label>
						<input type="text" name="owner.phone" id="owner.phone" value="${user.phone }" />
						</span>
					</p>
					
					<p style="display: none;">
						<span style="text-align: left"> <label for="password">密码：</label>
						<input type="password" name="owner.password" id="owner.password" value="${user.password}" 
						readOnly="true" /><!-- disabled="true" -->  <span><font color="red" size="2px">&nbsp; 修改密码功能暂时不可编辑</font></span>
						</span>　
					</p>
					
					<p>
						<input type="submit" name="submit" id="submit" value="Submit" /> </span>
					</p>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>
