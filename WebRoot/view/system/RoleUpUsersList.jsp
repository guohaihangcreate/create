<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>角色下面的用户</title>
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
	function addinfo(){
		document.forms[0].action="<%=path%>/sysRoleController/toAddRoleInfoPage.go";
		document.forms[0].submit();
	}
	
	function toSeeinfo(dateid){
		document.forms[0].action="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
		document.forms[0].submit();
	}
	function toEditeinfo(dateid){
		document.forms[0].action="<%=path%>/sysRoleController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
		document.forms[0].submit();
	}
	
	function queryXXX(){
		$('#myWindow_2').window('open');
	}
	
	function deleteXXX(){
		var ids="";
	    $('input[name="checkbox2"]:checked').each(function(){
	    		if(22==$(this).val()){
	    			alert("系统管理员不能删除");
	    			return false;
	    		}
				ids = ids + $(this).val()+",";
		});
		window.location.href="<%=path%>/sysRoleController/deleteoleInfoRefUser.go?ids="+ids+"&roleId="+${roleId};
	}
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="display: none;">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="return_back" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th colspan="2">
								</th>
							</TR>
							<TR>
								<th width="20%" align="center">
									角色名称
								</th>
								<TD class="BGCgray">
									<input name="roleName" type="text" id="roleName"
										value="${role.roleName}">
								</TD>
							</TR>
							<TR>
								<th align="center">
									说明
								</th>
								<TD width="80%" class="BGCgray">
									<input name="roleMark" type="text" id="roleMark"
										value="${role.roleMark}">
								</TD>
							</TR>
							<TR>
								<th align="center">
									备注
								</th>
								<TD class="BGCgray">
									<textarea rows="3" cols="60" name="description" id="description"
										value="${role.description}"></textarea>
								</TD>
							</TR>
							<TR>
								<th colspan="2">
								</th>
							</TR>
						</table>
						<div style="overflow: auto; width: 100%;">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<tr>
									<th align="left" colspan="4">
										<label style="color: blue;">
											权限详细
										</label>
									</th>
									<th align="right" colspan="1">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											plain="true" iconcls="icon-add"
											data-options="plain:true,iconCls:'icon-add'"
											onclick="queryXXX();"><font color="black">加 入</font> </a>
										&nbsp;&nbsp;
										<a href="javascript:void(0)" class="easyui-linkbutton"
											plain="true" iconcls="icon-add"
											data-options="plain:true,iconCls:'icon-add'"
											onclick="deleteXXX();"><font color="black">删 除</font> </a>

									</th>
								</tr>
								<form action="" method="post" enctype="multipart/form-data">
									<table width="100%" height="100%" border="0" cellspacing="0"
										cellpadding="3">
										<tr>
											<td height="100%" valign="top">
												<div style="overflow: auto; height: 100%; width: 100%">
													<table width="100%" border="0" cellpadding="3"
														cellspacing="1" class="table1">
														<TR>
															<th align="center">
																全选&nbsp;
																<input type="checkbox" name="checkbox2" id="checkAll">
															</th>
															<th align="center">
																名称
															</th>
															<th align="center">
																联系方式
															</th>
															<th align="center">
																所属部门
															</th>
															<th align="center">
																岗位
															</th>
														</TR>
														<c:forEach items="${userList}" var="user"
															varStatus="status">
															<TR onMouseOver="mouseOver(this)"
																onMouseOut="mouseOut(this)"
																id="${page.everyPage*(page.currentPage-1)+status.index+1}"
																<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
																<TD align="center">
																	${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
																	<input type="checkbox" name="checkbox2"
																		value="${user.id}" onselect="mouseOver(this)">
																</TD>
																<TD align="center">
																	${user.username}
																</TD>
																<TD align="center">
																	${user.telephone}
																</TD>
																<TD align="center">
																	${user.departName}
																</TD>
																<TD align="center">
																	${user.jobName}
																</TD>
															</TR>
														</c:forEach>
														<TR>
															<th align="center" colspan="5">
																<input name="roleId" id="roleId" value="${roleId}"
																	type="hidden">
															</th>
														</TR>
													</table>
												</div>
											</td>
										</tr>
									</table>
								</form>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<div id="myWindow_2" class="easyui-window" title="选择角色成员"
			data-options="modal:true,closed:true,iconCls:'icon-save'"
			style="top: 5px; left: 80px; width: 600; height: 400;">
			<iframe name="authIframe" id="authIframe"
				src="<%=path%>/userController/select_userData.go" scrolling="no"
				style="width: 100%; height: 98%;"></iframe>
		</div>
	</body>
	<script type="text/javascript">
		$("#checkAll").click(function(){    
		    if(this.checked){    
		          $('input[name="checkbox2"]').each(function(){
						$(this).attr("checked", true); 
			   		});
		    }else{    
		        $('input[name="checkbox2"]').each(function(){
						$(this).attr("checked", false); 
			   		}); 
		    }    
		});
	
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'return_back': function(t) {
				window.parent.location.href="<%=path%>/sysRoleController/queryList.go";
			}
		  }
	});
	</script>

</html>