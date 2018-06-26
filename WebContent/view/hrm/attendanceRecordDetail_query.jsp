<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript">
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="returnBack">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data"
			name="form0">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th align="center" nowrap="nowrap">
										姓名
									</th>
									<th align="center" nowrap="nowrap">
										部门
									</th>
									<th align="center" nowrap="nowrap">
										职位
									</th>
									<th align="center" nowrap="nowrap">
										考勤日期
									</th>
									<th align="center" nowrap="nowrap">
										考勤时间
									</th>
									<th align="center" nowrap="nowrap">
										打卡时间
									</th>
									<th align="center" nowrap="nowrap">
										打卡结果
									</th>
									<th align="center" nowrap="nowrap">
										打卡地址
									</th>
								</TR>
								<c:forEach items="${AttendanceRercordAll_List}" var="AttendanceRercord"
									varStatus="status">
									<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											${AttendanceRercord.userName}
										</TD>
										<TD align="center" nowrap="nowrap">
											${AttendanceRercord.departName}
										</TD>
										<TD align="center" nowrap="nowrap">
											${AttendanceRercord.jobName}
										</TD>
										<TD align="center" >
											${AttendanceRercord.workdate}
										</TD>
										<TD align="center" >
											${AttendanceRercord.planchecktime}
										</TD>
										<TD align="center" >
											${AttendanceRercord.userchecktime}
										</TD>
										<TD align="center" >
											<c:if test="${AttendanceRercord.locationresult eq 'Normal'}">
												正常
											</c:if>
											<c:if test="${AttendanceRercord.locationresult eq 'Early'}">
												早退
											</c:if>
											<c:if test="${AttendanceRercord.locationresult eq 'Late'}">
												迟到
											</c:if>
											<c:if test="${AttendanceRercord.locationresult eq 'SeriousLate'}">
												严重迟到
											</c:if>
											<c:if test="${AttendanceRercord.locationresult eq 'Absenteeism'}">
												旷工迟到
											</c:if>
											<c:if test="${AttendanceRercord.locationresult eq 'NotSigned'}">
												未打卡
											</c:if>
										</TD>
										<TD align="center" >
											${AttendanceRercord.useraddress}
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="9" /></th>
								</TR>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<script>

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
	  	'returnBack': function(t) {	 
	  		window.history.go(-1);
		}
	  }
});

<%--日期框架--%>

var workday_begin = {
    elem: '#workday_begin',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var workday_end = {
    elem: '#workday_end',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(workday_begin);
laydate(workday_end);

var msstart = {
    elem: '#msstart',
    format: 'YYYY/MM/DD hh:mm:ss',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var msend = {
    elem: '#msend',
    format: 'YYYY/MM/DD hh:mm:ss',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(msstart);
laydate(msend);
</script>
	</body>
</html>