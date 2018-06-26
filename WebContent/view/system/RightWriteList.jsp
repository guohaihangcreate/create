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
				<li id="query_data">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
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
									权限详细关键字
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="textfield2" id="textfield2">
								</td>
								<th width="10%" align="center">
									<STRONG>所属权限</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select id="parentTrId" name="parentTrId">
										<option value="">
											请选择
										</option>
										<c:forEach items="${right_query}" var="r">
											<option value="${r.trId}">
												${r.rightName}
											</option>
										</c:forEach>
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
										标识
									</th>
									<th align="center">
										名称
									</th>
									<th align="center">
										权限详细关键字
									</th>
									<th align="center">
										所属权限
									</th>
								</TR>
								<c:forEach items="${listRight}" var="right" varStatus="status">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
											${(page.currentPage-1)*page.everyPage + status.index + 1}
										</TD>
										<TD align="center">
											${right.trId}
										</TD>
										<TD align="center">
											<a
												href="<%=path%>/rightGroupController/toUpdateRirhtDetail.go?trId=${right.trId}"><font
												color="bule">${right.rightName}</font> </a>
										</TD>
										<TD align="center">
											${right.trMark}
										</TD>
										<TD align="center">
											${right.belong_right}
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/rightGroupController/queryRghtDetailList.go" />
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
		    document.forms[0].action="<%=path%>/view/system/to_update_addRightDetailInfo.jsp"
			document.forms[0].submit();
		},
		'query_data': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/queryRghtDetailList.go"
			document.forms[0].submit();
		}
	  }

});

</script>
	</body>
</html>