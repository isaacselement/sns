<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="icon" type="image/png" href="/sns/images/ico/twitter_32.png">
<title>I微博 - 登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
a:HOVER {
	color: rgba(255, 255, 255, 1);
	text-shadow: 0 1px 0 rgba(0, 0, 0, .8);
}
#login {
	width: 480px;
	height: 390px;
	position: absolute;
	top: 50%;
	left: 50%;
	margin: -195px 0 0 -240px;
}

#login form {
	*width: 262px;
	position: relative;
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

.remember_me {
	color: #b7d4ec;
	color: rgba(255, 255, 255, .8);
	*color: #b7d4ec;
}

.clearfix:before,.clearfix:after {
	content: "";
	display: table;
}

.clearfix:after {
	clear: both
}

.clearfix {
	zoom: 1
}

.promo {
	clear: both;
	padding: 80px 0 0;
}

.promo .reader {
	display: block;
	margin: 0 auto;
	width: 269px;
	height: 111px;
	background:
		url('images/login_promo-box.png')
		no-repeat 0 0;
}

.promo .reader:active span {
	opacity: .8
}

.promo .reader:hover {
	background:
		url('images/login_promo-box.png')
		no-repeat 0 -111px
}

.promo .reader span {
	display: block;
	width: 269px;
	height: 111px;
	background:
		url('images/login_promo-text.png')
		no-repeat 30px center;
	text-indent: -9999px;
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
</style>
</head>

<body>

	<div id="login">
		<form class="login" action="<%=request.getContextPath()%>/login.action" method="post" id="loginForm">
			<div>
				<input class="text" type="email" name="email" spellcheck="false"
					placeholder="邮 箱" autofocus tabindex="1">
			</div>
			<div>
				<input class="text" type="password" name="password"
					placeholder="密 码" tabindex="2">
			</div>
			<input class="button" type="submit" value="登 录" tabindex="3">
			<div class="actions">
				<input id="remember_me" type="checkbox" name="rememberme" checked>
				<label class="remember_me" for="remember_me">记住我</label> <span
					class="middot">&middot;</span> <a class="reset"
					href="#">忘记密码？</a>
			</div>
			<div class="clearfix"></div>
		</form>
		
		<div class="promo">
			<a href="/weibo/Qlogin.html" class="reader"> <span>I轻微博 - 立即登录</span> </a>
		</div>
		
		<div class="footer">
			&copy; 2012 - 2013 i微博 <span class="middot">&middot;</span> <a href="<%=request.getContextPath()%>">i微博</a> <span></span>
		</div>
	</div>
	<div class="reg">
		<a href="register.jsp" class="register">申请注册帐号</a>
	</div>

</body>
</html>
