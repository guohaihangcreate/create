<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>人员列表</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
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
			   
			function CheckAll(){
				$(":checkbox").each(function(){
							if($(this).prop("checked")){
								$(this).prop("checked",false);
							}else{
								$(this).prop("checked",true);
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
				<li id="select" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="select_date" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;选择数据
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
									所属公司
								</th>
								<td width="20%" class="BGCgray">
									<select name="companyId" id="companyId">
										<option value="">
											请选择数据
										</option>
										<c:forEach items="${companyData}" var="company">
											<option value="${company.companyid}">
												${company.companyname}
											</option>
										</c:forEach>
									</select>
								</td>
								<th width="10%" align="center">
									所属部门
								</th>
								<td width="20%" class="BGCgray">
									<select name="departid" id="departid">
										<option value="">
											请选择数据
										</option>
										<c:forEach items="${departData}" var="depart">
											<option value="${depart.deptId}">
												${depart.deptName}
											</option>
										</c:forEach>
									</select>
								</td>
							</TR>
							<tr>
								<th width="10%" align="center">
									姓名
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="username" id="username">
								</td>
								<th width="10%" align="center">
									<STRONG>性别</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select name="sex" id="sex">
										<option value="">
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
									<th align="center">
										全选&nbsp;
										<input type="checkbox" name="checkbox1" id="all">
									</th>
									<th align="center">
										员工姓名
									</th>
									<th align="center">
										所属部门
									</th>
								</TR>
								<c:forEach items="${users}" var="user" varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
										id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox1"
												title="${user.username}" value="${user.id}"
												onselect="mouseOver(this)">
										</TD>
										<TD align="center" id="${user.id}">
											${user.username}
										</TD>
										<TD align="center">
											${user.departName}
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url" value="/sysRoleController/queryList.go" />
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
	$("#all").click(function(){    
		    if(this.checked){    
		          $('input[name="checkbox1"]').each(function(){
						$(this).attr("checked", true); 
			   		});
		    }else{    
		        $('input[name="checkbox1"]').each(function(){
						$(this).attr("checked", false); 
			   		}); 
		    }    
		});
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'select_date': function(t) {
						var b = true;
						var values="";
						var titles="";
					   $('input[name="checkbox1"]:checked').each(function(){
								values = values + $(this).val()+";";
								titles = titles + $(this).attr("title")+";";
								var ckb1=$(this).val();
								 $(window.parent.document).find("input[name='checkbox2']").each(function(){
									if(ckb1==$(this).val()){
										b=false;
									}
						   		});
			   			});
			   		
			   			//给input赋值
			   			if(GetQueryString("type")=="selectUser"){
							window.parent.document.getElementById("sale_view").value=titles;
							window.parent.document.getElementById("sale").value=values;
							
							window.parent.document.getElementById("dept_name").value=titles;
							window.parent.document.getElementById("deptId").value=values;
							window.parent.$('#myWindow_2').window('close');
			   			}
			   			if(GetQueryString("type")=="select_payrollUser"){
							window.parent.document.getElementById("username_view").value=titles.split(";")[0];
							window.parent.document.getElementById("userid").value=values.split(";")[0];
							window.parent.$('#myWindow_2').window('close');
			   			}else{
			   				if(b&&values!=""){
			   				document.forms[0].action="<%=path%>/sysRoleController/updateRoleInfoRefUser.go?roleId="+window.parent.document.getElementById("roleId").value+"&role_list="+values.substring(0,values.lastIndexOf(";"));
					   		document.forms[0].submit();
					   		window.parent.location.reload();
							window.parent.$('#myWindow_2').window('close');
				   			}else{
				   				alert("您选择的数据已经在列表中，请重新操作！");
				   				return false;
				   			}
			   			}
			},
			'select': function(t) {
		  					document.forms[0].action="<%=path%>/userController/select_userData.go?type=select_payrollUser&departid="+jQuery("#departid  option:selected").val()+"&companyId="+jQuery("#companyId  option:selected").val()+"&username="+document.getElementById("username").value+"&sex="+jQuery("#sex  option:selected").val();
		  					document.forms[0].submit();
		  }
		  },
	});
	</script>
</html>