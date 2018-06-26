<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
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
										姓名
									</th>
									<TD class="BGCgray">
										<input type="text" name="xingming"
											value="${userInfo.username}">
										<input type="hidden" name="userid" 
											value="${userInfo.id}">
										<span id="xingming_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										邮箱
									</th>
									<TD class="BGCgray">
										<input type="text" name="email" value="${userInfo.email}">
										<span id="email_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										手机号
									</th>
									<TD class="BGCgray">
										<input type="text" name="mobile" value="${userInfo.telephone}">
										<span id="mobile_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										QQ
									</th>
									<TD class="BGCgray">
										<input type="text" name="qq" value="">
										<span id="qq_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										建议简历名称
									</th>
									<TD class="BGCgray">
										<input type="text" name="jianliName" readonly="readonly">
										(系统根据输入信息自动生成)
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										导入简历
									</th>
									<TD class="BGCgray">
										<input type="file" name="file">
									</TD>
								</TR>
								<TR>
									<th align="center">
										工作年限
									</th>
									<TD width="80%" class="BGCgray">
										<select name="gznx">
											<option value="0">
												暂无工作经验
											</option>
											<option value="1">
												培训无实际工作经验
											</option>
											<option value="2">
												一年以下
											</option>
											<option value="3">
												1-2年工作经验
											</option>
											<option value="4">
												2-3年工作经验
											</option>
											<option value="5">
												3-5年工作经验
											</option>
											<option value="6">
												6年以上
											</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th align="center">
										技术类型
									</th>
									<TD width="80%" class="BGCgray">
										<select name="jishuLx">
											<option value="0">
												java
											</option>
											<option value="1">
												.net
											</option>
											<option value="2">
												ios
											</option>
											<option value="3">
												安卓
											</option>
											<option value="4">
												web前端
											</option>
											<option value="5">
												php
											</option>
											<option value="6">
												其他
											</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th align="center">
										简历来源
									</th>
									<TD width="80%" class="BGCgray">
										<select name="jianliLy">
											<option value="0">
												51JOb
											</option>
											<option value="1">
												智联招聘
											</option>
											<option value="2">
												中华英才
											</option>
											<option value="3">
												猎聘
											</option>
											<option value="4">
												58同城
											</option>
											<option value="5">
												其他
											</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th align="center">
										备注
									</th>
									<TD width="80%" class="BGCgray">
										<textarea rows="8" cols="60" name="beizhu"></textarea>
										(输入工作年限，毕业年限等补充信息)
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
			var state = 0;
			var xingming = $("input[name=xingming]").val()+"&";
			var email = $("input[name=email]").val()+"&";
			if($("input[name=xingming]").val()==""){
				$("#xingming_check").text("姓名不能为空，若无相关信息请输入***")
				state = 1;
			}
			if($("input[name=email]").val()==""){
				$("#email_check").text("邮箱不能为空，若无相关信息请输入***")
				state = 1;
			}
			if($("input[name=mobile]").val()==""){
				$("#mobile_check").text("手机号码不能为空，若无相关信息请输入***")
				state = 1;
			}
			if($("input[name=QQ]").val()==""){
				$("#qq_check").text("QQ号码不能为空，若无相关信息请输入***")
				state = 1;
			}
			if(state == 1){
				return false;
			}
			var mobile = $("input[name=mobile]").val()+"&";
			
			var qq = $("input[name=qq]").val();
			$("input[name=jianliName]").val(xingming+email+mobile+qq)
		    document.forms[0].action="<%=path%>/zhaoPinController/saveWaipaiJL.go";
			document.forms[0].submit();
		},
		'see': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/zhaoPinController/saveWaipaiJL.go?opt_type=1&dateid="+dateid;
			document.forms[0].submit();
		},
		'edite': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
			document.forms[0].submit();
		},
		'return_back': function(t) {
			window.history.go(-1);
		}
	  }

});

</script>
</html>