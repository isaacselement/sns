<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/png" href="/sns/images/ico/twitter_32.png">
<title>修改头像</title>
<style type="text/css">
html,body,ul,li {
	margin: 0;
	padding: 0;
	text-align: center;
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
	margin: 15px 20px 0 0;
}

.menu li a {
	color: #EEEEEE;
	font-weight: bold;
	font: 18px 'Helvetica Neue', Helvetica, Arial, Sans-serif;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.5);
}

.menu li a:HOVER {
	color: #FFFFFF;
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

.submit {
	width:103px;
	height:36px;
	border:0px ;
	background: url("images/bg_btn.png");
	background-position: -112px -48px;
}
.submit:HOVER {
	cursor:pointer;
	background-position: -112px -96px;
}

</style>

</head>

<body>
	<div class="navigation">
		<div class="menu">

			<ul>
				<li style="margin-left:40%"><a
					href="<%=request.getContextPath()%>/main.action">我的首页</a></li>
				<li style="margin-left:40px"><a
					href="<%=request.getContextPath()%>/profile.action">我的微博</a></li>
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
			<td width="500" height="500" valign="top" style="text-align: center">
			<p>
					<img src="<s:property value="user.photo"/>" width="187"
						height="190" />
			</p>
			</td>
				
			<td width="300" valign="top" style="text-align: left">
			
				<form action="<%=request.getContextPath()%>/uplaod.action"
					method="post" enctype="multipart/form-data" name="frmUpload" >
					<div>
						<p>&nbsp;</p>
						<input type="file" name="image" />
						<p>
							<input type="submit" value="上传" class="submit"/> </span>
						</p>
					</div>
				</form>
			</td>
			
		</tr>
	</table>
</body>
</html>

