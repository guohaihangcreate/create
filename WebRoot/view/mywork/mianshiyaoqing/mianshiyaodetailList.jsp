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
	function InterViewinVitation(dateid){
		alert(dateid);
		document.forms[0].action="<%=path%>/systemRightController/toProcessRoleInfoPage.go?opt_type=2&jlID="+dateid;
		document.forms[0].submit();
	}
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<%--				<li id="add">--%>
				<%--					&nbsp;&nbsp;&nbsp;&nbsp;新增邀请--%>
				<%--				</li>--%>
				<%--				<li id="refresh">--%>
				<%--					&nbsp;&nbsp;&nbsp;&nbsp;刷新--%>
				<%--				</li>--%>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<th align="center" colspan="7">
						<label style="color: red;">
							邀请详细
						</label>
					</th>
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
									<th align="center">
										邀请日期
									</th>
									<th align="center">
										面试时间
									</th>
									<th width="200" align="center">
										最后沟通状态
									</th>
									<th align="center">
										沟通备注
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
											${Interview.state}
										</TD>
										<TD align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="InterViewinVitation('${jl.pId}');">
												补充面试结果
											</BUTTON>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
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
		'add': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/mianshiYaoQingController/toAddInterviewInvitation.go";
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
    format: 'YYYY/MM/DD',
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
    format: 'YYYY/MM/DD',
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