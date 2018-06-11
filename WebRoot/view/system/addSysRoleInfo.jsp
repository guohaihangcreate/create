<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="display: none;">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="save_data" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;保存
				</li>
				<li id="return_back" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<form action="" method="post" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th colspan="2" align="left">
										角色信息
									</th>
								</TR>
								<TR>
									<th width="20%" align="center">
										角色名称
									</th>
									<TD class="BGCgray">
										<input name="roleName" type="text" id="roleName">
									</TD>
								</TR>
								<TR>
									<th align="center">
										角色标识
									</th>
									<TD width="80%" class="BGCgray">
										<input name="roleMark" type="text" id="roleMark">
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">角色状态</span>
									</th>
									<TD class="BGCgray">
										<input name="state" type="radio" value="0" id="state" checked="checked">
										<font>启用</font>
										<input name="state" type="radio" value="1" id="state">
										<font>停用</font>
									</TD>
								</TR>
								<TR>
									<th align="center">
										角色说明
									</th>
									<TD class="BGCgray">
										<textarea rows="3" cols="20" name="description"
											id="description"></textarea>
									</TD>
								</TR>
								<TR>
									<th colspan="2" align="left">
										
									</th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</body>
	<script type="text/javascript">
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'save_data': function(t) {
			  	document.forms[0].action="<%=path%>/sysRoleController/toSaveRoleInfo.go";
				document.forms[0].submit();
			},
			'return_back': function(t) {
			  	window.history.go(-1);
			}
		  }
	});
	</script>
</html>