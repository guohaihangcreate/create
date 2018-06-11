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
	function addinfo(){
		document.forms[0].action="<%=path%>/systemRightController/toAddRightInfoPage.go";
		document.forms[0].submit();
	}
	
	function toSeeinfo(dateid){
		document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
		document.forms[0].submit();
	}
	function toEditeinfo(dateid){
		document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
		document.forms[0].submit();
	}
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="add">
					&nbsp;&nbsp;&nbsp;&nbsp;新增
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
									权限编码
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="textfield2" id="textfield2">
								</td>
								<th width="10%" align="center">
									<STRONG>权限状态</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select name="select2" id="select2">
										<option>
											请选择
										</option>
										<option>
											新增
										</option>
										<option>
											取消
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
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center">
										权限组名称
									</th>
									<th align="center">
										权限数量
									</th>
								</TR>
								<TR class="BGCgray">
									<TD align="center">
										<input type="checkbox" name="checkbox2" id="checkbox2">
									</TD>
									<TD align="center">
										全部
									</TD>
									<TD align="center">
										<a
												href="<%=path%>/rightGroupController/queryGroupAndRelationRight.go?groupId=${group.tgId}"><font
												color="blue">${all_right_num}</font> </a>
										
									</TD>
								</TR>
								<c:forEach items="${groups}" var="group">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											${group.groupName}
										</TD>
										<TD align="center">
											<a
												href="<%=path%>/rightGroupController/queryGroupAndRelationRight.go?groupId=${group.tgId}&detail=is not null"><font
												color="blue">${group.right_num}</font> </a>
										</TD>
									</TR>
								</c:forEach>
								<tr>
									<th align="center" colspan="6" /></th>
								</tr>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/rightGroupController/queryGroupList.go" />
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
		    document.forms[0].action="<%=path%>/view/system/addRightGroupInfo.jsp";
			document.forms[0].submit();
		}
	  }

});

</script>
	</body>
</html>