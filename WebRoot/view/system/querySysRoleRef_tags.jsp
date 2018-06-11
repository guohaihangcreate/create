<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
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
	function addinfo(){
		document.forms[0].action="<%=path%>/sysRoleController/toAddRoleInfoPage.go";
		document.forms[0].submit();
	}
	
	function toSeeinfo(dateid){
		document.forms[0].action="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
		document.forms[0].submit();
	}
	function toEditeinfo(dateid){
		document.forms[0].action="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
		document.forms[0].submit();
	}
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="display: none;">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="query_data" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="toAdd_data" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;新增
				</li>
				<li id="return_back" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<form action="" method="post" enctype="multipart/form-data">
			<div class="easyui-tabs" style="width: 100%; height: 480px">
				<div title="功能权限"
					<%
					if(request.getParameter("type").equals("3")){
				 %>
					data-options="selected:true" <%} %>>
					<iframe scrolling="no"
						src="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?dateid=<%=request.getParameter("roleId")%>"
						style="width: 100%; height: 100%;"></iframe>
				</div>
				<div title="功能权限"
					<%
					if(request.getParameter("type").equals("0")){
				 %>
					data-options="selected:true" <%} %>>
					<iframe scrolling="no"
						src="<%=path%>/systemRightController/queryRoleRefRightList.go?dateid=<%=request.getParameter("roleId")%>"
						style="width: 100%; height: 100%;"></iframe>
				</div>
				<div title="成员"
					<%
					if(request.getParameter("type").equals("2")){
				 %>
					data-options="selected:true" <%} %>>
					<iframe scrolling="no"
						src="<%=path%>/userController/queryRoleUpUser.go?dateid=<%=request.getParameter("roleId")%>"
						style="width: 100%; height: 100%;"></iframe>
				</div>
				<div title="菜单权限"
					<%
					if(request.getParameter("type").equals("1")){
				 %>
					data-options="selected:true" <%} %>>
					<iframe scrolling="auto"
						src="<%=path%>/treeNodeController/queryRoleTreeNode.go?roleId=<%=request.getParameter("roleId")%>"
						style="width: 100%; height: 100%;"></iframe>
				</div>
			</div>
		</form>
	</body>
	<script type="text/javascript">
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'query_data': function(t) {
				//执行事件
			  	document.forms[0].action="<%=path%>/sysRoleController/queryList.go";
				document.forms[0].submit();
			},
			'toAdd_data': function(t) {
			  	document.forms[0].action="<%=path%>/sysRoleController/toAddRoleInfoPage.go";
				document.forms[0].submit();
			},
			'return_back': function(t) {
			  	window.history.go(-1);
			}
		  }
	});
	</script>

</html>