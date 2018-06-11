<%@ page language="java" import="create.model.system.Group"
	pageEncoding="utf-8"%>
<%@ page import="create.model.system.Right"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
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
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="display: none;">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="select_date" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;选择数据
				</li>
			</ul>
		</div>

		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="1">
				<tr>
					<td
						style="background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="3" class="table1">
							<%
								List<Group> groups = (List<Group>) request.getAttribute("groups");
								for (int j = 0; j < groups.size(); j++) {
							%>
							<tr class="BGCgray">
								<td colspan="6">
									<input type="checkbox"
										name="checkbox_<%=groups.get(j).getTgId()%>"
										onclick="check_all_1(this,'checkbox_<%=groups.get(j).getTgId()%>');"
										value="<%=groups.get(j).getTgId()%>">
									<font color="green"><%=groups.get(j).getGroupName()%></font>
								</td>
							</tr>
							<%
								List<Right> rights = groups.get(j).getSysRights();
									if (rights != null) {
										for (int i = 0; i < rights.size(); i++) {
							%>
							<tr class="BGCgray">
								<%
									if (i < rights.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox1"
										title="checkbox_<%=groups.get(j).getTgId()%>"
										onclick="check_all_1(this,'checkbox_<%=groups.get(j).getTgId()%>"
										value="<%=rights.get(i).getTrId()%>">
									<%=rights.get(i).getRightName()%>
								</td>
								<%
									i = i + 1;
												} else {
								%>
								<td></td>
								<%
									}
								%>
								<%
									if (i < rights.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox1"
										title="checkbox_<%=groups.get(j).getTgId()%>"
										onclick="check_all_1(this,'checkbox_<%=groups.get(j).getTgId()%>"
										value="<%=rights.get(i).getTrId()%>">
									<%=rights.get(i).getRightName()%>
								</td>
								<%
									i = i + 1;
												} else {
								%>
								<td></td>
								<%
									}
								%>
								<%
									if (i < rights.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox1"
										title="checkbox_<%=groups.get(j).getTgId()%>"
										onclick="check_all_1(this,'checkbox_<%=groups.get(j).getTgId()%>"
										value="<%=rights.get(i).getTrId()%>">
									<%=rights.get(i).getRightName()%>
								</td>
								<%
									i = i + 1;
												} else {
								%>
								<td></td>
								<%
									}
								%>
							</tr>
							<%
								}
									}
								}
							%>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	
	function check_all_1(obj, cName) { 
	  if(obj.checked){    
		           $('input[title='+cName+']').each(function(){
						$(this).attr("checked", true); 
			   		});
		    }else{    
		         $('input[title='+cName+']').each(function(){
						$(this).attr("checked", false); 
			   		}); 
		    }    
	}  
	
		//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'select_date': function(t) {
						var b = true;
						var values="";
					   $('input[name="checkbox1"]:checked').each(function(){
					   			
								values = values + $(this).val()+";";
								var ckb1=$(this).val();
								 $(window.parent.document).find("input[name='checkbox2']").each(function(){
									if(ckb1==$(this).val()){
										b=false;
									}
						   		});
			   			});
			   			if(b&&values!=""){
			   				document.forms[0].action="<%=path%>/systemRightController/saveRightGroupRef.go?roleId="+window.parent.document.getElementById("roleId").value+"&right_list="+values.substring(0,values.lastIndexOf(";"));
					   		document.forms[0].submit();
					   		window.parent.location.reload();
							parent.$('#myWindow_2').window('close');
			   			}else{
			   				alert("您选择的数据已经在列表中，请重新操作！");
			   				return false;
			   			}
			}
		  }
	});

	</script>

</html>