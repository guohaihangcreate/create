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
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<!--右键代码开始-->
			<div class="contextMenu" id="myMenu1" style="background-color: ">
				<ul>
					<!--图片地址为右键时，显示在菜单左边的小图标-->
					<li id="refresh">
						&nbsp;&nbsp;&nbsp;&nbsp;刷新
					</li>
					<li id="save">
						&nbsp;&nbsp;&nbsp;&nbsp;保存
					</li>
					<li id="fanhui">
						<%--					<img src="disk.jpg" />--%>
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
										<input type="text" name="xingming" value="${xingming}"><span id="xingming_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										邮箱
									</th>
									<TD class="BGCgray">
										<input type="text" name="email" value="${email}"><span id="email_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										手机号
									</th>
									<TD class="BGCgray">
										<input type="text" name="mobile" value="${mobile}"><span id="mobile_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										QQ
									</th>
									<TD class="BGCgray">
										<input type="text" name="qq" value="${qq}"><span id="qq_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										建议简历名称
									</th>
									<TD class="BGCgray">
										<input type="text" name="jianliName" readonly="readonly" value="${jl.jianliName}">(系统根据输入信息自动生成)
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										导入简历
									</th>
									<TD class="BGCgray">
										<input type="file" name="file"><input type="hidden" value="${jl.pId}" name="pId"><span style="color: gray;">${jl.jianliName}</span>
									</TD>
								</TR>
								<TR>
									<th align="center">
										工作年限
									</th>
									<TD width="80%" class="BGCgray">
										<select name="gznx">
											<option value="0" <c:if test="${jl.gznx eq 0}">selected="selected"</c:if>>
												暂无工作经验
											</option>
											<option value="1" <c:if test="${jl.gznx eq 1}">selected="selected"</c:if>>
												培训无实际工作经验
											</option>
											<option value="2" <c:if test="${jl.gznx eq 2}">selected="selected"</c:if>>
												一年以下
											</option>
											<option value="3" <c:if test="${jl.gznx eq 3}">selected="selected"</c:if>>
												1-2年工作经验
											</option>
											<option value="4" <c:if test="${jl.gznx eq 4}">selected="selected"</c:if>>
												2-3年工作经验
											</option>
											<option value="5" <c:if test="${jl.gznx eq 5}">selected="selected"</c:if>>
												3-5年工作经验
											</option>
											<option value="6" <c:if test="${jl.gznx eq 6}">selected="selected"</c:if>>
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
											<option value="0" <c:if test="${jl.jishuLx eq 0}">selected="selected"</c:if>>
												java
											</option>
											<option value="1" <c:if test="${jl.jishuLx eq 1}">selected="selected"</c:if>>
												.net
											</option>
											<option value="2" <c:if test="${jl.jishuLx eq 2}">selected="selected"</c:if>>
												ios
											</option>
											<option value="3" <c:if test="${jl.jishuLx eq 3}">selected="selected"</c:if>>
												安卓
											</option>
											<option value="4" <c:if test="${jl.jishuLx eq 4}">selected="selected"</c:if>>
												web前端
											</option>
											<option value="5" <c:if test="${jl.jishuLx eq 5}">selected="selected"</c:if>>
												php
											</option>
											<option value="6" <c:if test="${jl.jishuLx eq 6}">selected="selected"</c:if>>
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
											<option value="0" <c:if test="${jl.jianliLy eq 0}">selected="selected"</c:if>>
												51JOb
											</option>
											<option value="1" <c:if test="${jl.jianliLy eq 1}">selected="selected"</c:if>>
												智联招聘
											</option>
											<option value="2" <c:if test="${jl.jianliLy eq 2}">selected="selected"</c:if>>
												中华英才
											</option>
											<option value="3" <c:if test="${jl.jianliLy eq 3}">selected="selected"</c:if>>
												猎聘
											</option>
											<option value="4" <c:if test="${jl.jianliLy eq 4}">selected="selected"</c:if>>
												58同城
											</option>
											<option value="5" <c:if test="${jl.jianliLy eq 5}">selected="selected"</c:if>>
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
										<textarea rows="8" cols="60" name="beizhu">${jl.beizhu}</textarea>(输入工作年限，毕业年限等补充信息)
									</TD>
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
			if($("input[name=qq]").val()==""){
				$("#qq_check").text("QQ号码不能为空，若无相关信息请输入***")
				state = 1;
			}
			if(state == 1){
				return false;
			}
			
			var mobile = $("input[name=mobile]").val()+"&";
			
			var qq = $("input[name=qq]").val();
			$("input[name=jianliName]").val(xingming+email+mobile+qq)
		    document.forms[0].action="<%=path%>/zhaoPinController/updateWaipaiJL.go";
			document.forms[0].submit();
		},
		'fanhui': function(t) {
			//执行事件
			window.history.go(-1);
		},
	  }

});

</script>
</html>