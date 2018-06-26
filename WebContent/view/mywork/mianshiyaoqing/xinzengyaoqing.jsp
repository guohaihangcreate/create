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
			function doAddInterProcess(dateid,customerId){
				document.forms[0].action="<%=path%>/mianshiYaoQingController/toMianshiprocessDetail.go?jlID="+dateid+"&customerId="+customerId;
				document.forms[0].submit();
			}
			//ajax获取客户联系人
			function getCustomercontacts(value){
				$("#djfzr").empty();
				$.get("<%=path%>/contactInfroController/ajaxContactLit.go?customerid="+value,function(data){
						for(var i=0;i<data.split(";").length;i++){
				    			$("#djfzr").append("<option value="+data.split(";")[i].split(",")[0].split(":")[1]+">"+data.split(";")[i].split(",")[1].split(":")[1]+"</option>");
				    		}
				  });
			}
		</script>
	</head>
	<%
		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		java.util.Date currentTime = new java.util.Date();
		String time = simpleDateFormat.format(currentTime).toString(); //放到页面的head中}
	%>
	<body id="divtest">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<!--右键代码开始-->
			<div class="contextMenu" id="myMenu1" style="background-color: ">
				<ul>
					<!--图片地址为右键时，显示在菜单左边的小图标-->
					<li id="addInterViewDetail">
						&nbsp;&nbsp;&nbsp;&nbsp;添加邀请
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
										邀约日期
									</th>
									<TD class="BGCgray">
										<input class="laydate-icon" value="<%=time%>"
											readonly="readonly" name="interviewdateStr"
											id="interviewdateStr">
										(系统根据输入信息自动生成)
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										姓名
									</th>
									<TD class="BGCgray">
										<input type="text" name="email" value="${interViewerName}">
										<span id="email_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										岗位
									</th>
									<TD class="BGCgray">
										<select name="jishuLx" id="jishuLx">
											<option value="">
												请选择
											</option>
											<option value="0"
												<c:if test="${jl.jishuLx eq 0}">selected="selected"</c:if>>
												java软件工程师
											</option>
											<option value="1"
												<c:if test="${jl.jishuLx eq 1}">selected="selected"</c:if>>
												.net软件工程师
											</option>
											<option value="2"
												<c:if test="${jl.jishuLx eq 2}">selected="selected"</c:if>>
												ios软件工程师
											</option>
											<option value="3"
												<c:if test="${jl.jishuLx eq 3}">selected="selected"</c:if>>
												安卓软件工程师
											</option>
											<option value="4"
												<c:if test="${jl.jishuLx eq 4}">selected="selected"</c:if>>
												web前端软件工程师
											</option>
											<option value="5"
												<c:if test="${jl.jishuLx eq 5}">selected="selected"</c:if>>
												php软件工程师
											</option>
											<option value="6"
												<c:if test="${jl.jishuLx eq 6}">selected="selected"</c:if>>
												其他
											</option>
										</select>
										<span id="jishuLx_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										联系方式
									</th>
									<TD class="BGCgray">
										<input type="text" name="mobile" value="${mobile}">
										<span id="qq_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										邮箱
									</th>
									<TD class="BGCgray">
										<input type="text" name="email" value="${email}">
										<span id="email_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										QQ
									</th>
									<TD class="BGCgray">
										<input type="text" name="qq" value="${qq}">
										<span id="QQ_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th align="center">
										是否接听
									</th>
									<TD width="80%" class="BGCgray">
										<input type="radio" name="yl4" checked="checked" value="1" />
										是&nbsp&nbsp&nbsp
										<input type="radio" name="yl4" value="0">
										否
									</TD>
								</TR>
								<TR>
									<th align="center">
										面试时间
									</th>
									<TD width="80%" class="BGCgray">
										<input id="invitationdateStr" class="laydate-icon"
											value="请选择面试时间" readonly="readonly" name="invitationdateStr">
										<span id="invitationdateStr_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th align="center">
										客户信息
									</th>
									<TD width="80%" class="BGCgray">
										<select class="" name="customer" id="customer"
											onchange="getCustomercontacts(this.value)">
											<option value="">
													请选择
											</option>
											<c:forEach items="${customerInfos}" var="customer">
												<option value="${customer.id}">
													${customer.customername}
												</option>
											</c:forEach>
										</select>
										<span id="customer_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th align="center">
										客户对接负责人
									</th>
									<TD width="80%" class="BGCgray">
										<select name="djfzr" id="djfzr">
											<option>
												请选择
											</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th align="center">
										是否同意面试
									</th>
									<TD width="80%" class="BGCgray">
										<input type="radio" name="state" checked="checked" value="1" />
										是&nbsp&nbsp&nbsp
										<input type="radio" name="state" value="0">
										否
									</TD>
								</TR>
								<TR>
									<th align="center">
										备注
									</th>
									<TD width="80%" class="BGCgray">
										<textarea rows="8" cols="60" name="gtbz"></textarea>
										(安排面试的相关信息)
									</TD>
								</TR>
							</table>
						</form>
						<div style="overflow: auto; width: 100%;">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<tr>
									<th align="center" colspan="7">
										<label style="color: red;">
											邀请详细
										</label>
									</th>
								</tr>
								<TR>
									<th align="center">
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center">
										邀请日期
									</th>
									<th align="center">
										面试时间
									</th>
									<th width="200" align="center">
										沟通详细
									</th>
									<th align="center">
										是否同意面试
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${InterviewInvitations}" var="Interview">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											<fmt:formatDate value="${Interview.interviewdate}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</TD>
										<TD align="center">
											<fmt:formatDate value="${Interview.invitationdate}"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</TD>
										<TD align="center">
											${Interview.gtbz}
										</TD>
										<TD align="center">
											<c:if test="${Interview.state eq 1}">
												是
											</c:if>
											<c:if test="${Interview.state ne 1}">
												否
											</c:if>
										</TD>
										<TD align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="doAddInterProcess('${jl.pId}','${Interview.customer}','${Interview.id}');">
												补充面试结果
											</BUTTON>
										</TD>
									</TR>
								</c:forEach>
								<tr>
									<th align="center" colspan="7">
									</th>
								</tr>
							</table>
						</div>
						<iframe width="100%" height="100%" scrolling="auto"
							src="<%=path%>/jianli_html/${randomHtmlJL_name}"></iframe>
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
		'return_back': function(t) {
			//执行事件
			window.history.go(-1);
		},
		
		'addInterViewDetail': function(t) {
			//执行事件
			var state = 0;
			var xingming = $("input[name=xingming]").val()+"&";
			var email = $("input[name=email]").val()+"&";
			var jishuLx = $("#jishuLx").val();
			var checkbox = $("#jishuLx :selected");
<%--			简历id和客户id和对接人ajax校验--%>
			if($("input[name=xingming]").val()==""){
				$("#xingming_check").text("姓名不能为空")
				state = 1;
			}
			if(checkbox.val()==""){
				$("#jishuLx_check").text("岗位不能为空")
				state = 1;
			}
			if($("input[name=email]").val()==""){
				$("#email_check").text("邮箱不能为空")
				state = 1;
			}
			if($("input[name=mobile]").val()==""){
				$("#mobile_check").text("手机号码不能为空")
				state = 1;
			}
			if($("input[name=QQ]").val()==""){
				$("#QQ_check").text("QQ号码不能为空")
				state = 1;
			}
			if($("input[name=invitationdateStr]").val()=="请选择面试时间"){
				$("#invitationdateStr_check").text("面试时间不能为空")
				state = 1;
			}
			var customerSelect = $("#customer :selected");
			if(customerSelect.val()==""){
				$("#customer_check").text("客户不能为空")
				state = 1;
			}
			if(state == 1){
				return false;
			}
			var mobile = $("input[name=mobile]").val()+"&";
			var qq = $("input[name=qq]").val();
			$("input[name=jianliName]").val(xingming+email+mobile+qq)
		    document.forms[0].action="<%=path%>/mianshiYaoQingController/toAddInterviewInvitation.go?pId=${jl.pId}";
			document.forms[0].submit();
		}
	  }

});
<%--日期框架--%>

var interviewdateStr = {
    elem: '#interviewdateStr',
    format: 'YYYY-MM-DD',
    min: laydate.now(), //设定最小日期为当前日期
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var invitationdateStr = {
    elem: '#invitationdateStr',
    format: 'YYYY-MM-DD hh:mm:ss',
    min: laydate.now(),
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(interviewdateStr);
laydate(invitationdateStr);
<%--日期框架--%>
</script>
</html>