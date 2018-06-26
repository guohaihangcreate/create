<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>新增通知公告</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript">
			function save(){
				document.forms[0].action="<%=path%>/systemRightController/saveRightInfo.go";
				document.forms[0].submit();
			}
		</script>
	</head>
	<body id="divtest">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<!--右键代码开始-->
			<div class="contextMenu" id="myMenu1" style="background-color: ">
				<ul>
					<!--图片地址为右键时，显示在菜单左边的小图标-->
					<li id="save">
						&nbsp;&nbsp;&nbsp;&nbsp;保存
					</li>
					<li id="return_back">
						&nbsp;&nbsp;&nbsp;&nbsp;返回
					</li>
				</ul>
			</div>
			<!--右键代码结束-->
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<form action="" method="post" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th width="20%" align="center">
										公告标题
									</th>
									<TD class="BGCgray">
										<input name="noticename" type="text">
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										公告文件
									</th>
									<TD class="BGCgray">
										<input type="file" name="file">
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
	</body>

	<script>

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'refresh': function(t) {
			//执行事件
			window.location.reload();
		},
		'save': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/noticeController/saveSysNotice.go";
			document.forms[0].submit();
		},
		'return_back': function(t) {
			window.history.go(-1);
		}
	  }

});

</script>
</html>