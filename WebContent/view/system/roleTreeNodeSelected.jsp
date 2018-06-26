<%@ page language="java" import="create.model.hrm.Treenodes"
	pageEncoding="utf-8"%>
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
				<li id="save_data" style="border-bottom-style: dotted">
					&nbsp;&nbsp;&nbsp;&nbsp;保存
				</li>
			</ul>
		</div>
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" height="100%" border="0" cellspacing="0"
							cellpadding="3" class="table1">
							<%
								List<Treenodes> allreenodes = (List<Treenodes>) request
										.getAttribute("allreenodes");
								for (int j = 0; j < allreenodes.size(); j++) {
							%>
							<tr class="BGCgray">
								<td colspan="6">
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"   value="<%=allreenodes.get(j).getId()%>"
									onclick="check_all_1(this,'checkbox_<%=allreenodes.get(j).getId()%>');">
									<%=allreenodes.get(j).getName()%>
								</td>
							</tr>
							<%
								List<Treenodes> nodes = allreenodes.get(j).getSunTreeNodes();
									if (nodes != null) {
										for (int i = 0; i < nodes.size(); i++) {
							%>
							<tr class="BGCgray">
								<%
									if (i < nodes.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"
										value="<%=nodes.get(i).getId()%>"
										<%
							if(nodes.get(i).getSelected()!=null&&nodes.get(i).getSelected().equals(1)) {
							%>
										checked="checked" <%
							}
							%>>
									<%=nodes.get(i).getName()%>
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
									if (i < nodes.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"
										value="<%=nodes.get(i).getId()%>"
										<%
							if(nodes.get(i).getSelected()!=null&&nodes.get(i).getSelected().equals(1)) {
							%>
										checked="checked" <%
							}
							%>>
									<%=nodes.get(i).getName()%>
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
									if (i < nodes.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"
										value="<%=nodes.get(i).getId()%>"
										<%
							if(nodes.get(i).getSelected()!=null&&nodes.get(i).getSelected().equals(1)) {
							%>
										checked="checked" <%
							}
							%>>
									<%=nodes.get(i).getName()%>
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
									if (i < nodes.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"
										value="<%=nodes.get(i).getId()%>"
										<%
							if(nodes.get(i).getSelected()!=null&&nodes.get(i).getSelected().equals(1)) {
							%>
										checked="checked" <%
							}
							%>>
									<%=nodes.get(i).getName()%>
								</td>
								<%
									} else {
								%>
								<td></td>
								<%
									}
								%>
								<%
									if (i < nodes.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"
										value="<%=nodes.get(i).getId()%>"
										<%
							if(nodes.get(i).getSelected()!=null&&nodes.get(i).getSelected().equals(1)) {
							%>
										checked="checked" <%
							}
							%>>
									<%=nodes.get(i).getName()%>
								</td>
								<%
									} else {
								%>
								<td></td>
								<%
									}
								%>
								<%
									if (i < nodes.size()) {
								%>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="checkbox" name="checkbox_<%=allreenodes.get(j).getId()%>"
										value="<%=nodes.get(i).getId()%>"
										<%
							if(nodes.get(i).getSelected()!=null&&nodes.get(i).getSelected().equals(1)) {
							%>
										checked="checked" <%
							}
							%>>
									<%=nodes.get(i).getName()%>
								</td>
								<%
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
							%>
							<%
								}
							%>
							<TR>
								<th align="center" colspan="6">
									<input type="hidden" value="${roleID}" name="roleid" id="roleid">
								</th>
							</TR>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script type="text/javascript">
	
	
	
	function check_all_1(obj, cName) { 
	  if(obj.checked){    
		           $('input[name='+cName+']').each(function(){
						$(this).attr("checked", true); 
			   		});
		    }else{    
		         $('input[name='+cName+']').each(function(){
						$(this).attr("checked", false); 
			   		}); 
		    }    
	}  
	
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
			'save_data': function(t) {
				var menue = "";
				$(":checked").each(function(){
								menue=menue+$(this).val()+",";	
						   		});
				document.forms[0].action="<%=path%>/sysRoleController/saveRoleInfoRefMenue.go?menueId="+menue;
				document.forms[0].submit();
			}
		  }
		});
	</script>
</html>