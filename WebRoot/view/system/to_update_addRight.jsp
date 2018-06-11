<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
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
			function save(){
				document.forms[0].action="<%=path%>/systemRightController/saveRightInfo.go";
				document.forms[0].submit();
			}
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="update_date">
					&nbsp;&nbsp;&nbsp;&nbsp;修改数据
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
										<input name="rightName" type="text" id="rightName"
											value="${right.rightName}">
										<input name="trId" type="hidden" id="trId"
											value="${right.trId}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										权限详细
									</th>
									<TD width="80%" class="BGCgray">
										<input name="description" type="text" id="description"
											value="${right.description}">
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
		'update_date': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/updateRirht.go";
			document.forms[0].submit();
		},
		'return_back': function(t) {
			window.history.go(-1);
		}
	  }

});




function openwindow()
{	
	window.showModalDialog();
	window.open("<%=path%>/view/system/addRightInfo.jsp","a","center:yes;dialogTop:20px;scroll:0;status:0;help:0;resizable:0;dialogWidth:80px;dialogHeight:100px"); 
}

</script>
	</body>
</html>