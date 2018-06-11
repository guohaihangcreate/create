<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>当日统计报表</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>

		<script type="text/javascript">
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="query">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="imageReport">
					&nbsp;&nbsp;&nbsp;&nbsp;图形报表
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									邀约日期
								</th>
								<td width="25%" class="BGCgray">
									<input type="text" name="query_interviewDate_start"
										class="laydate-icon" id="query_interviewDate_start"
										value="${interviewReportModel.query_interviewDate_start}"
										style="width: 100px;">
									&nbsp;至&nbsp;
									<input type="text" class="laydate-icon"
										name="query_interviewDate_end" id="query_interviewDate_end"
										value="${interviewReportModel.query_interviewDate_end}"
										style="width: 100px;">
								</td>
								<th width="10%" align="center">
									<STRONG>面试时间</STRONG>
								</th>
								<td width="25%" class="BGCgray">
									<input type="text" name="query_invitationDate_start"
										class="laydate-icon" id="query_invitationDate_start"
										style="width: 120px;"
										value="${interviewReportModel.query_invitationDate_start}">
									&nbsp;至&nbsp;
									<input type="text" class="laydate-icon"
										name="query_invitationDate_end" id="query_invitationDate_end"
										style="width: 120px;"
										value="${interviewReportModel.query_invitationDate_end}">
								</td>
							</TR>
							<TR>
								<th width="8%" align="center">
									招聘人
								</th>
								<td width="10%" class="BGCgray">
									<select name="userID">
										<option value="">
											请选择
										</option>
										<c:forEach items="${users}" var="user">
											<option value="${user.id}">
												${user.username}
											</option>
										</c:forEach>
									</select>
								</td>
								<th width="8%" align="center" colspan="2">

								</th>
							</TR>
						</table>
					</td>
				</tr>
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th align="center" nowrap="nowrap">
										邀请日期
									</th>
									<th align="center" nowrap="nowrap">
										候选人姓名
									</th>
									<th align="center" nowrap="nowrap">
										联系方式
									</th>
									<th align="center" nowrap="nowrap">
										面试时间
									</th>
									<th align="center" nowrap="nowrap">
										职位
									</th>
									<th align="center" nowrap="nowrap">
										工作年限
									</th>
									<th align="center" nowrap="nowrap">
										项目
									</th>
									<th align="center" nowrap="nowrap">
										沟通结果(薪资福利待遇等)
									</th>
									<th align="center" nowrap="nowrap">
										招聘人
									</th>
								</TR>
								<c:forEach items="${reportDate}" var="reportdate"
									varStatus="status">
									<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											${reportdate.interviewDate}
										</TD>
										<TD align="center" nowrap="nowrap">
											${reportdate.hxzName}
										</TD>
										<TD align="center" nowrap="nowrap">
											${reportdate.mobel_phone}
										</TD>
										<TD align="center" nowrap="nowrap">
											${reportdate.invitationDate}
										</TD>
										<TD align="center" nowrap="nowrap">
											<c:if test="${reportdate.jishu_lx eq 0}">java</c:if>
											<c:if test="${reportdate.jishu_lx eq 1}">.net</c:if>
											<c:if test="${reportdate.jishu_lx eq 2}">ios</c:if>
											<c:if test="${reportdate.jishu_lx eq 3}">安卓</c:if>
											<c:if test="${reportdate.jishu_lx eq 4}">php</c:if>
											<c:if test="${reportdate.jishu_lx eq 5}">其他</c:if>
										</TD>
										<TD align="center" nowrap="nowrap">
											<c:if test="${reportdate.gznx eq 0}">暂无工作经验</c:if>
											<c:if test="${reportdate.gznx eq 1}">培训无实际工作经验</c:if>
											<c:if test="${reportdate.gznx eq 2}">一年以下</c:if>
											<c:if test="${reportdate.gznx eq 3}">1-2年工作经验</c:if>
											<c:if test="${reportdate.gznx eq 4}">2-3年工作经验</c:if>
											<c:if test="${reportdate.gznx eq 5}">3-5年工作经验</c:if>
											<c:if test="${reportdate.gznx eq 6}">6年以上</c:if>
										</TD>
										<TD align="center" nowrap="nowrap">
											${reportdate.customername}
										</TD>
										<TD align="center" style="width: 300px;">
											${reportdate.gtbz}
										</TD>
										<TD align="center" nowrap="nowrap">
											${reportdate.zpren}
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
		'query': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/mianshiReportController/todayInterviewReport.go";
			document.forms[0].submit();
		},
		'imageReport': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/mianshiReportController/reportSeries.go";
			document.forms[0].submit();
		}
	  }

});


<%--日期框架--%>

var query_interviewDate_start = {
    elem: '#query_interviewDate_start',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var query_interviewDate_end = {
    elem: '#query_interviewDate_end',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(query_interviewDate_start);
laydate(query_interviewDate_end);

var query_invitationDate_start = {
    elem: '#query_invitationDate_start',
    format: 'YYYY-MM-DD hh:mm:ss',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var query_invitationDate_end = {
    elem: '#query_invitationDate_end',
    format: 'YYYY-MM-DD hh:mm:ss',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(query_invitationDate_start);
laydate(query_invitationDate_end);
<%--日期框架--%>

</script>
	</body>
</html>