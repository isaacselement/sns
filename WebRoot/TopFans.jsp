<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'TopFans.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="showTopFans.js"></script>
<style type="text/css">
ul,li {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	margin: 0;
	height: 100%;
	background: ;
}

.hq {
	position: relative;
	width: 200px;
	height: 550px;
	overflow: hidden;
	margin: 0px auto;
	border: 1px solid #ccc;
}

.TopFans {
	position: absolute;
	width: 460px;
	padding: 20px;
	left: 0;
	top: 0;
}

.fl1 {
	float: left;
}

.TopFans img {
	display: block;
	padding: 2px;
	border: 1px solid #ccc;
}

.TopFans li {
	padding: 20px 0;
	border-bottom: 0px dashed #ccc;
	overflow: hidden;
	width: 100%;
}
</style>

</head>

<body onLoad="showTopFans()">
	<div class="hq">
		<ul id="TopFans" class="TopFans">
			<li></li>
		</ul>
	</div>
</body>
</html>
