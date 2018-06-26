<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>

<html>
	<head>
		<title></title>
		<link href="<%=path%>/login_b/css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/login_b/js/main.js">
				</script>

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
		<div class="contextMenu" id="myMenu1" style="display: none;">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<c:if test="${opt_type eq 2}">
					<li id="save_data" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;保存
					</li>
				</c:if>
				<li id="return_back" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<form action="">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<form action="" method="post" enctype="multipart/form-data">
								<table width="100%" border="0" cellpadding="3" cellspacing="1"
									class="table1">
									<TR>
										<th align="center" colspan="5" /></th>
									</TR>
									<TR>
										<th width="15%" align="center">
											角色名称
										</th>
										<TD class="BGCgray" width="35%">
											<input name="roleName" type="text" id="roleName"
												<c:if test="${opt_type eq 1}">readonly="readonly"</c:if>
												value="${trole.roleName}" readonly="readonly">
										</TD>
										<th align="center" width="15%">
											角色标识
										</th>
										<TD width="35%" class="BGCgray">
											<input name="roleMark" type="text" id="roleMark"
												readonly="readonly" value="${trole.roleMark}"
												<c:if test="${opt_type eq 1}">readonly="readonly"</c:if>>
										</TD>
									</TR>
									<TR>
										<th align="center" width="15%">
											<span class="BGCgray">角色状态</span>
										</th>
										<TD class="BGCgray" width="35%" colspan="3">
											<input name="state" type="radio" value="0" id="state"
												readonly="readonly"
												<c:if test="${trole.state eq 0}">checked="checked"</c:if>
												<c:if test="${opt_type eq 1}">readonly="readonly"</c:if>>
											<font>启用</font>
											<input name="state" type="radio" value="1" id="state"
												readonly="readonly"
												<c:if test="${trole.state eq 1}">checked="checked"</c:if>
												<c:if test="${opt_type eq 1}">readonly="readonly"</c:if>>
											<font>停用</font>
										</TD>
									</TR>
									<TR>
										<th align="center" colspan="5" /></th>
									</TR>
								</table>
							</form>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'return_back': function(t) {
				//执行事件
			  window.history.go(-1);
			},
			'save_data': function(t) {
				//执行事件
			  	document.forms[0].action="<%=path%>/sysRoleController/updateRoleInfo.go";
				document.forms[0].submit();
			}
		  }
	});
	
	</script>
</html>