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
						<c:if test="${type eq 0}">
							<li id="saveContact">
								&nbsp;&nbsp;&nbsp;&nbsp;增加联系人
							</li>
						</c:if>
						<c:if test="${type eq 1}">
							<li id="editeContact">
								&nbsp;&nbsp;&nbsp;&nbsp;修改
							</li>
						</c:if>
						<li id="return_back">
							&nbsp;&nbsp;&nbsp;&nbsp;返回
						</li>
					</ul>
				</div>
				<!--右键代码结束-->
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form1" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
										联系人信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										姓名
									</th>
									<TD class="BGCgray" width="40%">
										<input name="contactsname"
											value="${contactInfro.contactsname}">
										<input name="id"  type="hidden" value="${contactInfro.id}">
									</TD>
									<th align="center" width="10%">
										性别
									</th>
									<TD width="80%" class="BGCgray" width="40%">
										男
										<input type="radio"
											<c:if test="${contactInfro.sex eq 0 or contactInfro.sex eq null}">checked="checked"</c:if>
											name="sex" value="0">
										&nbsp;女
										<input type="radio" name="sex" value="1"
											<c:if test="${contactInfro.sex eq 1 or contactInfro.sex eq null}">checked="checked"
										</c:if>>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										<span class="BGCgray">电话</span>
									</th>
									<TD class="BGCgray" width="40%">
										<input name="telephone" type="text"
											value="${contactInfro.telephone}" id="telephone">
									</TD>
									<th align="center" width="10%">
										手机号
									</th>
									<TD class="BGCgray" width="40%">
										<input name="phone" value="${contactInfro.phone}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										传真
									</th>
									<TD class="BGCgray" width="40%">
										<input name="fax" value="${contactInfro.fax}">
									</TD>
									<th align="center" width="10%">
										电子邮件
									</th>
									<TD class="BGCgray" width="40%">
										<input name="email" value="${contactInfro.email}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										角色
									</th>
									<TD class="BGCgray" width="40%">
										<input name="role" value="${contactInfro.role}">
									</TD>
									<th align="center" width="10%">
										部门
									</th>
									<TD class="BGCgray" width="40%">
										<input name="dept" value="${contactInfro.dept}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										职务
									</th>
									<TD class="BGCgray" width="40%">
										<input name="post" value="${contactInfro.post}">
									</TD>
									<th align="center" width="10%">
										生日
									</th>
									<TD class="BGCgray" width="40%">
										<input type="text" name="shengri" class="laydate-icon"
											id="shengri" value="${contactInfro.brithday}"
											style="width: 100px;">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										msn
									</th>
									<TD class="BGCgray" width="40%">
										<input name="msn" value="${contactInfro.msn}">
									</TD>
									<th align="center" width="10%">
										联系人级别
									</th>
									<TD class="BGCgray" width="40%">
										<input name="level" value="${contactInfro.level}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										英文姓名
									</th>
									<TD class="BGCgray" width="40%">
										<input name="englishname" value="${contactInfro.englishname}">
									</TD>
									<th align="center" width="10%">
										QQ
									</th>
									<TD class="BGCgray" width="40%">
										<input name="qq" value="${contactInfro.qq}">
										<c:if test="${type eq 0}">
											<input value="<%=request.getParameter("customerId")%>"
												name="customerid" type="hidden">
										</c:if>
										<c:if test="${type eq 1}">
											<input value="${contactInfro.customerid}" name="customerid"
												type="hidden">
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
		'saveContact': function(t) {
			//执行事件 return_type=0跳转到联系人新增页面
		   document.form1.action="<%=path%>/contactInfroController/insertContactInfro.go?type=0&return_type=0";	
		   document.form1.submit();
		},
		'editeContact': function(t) {
			//执行事件
		    document.form1.action="<%=path%>/contactInfroController/editecontactInfo.go?type=1&return_type=0";
			document.form1.submit();
		},
		'return_back': function(t) {
			//执行事件
		    window.history.go(-1);
		}
	  }

});


<%--日期框架--%>
var shengri = {
    elem: '#shengri',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
laydate(shengri);	
</script>
	</body>
</html>