<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			    $("div").animate({left:'250px'});
			});
		</script>
	</head>
	<body id="divtest" bgcolor="#98bf21">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<td valign="middle" width="100%" nowrap="nowrap">
					<div style="height:100px;width:100px;position:absolute;margin-top: 200px;">
						该部分功能正在开发过程中,敬请期待........
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>