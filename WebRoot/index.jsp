<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%--
<link rel="icon" type="image/png" href="/sns/images/ico/twitter_32.png">
--%>
<link rel="shortcut icon" href="/sns/images/ico/twitter_32.png"
	type="image/x-icon" />

<title>I微博 - 随时随地分享身边的新鲜事儿</title>

<style type="text/css">

html {
	background: #0d7bd5 url('images/bg_green.png') no-repeat center center;
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

#shouye {
	left: 10%;
	top: auto;
	width: auto;
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
.promo .reader:hover {
	background:
		url('images/login_promo-box.png')
		no-repeat 0 -111px
}

.promo .reader:active span {
	opacity: .2
}

</style>
</head>

<body>
	<div id="shouye">
		<table border="0" align="center">
			<tr>

				<td colspan="3" valign="bottom"><%@include file="picsGlide.htm"%>
				</td>

			</tr>
		</table>
			<hr />
		<table  border="0" align="center">	
			<tr>
			
				<td valign="top">
					<br />
						<div id="login" >
							<form class="login"
								action="<%=request.getContextPath()%>/login.action"
								method="post" id="loginForm">
								<div>
									<input class="text" type="email" name="email"
										spellcheck="false" placeholder="邮 箱" autofocus tabindex="1">
								</div>
								<div>
									<input class="text" type="password" name="password"
										placeholder="密 码" tabindex="2">
								</div>
								<input class="button" type="submit" value="登 录" tabindex="3">
									<div class="actions">
										<input id="remember_me" type="checkbox" name="rememberme" checked> 
										<label class="remember_me" for="remember_me">记住我</label>
											<span class="middot">&middot;</span>
											<a class="reset" href="#">忘记密码？</a>
									</div>
									<div class="clearfix"></div>
							</form>
							<br />
					
							<div class="promo">
								<a href="register.jsp" class="reader"><p>&nbsp;</p> <span class="span">还没有i微博帐号? 立即注册</span> </a>
							</div>
					
						</div>
						
						
				</td>
				
				<td>
				<hr style="width: 0.5px;height: 450px;"/>
				</td>

				<td valign="top">
					<div>
						<%@ include file="shouye_newWeibo.jsp"%>
					</div>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
