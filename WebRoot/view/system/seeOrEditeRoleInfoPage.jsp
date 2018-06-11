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
										<th align="center" width="15%">
											功能权限分配
										</th>
										<TD class="BGCgray" width="35%">
											<div style="margin: 20px 0;">
												<a href="javascript:void(0)" class="easyui-linkbutton"
													iconCls="icon-search" plain="true"
													onclick="$('#myWindow_1').window('open');"><font
													color="bule">功能权限分配</font> </a>
											</div>
										</TD>
										<th align="center">
											功能权限列表
										</th>
										<TD class="BGCgray">
											<div class="easyui-resizable"
												data-options="minWidth:400,minHeight:50"
												style="width: 500px; height: 180px; border: 1px solid #ccc;">
												<div style="padding: 20px; width: 400px;"
													id="right_listname" name="right_listname">
												</div>
											</div>
											<textarea rows="" cols="" id="right_list" name="right_list"
												style="display: none;"></textarea>
										</TD>
									</TR>
									<TR>
										<th align="center">
											角色菜单权限分配
										</th>
										<TD class="BGCgray">
											<div style="margin: 20px 0;">
												<a href="javascript:void(0)" class="easyui-linkbutton"
													iconCls="icon-search" plain="true"
													onclick="$('#myWindow').window('open');"><font
													color="bule">权限分配</font> </a>
											</div>
										</TD>
										<th align="center">
											角色权限
										</th>
										<TD class="BGCgray">
											<div class="easyui-resizable"
												data-options="minWidth:400,minHeight:50"
												style="width: 500px; height: 180px; border: 1px solid #ccc;">
												<div style="padding: 20px; width: 400px;"
													id="aoth_listvalue" name="aoth_listvalue">
													${trole.aoth_list}
												</div>
											</div>
											<textarea rows="" cols="" id="aoth_list" name="aoth_list"
												style="display: none;">${trole.aoth_list}</textarea>
											<input name="roleId" type="hidden" value="${trole.roleId}">
										</TD>
									</TR>
									<TR>
										<th align="center" readonly="readonly">
											角色成员选择
										</th>
										<TD class="BGCgray" readonly="readonly">
											<div style="margin: 20px 0;">
												<a href="javascript:void(0)" class="easyui-linkbutton"
													iconCls="icon-search" plain="true"
													onclick="$('#myWindow_2').window('open');"><font
													color="bule">选择角色成员</font> </a>
											</div>
										</TD>
										<th align="center">
											角色成员
										</th>
										<TD class="BGCgray">
											<div class="easyui-resizable"
												data-options="minWidth:400,minHeight:50"
												style="width: 500px; height: 180px; border: 1px solid #ccc;">
												<div style="padding: 20px; width: 400px;"
													id="role_listvalue" name="role_listvalue">
													${trole.role_list}
												</div>
											</div>
											<textarea rows="" cols="" id="role_list" name="role_list"
												style="display: none;">${trole.role_list}</textarea>
										</TD>
									</TR>
									<TR>
										<th align="center">
											角色说明
										</th>
										<TD class="BGCgray" colspan="3">
											<textarea rows="3" cols="20" name="description"
												id="description"
												<c:if test="${opt_type eq 1}">readonly="readonly"</c:if>>${trole.description}</textarea>
										</TD>
									</TR>
									<TR>
										<th align="center" colspan="2" /></th>
									</TR>
								</table>
							</form>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<div id="myWindow" class="easyui-window" title="权限分配"
			data-options="modal:true,closed:true,iconCls:'icon-save'"
			style="width: 50%; height: 100%; padding: 0px;">
			<iframe name="authIframe" id="authIframe"
				src="<%=path%>/view/system/distributionAuthMenue.jsp?menueselected='${trole.aoth_list}'"
				width="100%" height="150%" scrolling="no"></iframe>
		</div>
		<div id="myWindow_1" class="easyui-window" title="功能权限分配"
			data-options="modal:true,closed:true,iconCls:'icon-save'"
			style="width: 50%; height: 100%; padding: 0px;">
			<iframe name="authIframe" id="authIframe" src="" width="100%"
				height="150%" scrolling="no"></iframe>
		</div>
		<div id="myWindow_2" class="easyui-window" title="角色成员选择"
			data-options="modal:true,closed:true,iconCls:'icon-save'"
			style="width: 65%; height: 60%; padding: 0px;">
			<iframe name="authIframe" id="authIframe"
				src="<%=path%>/userController/select_userData.go" width="100%"
				height="150%" scrolling="no"></iframe>
		</div>
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