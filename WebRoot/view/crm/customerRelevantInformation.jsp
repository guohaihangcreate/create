<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript"> 
function setTab(name,cursel,n){
	for(i=1;i<=n;i++){
	   var menu=document.getElementById(name+i);
	   var con=document.getElementById("con_"+name+"_"+i);
	   menu.className=i==cursel?"hover":"";
	   con.style.display=i==cursel?"block":"none";
	}
}
</script>
		<title>客户关联的相关信息</title>
		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

ul,li {
	list-style: none;
}

.main {
	width: 100%;
	border: 1px solid #ccc;
	float: left;
	font-size: 12px;
}

.main ul {
	float: left;
	height: 28px;
	line-height: 28px;
	border-bottom: 1px solid #ccc;
	width: 470px;
}

.main ul li {
	float: left;
	width: 90px;
	text-align: center;
	border-right: 1px solid #ccc;
}

.main ul li.hover {
	float: left;
	display: block;
	padding: 5px;
	margin-right: 5px;
	font-weight: 50;
	color: #8FDBFA;
}

.mainbox {
	float: left;
	width: 100%
}
</style>
	</head>
	<body style="height: 200%;">
		<div class="main">
			<ul class="nav nav-list collapse menu-second">
				<li id="two1" onclick="setTab('two',1,5)" class="hover">
					联系人
				</li>
				<li id="two2" onclick="setTab('two',2,5)">
					银行和开票信息
				</li>
				<li id="two5" onclick="setTab('two',5,5)">
					驻场项目
				</li>
				<li id="two3" onclick="setTab('two',3,5)">
					在职工程师
				</li>
				<li id="two4" onclick="setTab('two',4,5)">
					面试列表
				</li>
			</ul>
			<div class="sidebar-menu">
				<div id="con_two_1">
					<iframe style='width: 100%; height: 100%;'
						src="<%=path%>/contactInfroController/contactInfoList.go?customerid=<%=request.getParameter("customerId")%>"
						class=tabs-iframe frameborder="no" border="0" marginwidth="0"
						marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
				</div>
				<div style="display: none;" id="con_two_2">
					<iframe style='width: 100%; height: 100%;'
						src="<%=path%>/customerBankInfroController/customerBankInfoList.go?customerid=<%=request.getParameter("customerId")%>"
						class=tabs-iframe frameborder="no" border="0" marginwidth="0"
						marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
				</div>
				<div style="display: none;" id="con_two_5">
					<iframe style='width: 100%; height: 100%;'
						src="<%=path%>/customerInfoController/queryCustomerZcProjectList.go?cid=<%=request.getParameter("customerId")%>"
						class=tabs-iframe frameborder="no" border="0" marginwidth="0"
						marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
				</div>
				<div style="display: none;" id="con_two_3">
					<iframe style='width: 100%; height: 100%;'
						src="<%=path%>/customerInfoController/queryCustomerWaipenRenyuan.go?status=0&customerid=<%=request.getParameter("customerId")%>"
						class=tabs-iframe frameborder="no" border="0" marginwidth="0"
						marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
				</div>
				<div style="display: none;" id="con_two_4">
					<iframe style='width: 100%; height: 100%;'
						src="<%=path%>/customerInfoController/queryCustomerWaipenRenyuan.go?customerid=<%=request.getParameter("customerId")%>"
						class=tabs-iframe frameborder="no" border="0" marginwidth="0"
						marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>
