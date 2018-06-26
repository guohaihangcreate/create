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
									班次名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="classname" style="width: 200px;">
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
										班次名称
									</th>
									<th align="center" nowrap="nowrap">
										考勤时间
									</th>
									<th align="center" nowrap="nowrap">
										操作
									</th>
								</TR>
								<c:forEach items="${attendanceClass_list}" var="attendanceClass"
									varStatus="status">
									<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											${attendanceClass.classname}
										</TD>
										<TD align="center" nowrap="nowrap">
											${attendanceClass.rest_begintime} - ${attendanceClass.rest_endtime}
										</TD>
										<TD align="center" nowrap="nowrap">
											编辑或者查看详细等工作请到钉钉客户端进行！
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/attendanceClassController/queryAttendanceClassList.go" />
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
		   	document.form0.action="<%=path%>/attendanceClassController/queryAttendanceClassList.go";
			document.form0.submit();
		}
	  }
});
</script>
	</body>
</html>