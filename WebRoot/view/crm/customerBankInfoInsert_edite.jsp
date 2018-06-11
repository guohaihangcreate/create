<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
	</head>
	<body id="divtest">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<!--右键代码开始-->
				<div class="contextMenu" id="myMenu1" style="background-color: ">
					<ul>
						<!--图片地址为右键时，显示在菜单左边的小图标-->
						<c:if test="${type eq null}">
							<li id="saveBankInfo">
								&nbsp;&nbsp;&nbsp;&nbsp;新增开票信息
							</li>
						</c:if>
						<c:if test="${type eq 1}">
							<li id="updateCustomerBank">
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
										发票抬头及开户行信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										发票抬头
									</th>
									<TD class="BGCgray" width="40%">
										<input name="att2" value="${customerBankInfro.att2}" style="width: 400px;">
									</TD>
									<th align="center" width="10%" nowrap="nowrap">
										纳税人识别号
									</th>
									<TD class="BGCgray" width="40%">
										<input name="att3"
											value="${customerBankInfro.att3}" style="width: 400px;">
									</TD>
								</TR>
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										地址、电话：
									</th>
									<TD  class="BGCgray" colspan="3">
										<input name="att4" value="${customerBankInfro.att4}" style="width: 400px;">
									</TD>
								</TR>
								
								<TR>
									<th width="10%" align="center" nowrap="nowrap">
										开户银行名称
									</th>
									<TD class="BGCgray" width="40%">
										<input name="bankname" value="${customerBankInfro.bankname}" style="width: 400px;">
									</TD>
									<th align="center" width="10%" nowrap="nowrap">
										开户银行账户
									</th>
									<TD class="BGCgray" width="40%">
										<input name="customerbank"
											value="${customerBankInfro.customerbank}" style="width: 400px;">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%" nowrap="nowrap">
										备注
									</th>
									<TD  class="BGCgray" colspan="3">
										<textarea rows="5" cols="160" name="beizhu">
											<c:if test="${type eq 1}">${customerBankInfro.beizhu}</c:if>
										</textarea>
										<c:if test="${type eq null}">
											<input value="<%=request.getParameter("customerId")%>"
												name="customerid" type="hidden">
										</c:if>
										<c:if test="${type eq 1}">
<%--										type=1是修改操作--%>
											<input value="${customerBankInfro.customerid}"
												name="customerid" type="hidden">
											<input value="${customerBankInfro.id}"
												name="id" type="hidden">
										</c:if>
									</TD>
								</TR>
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
									</th>
								</TR>
							</table>
						</form>
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
		'saveBankInfo': function(t) {
			//新增
		    document.form0.action="<%=path%>/customerBankInfroController/editeOrInsertCustomerBankInfro.go?type=0";
			document.form0.submit();
		},
		'updateCustomerBank': function(t) {
			//修改
		    document.form0.action="<%=path%>/customerBankInfroController/editeOrInsertCustomerBankInfro.go?type=1";
			document.form0.submit();
		},
		'return_back': function(t) {
			//执行事件
		    window.history.go(-1);
		}
	  }

});
</script>
	</body>
</html>