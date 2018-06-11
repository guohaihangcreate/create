<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
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

	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="queryData">
					&nbsp;&nbsp;&nbsp;&nbsp;查 询
				</li>
				<li id="add">
					&nbsp;&nbsp;&nbsp;&nbsp;新 增
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									权限名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="rightName" id="rightName">
								</td>
								<th width="10%" align="center">
									权限描述
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="description" id="description">
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
									<th align="center">
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center">
										标识
									</th>
									<th align="center">
										名称
									</th>
									<th align="center">
										描述
									</th>
									<th align="center">
										操 作
									</th>
								</TR>
								<c:forEach items="${listRight}" var="right">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											${right.trId}
										</TD>
										<TD align="center">
											${right.rightName}
										</TD>
										<TD align="center">
											${right.description}
										</TD>
										<td align="center">
											<a
												href="<%=path%>/rightGroupController/toUpdateRirht.go?trId=${right.trId}"
												class="easyui-linkbutton"
												data-options="plain:true,iconCls:'icon-edit'"><font
												color="black">修 改</font> </a>
											<a
												href="<%=path%>/rightGroupController/deleteRirht.go?trId=${right.trId}"
												class="easyui-linkbutton"
												data-options="plain:true,iconCls:'icon-remove'"><font
												color="black">删 除</font> </a>	
										</td>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url" value="/rightGroupController/queryRghtList.go" />
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
		'add': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/view/system/addRightInfo.jsp"
			document.forms[0].submit();
		},
		'queryData': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/queryRghtList.go"
			document.forms[0].submit();
		}
	  }

});

</script>
	</body>
</html>