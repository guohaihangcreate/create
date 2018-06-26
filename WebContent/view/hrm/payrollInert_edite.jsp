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
	</head>
	<body id="divtest">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<!--右键代码开始-->
				<div class="contextMenu" id="myMenu1" style="background-color: ">
					<ul>
						<!--图片地址为右键时，显示在菜单左边的小图标-->
						<c:if test="${type eq null}">
							<li id="savePayRollInfo">
								&nbsp;&nbsp;&nbsp;&nbsp;新增
							</li>
						</c:if>
						<c:if test="${type eq 1}">
							<li id="updatePayRoll">
								&nbsp;&nbsp;&nbsp;&nbsp;更新
							</li>
						</c:if>
						<li id="return_back">
							&nbsp;&nbsp;&nbsp;&nbsp;返回
						</li>
					</ul>
				</div>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form0" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
									</th>
								</TR>
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										员工姓名
									</th>
									<TD class="BGCgray" colspan="3">
										<input name="username_view" value="${payroll.user.username}"
											id="username_view" readonly="readonly">
										&nbsp;&nbsp;
										<a href="javascript:void(0)" class="easyui-linkbutton"
											iconCls="icon-search" plain="true"
											onclick="$('#myWindow_2').window('open');"><font
											color="bule">请选择</font> </a>
										<input id="userid" name="userid" value="${payroll.userid}" type="hidden">
									</TD>
								</TR>
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										转正工资
									</th>
									<TD  class="BGCgray" width="40%">
										<input name="wage" value="${payroll.wage}" style="width: 400px;">
									</TD>
									<th align="center" width="10%" nowrap="nowrap">
										试用期工资
									</th>
									<TD class="BGCgray" width="40%">
										<input name="periodwage"
											value="${payroll.periodwage}" style="width: 400px;">
									</TD>
								</TR>
								
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										入职日期
									</th>
									<TD class="BGCgray" width="40%">
										<input type="text" name="enterdate_str" class="laydate-icon" id="enterdate" value="<fmt:formatDate value="${payroll.enterdate}" pattern="yyyy-MM-dd" />"
										style="width: 400px;">
									</TD>
									<th align="center" width="10%" nowrap="nowrap">
										转正日期
									</th>
									<TD class="BGCgray" width="40%">
										<input type="text" name="zzdate_str" class="laydate-icon" id="zzdate" value="<fmt:formatDate value="${payroll.zzdate}" pattern="yyyy-MM-dd" />"
										style="width: 400px;">
									</TD>
								</TR>
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
										<input name="id" value="${payroll.id}"
											id="id" readonly="readonly" type="hidden">
									</th>
								</TR>
							</table>
						</form>
						<div id="myWindow_2" class="easyui-window" title="人员选择"
							data-options="modal:true,closed:true,iconCls:'icon-save'"
							style="width: 65%; height: 60%; padding: 0px;">
							<iframe name="authIframe" id="authIframe"
								src="<%=path%>/userController/select_userData.go?type=select_payrollUser"
								width="100%" height="150%" scrolling="no"></iframe>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'savePayRollInfo': function(t) {
			var state = 0;
			 jQuery.ajax({
		        type : 'GET',
		        contentType : 'text/json;charset=utf-8',
		        url : '<%=path%>/payrollController/validate_payroll.go',
		        data : {
		               userid : encodeURI($("#userid").val())
		           },
		        dataType : 'json',
		        success : function(data) {
		        	if(data.message==1){
		        		state = 1;
		        		alert("系统中已经存在该员工薪资信息");
		        	}else{
						document.form0.action="<%=path%>/payrollController/insertPayrollInfro.go";
						document.form0.submit();
					}
		        },
		        error : function() {
		        	alert("请求错误");
		        }
		      });
		},
		'updatePayRoll': function(t) {
			//修改
		    document.form0.action="<%=path%>/payrollController/updatePayrollInfro.go";
			document.form0.submit();
		},
		'return_back': function(t) {
			//执行事件
		    window.history.go(-1);
		}
	  }

});



<%--日期框架--%>

var enterdate = {
    elem: '#enterdate',
    format: 'YYYY-MM-DD',
    max: '2099-06-16', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var zzdate = {
    elem: '#zzdate',
    format: 'YYYY-MM-DD',
    max: '2099-06-16',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(enterdate);
laydate(zzdate);
<%--日期框架--%>

</script>
	</body>
</html>