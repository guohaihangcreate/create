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
	function toEditeInfo(Id){
		document.forms[0].action="<%=path%>/payrollController/toEditePayrollInfro.go?id="+Id;
		document.forms[0].submit();
	}
	
	function todeletInfo(Id){
		document.forms[0].action="<%=path%>/payrollController/deletePayrollInfro.go?id="+Id;
		document.forms[0].submit();
	}
	
   
   function download(){
		document.forms[0].action="<%=path%>/template/template_customer.xls";
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
				<li id="insertData">
					&nbsp;&nbsp;&nbsp;&nbsp;新增数据
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data"
			name="form0">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="20%" align="center">
									员工姓名
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="username" style="width: 200px;">
								</td>
								<th width="20%" align="center">
									员工状态
								</th>
								<td width="30%" class="BGCgray">
									<select name="status">
										<option value="0" selected="selected">正式员工</option>
										<option value="2">正式员工</option>
									</select>
								</td>
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
										序号
									</th>
									<th align="center">
										员工姓名
									</th>
									<th align="center">
										转正工资
									</th>
									<th align="center">
										试用期工资
									</th>
									<th width="200" align="center">
										入职日期
									</th>
									<th width="200" align="center">
										转正日期
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${payrollList}" var="payroll"
									varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)" id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox2" id="checkbox2" onselect="mouseOver(this)">
										</TD>
										<TD align="center" nowrap="nowrap" >
											${payroll.user.username}
										</TD>
										<TD align="center" nowrap="nowrap"  title="${customerInfo.needproducts}">
											${payroll.wage}
										</TD>
										<TD align="center" nowrap="nowrap" >
											${payroll.periodwage}
										</TD>
										<TD align="center" nowrap="nowrap">
											<fmt:formatDate value="${payroll.enterdate}" pattern="yyyy-MM-dd" />
										</TD>
										<TD align="center" nowrap="nowrap">
											<fmt:formatDate value="${payroll.zzdate}" pattern="yyyy-MM-dd" />
										</TD>
										<TD width="200" align="center" nowrap="nowrap">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toEditeInfo('${payroll.id}');">
												修改
											</BUTTON>
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="todeletInfo('${payroll.id}');">
												删除
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
											value="/payrollController/queryPayrollInfro.go" />
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
		'query': function(t) {
			//执行事件
			document.form0.action="<%=path%>/payrollController/queryPayrollInfro.go";
			document.form0.submit();
		},
		'refresh': function(t) {
			//执行事件
		  window.location.reload();
		},
		'download': function(t) {
			//执行事件
		  document.forms[0].action="<%=path%>/template/template_customer.xls";
		  document.forms[0].submit();
		},
		'importData': function(t) {
			//执行事件
		  window.location.href="<%=path%>/view/crm/importCustomerData.jsp";
		},
		'insertData': function(t) {
			//执行事件
		  window.location.href="<%=path%>/view/hrm/payrollInert_edite.jsp";
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