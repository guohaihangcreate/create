<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>

<html>
	<head>
		<title></title>
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
		<div class="easyui-layout"
			style="width: 120%; height: 120%; padding: -100px; margin: -20px;">
			<div id="p" data-options="region:'west'"
				style="width: 100%; height: 100%; padding: 0px; border-bottom-style: dotted;">
				<div class="easyui-panel" style="padding: 5px; height: 100%;">
					<ul id="tt" class="easyui-tree"
						data-options="url:'<%=path%>/deptController/easyUiTreeData.go',method:'get',animate:true"></ul>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
			$('#tt').tree({
				    onClick: function(node){
				       var type = node.id.split(",");
						if(type[1]==1){
							window.parent.document.getElementById("departid").value =type[0];
					        window.parent.document.getElementById("departName").value =node.text;
					   		window.parent.document.getElementById("dept_name").innerHTML =node.text;
					   		window.parent.document.getElementById("companyId").value =node.parentID;
					        window.parent.document.getElementById("companyName").value =node.parentName;
					   		window.parent.document.getElementById("companyName_span").innerHTML =node.parentName;
							parent.$('#myWindow').window('close');
						}else{
							alert("数据选择有误，请重新选择部门信息");
						}
				    }
				});
				
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