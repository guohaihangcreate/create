<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/icon.css">


		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.mobile.js"></script>
		<script type="text/javascript">
				//ajax获取项目信息
			function getProjectIformations(value){
				$("#project").empty();
				$.get("<%=path%>/customerInfoController/ajaxProjectIformations.go?customerid="+value,function(data){
						for(var i=0;i<data.split(";").length;i++){
				    			$("#project").append("<option value="+data.split(";")[i].split(",")[0].split(":")[1]+">"+data.split(";")[i].split(",")[1].split(":")[1]+"</option>");
				    		}
				  });
			}
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<c:if test="${dotype eq 0}">
					<li id="to_edite" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;修改
					</li>
				</c:if>
				<c:if test="${dotype eq 1}">
					<li id="to_save" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;保存
					</li>
				</c:if>
				<li id="to_back" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form name="form0" action="" method="post"
			enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th colspan="4" align="left">
										人员信息
									</th>
								</TR>
								<TR>
									<th width="20%" align="center">
										人员名称
									</th>
									<TD class="BGCgray">
										<input name="username" type="text" id="roleName"
											value="${editeUser.username}">
										<input name="id" type="hidden" id="id" value="${editeUser.id}">
									</TD>
								</TR>
								<tr>
									<th width="20%" align="center">
										钉钉人员ID
									</th>
									<TD class="BGCgray">
										<input name="dingtalkId" type="text" id="dingtalkId"
											value="${editeUser.dingtalkId}">
									</TD>
								</tr>
								<TR>
									<th align="center">
										所在部门
									</th>
									<TD width="80%" class="BGCgray">
										<span id="dept_name">${editeUser.departName}</span>
										<input name="departName" type="hidden" id="departName"
											value="${editeUser.departName}">
										<input name="departid" type="hidden" id="departid"
											value="${editeUser.departid}">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											iconCls="icon-search" plain="true"
											onclick="queryAllDepartment();">
										<font color="bule">请选择</font>
										</a>
									</TD>
								</TR>
								<TR>
									<th align="center">
										所属公司
									</th>
									<td width="80%" class="BGCgray">
										<span id="companyName_span">${editeUser.companyName}</span>
										<input name="companyId" type="hidden" id="companyId"
											value="${editeUser.companyId}">
										<input name="companyName" type="hidden" id="companyName"
											value="${editeUser.companyName}">
									</td>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">电话</span>
									</th>
									<TD class="BGCgray">
										<input name="telephone" type="text" id="telephone" style="width:200px;"
											value="${editeUser.telephone}">（钉钉中的座机电话项目）
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">手机号码1</span>
									</th>
									<TD class="BGCgray">
										<input name="mobile0" type="text" id="mobile0" style="width:200px;"
											value="${editeUser.mobile0}">（钉钉中的手机号码，请认真填写）
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">手机号码2</span>
									</th>
									<TD class="BGCgray">
										<input name="mobile1" type="text" id="mobile1" style="width:200px;"
											value="${editeUser.mobile1}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										人员状态
									</th>
									<TD width="80%" class="BGCgray">
										在职
										<input name="status" type="radio" value="0" checked="checked"
											<c:if test="${editeUser.status eq 0 or editeUser eq null}">checked="checked"</c:if>>
										&nbsp;离职
										<input name="status" type="radio" value="1"
											<c:if test="${editeUser.status eq 1}">checked="checked"</c:if>>
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">Email</span>
									</th>
									<TD class="BGCgray">
										<input name="email" type="text" id="email"
											value="${editeUser.email}"  style="width:200px;">
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">性别</span>
									</th>
									<TD class="BGCgray">
										男
										<input name="sex" type="radio" value="1"
											<c:if test="${editeUser.sex eq 1}">checked="checked"</c:if>>
										&nbsp;女
										<input name="sex" type="radio" value="0"
											<c:if test="${editeUser.sex eq 0 or editeUser.sex eq null}">checked="checked"</c:if>>
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">是否内部人员</span>
									</th>
									<TD class="BGCgray">
										是
										<input name="internalstaff" type="radio" value="1"   onclick="showORhiddenCustomer(this.value);" 
											<c:if test="${editeUser.internalstaff eq 1 or editeUser.internalstaff eq null}">checked="checked"</c:if>>
										&nbsp;否
										<input name="internalstaff" type="radio" value="0" onclick="showORhiddenCustomer(this.value);"
											<c:if test="${editeUser.internalstaff ne 1 or editeUser.internalstaff ne null}">checked="checked"</c:if>>
									</TD>
								</TR>
								<TR  <c:if test="${editeUser.internalstaff eq 1 or editeUser.internalstaff eq null}">style="display: none;"</c:if> id="customerId">
									<th align="center">
										<span class="BGCgray">驻场客户</span>
									</th>
									<TD class="BGCgray">
										<select class="" name="customerId" onchange="getProjectIformations(this.value);">
											<option value="">
												请选择
											</option>
											<c:forEach items="${customerInfos}" var="customer">
												<option  value="${customer.id}" <c:if test="${editeUser.internalstaff eq customer.id}">selected="selected"</c:if> >
													${customer.customername}
												</option>
											</c:forEach>
										</select>
									</TD>
								</TR>
								<tr <c:if test="${editeUser.internalstaff eq 1 or editeUser.internalstaff eq null}">style="display: none;"</c:if> id="projectID">
									<th align="center">
										<span class="BGCgray">驻场项目</span>
									</th>
									<TD class="BGCgray">
											<select class="" name="zcPid" id="project" style="width: 240px;">
																<option value="">
																	请选择
																</option>
															<c:forEach items="${zcprojects}" var="project_">
																<option  value="${project_.id}" <c:if test="${project_.id eq editeUser.zcprojectId}">selected="selected"</c:if>>
																	${project_.projectname}
																</option>
															</c:forEach>
											</select>
									</TD>
								</tr>
								<TR>
									<th align="center">
										<span class="BGCgray">人事负责人</span>
									</th>
									<TD class="BGCgray">
										<input name="rsfzr" type="text" id="rsfzr"
											value="${editeUser.rsfzr}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">职位</span>
									</th>
									<TD class="BGCgray">
										<input name="jobName" type="text" id="jobName"
											value="${editeUser.jobName}">
									</TD>
								</TR>
								<c:if test="${user.loginid eq 'sysadmin'}">
									<TR>
										<th align="center">
											<span class="BGCgray">登录名称</span>
										</th>
										<TD class="BGCgray">
											<input name="loginid" type="text" id="email"
												value="${editeUser.loginid}">
										</TD>
									</TR>
									<TR>
										<th align="center">
											<span class="BGCgray">登录密码</span>
										</th>
										<TD class="BGCgray">
											<input name="password" type="password" id="password"
												value="${editeUser.password}">
										</TD>
									</TR>
								</c:if>
								<TR>
									<th align="center">
										<span class="BGCgray">身份证号码</span>
									</th>
									<TD class="BGCgray">
										<input name="idno" type="text" id="idno" style="width:300px;" value="${editeUser.idno}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										<span class="BGCgray">所属角色</span>
									</th>
									<TD class="BGCgray">
										${editeUser.roleName}
									</TD>
								</TR>
								<TR>
									<th colspan="2" align="center">
									</th>
								</TR>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>

	<script type="text/javascript">
		//显示或者隐藏驻场地址
	function showORhiddenCustomer(internalstaff){
		<%--	内部员工，隐藏驻场地址信息--%>
				if(internalstaff==1){
					$("#customerId").css('display','none'); 
					$("#projectID").css('display','none'); 
				}
		<%--	外部员工，显示驻场地址信息--%>
				if(internalstaff==0){
					$("#customerId").css('display','');
					$("#projectID").css('display','');
				}
	}
	
	  function queryAllDepartment() {  
           			showMyWindow("部门选择",  
                    '${pageContext.request.contextPath}/view/hrm/select_dept_data.jsp',  
                    300, 500); 
        } 
        
      $(function() {  
        		$('body').append('<div id="myWindow" class="easyui-window"  closed="true"></div>'); 
		    }); 
        
      function showMyWindow(title, href, width, height, modal, minimizable,  
		            maximizable) {  
		       			 $('#myWindow').window(  
		                        {  
		                            title : title,  
		                            width : width === undefined ? 600 : width,  
		                            height : height === undefined ? 400 : height,  
		                            content : '<iframe scrolling="yes" frameborder="0"  src="'  
		                                    + href  
		                                    + '" style="width:100%;height:98%;"></iframe>',  
		                            modal : modal === undefined ? true : modal,  
		                            minimizable : minimizable === undefined ? false  
		                                    : minimizable,  
		                            maximizable : maximizable === undefined ? false  
		                                    : maximizable,  
		                            shadow : false,  
		                            cache : false,  
		                            closed : false,  
		                            collapsible : false,  
		                            resizable : false,  
		                            loadingMessage : '正在加载数据，请稍等片刻......'  
		                        });  
		    }  
	
	
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
		  bindings: 
		  {
			'to_edite': function(t) {
				//执行事件
			 		document.form0.action="<%=path%>/userController/edite_user.go";
					document.form0.submit();
			},
			'to_back': function(t) {
				//执行事件
			 	window.history.go(-1);
			},
			'to_save': function(t) {
				//执行事件
			 	document.form0.action="<%=path%>/userController/save_user.go";
				document.form0.submit();
			}
		  }
	
	});
	</script>
</html>