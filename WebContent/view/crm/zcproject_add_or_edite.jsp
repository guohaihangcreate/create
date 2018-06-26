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
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<!--右键代码开始-->
				<div class="contextMenu" id="myMenu1" style="background-color: ">
					<ul>
						<!--图片地址为右键时，显示在菜单左边的小图标-->
						<c:if test="${type eq 'edite'}">
							<li id="edite_project">
							&nbsp;&nbsp;&nbsp;&nbsp;修改项目
							</li>
						</c:if>
						<c:if test="${type ne 'edite'}">
							<li id="add_project">
							&nbsp;&nbsp;&nbsp;&nbsp;新增项目
							</li>
						</c:if>
						<li id="return_back">
							&nbsp;&nbsp;&nbsp;&nbsp;返回
						</li>
					</ul>
				</div>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form0" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
										驻场项目信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										项目名称
									</th>
									<TD class="BGCgray" width="40%">
										<input name="projectname" value="${zcproject.projectname}" style="width: 400px;">
										<c:if test="${type ne 'edite'}">
										<input name="cid" value="<%=request.getParameter("cid") %>" type="hidden">
										</c:if>
										<c:if test="${type eq 'edite'}">
											<input name="cid" value="${zcproject.cid}" type="hidden">
											<input name="id" value="${zcproject.id}" type="hidden">
										</c:if>
									</TD>
									<th align="center" width="10%">
										项目地址
									</th>
									<TD class="BGCgray" width="40%">
										<input name="projectadress" value="${zcproject.projectadress}" style="width: 400px;">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										备注信息
									</th>
									<TD width="90%" class="BGCgray" colspan="3">
										<textarea rows="8" cols="160" name="yl1">${zcproject.yl1}</textarea>
									</TD>
								</TR>
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
									</th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'add_project':function(t) {
			document.form0.action="<%=path%>/customerInfoController/addCustomerZcProjectList.go";
			document.form0.submit();
		},
		'edite_project':function(t) {
			document.form0.action="<%=path%>/customerInfoController/updateCustomerZcProjectList.go";
			document.form0.submit();
		},
		'return_back': function(t) {
			//执行事件
		    window.history.go(-1);
		}
	  }

});
</script>
	</body>
</html>