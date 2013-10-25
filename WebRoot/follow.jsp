<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关注我的人   I微博 - 随时随地分享身边的新鲜事儿</title>
<style type="text/css">

</style>
</head>

<body>
	
	<jsp:include page="main_nav.jsp" />

	<div class="body">
	
	<table width="731" height="979" border="0" align="center"
		cellspacing="1" style="background-image: url(images/followLeft.png);">
		
		<tr>
			<td width="497" height="56">&nbsp;&nbsp; 已有<font color="#66FF00">${followersNum}</font>人关注<font
				color="#FF3300">${user.username}</font>
				<hr />
			</td>
		</tr>
		<tr>
			<td height="765" align="left" valign="top"><s:iterator
					value="followers" var="c">
					<s:set name="id" value='#c.id'></s:set>
					<s:set name="uid" value='user.id'></s:set>
					<s:if test='#id!=#uid'>
						<div>
						<a href="<%=request.getContextPath()%>/profile.action?fanid=<s:property value="#c.id"/>">
							<img src="<s:property value='#c.photo'/>" alt="" name="fans"
								width="40" height="40" align="left" id="fans" />
								<font color="#CC99FF"><s:property value='#c.username' />
							</font>
							</a><br /> 地址：
							<s:property value='#c.address' />
							<br />
							<br />
							<hr />
						</div>
					</s:if>
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
