<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>人员列表</title>
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
			   
			   function queryUser(){
			        window.location.href="<%=path%>/userController/showUsers.go";;
			   }
		</script>
		
	</head>
	<body id="divtest" onload="">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<c:if test="${type eq null}">
					<li id="query" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;查询
					</li>
					<li id="to_save" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;新增
					</li>
					<li id="to_edite" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;编辑
					</li>
					<li id="to_delete" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;删除
					</li>
					<li id="importData">
					&nbsp;&nbsp;&nbsp;&nbsp;导入工资表
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
		<form name="form0" action="" accept-charset="UTF-8">
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
									<select name="sex" id="select2">
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
								<th width="10%" align="center">
									<STRONG>是否内部人员</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select name="internalstaff" id="select2">
										<option value="">
											全部
										</option>
										<option value="1">
											内部
										</option>
										<option value="0">
											外部
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
										全选&nbsp;<input type="checkbox" name="checkbox2" id="checkAll">
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
										邮箱
									</th>
									<th align="center">
										职位
									</th>
									<th align="center">
										在职状态
									</th>
								</TR>
								<c:forEach items="${users}" var="user" 
									varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
										id="${page.everyPage*(page.currentPage-1)+status.index+1}" 
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox2"
												title="${user.username}" value="${user.id}"
												onselect="mouseOver(this)">
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
											${user.email}
										</TD>
										<TD align="center">
											${user.jobName}
										</TD>
										<TD align="center">
											<%--0 在职，1离职，2 删除--%>
											<c:if test="${user.status eq 0}">
												在职
											</c:if>
											<c:if test="${user.status eq 1}">
												在职
											</c:if>
											<c:if test="${user.status eq 2}">
												在职
											</c:if>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/userController/showUsers.go" />
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
	 $(function() {  
        		$('body').append('<div id="myWindow" class="easyui-window" style="top: 5px;" closed="true"></div>'); 
		    }); 
		     
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'query': function(t) {
				//执行事件
			    document.form0.action="<%=path%>/userController/showUsers.go";
				document.form0.submit();
			},
			'to_save': function(t) {
				//执行事件 dotype=1是添加
			    	window.location="<%=path%>/userController/to_edite.go?dotype=1";
			},
			'to_edite': function(t) {
				//执行事件
			   var checkbox = $('input[name="checkbox2"]:checked');
			   if(checkbox.length==1){
			   		var id = checkbox[0].value;
			   		//执行事件 dotype=0是修改
				   	window.location="<%=path%>/userController/to_edite.go?dotype=0&id="+id;
			   }else{
			   		alert("本次操作只能选择一个数据");
			   		return;
			   }
			},
			'to_delete': function(t) {
				//执行事件
			   var checkbox = $('input[name="checkbox2"]:checked');
			   var ids="";
			   for(var i=0;i<checkbox.length;i++){
			   		ids = ids +","+checkbox[i].value;
			   }
			  window.location="<%=path%>/userController/edite_user.go?dotype=2&ids="+ids;
			},
			'select_date': function(t) {
						var values="";
						var title = "";
					   $('input[name="checkbox2"]:checked').each(function(){
			   				values = values +$(this).val()+",";
			   				title = title +$(this).attr("title")+",";
			   			});
			   		window.parent.document.getElementById("person_name").innerHTML =title.substring(0,title.lastIndexOf(","));
			   		window.parent.document.getElementById("personId").value=values.substring(0,values.lastIndexOf(","));
					parent.$('#myWindow').window('close');
			},
			'importData': function(t) {
				showMyWindow("人员导入",  
                    '${pageContext.request.contextPath}/view/hrm/importUserData.jsp',  
                    500, 200); 
			} 
		  }
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
		                            shadow : true,  
		                            cache : false,  
		                            closed : false,  
		                            collapsible : false,  
		                            resizable : false,  
		                            loadingMessage : '正在加载数据，请稍等片刻......'  
		                        });  
		    }  
	</script>
</html>