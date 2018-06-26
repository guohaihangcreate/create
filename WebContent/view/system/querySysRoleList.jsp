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

		<script type="text/javascript">
	function addinfo(){
		document.forms[0].action="<%=path%>/sysRoleController/toAddRoleInfoPage.go";
		document.forms[0].submit();
	}
	
	function toSeeinfo(dateid){
		document.forms[0].action="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
		document.forms[0].submit();
	}
	function toEditeinfo(dateid){
		document.forms[0].action="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
		document.forms[0].submit();
	}
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="display: none;">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="query_data" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="toAdd_data" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;新增
				</li>
			</ul>
		</div>
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="15%" align="center">
									角色名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="roleName" id="roleName">
								</td>
								<th width="15%" align="center">
									角色编码
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="roleMark" id="roleMark">
								</td>
								<th width="10%" align="center">
									<STRONG>角色状态</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select name="state" id="state">
										<option value="">
											请选择
										</option>
										<option value="0">
											使用中
										</option>
										<option value="1">
											停用
										</option>
									</select>
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
										全选&nbsp;<input type="checkbox" name="checkbox" id="checkAll">
									</th>
									<th align="center">
										角色名称
									</th>
									<th align="center">
										功能权限
									</th>
									<th align="center">
										菜单权限
									</th>
									<th align="center">
										成员
									</th>
								</TR>
								<c:forEach items="${sysRoles}" var="role">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											<a
												href="<%=path%>/view/system/querySysRoleRef_tags.jsp?roleId=${role.roleId}&type=3">
												<font color="blue">${role.roleName}</font> </a>
										</TD>
										<TD align="center">
											<a
												href="<%=path%>/view/system/querySysRoleRef_tags.jsp?roleId=${role.roleId}&type=0">
												<font color="blue">功能权限</font> </a>
										</TD>
										<TD align="center">
											<a
												href="<%=path%>/view/system/querySysRoleRef_tags.jsp?roleId=${role.roleId}&type=1">
												<font color="blue">菜单权限</font> </a>
										</TD>
										<TD align="center">
											<a
												href="<%=path%>/view/system/querySysRoleRef_tags.jsp?roleId=${role.roleId}&type=2">
												<font color="blue">${role.user_member}</font> </a>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url" value="/userController/showUsers.go" />
									</jsp:include>
								</table>
							</table>
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
			'query_data': function(t) {
				//执行事件
			  	document.forms[0].action="<%=path%>/sysRoleController/queryList.go";
				document.forms[0].submit();
			},
			'toAdd_data': function(t) {
			  	document.forms[0].action="<%=path%>/sysRoleController/toAddRoleInfoPage.go";
				document.forms[0].submit();
			}
		  }
	});
	</script>

</html>