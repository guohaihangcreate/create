<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>系统首页</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/icon.css">

		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.mobile.js"></script>
		<script type="text/javascript">
			function showNoticeHtml(id){
					window.location.href="<%=path%>/noticeController/queryNotice.go?Noticeid="+id;
				}
		</script>
	</head>
	<body id="divtest" onload="">
		<!--右键代码开始-->
			<div class="contextMenu" id="myMenu1" style="background-color: ">
				<ul>
					<!--图片地址为右键时，显示在菜单左边的小图标-->
					<li id="addNotice">
						&nbsp;&nbsp;&nbsp;&nbsp;新增通知公告
					</li>
				</ul>
			</div>
			<!--右键代码结束-->
		<form action="">
			<iframe width="100%" height="50%" scrolling="auto"
				src="<%=path%>/${showNotice}"></iframe>
			<div style="overflow: auto; width: 100%;">
								<table width="100%" border="0" cellpadding="3" cellspacing="1"
									class="table1">
									<tr>
										<th align="center" colspan="7">
											<label style="color: red;">
												通知公告
											</label>
										</th>
									</tr>
									<TR>
										<th align="center">
											<input type="checkbox" name="checkbox" id="checkbox">
										</th>
										<th align="center">
											公告标题
										</th>
										<th align="center">
										   发布日期
										</th>
										<th width="200" align="center">
											操作
										</th>
									</TR>
									<c:forEach items="${notices}" var="notice">
										<TR class="BGCgray">
											<TD align="center">
												<input type="checkbox" name="checkbox2" id="checkbox2">
											</TD>
											<TD align="center">
												<a onclick="showNoticeHtml('${notice.id}');"><font color="blue">${notice.noticename}</font></a>
											</TD>
											<TD align="center">
												<fmt:formatDate value="${notice.releasedate}"
													pattern="yyyy-MM-dd HH:mm:ss" />
											</TD>
											<TD align="center">
												<a
													href="<%=path%>/noticeController/updataNotice.go?Noticeid=${notice.id}"
													class="easyui-linkbutton"
													iconCls="icon-search" plain="true"><font color="black">公布</font>
												</a>
												<a href="<%=path%>/noticeController/download.go?Noticeid=${notice.id}"
													class="easyui-linkbutton"
													iconCls="icon-search" plain="true"><font color="black">下载</font>
												</a>
												<a href="<%=path%>/noticeController/deleteNotice.go?Noticeid=${notice.id}"
													class="easyui-linkbutton"
													iconCls="icon-search" plain="true"><font color="black">删除</font>
												</a>
											</TD>
										</TR>
									</c:forEach>
									<tr>
										<th align="center" colspan="7">
										</th>
									</tr>
								</table>
							</div>
					</form>
	</body>
<script>
//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'refresh': function(t) {
				//执行事件
				window.location.reload();
				},
			'addNotice': function(t) {
					   document.forms[0].action="<%=path%>/view/sys/addNotice.jsp";
					   document.forms[0].submit();
				}
		  }
	});
</script>
</html>