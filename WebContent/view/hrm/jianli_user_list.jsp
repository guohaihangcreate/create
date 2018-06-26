<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>员工简历管理</title>
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
			 function mouseOver(obj){
			        $(obj).css("background-color","green");
			   }
			   function mouseOut(obj){
			      if(obj.id%2==0){
			      	 $(obj).css("background-color","#e3efff");
			      }else{
			      	 $(obj).css("background-color","#ffffff");
			      }
			   }
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<c:if test="${type eq null}">
					<li id="query" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;查询
					</li>
				</c:if>
				<c:if test="${type ne null}">
					<li id="select_date" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;选择数据
					</li>
				</c:if>
			</ul>
		</div>
		<!--右键代码结束-->
		<form name="form0" action="">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									员工名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="username" id="username">
								</td>
								<th width="10%" align="center">
									所属部门
								</th>
								<td width="20%" class="BGCgray">
									<span id="dept_name"></span>
									<input type="hidden" name="departid" id="departid">
									<input type="text" name="departName" id="departName">
								</td>
								<th width="10%" align="center">
									<STRONG>性别</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select name="select2" id="select2">
										<option>
											全部
										</option>
										<option value="1">
											男
										</option>
										<option value="0">
											女
										</option>
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
										<input type="checkbox" name="checkbox2" id="checkbox">
									</th>
									<th align="center">
										员工姓名
									</th>
									<th align="center">
										所属部门
									</th>
									<th align="center">
										联系电话
									</th>
									<th align="center">
										职位
									</th>
									<th align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${users}" var="user" varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
										id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox2" title="${user.id}"
												value="${user.id}" onselect="mouseOver(this)">
										</TD>
										<TD align="center" id="${user.id}">
											${user.username}
										</TD>
										<TD align="center">
											${user.departName}
										</TD>
										<TD align="center">
											${user.telephone}
										</TD>
										<TD align="center">
											${user.jobName}
										</TD>
										<TD align="center">
											<c:if test="${user.salt eq null}">
												<a
													href="<%=path%>/zhaoPinController/zengjiajianliInfo.go?userid=${user.id}"
													class="easyui-linkbutton"
													data-options="plain:true,iconCls:'icon-add'"><font
													color="black">添加简历</font> </a>
											</c:if>
											<c:if test="${user.salt ne null && user.salt ne 'null'}">
												<a
													href="<%=path%>/mianshiYaoQingController/seeJianli.go?pId=${user.salt}"
													class="easyui-linkbutton"
													iconCls="icon-search" plain="true"><font color="black">查看</font>
											</c:if>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="6" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/userController/showUsers.go?type=1" />
									</jsp:include>
								</table>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>

	<script type="text/javascript">
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'query': function(t) {
				//执行事件
			    document.form0.action="<%=path%>/userController/showUsers.go";
				document.form0.submit();
			}
		  }
	});
	</script>
</html>