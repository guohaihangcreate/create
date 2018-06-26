<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>柯锐特综合业务管理平台</title>
		<style>
*{
	padding: 0px;
	margin: 0px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background: url(<%=path%>/login_b/images/grass.jpg);
	font-size: 13px;
}

img {
	border: 0;
}

.lg {
	width: 468px;
	margin-left: 100px;
	height: 468px;
	margin: 100px auto;
	background: url(<%=path%>/login_b/images/login_bg.png) no-repeat;
}

.lg_top {
	height: 200px;
	width: 468px;
}

.lg_main {
	width: 400px;
	height: 180px;
	margin: 0 25px;
}

.lg_m_1 {
	width: 290px;
	height: 100px;
	padding: 60px 55px 20px 55px;
}

.ur {
	height: 37px;
	border: 0;
	color: #666;
	width: 236px;
	margin: 4px 28px;
	background: url(<%=path%>/login_b/images/user.png) no-repeat;
	padding-left: 10px;
	font-size: 16pt;
	font-family: Arial, Helvetica, sans-serif;
}

.pw {
	height: 37px;
	border: 0;
	color: #666;
	width: 236px;
	margin: 4px 28px;
	background: url(<%=path%>/login_b/images/password.png) no-repeat;
	padding-left: 10px;
	font-size: 16pt;
	font-family: Arial, Helvetica, sans-serif;
}

.enter {
	width: 330px;
	height: 72px;
	background: url(<%=path%>/login_b/images/enter.png) no-repeat;
	border: 0;
	display: block;
	padding-left: 60px;
	font-size: 18px;
	color: #FFF;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bolder;
}

.btn {
	width: 68px;
	height: 35px;
	border: 0;
	margin-top: 10;
	margin-right: 0;
	float: left;
	font-size: 15px;
	color: #FFF;
	background-color: #69B0DE;
	margin-left: 0px;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bolder;
}

.lg_msg {
	height: 20px;
	width: 170px;
	padding: 6px 68px 0 68px;
	border-color: E4393C;
	background-color: #FFEBEB;
	visibility: hidden;
	color: E4393C;
}

.lg_foot {
	height: 50px;
	width: 330px;
	padding: 6px 68px 0 68px;
}
</style>
<script type="text/javascript">
function keyLogin(){  
   if (event.keyCode==13){  //回车键的键值为13  
        document.getElementById("login").click(); //调用登录按钮的登录事件  
    }  
}  
</script>
	</head>
	<body class="b" onkeydown="keyLogin();">
		<div class="lg">
			<form action="<%=path%>/userController/login.go" method="post"
				id="uerform" enctype="multipart/form-data">
				<div class="lg_top"></div>
				<div class="lg_main">
					<div class="lg_m_1">
						<input name="loginid" id="name" class="ur" />
						<input name="password" id="pass" type="password" class="pw" />
						<div class="lg_msg">
							<p id="login_msg"></p>
						</div>
					</div>
				</div>
				<div class="lg_foot">
					<div class="enter">
						<input type="button" id="login" value="登录" class="btn" />
						<input type="button" id="zhuce" value="注册" class="btn" />
						<input type="button" id="foget" value="忘记密码" class="btn"
							style="font-size: 8px; color: #FFEBEB;" />
					</div>
				</div>
			</form>
		</div>
		<div style="text-align: center;">
			<p>
				来源:
				<a href="http://xiangmu.ren/" target="_blank">北京柯锐特信息技术有限公司</a>
			</p>
		</div>
		<script type="text/javascript"> 
		//登录并且校验    
     $(document).ready(function(){
      	$("#login").click(function(){
      		if($("#name").val()==""||$("#pass").val()==""){
							$("#login_msg").text("用户名或者密码为空");
							$("#login_msg").css("visibility","visible");
							return false;
						}
      		var name = $("#name").val();
      		var pass = $("#pass").val();
		      jQuery.ajax({
		        type : 'GET',
		        contentType : 'text/json;charset=utf-8',
		        url : '<%=path%>/userController/list.go',
		        data : {
		               name : encodeURI($("#name").val()),
		               pass : encodeURI($("#pass").val())
		           },
		        dataType : 'json',
		        success : function(data) {
		        	if(data.message!="true"){
		        		$("#login_msg").text("用户名或者密码不匹配");
						 $("#login_msg").css("visibility","visible");
						 return false;
		        	}
		        	else{
		        		document.forms[0].submit();
		        	}
		        },
		        error : function() {
		        	alert("请求错误");
		        }
		      });
      });
       });
				
			//用户名或者密码活得鼠标提示取消
			$(document).ready(function(){
				   $("#name,#pass").click(function(){
				   		$("#login_msg").css("visibility","hidden");
				   })
				});
		</script>
	</body>
</html>
