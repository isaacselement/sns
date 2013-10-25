<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="icon" type="image/png" href="/sns/images/ico/twitter_32.png">
<title>I微博 - 注册</title>

<style type="text/css">
html {
	background: #0d7bd5 url('images/reg_glow.png') no-repeat center center;
	height: 100%;
	_background: #0d7bd5;
}

body {
	color: #b7d4ec;
	color: rgba(255, 255, 255, .8);
	font: 13px/22px 'Helvetica Neue', Arial, 'Liberation Sans', FreeSans,
		'Hiragino Sans GB', sans-serif;
	text-shadow: 0 1px 0 rgba(0, 0, 0, .3);
	position: relative;
	height: 100%;
	text-align: center;
}

body,label,input,textarea,select,button {
	font-family: 'Helvetica Neue', Arial, 'Liberation Sans', FreeSans,
		'Hiragino Sans GB', sans-serif
}

a {
	color: #b7d4ec;
	color: rgba(255, 255, 255, .8);
	-webkit-transition: color .1s ease, background-color .1s ease;
	text-decoration: none;
}

#apply {
	width: 480px;
	height: 390px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -195px 0 0 -240px;
}

.register {
	font-size: 14px;
	color: #b7d4ec;
	color: rgba(255, 255, 255, .8);
	display: block;
	background: rgba(0, 0, 0, .1);
	padding: 3px 15px;
	border-radius: 50px;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .15), 0px 1px 3px
		rgba(0, 0, 0, .2) inset;
	*color: #b7d4ec;
	*background: #0c6ebf;
}

.register:hover {
	background: rgba(0, 0, 0, .15)
}

.text {
	display: inline-block;
	width: 250px;
	padding: 10px 5px;
	margin: 0 0 18px;
	font-size: 14px;
	line-height: 18px;
	background: #e8f4fc;
	border: 1px solid #0d7bd5;
	color: #888;
	cursor: text;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .3), 0 1px 3px rgba(0, 0, 0, .3)
		inset;
	background-clip: padding-box;
	border-radius: 5px;
}

.text:focus {
	background: #fff
}

textarea.text {
	height: 80px;
}

.button {
	background: #1e95e5;
	color: #b7d4ec;
	color: rgba(255, 255, 255, .8);
	box-shadow: 0 1px 0 rgba(0, 0, 0, .05), 0 1px 0 rgba(255, 255, 255, .15)
		inset;
	border: 1px solid #147dcd;
	cursor: pointer;
	display: inline-block;
	font-size: 14px;
	line-height: 18px;
	text-shadow: 0 1px 0 rgba(0, 0, 0, .2);
	padding: 6px 15px;
	text-align: center;
	vertical-align: middle;
	border-radius: 5px;
	-webkit-appearance: none;
	*color: #b7d4ec;
}

.button:active {
	background: #1d8fdb;
	box-shadow: 0 1px 0 rgba(255, 255, 255, .15);
}

.button:focus , .button:HOVER {
	box-shadow: 0 0 10px rgba(255, 255, 255, .5), 0 1px 0
		rgba(255, 255, 255, .15) inset
}

.footer {
  width: 100%;
  text-align: center;
  position: absolute;
  bottom: 20px;
}

</style>
</head>

<body>

	<div id="apply">

		<form class="login" method="post" action="<%=request.getContextPath()%>/register.action" id="regist">
			<div>
				<input autofocus="true" class="text" id="email" name="user.email"
					placeholder="邮 箱" spellcheck="false" tabindex="1" type="email"
					value="">
			</div>
			<div>
				<input class="text" id="fullname" name="user.password" placeholder="密码"
					type="password" value="">
			</div>
			<div>
				<input class="text" id="fullname" name="repeatedPassword" placeholder="确认密码"
					type="password" value="">
			</div>
			<div>
				<textarea class="text" id="headline" name="headline"
					placeholder="一句话介绍自己（职业背景、专业技能，比如Ruby开发者、医生、律师）"></textarea>
			</div>
			<input class="button" type="submit" value="注册">
		</form>

		<div class="footer">
			&copy; 2012 - 2013 i微博 <span class="middot">&middot;</span> <a href="/sns">i微博</a> <span></span>
		</div>
	</div>
	<div class="reg">
		<a href="login.jsp" class="register">已有帐号登录</a>
	</div>

</body>
</html>