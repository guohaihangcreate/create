<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ page import="create.model.hrm.User"%>
<%@ include file="/view/system/init.jsp"%>
<%
	Cookie cookie = new Cookie("key", "value");
	cookie.setMaxAge(60);
%>
<html>
	<head>
		<title>柯锐特综合办公平台</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<%=path%>/login_b/css/style.css" rel="stylesheet"
			type="text/css" />
		<link rel="StyleSheet" href="<%=path%>/login_b/css/dtree.css"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/login_b/js/dtree.js"></script>
		<style>
.picBox {
	width: 10px;
	background: #337ABB url(../../images/right.gif) no-repeat center center;
}
</style>
		<script type="text/javascript">
			var status = 1;
			function witchSysBar(){
				var switchPoint=document.getElementById("switchPoint");
				var frmTitle=document.getElementById("leftdoor");
			     if (1 == window.status){
					  window.status = 0;
			          switchPoint.style.backgroundImage = 'url(<%=path%>/create/images/left.gif)';
			          frmTitle.style.display="none"
			     }
			     else{
					  window.status = 1;
			          switchPoint.style.backgroundImage = 'url(<%=path%>/create/images/right.gif)'; 
			          frmTitle.style.display=""
			     }
			}
			
			function outSystem(){
				var userID='<%=session.getAttribute("userID")%>';
				var $document = $(window.parent.frames["maipage"].document);
				$document.find("#content").append("<div><iframe  style='width: 100%;'  src='<%=path%>/userController/to_edite.go?dotype=0&id=<%=session.getAttribute("userID")%>'  class='tabs-iframe'></iframe></div>");
			}
</script>
	</head>
	<body scroll="no">
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="10000">
					<div
						style="background: url(<%=path%>/images/top.jpg) no-repeat; height: 100px; width: 100%;">
						<div style="float: right; margin-top: 10px" align="right">
							<a style="text-decoration: none;" href="<%=path%>/create"> <span
								style="color: #FFF; text-shadow: #333 5px 5px 10px; margin-right: 9px;">
									帮助中心</span> </a>
							<span
								style="color: #FFF; text-shadow: #333 5px 5px 10px; margin-right: 8px; margin-left: 8px">
								| </span>
							<a style="text-decoration: none;"
								href="javascript:outSystem();"> <span
								style="color: #FFF; text-shadow: #333 5px 5px 10px; margin-right: 9px;">
									修改密码 </span> </a>
							<span
								style="color: #FFF; text-shadow: #333 5px 5px 10px; margin-right: 8px; margin-left: 8px">
								| </span>
							<a style="text-decoration: none;"
								href="<%=path%>/userController/logout.go"> <span
								style="color: #FFF; text-shadow: #333 5px 5px 10px; margin-right: 9px;">
									安全退出 </span> </a>
						</div>
						<img src="<%=path%>/images/createlogo.png" width="100"
							height="100" style="padding-left: 30px; float: left;" />
						<span
							style="margin-left: 50px; font-size: 30px; line-height: 100px; color: #FFF; text-shadow: #333 5px 5px 10px;"font-family:'宋体', Times, serif;  >柯锐特信息系统平台</span>
						<div
							style="float: right; margin-top: -19px; position: absolute; margin-left: 990px;"
							align="right">
							<span
								style="color: #6f2966; text-shadow: #333 5px 5px 10px; margin-right: 5px;">
								当前用户：<%=request.getSession().getAttribute("c_user")%> </span>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100%">
					<table width="100%" height="100%" border="0" cellspacing="0"
						cellpadding="0">
						<tr>
							<td width="11.7%" height="100%" valign="top" id="leftdoor">
								<iframe src="<%=path%>/treeNodeController/leftTreeNode.go"
									width="100%" height="720" frameborder="0" scrolling="no"
									name="leftpage"
									style="background-repeat: repeat-x; margin-left: 0.03cm;"></iframe>
							</td>
							<td width="0.95%" height="100%" id="switchPoint"
								style="background: #337ABB url(<%=path%>/create/images/left.gif) no-repeat center center;"
								onclick="witchSysBar()">
							</td>
							<td>
								<iframe src="<%=path%>/view/sys/createTabs.jsp" width="100%" scrolling="no"
									height="100%" frameborder="0" scrolling="auto" name="maipage"></iframe>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>