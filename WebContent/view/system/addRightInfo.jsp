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
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="add">
					&nbsp;&nbsp;&nbsp;&nbsp;保存
				</li>
				<li id="return_back">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
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
										名称
									</th>
									<TD class="BGCgray">
										<input name="rightName" type="text" id="rightName">
									</TD>
								</TR>
								<TR>
									<th align="center">
										详细
									</th>
									<TD width="80%" class="BGCgray">
										<input name="description" type="text" id="description">
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
		'add': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/saveRirht.go"; 
			document.forms[0].submit();
		},
		'return_back': function(t) {
			window.history.go(-1);
		}
	  }

});

</script>
	</body>
</html>