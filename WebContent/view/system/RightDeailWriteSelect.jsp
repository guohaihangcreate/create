<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>权限选择</title>
		<link href="<%=path%>/login_b/css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/login_b/js/main.js">
				</script>

		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/icon.css">

		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.mobile.js"></script>
		<script type="text/javascript">
			 function mouseOver(obj){
			        $(obj).css("background-color","green");
			   }
			   
			   
			function mouseOut(obj){
			      if(obj.id%2==0){
			      	 $(obj).css("background-color","#e3efff");
			      }else{
			      	 $(obj).css("background-color","#ffffff");
			      }
			 }
			   
			   
			function writeSelectDate(id,name){
				   	window.parent.document.getElementById("parentTrId").value =id;
					if(GetQueryString("methed")=="savedata"){
						if(window.parent.document.getElementById("tgId").value!=null&&window.parent.document.getElementById("tgId").value!=""){
				    				$.getJSON("<%=path%>/rightGroupController/checkGroupRelationRight.go?trId="+id+"&tgId="+window.parent.document.getElementById("tgId").value, function(json){
												if(json==null){
													window.parent.document.forms[0].action="<%=path%>/rightGroupController/saveGroupRelationRight.go?groupId="+window.parent.document.getElementById("tgId").value;
						 							window.parent.document.forms[0].submit();
												}else{
													alert("数据已经存在");
													return false;
												}
											});
				    	}
					}
					if(GetQueryString("type")=="select"){
				    	window.parent.document.getElementById("parentTrId_Name").innerHTML =name;
					}
				   
				   	parent.$('#myWindow').window('close');
			}
	</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="queryData">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="return_back">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
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
							<TR onclick="">
								<th width="10%" align="center">
									权限名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="rightName" id="rightName">
								</td>
								<th width="10%" align="center">
									权限描述
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="description" id="description">
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
								<TR onMouseOver="mouseOver(this)">
									<th align="center">
										标识
									</th>
									<th align="center">
										名称
									</th>
									<th align="center">
										描述
									</th>
								</TR>
								<c:forEach items="${listRight}" var="right">
									<TR class="BGCgray" onMouseOver="mouseOver(this)"
										onMouseOut="mouseOut(this)"
										onclick="writeSelectDate('${right.trId}','${right.rightName}');">
										<TD align="center">
											${right.trId}
										</TD>
										<TD align="center">
											${right.rightName}
										</TD>
										<TD align="center">
											${right.description}
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="4" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/rightGroupController/queryRghtList.go?type=select" />
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
		'queryData': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/queryRghtList.go?type=select"
			document.forms[0].submit();
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