<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title></title>
		<link href="<%=path%>/login_b/css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/login_b/js/main.js"></script>
		<script type="text/javascript">
			
		</script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td
					style="height: 25px; background-color: #f3f3f3; font-weight: bold"
					valign="top">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：
					<img src="<%=path%>/images/arrow.gif" align="absmiddle">
					&nbsp;&nbsp;成都市企业服务呼叫中心&nbsp;&nbsp;
					<img src="<%=path%>/images/arrow.gif" align="absmiddle">
					&nbsp;&nbsp;扶持项目专区&nbsp;&nbsp;
					<img src="<%=path%>/images/arrow.gif" align="absmiddle">
					&nbsp;&nbsp;服务券申请
				</td>
			</tr>
			<tr>
				<td
					style="height: 34px; background-image: url(<%=path%>/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34">
								<img src="<%=path%>/images/main_headerL.gif" width="20"
									height="34">
							</td>
							<td style="color: #90c8e8;">
								<img src="<%=path%>/images/icon_card.gif" width="16" height="16"
									align="absmiddle">
								&nbsp;&nbsp;
								<strong>人员信息管理</strong>
							</td>
							<td align="right" class="white" style="padding-right: 20px">
								<a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
										src="<%=path%>/images/btn_left.gif" align="absmiddle">后退</a>
								<a href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
										src="<%=path%>/images/btn_right.gif" align="absmiddle">前进</a>
								<a href="#" class="barBtn"><img
										src="<%=path%>/images/btn_refresh.gif" align="absmiddle">
									刷新</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<form action="<%=path%>/userController/adduser.go" method="post" enctype="multipart/form-data"> 
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th width="20%" align="center">
										员工姓名
									</th>
									<TD class="BGCgray">
										<input name="username" id="username">
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										登录名
									</th>
									<TD class="BGCgray">
										<input name="loginid" id="loginid">
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										密码
									</th>
									<TD class="BGCgray">
										<input name="password" id="password" type="password">
									</TD>
								</TR>
								<TR>
									<th align="center">
										电话
									</th>
									<TD width="80%" class="BGCgray">
										<input name="telephone" type="text" id="telephone">
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">部门</span>
									</th>
									<TD class="BGCgray">
										<input name="departid" type="text" id="departid">
									</TD>
								</TR>
								<TR>
									<th align="center">
										职位
									</th>
									<TD class="BGCgray">
										<input name="jobid" type="text" id="jobid">
									</TD>
								</TR>
								<TR>
									<th align="center">
										邮箱
									</th>
									<TD class="BGCgray">
										<input name="email" type="text" id="email">
									</TD>
								</TR>
								<TR>
									<th align="center">
										身份证号码
									</th>
									<TD class="BGCgray">
										<input name="idno" type="text" id="idno" style="size: 300px;">
									</TD>
								</TR>
								<TR>
									<th align="center">
										简历
									</th>
									<TD class="BGCgray">
										<input name="resume" type="file" id="resume">
									</TD>
								</TR>
								<TR>
									<th align="center">
										角色
									</th>
									<TD class="BGCgray">
										<input name="resume" type="text" id="resume">
									</TD>
								</TR>
							</table>
							<div style="width: 100%; text-align: center; padding: 5px">
								<BUTTON style="HEIGHT: 25px" id="savabtn">
									<img src="<%=path%>/images/btn_save.gif" width="16" height="16"
										align="absmiddle">
									保存
								</BUTTON>
							</div>
						</div>
					</form>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
	     $(document).ready(function(){
			$("#savabtn").click(function(){
				document.forms[0].submit();
			})
	})

</script>
</html>