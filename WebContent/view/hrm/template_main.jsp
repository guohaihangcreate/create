<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<%@ include file="/view/system/init.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>左侧菜单</title>
		<meta name="keywords" content="系统左侧菜单" />
		<link href="skins/css/style.css" rel="stylesheet" type="text/css" />
		<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
	border: none;
}

.main {
	width: 100%;
	height: 100%;
	text-align: left;
}

.main_left {
	width: 80%;
	height: 100%;
	background: white;
}

.main_right {
	height: 100%;
	background-color: #CCC;
}

.picBox {
	width: 9px;
	background: #337ABB url(../../images/right.gif) no-repeat center center;
}

.main_left,.picBox {
	float: left;
	height: 100%;
	_margin-right: -3px;
}

.bottom {
	width: 100%;
	height: 98%;
	text-align: left;
}

.bottom_left {
	width: 60%;
	background: white;
}

.uppicBox {
	width: 100%;
	height: 6px;
	background: #337ABB url(../../images/up.gif) no-repeat center center;
}

.bottom_right {
	width: 40%;
	background-color: #CCC;
}
</style>
		<script src="<%=path%>/js/admin.js" type="text/javascript"></script>
<script type="text/javascript">
			var status = 1;
			function upswitchSysBar(){
				var switchPoint=document.getElementById("upswitchPoint");
				var frmTitle=document.getElementById("bottomDiv");
			     if (1 == window.status){
					  window.status = 0;
			          switchPoint.style.backgroundImage = 'url(../../images/down.gif)';
			          frmTitle.style.display="none"
			     }
			     else{
					  window.status = 1;
			          switchPoint.style.backgroundImage = 'url(../../images/up.gif)'; 
			          frmTitle.style.display=""
			     }
			}
</script>
	<body>
		<div class="bottom" id="bottomDiv">
		</div>
		<div class="uppicBox" onclick="upswitchSysBar()" id="upswitchPoint"></div>

		<div class="main">
			<div class="main_left" id="frmTitle">
				左边
			</div>
			<div class="picBox" onclick="switchSysBar()" id="switchpoint"></div>
			<div class="main_right">
			</div>
		</div>
		
	</body>
</html>