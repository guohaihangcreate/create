<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>

<html>
	<head>
		<title>组织结构</title>
		<link href="<%=path%>/login_b/css/style.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="<%=path%>/login_b/js/main.js">
				</script>

		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css"
			href="<%=path%>/css/easyui/demo.css">

		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.mobile.js"></script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1">
			<ul id="rightMenue">
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="to_depart"
					style="border-bottom-style: dotted;">
					&nbsp;&nbsp;&nbsp;&nbsp;新增部门
				</li>
				<li id="to_company" style="border-bottom-style: dotted;">
					&nbsp;&nbsp;&nbsp;&nbsp;新增公司
				</li>
				<li id="SaveDept" style="border-bottom-style: dotted;">
					&nbsp;&nbsp;&nbsp;&nbsp;保存部门信息
				</li>
				<li id="to_getData" style="border-bottom-style: dotted;">
					&nbsp;&nbsp;&nbsp;&nbsp;获取数据
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<div class="easyui-layout"
			style="width: 100%; height: 80%; padding: -100px; margin: -20px;">
			<div id="p" data-options="region:'west'"
				style="width: 30%; height: 100%; padding: 0px; border-bottom-style: dotted;">
				<div class="easyui-panel" style="padding: 5px; height: 100%;">
					<ul id="tt" class="easyui-tree"
						data-options="url:'<%=path%>/deptController/easyUiTreeData.go',method:'get',animate:true"></ul>
				</div>
			</div>
			<div id="departInfo" data-options="region:'center'"
				style="border-bottom-style: dotted; width: 60%;">
				<form id="form0" name="form0" action="" method="post"
					enctype="multipart/form-data" style="display: block;">
					<table width="100%" height="100%" border="0" cellspacing="0"
						cellpadding="3">
						<tr>
							<td height="100%" valign="top">
								<div style="overflow: auto; height: 100%; width: 100%">
									<table width="100%" border="0" cellpadding="3" cellspacing="1"
										class="table1">
										<TR>
											<th colspan="2">
												部门信息
											</th>
										</TR>
										<TR>
											<th width="20%" align="center">
												所属公司
											</th>
											<TD class="BGCgray">
												<a href="javascript:void(0)" class="easyui-linkbutton"
													iconCls="icon-search" plain="true"
													onclick="queryAllCompany();"><font color="bule">请选择</font>
												</a>
												<span id="dept_name"></span>
												<input name="yl1" type="hidden" id="yl1" value="">
												<input name="deptId" type="hidden" id="deptId" value="">
											</TD>
										</TR>
										<TR>
											<th width="20%" align="center">
												上级部门
											</th>
											<TD class="BGCgray">
												<input name="pdeptName" type="text" id="pdeptName" value="">
												<input name="pdeptId" type="hidden" id="pdeptId" value="">
											</TD>
										</TR>
										<TR>
											<th width="20%" align="center">
												部门名称
											</th>
											<TD class="BGCgray">
												<input name="deptName" type="text" id="deptName" value="">
											</TD>
										</TR>
										<TR>
											<th align="center">
												部门编码
											</th>
											<TD width="80%" class="BGCgray">
												<input name="deptMak" type="text" id="deptMak" value="">
											</TD>
										</TR>
										<TR>
											<th align="center">
												部门负责人
											</th>
											<TD width="80%" class="BGCgray">
												<a href="javascript:void(0)" class="easyui-linkbutton"
													iconCls="icon-search" plain="true"
													onclick="queryAllPerson();"><font color="bule">请选择</font>
												</a>
												<span id="person_name"></span>
												<input name="deptDirector" type="hidden" id="personId"
													value="">
											</TD>
										</TR>
										<TR>
											<th align="center">
												<span class="BGCgray">部门职责</span>
											</th>
											<TD class="BGCgray">
												<input name="yl2" type="text" id="yl2" value="">
											</TD>
										</TR>
										<TR>
											<th align="center">
												<span class="BGCgray">钉钉ID</span>
											</th>
											<TD class="BGCgray">
												<input name="dingtalkId" type="text" id="dingtalkId" value="${dingtalkId}">
											</TD>
										</TR>
										<TR>
											<th colspan="2">
											</th>
										</TR>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</form>
				<form id="form1" name="form1" action="" method="post"
					enctype="multipart/form-data" style="display: none;">
					<table width="100%" height="100%" border="0" cellspacing="0"
						cellpadding="3">
						<tr>
							<td height="100%" valign="top">
								<div style="overflow: auto; height: 100%; width: 100%">
									<table width="100%" border="0" cellpadding="3" cellspacing="1"
										class="table1">
										<TR>
											<th colspan="2">
												公司信息
											</th>
										</TR>
										<TR>
											<th width="20%" align="center">
												公司名称
											</th>
											<TD class="BGCgray">
												<input name="companyname" type="text" id="companyname"
													value="">
												<input name="companyid" type="hidden" id="companyid"
													value="">
											</TD>
										</TR>
										<TR>
											<th align="center">
												公司编码
											</th>
											<TD width="80%" class="BGCgray">
												<input name="companymark" type="text" id="companymark"
													value="">
											</TD>
										</TR>
										<TR>
											<th align="center">
												注册地址
											</th>
											<TD width="80%" class="BGCgray">
												<input type="text" name="registeredaddress" id="registeredaddress">
											</TD>
										</TR>
										<TR>
											<th align="center">
												<span class="BGCgray">经营范围</span>
											</th>
											<TD class="BGCgray">
												<textarea rows="10" cols="50" name="businessscope" id="businessscope"></textarea>
											</TD>
										</TR>
										<TR>
											<th colspan="2">
											</th>
										</TR>
									</table>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
	<script type="text/javascript">
	
		 function queryAllPerson() {  
           showMyWindow("请选择人员信息",  
                    '${pageContext.request.contextPath}/userController/showUsers.go?page=1&rows=10&type=selectUser',  
                    800, 400); 
        } 
        
        
         function queryAllCompany() {  
           			showMyWindow("请选择公司",  
                    '${pageContext.request.contextPath}/companyController/showCompanys.go?page=1&rows=10&type=select',  
                    800, 400); 
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
									var node = $('#tt').tree('getSelected');
									if (node){
										var s = node.id;
										alert(s);
									}
							},
							'to_getData': function(t) {
									var node = $('#tt').tree('getSelected');
									if (node){
										$.getJSON("<%=path%>/deptController/getAjaxDATA.go?id="+node.id, function(json){
												var type = node.id.split(",");
												//0表示获取公司信息
												if(type[1]==0){
														   $("#form0").css('display','none');
						       							  $("#form1").css('display','block');
						       							  //公司添加赋值
						       							  $("#companyname").val(json.companyname);
						       							  $("#companyid").val(json.companyid);
						       							  $("#companymark").val(json.companymark);
						       							  $("#registeredaddress").val(json.registeredaddress);
						       							  $("#businessscope").val(json.businessscope);
						       							
						       							  $("#Savecompany").remove();
						       							  $("#SaveDept").remove();
						       							  $("#to_depart").remove();
						       							  $("#to_edite_depart").remove();
						       							  if($("#to_edite_company").length==0){
						       							  	  $("#Savecompany").remove();
							       							  $("#SaveDept").remove();
							       							  $("#to_depart").remove();
							       							  $("#to_edite_depart").remove();
							       							  $("#rightMenue").append("<li id='to_edite_company' style='border-bottom-style: dotted;display: none;'>&nbsp;&nbsp;&nbsp;&nbsp;修改公司信息</li>");
							       							  $("#rightMenue").append("<li id='delete_company' style='border-bottom-style: dotted;display: none;'>&nbsp;&nbsp;&nbsp;&nbsp;删除数据</li>");
						       							  }
												}else{
														$("#form1").css('display','none');
							       						$("#form0").css('display','block');
							       						//部门添加赋值
							       						$("#deptId").val(json.id);
														$("#dept_name").text(json.companyname);
						       							$("#dingtalkId").val(json.dingtalkId);
														$("#yl1").val(json.companyid);
														$("#pdeptId").val(json.pdeptId);
														$("#pdeptName").val(json.pdeptName);
														$("#deptName").val(json.deptName);
														$("#deptMak").val(json.deptMak);
														$("#person_name").text(json.person_name);
														$("#personId").val(json.personId);
														$("#deptDirector").val(json.deptDirector);
														$("#yl2").val(json.yl2);
														if($("#to_edite_depart").length==0){
															$("#Savecompany").remove();
							       							$("#to_depart").remove();
							       							$("#rightMenue").append("<li id='to_edite_depart' style='border-bottom-style: dotted;display: none;'>&nbsp;&nbsp;&nbsp;&nbsp;修改部门信息</li>");
							       							$("#rightMenue").append("<li id='delete_depart' style='border-bottom-style: dotted;display: none;'>&nbsp;&nbsp;&nbsp;&nbsp;删除数据</li>");
														}
												}
											});

									}
							},
							'to_back': function(t) {
								//执行事件
							 	window.history.go(-1);
							},
							'to_company': function(t) {
								//执行事件
							 	  $("#form0").css('display','none');
       							  $("#form1").css('display','block');
       							  $("#to_company").remove();
       							  $("#SaveDept").remove();
       							  $("#rightMenue").append("<li id='Savecompany' style='border-bottom-style: dotted;display: none;'>&nbsp;&nbsp;&nbsp;&nbsp;保存公司信息</li>");
							},
							'to_depart': function(t) {   
								//执行事件
       							  $("#form1").css('display','none');
       							  $("#form0").css('display','block');
       							  $("#to_depart").remove();
       							  $("#rightMenue").append("<li id='SaveDept' style='border-bottom-style: dotted;display: none;'>&nbsp;&nbsp;&nbsp;&nbsp;保存部门信息</li>");
							},
							'Savecompany': function(t) {   
								//执行事件
							 	 document.form1.action="<%=path%>/companyController/addCompany.go";
								 document.form1.submit();
							},
							'saveDept': function(t) {   
								//执行事件
							 	 document.form0.action="<%=path%>/deptController/adddept.go";
								 document.form0.submit();
							},
							'to_edite_company': function(t) {   
								//执行事件
							 	 document.form1.action="<%=path%>/companyController/editeCompany.go";
								 document.form1.submit();
							},
							'to_edite_depart': function(t) {   
								//执行事件
							 	  document.form0.action="<%=path%>/deptController/editedept.go";
								  document.form0.submit();
							},
							'delete_depart': function(t) {   
								//执行事件
							 	 document.form0.action="<%=path%>/deptController/deleteDept.go";
								 document.form0.submit();
							},
							'delete_company': function(t) {   
								//执行事件
							 	 document.form1.action="<%=path%>/companyController/deleteCompany.go";
								 document.form1.submit();
							}
						  }
					});
					
		</script>
	<script type="text/javascript">
			
			$('#tt').tree({onlyLeafCheck:$(this).is(':checked')});
			
			
			$(document).ready(function(){ 
					 $("#tt").tree({  
					 url:'<%=path%>/deptController/easyUiTreeData.go',
					 method: 'GET',  
					 animate: true,  
					 checkbox: true,  
					 cascadeCheck:true,//层叠选中  
					 lines:true,//显示虚线效果  
					 onLoadSuccess:function(node,data){  
					  var nodeDep = $('#tt').tree('find',checkeid);  
					  if (null != nodeDep && undefined != nodeDep)  
					  {  
					      $('#tt').tree('check',nodeDep.target);  
					  }  
					 },  
					 onCheck:function(node, checked)  
					 {  
					  if (checked)  
					  {  
					      //这段逻辑自拟  
					      alert(this.id);
					      alert(this.text);
					      	alert(11111);
					      }   
					      else   
					      {   
					      }  
					       
					}   
					});
				})
				
	</script>
</html>