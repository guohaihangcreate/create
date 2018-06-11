<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript">
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="select">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data"
			name="form0">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									考勤组名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="groupName" style="width: 200px;">
								</td>
							</TR>
						</table>
					</td>
				</tr>
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th align="center" nowrap="nowrap">
										名称
									</th>
									<th align="center" nowrap="nowrap">
										人数
									</th>
									<th align="center" nowrap="nowrap">
										类型
									</th>
									<th align="center" nowrap="nowrap">
										考勤时间
									</th>
									<th align="center" nowrap="nowrap">
										说明
									</th>
								</TR>
								<c:forEach items="${attendanceGroupList}" var="attendanceGroup"
									varStatus="status">
									<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											${attendanceGroup.groupName}
										</TD>
										<TD align="center" nowrap="nowrap">
											${attendanceGroup.yl2}
										</TD>
										<TD align="center" nowrap="nowrap">
<%--										//考勤类型,FIXED为固定排班，TURN为轮班排班，NONE为无班次--%>
											<c:if test="${attendanceGroup.type eq 'FIXED'}">
												固定排班
											</c:if>
											<c:if test="${attendanceGroup.type eq 'TURN'}">
												轮班排班
											</c:if>
											<c:if test="${attendanceGroup.type eq 'NONE'}">
												无班次
											</c:if>
										</TD>
										<TD align="center" nowrap="nowrap">
											${attendanceGroup.yl3}
										</TD>
										<TD align="center" >
											本系统中数据只作为参考信息使用,详细信息请相关的公司管理员登录钉钉考勤设置中考勤设置中的考勤组管理中查看
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/attendanceGroupController/queryAttendanceGroupList.go" />
									</jsp:include>
								</table>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<script>

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'select': function(t) {
			//执行事件
		   	document.form0.action="<%=path%>/attendanceGroupController/queryAttendanceGroupList.go";
			document.form0.submit();
		}
	  }
});
</script>
	</body>
</html>