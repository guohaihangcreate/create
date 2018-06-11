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
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="selectdata">
					&nbsp;&nbsp;&nbsp;&nbsp;选择数据
				</li>
				<li id="select">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
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
									公司名称
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="companyname" style="width: 200px;">
								</td>
								<th width="20%" align="center">
									公司编码
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="companymark" style="width: 200px;">
								</td>
							</TR>
							<tr>
								<th width="20%" align="center">
									业务范围
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="businessscope" style="width: 200px;">
								</td>
								<th width="20%" align="center">
									注册地址
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="registeredaddress"
										style="width: 200px;">
								</td>
							</tr>
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
										序号
									</th>
									<th align="center" nowrap="nowrap">
										公司名称
									</th>
									<th align="center" nowrap="nowrap">
										注册地址
									</th>
									<th width="200" align="center" nowrap="nowrap">
										业务范围
									</th>
								</TR>
								<c:forEach items="${companyList}" var="company"
									varStatus="status">
									<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											<%--											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;--%>
											<input type="checkbox" name="checkbox2" id="checkbox2"
												value="${company.companyid}" title="${company.companyname}">
										</TD>
										<TD align="center" nowrap="nowrap">
											${company.companyname}
										</TD>
										<TD align="center" nowrap="nowrap">
											${company.companymark}
										</TD>
										<TD align="center" nowrap="nowrap">
											${contactInfro.registeredaddress}
										</TD>
										<TD align="center" nowrap="nowrap">
											${contactInfro.businessscope}
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/companyController/showCompanys.go" />
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
		'selectdata': function(t) {
			//执行事件
		   			var values="";
					var title = "";
					if($('input[name="checkbox2"]:checked').length==1){
			   			window.parent.document.getElementById("deptName").value =$('input[name="checkbox2"]:checked')[0].title;
				   		window.parent.document.getElementById("dept_name").innerHTML =$('input[name="checkbox2"]:checked')[0].title;
				   		window.parent.document.getElementById("deptId").value=$('input[name="checkbox2"]:checked')[0].value;
						parent.$('#myWindow').window('close');
					}
					else{
						alert("本次操作是单选");
						return false;
					}
		},
		'select': function(t) {
			//执行事件
		   	document.form0.action="<%=path%>/companyController/showCompanys.go";
			document.form0.submit();
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