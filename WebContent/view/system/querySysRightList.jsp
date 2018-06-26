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
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="query">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="add">
					&nbsp;&nbsp;&nbsp;&nbsp;新增
				</li>
				<li id="edite">
					<%--					<img src="disk.jpg" />--%>
					&nbsp;&nbsp;&nbsp;&nbsp;编辑
				</li>
				<li id="see">
					&nbsp;&nbsp;&nbsp;&nbsp;查看
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
									名称
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
										名称
									</th>
									<th align="center">
										权限详细关键字
									</th>
									<th align="center">
										所属权限
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${sysRights}" var="right">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											${right.rightName}
										</TD>
										<TD align="center">
											${right.trMark}
										</TD>
										<TD align="center">
											${right.description}
										</TD>
										<TD width="200" align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toSeeinfo('${right.trId}');">
												查看
											</BUTTON>
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="javascript:toEditeinfo('${right.trId}');">
												编辑
											</BUTTON>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="6" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/sysRoleController/queryList.go" />
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
		    document.forms[0].action="<%=path%>/systemRightController/toAddRightInfoPage.go";
			document.forms[0].submit();
		},
		'query': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/systemRightController/queryList.go";
			document.forms[0].submit();
		},
		'see': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
			document.forms[0].submit();
		},
		'edite': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
			document.forms[0].submit();
		}
	  }

});

</script>
	</body>
</html>