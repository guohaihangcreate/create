<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>增加权限组</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="save">
					&nbsp;&nbsp;&nbsp;&nbsp;保存
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
									<th colspan="2">
									</th>
								</TR>
								<TR>
									<th width="20%" align="center">
										标识
									</th>
									<TD class="BGCgray">
										<input name="rightName" type="text" id="rightName">
									</TD>
								</TR>
								<TR>
									<th align="center">
										说明
									</th>
									<TD width="80%" class="BGCgray">
										<input name="groupName" type="text" id="groupName">
									</TD>
								</TR>
								<TR>
									<th align="center">
										备注
									</th>
									<TD class="BGCgray">
										<textarea rows="3" cols="60" name="tgMark" id="tgMark"></textarea>
									</TD>
								</TR>
								<TR>
									<th colspan="2">
									</th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>

		<script>

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'save': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/saveGroup.go";
			document.forms[0].submit();
		}
	  }

});

</script>
	</body>
</html>