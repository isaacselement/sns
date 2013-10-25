<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>I微博搜索</title>
<link rel="stylesheet" href="css/boxy.css" type="text/css" />
<link rel="stylesheet" href="css/search/allUser.css" type="text/css"/>

<script type="text/javascript" src="js/jquery-1.2.6.pack.js"></script>
<script type="text/javascript" src="js/jquery.boxy.js"></script>
<script type="text/javascript" src="addComments.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.zxxbox.3.0.js"></script>
<script type="text/javascript" src="js/content_zoom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('div.small_pic a').fancyZoom({
			scaleImg : true,
			closeOnClick : true
		});
	});
</script>

</head>

<body>

	<jsp:include page="main_nav.jsp" />

	<div class="body">

		<!-- 搜索Header -->
		<div class="search_header" style="border: 0px solid red;">
			<div class="W_main_l"  style="border: 0px solid black;">
				<a href="" class="s_logo"></a>
			</div>
			<div class="W_main_c" style="border: 0px solid black;" >
				<div class="search_bar" style="border: 0px solid green;">
					<input class="input_search" type="text" placeholder="" maxlength="40"> 
						<a  class="btn_search" href="javascript:void(0);">搜索</a>
				</div>
				<p>
					<span class="search_result"></span> 
				</p>
			</div>
		</div>
		<!-- /搜索Header -->

		<table width="731" height="979" border="0" align="center"
			cellspacing="1" >
			<tr>
				<td width="497" height="56">&nbsp;&nbsp;
					为你搜索到${choUserSize}个用户
					<hr />
				</td>
			</tr>
			<tr>
				<td height="765" align="left" valign="top"><s:set
						name="userExit" value='choUserSize'></s:set> <s:if
						test='#userExit!=0'>
						<s:iterator value="choUser" var="c">
							<div>
								<img src="<s:property value='#c.photo'/>" alt="" name="fans"
									width="40" height="40" align="left" id="fans" /><a
									href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.id"/>"><s:property
										value='#c.username' /> </a><br /> 地址：
								<s:property value='#c.address' />
								<hr />
							</div>
						</s:iterator>
					</s:if> <s:else>
						<p>找不到符合的用户，请确定信息后重新输入搜索！</p>
					</s:else>
				</td>
			</tr>
			<tr>
				<td height="83" colspan="2">&nbsp;</td>
			</tr>
		</table>
	</div>
</body>
</html>
