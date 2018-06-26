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
	function toEditeinfo(pId){
		document.forms[0].action="<%=path%>/customerBankInfroController/toEditeCustomerBankInfro.go?type=1&bankid="+pId;
		document.forms[0].submit();
	}
	
	function todeletInfo(pId){
		document.forms[0].action="<%=path%>/customerBankInfroController/editeOrInsertCustomerBankInfro.go?type=2&id="+pId;
		document.forms[0].submit();
	}
	
</script>
	</head>
	<body id="divtest">
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<!--右键代码开始-->
					<div class="contextMenu" id="myMenu1" style="background-color: ">
						<ul>
							<!--图片地址为右键时，显示在菜单左边的小图标-->
							<li id="addCustomerBank">
								&nbsp;&nbsp;&nbsp;&nbsp;增加开票信息
							</li>
						</ul>
					</div>
					<!--右键代码结束-->
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th align="center">
										序号
									</th>
									<th align="center">
										发票抬头
									</th>
									<th align="center">
										税号
									</th>
									<th align="center">
										开户行名称
									</th>
									<th align="center">
										开户行账户
									</th>
									<th width="200" align="center">
										地址、电话
									</th>
									<th width="200" align="center">
										备注
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${customerBankInfroList}"
									var="customerBankInfro">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											${customerBankInfro.att2}
										</TD>
										<TD align="center">
											${customerBankInfro.att3}
										</TD>
										<TD align="center">
											${customerBankInfro.bankname}
										</TD>
										<TD align="center">
											${customerBankInfro.customerbank}
										</TD>
										<TD align="center">
											${customerBankInfro.att4}
										</TD>
										<TD align="center">
											${customerBankInfro.beizhu}
										</TD>
										<TD width="200" align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toEditeinfo('${customerBankInfro.id}');">
												修改
											</BUTTON>
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="todeletInfo('${customerBankInfro.id}');">
												删除
											</BUTTON>
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
		'addCustomerBank': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/view/crm/customerBankInfoInsert_edite.jsp?customerId="+${customerid};
			document.forms[0].submit();
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