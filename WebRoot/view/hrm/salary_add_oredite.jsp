<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>薪酬详细修改页面</title>
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
	</head>
	<body id="divtest">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<!--右键代码开始-->
				<div class="contextMenu" id="myMenu1" style="background-color: ">
					<ul>
						<!--图片地址为右键时，显示在菜单左边的小图标-->
						<li id="edteSalary">
							&nbsp;&nbsp;&nbsp;&nbsp;修改数据
						</li>
						<li id="return_back">
							&nbsp;&nbsp;&nbsp;&nbsp;返回
						</li>
						<li id="refresh">
							&nbsp;&nbsp;&nbsp;&nbsp;刷新
						</li>
					</ul>
				</div>
				<!--右键代码结束-->
				<td valign="top" width="100%">
					<div style="overflow: auto; width: 100%">
						<form name="form0" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR>
									<th colspan="6" style="text-align: left; color: black;">
										${salaryDetail.staffname}&nbsp;${salaryDetail.yl1}年${salaryDetail.yl2}月&nbsp;薪酬福利详细修改
									</th>
								</TR>
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										员工名称
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="staffname" style="width: 100%"
											value="${salaryDetail.staffname}">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										职务
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="position" style="width: 100%"
											value="${salaryDetail.position}">
									</TD>
								</TR>
								<tr>
									<th align="center" width="10%"   nowrap="nowrap">
										招聘人事
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="hr_Str" style="width: 100%" 
											value="${salaryDetail.hr_Str}" readonly="readonly">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										岗位
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="yl3" style="width: 100%"
											value="${salaryDetail.yl3}">
									</TD>
								</tr>
								<TR>
									<th width="10%" align="center"   nowrap="nowrap">
										身份证号码
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="idno" style="width: 100%"
											value="${salaryDetail.idno}">
									</TD>
									<th align="center" width="10%"   nowrap="nowrap">
										入职日期
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input type="text" id="entrydateStr" name="entrydateStr" class="laydate-icon"
										id="entrydate" style="width: 120px;"  value="<fmt:formatDate value="${salaryDetail.entrydate}" pattern="yyyy-MM-dd HH：mm：ss" />">
										
									</TD>
								</TR>
								<TR>
									<th width="10%" align="center"   nowrap="nowrap">
										转正后金额
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="fullsalary" style="width: 100%"
											value="${salaryDetail.fullsalary}">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										发全额薪水日期
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="fullsalarydate" style="width: 100%"
											value="${salaryDetail.fullsalarydate}">
									</TD>
								</TR>
								<tr>
									<th align="center" width="10%"   nowrap="nowrap">
										当月应发工资金额
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="paymentwage" style="width: 100%"
											value="${salaryDetail.paymentwage}">
									</TD>
									<th width="10%" align="center">
										上保险时间及状态
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="insurancestatus" style="width: 100%"
											value="${salaryDetail.insurancestatus}">
									</TD>
								</tr>
								<TR   nowrap="nowrap">
									<th width="10%" align="center"   nowrap="nowrap">
										电脑押金情况
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="pcdeposit" style="width: 100%"
											value="${salaryDetail.pcdeposit}">
									</TD>
									<th align="center" width="10%"   nowrap="nowrap">
										各项目计薪天数
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="payday" style="width: 100%"
											value="${salaryDetail.payday}">
									</TD>
								</TR>
								<tr>
									<th width="10%" align="center"   nowrap="nowrap">
										计薪天数
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="actualpayday" style="width: 100%"
											value="${salaryDetail.actualpayday}">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										加班费、补贴、扣款
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="subsidydebit" style="width: 100%"
											value="${salaryDetail.subsidydebit}">
									</TD>
								</tr>
								<TR>
									<th align="center" width="10%"   nowrap="nowrap">
										补贴说明
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<textarea rows="10" cols="80" name="subsidydebitexplain">
											${salaryDetail.subsidydebitexplain}
										</textarea>
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										报销费用
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="reimbursement" style="width: 100%"
											value="${salaryDetail.reimbursement}">
									</TD>
								</TR>
								<TR>
									<th width="10%" align="center"   nowrap="nowrap">
										 代扣社保
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="socialsecurity" style="width: 100%"
											value="${salaryDetail.socialsecurity}">
									</TD>
									<th align="center" width="10%"   nowrap="nowrap">
										代扣公积金
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="accumulationfund" style="width: 100%"
											value="${salaryDetail.accumulationfund}">
									</TD>
								</TR>
								<TR>
									<th width="10%" align="center"   nowrap="nowrap">
										考勤应发工资（考勤工资+调整补贴）
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="wages" style="width: 100%"
											value="${salaryDetail.wages}">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										应发-报销款（抵税报销）
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="actualwages" style="width: 100%"
											value="${salaryDetail.actualwages}">
									</TD>
								</TR>
								<tr>
									<th align="center" width="10%"   nowrap="nowrap">
										计算个税金额（减去社保和公积金）
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="selftax" style="width: 100%"
											value="${salaryDetail.selftax}">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										个人所得税
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="incometax" style="width: 100%"
											value="${salaryDetail.incometax}">
									</TD>
								</tr>
								<TR>
									<th width="10%" align="center"   nowrap="nowrap">
										实发工资
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="shifagongzi" style="width: 100%"
											value="${salaryDetail.shifagongzi}">
									</TD>
									<th align="center" width="10%"   nowrap="nowrap">
										已发
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="yifa" style="width: 100%"
											value="${salaryDetail.yifa}">
									</TD>
								</TR>
								<TR>
									<th width="10%" align="center"   nowrap="nowrap">
										补发
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="bufa" style="width: 100%"
											value="${salaryDetail.bufa}">
									</TD>
									<th width="10%" align="center"   nowrap="nowrap">
										账号
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="zhanghu" style="width: 100%"
											value="${salaryDetail.zhanghu}">
									</TD>
								</TR>
								<tr>
									<th align="center" width="10%"   nowrap="nowrap">
										开户行名称
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<input name="kaihuhangname" style="width: 100%"
											value="${salaryDetail.kaihuhangname}">
									</TD>
									<th align="center" width="10%"   nowrap="nowrap">
										工资条发放状态
									</th>
									<TD class="BGCgray" width="40%"   nowrap="nowrap">
										<c:if test="${salaryDetail.yl4 eq 1}">工资条已发</c:if>
										<c:if test="${salaryDetail.yl4 ne 1}">工资条未发</c:if>
										<input name="id" type="hidden" style="width: 100%"
											value="${salaryDetail.id}">
									</TD>
								</tr>
								<TR>
									<th colspan="6" style="text-align: left; color: black;">
									</th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
		</body>
		<script type="text/javascript">
		//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'edteSalary': function(t) {
			//执行事件
		    document.form0.action="<%=path%>/SalaryDetailController/editeSalaryData.go";
			document.form0.submit();
		},
		'return_back': function(t) {
			//执行事件
			 window.history.go(-1);
		},
		'refresh': function(t) {
			//执行事件
		  window.location.reload();
		}
	  }

});

<%--日期框架--%>

var entrydate = {
    elem: '#entrydate',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
laydate(entrydate);
<%--日期框架--%>


<%--日期框架--%>
var birthday = {
    elem: '#brithday',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
laydate(birthday);	
</script>
		<script type="text/javascript">
		var Gid  = document.getElementById("");
		var showArea = function(){
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
			Gid('s_city').value + " - 县/区" + 
			Gid('s_county').value + "</h3>"
									}
		Gid('s_county').setAttribute('onchange','showArea()');
		
		
</script>
</html>