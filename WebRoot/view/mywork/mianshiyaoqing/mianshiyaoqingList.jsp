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
	
	function toSeeinfo(pId){
		document.forms[0].action="<%=path%>/mianshiYaoQingController/toAddYaoQing.go?pId="+pId;
		document.forms[0].submit();
	}
	
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
				<li id="refresh">
					&nbsp;&nbsp;&nbsp;&nbsp;刷新
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
									<input type="text" name="start" class="laydate-icon" id="start" value="${start}"
										style="width: 100px;">
									&nbsp;至&nbsp;
									<input type="text" class="laydate-icon" name="end" id="end"  value="${end}"
										style="width: 100px;">
								</td>
								<th width="10%" align="center">
									<STRONG>面试时间</STRONG>
								</th>
								<td width="25%" class="BGCgray">
									<input type="text" name="msstart" class="laydate-icon"
										id="msstart" style="width: 120px;"  value="${msstart}">
									&nbsp;至&nbsp;
									<input type="text" class="laydate-icon" name="msend" id="msend"
										style="width: 120px;"   value="${msend}">
								</td>
							</TR>
							<TR>
								<th width="8%" align="center">
									岗位
								</th>
								<td width="10%" class="BGCgray">
									<select name="jishuLx" id="jishuLx">
											<option value="">
												请选择
											</option>
											<option value="0">
												java软件工程师
											</option>
											<option value="1">
												.net软件工程师
											</option>
											<option value="2">
												ios软件工程师
											</option>
											<option value="3">
												安卓软件工程师
											</option>
											<option value="4">
												web前端软件工程师
											</option>
											<option value="5">
												php软件工程师
											</option>
											<option value="6">
												其他
											</option>
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
									<th align="center">
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center" nowrap="nowrap">
										候选人姓名
									</th>
									<th align="center" nowrap="nowrap">
										推荐岗位
									</th>
									<th  align="center" nowrap="nowrap">
										工作经验
									</th>
									<th  align="center" nowrap="nowrap">
										操作
									</th>
								</TR>
								<c:forEach items="${jianliS}" var="jianli" varStatus="status">
									<TR class="BGCgray">
										<TD align="center">
											${status.index + 1}&nbsp;&nbsp;<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											${jianli.name}
										</TD>
										<TD align="center">
											<c:if test="${jianli.jishuLx eq 0}">java软件工程师</c:if>
											<c:if test="${jianli.jishuLx eq 1}">.net软件工程师</c:if>
											<c:if test="${jianli.jishuLx eq 2}">ios软件工程师</c:if>
											<c:if test="${jianli.jishuLx eq 3}">安卓软件工程师</c:if>
											<c:if test="${jianli.jishuLx eq 4}">web前端软件工程师</c:if>
											<c:if test="${jianli.jishuLx eq 5}">php软件工程师</c:if>
											<c:if test="${jl.jishuLx eq 6}">其他软件工程师</c:if>
										</TD>
										<TD align="center">
											<c:if test="${jianli.gznx eq 0}">暂无工作经验</c:if>
											<c:if test="${jianli.gznx eq 1}">一年以下</c:if>
											<c:if test="${jianli.gznx eq 2}">培训无实际工作经验</c:if>
											<c:if test="${jianli.gznx eq 3}">1-2年工作经验</c:if>
											<c:if test="${jianli.gznx eq 4}">2-3年工作经验</c:if>
											<c:if test="${jianli.gznx eq 5}">3-5年工作经验</c:if>
											<c:if test="${jianli.gznx eq 6}">6年以上</c:if>
										</TD>
										<TD width="200" align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toSeeinfo('${jianli.pId}');">
												查看详细
											</BUTTON>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/mianshiYaoQingController/toPageDateList.go" />
									</jsp:include>
								</table>
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
		'add': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/mianshiYaoQingController/toAddYaoQing.go";
			document.forms[0].submit();
		},
		'query': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/mianshiYaoQingController/toPageDateList.go";
			document.forms[0].submit();
		},
		'see': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
			document.forms[0].submit();
		},
		'edite': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
			document.forms[0].submit();
		},
		'refresh': function(t) {
			//执行事件
		  window.location.reload();
		}
	  }

});


<%--日期框架--%>

var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);

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
<%--日期框架--%>

</script>
	</body>
</html>