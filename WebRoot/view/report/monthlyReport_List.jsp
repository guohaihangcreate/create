<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>考勤月度统计</title>
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
			window.onload=function(){ 
				//设置年份的选择 
				var myDate= new Date(); 
				var startYear=myDate.getFullYear()-50;//起始年份 
				var endYear=myDate.getFullYear()+50;//结束年份 
				var obj=document.getElementById('myYear') 
				for (var i=startYear;i<=endYear;i++) 
				{ 
				  obj.options.add(new Option(i,i)); 
				} 
				obj.options[obj.options.length-51].selected=1; 
				//设置月份的选择
				var obj_month=document.getElementById('myMonth') 
				var nowmonth = myDate.getMonth();
				for (var i=0;i<=11;i++) 
				{ 
				  obj_month.options.add(new Option(i,i-1)); 
				} 
				obj_month.options[nowmonth-1].selected=1;
			} 
			
			function sendSalaryEmail(sid){
	  			var columnSelect = "";  
				$('input[name="columnSelect"]:checked').each(function(){    
	   				columnSelect = columnSelect + $(this).val()+";";
	  			});
				//执行事件
				document.form0.action="<%=path%>/SalaryDetailController/wageStripEmail.go?sId="+sid+"&sentAll=2&selectcolum="+columnSelect;
				document.form0.submit();
			}
			
			function toEdite(sid){
	  			var columnSelect = "";  
				$('input[name="columnSelect"]:checked').each(function(){    
	   				columnSelect = columnSelect + $(this).val()+";";
	  			});
				document.form0.action="<%=path%>/SalaryDetailController/toEditeSalary.go?type=0&sId="+sid+"&sentAll=2&selectcolum="+columnSelect;
				document.form0.submit();
			}
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="selectData">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
			</ul>
		</div>

		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th  align="left">
									姓名&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<td>
									<input type="text" name="userName" id="userName">
								</td>
								<th  align="left">
									部门&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<td colspan="2">
									<input type="text" name="departName" id="departName" value="${departName}">
								</td>
								<th  align="left">
									日期&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<td colspan="2">
									<input type="text" name="attendancDate" class="laydate-icon"
										id="attendancDate" style="width: 120px;"  value="${attendancDate}">
								</td>
								<th  align="left">
									仅查询异常&nbsp;&nbsp;&nbsp;&nbsp;
								</th>
								<td colspan="2">
									<input  type="radio" value="1" name="abnormal">是
									<input  type="radio" value="0" name="abnormal" checked="checked">否
								</td>
								<td colspan="2">
									<select name="status" id="status">
										<option value="0" selected="selected">在职人员</option>
										<option value="2">已离职人员</option>
										<option>全部</option>
									</select>
								</td>
							</TR>
						</table>
					</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<form action="" method="post" name="form0" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
									<tr>
										<th  align="center" nowrap="nowrap">
											序号<input type="checkbox" name="checkbox1"  value="" id="all"/>
										</th>
										<th  align="center" nowrap="nowrap">
											姓名
										</th>
										<th  align="center" nowrap="nowrap">
											部门
										</th>
										<th  align="center" nowrap="nowrap">
											职位
										</th>
										<th  align="center" nowrap="nowrap">
											日期
										</th>
										<th  align="center" nowrap="nowrap">
											班次
										</th>
										<th  align="center" nowrap="nowrap" colspan="2">
											上班打卡
										</th>
										<th  align="center" nowrap="nowrap" colspan="2">
											下班打卡
										</th>
									</tr>
									<c:forEach items="${reportMonthList}" var="reportMonth" varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)" 
										id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox1" title="${salaryDetail.id}"
												value="${salaryDetail.id}" onselect="mouseOver(this)"> 
										</TD>
										<TD align="center"  nowrap="nowrap">
											${reportMonth.userName}
										</TD>
										<TD align="center"  nowrap="nowrap">
											${reportMonth.departName}
										</TD>
										<TD align="center"  nowrap="nowrap">
											${reportMonth.jobName}
										</TD>
										<TD align="center"  nowrap="nowrap">
											<c:if test="${reportMonth.workDate ne null}">${reportMonth.workDate}</c:if>
											<c:if test="${reportMonth.workDate eq null}">${attendancDate}&nbsp;${attendancDateWeek}</c:if>
											
										</TD>
										<TD align="center"  nowrap="nowrap">
											<c:if test="${reportMonth.classname eq null}">暂未分配考勤组</c:if>
											<c:if test="${reportMonth.classname ne null}">${reportMonth.classname}</c:if>
											&nbsp;&nbsp;
											<c:if test="${reportMonth.checkBeginTime eq null}">未设置上班时间</c:if>
											<c:if test="${reportMonth.checkBeginTime ne null}">${reportMonth.checkBeginTime}</c:if>
											-
											<c:if test="${reportMonth.checkEndTime eq null}">未设置下班时间</c:if>
											<c:if test="${reportMonth.checkEndTime ne null}">${reportMonth.checkEndTime}</c:if>
										</TD>
										<TD align="center"  nowrap="nowrap">
											<a href="<%=path%>/attendanceRercordAllController/attendanceRecordDetail.go?userid=${reportMonth.useriD}&workDate=${attendancDate}"><font color="blue">${reportMonth.mixUserCheckTime}</font></a>
										</TD>
										<TD align="center"  nowrap="nowrap" <c:if test="${reportMonth.timeResultBegin eq '异常'}">bgcolor="red"</c:if>>
											${reportMonth.timeResultBegin} 
										</TD>
										<TD align="center"  nowrap="nowrap">
											${reportMonth.maxuserCheckTime}
										</TD>
										<TD align="center"  nowrap="nowrap" <c:if test="${reportMonth.timeResultEnd eq '异常'}">bgcolor="red"</c:if>>
											${reportMonth.timeResultEnd} 
										</TD>
									</TR>
								</c:forEach>
									<TR>
										<th align="center" colspan="10"/></th>
									</TR>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<jsp:include page="/page/page.jsp">
											<jsp:param name="url"
												value="/attendanceReportController/attendanceMonthlyReport.go?1=1&attendancDate=${attendancDate}&departName=${departName}"/>
										</jsp:include>
									</table>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>


<script>
function xxx(){
	alert(123456);
}

var attendancDate = {
    elem: '#attendancDate',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
laydate(attendancDate);



//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'selectData': function(t) {	 departName
			var attendancDate = $("#attendancDate").val();
			var userName = $("#userName").val();
			var departName = $("#departName").val();
			var abnormal = $("input[name='abnormal']:checked").val();
			var status = $("#status").find("option:selected").val();
			document.form0.action="<%=path%>/attendanceReportController/attendanceMonthlyReport.go?attendancDate="+attendancDate+"&abnormal="+abnormal+"&userName="+userName+"&departName="+departName+"&status="+status;
			document.form0.submit();
		}
	  }

});

</script>
	</body>
</html>