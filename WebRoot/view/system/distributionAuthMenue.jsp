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
		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/css/easyui/jquery.easyui.mobile.js"></script>
	</head>
	<body style="width: 100%; height: 100%;" id="divtest">
		<form action="" name="form0" method="post"
			enctype="multipart/form-data">
			<div class="easyui-panel" style="padding: 0px; width: 100%">
				<ul id="tt" class="easyui-tree" style="padding: 0px;"
					data-options="url:'',method:'get',animate:true,checkbox:true"></ul>
			</div>
			<div style="padding: 5px 0; text-align: center">
				<a onclick="getDate_Auth();" class="easyui-linkbutton"
					data-options="iconCls:'icon-save'"> <font color="blue">保存权限</font>
				</a>
			</div>
		</form>
	</body>
	<script type="text/javascript">
	$(document).ready(function(){ 
			 $("#tt").tree({  
			 url:'<%=path%>/treeNodeController/easyUiTreeData.go',
			 method: 'GET',  
			 animate: true,  
			 checkbox: true,  
			 cascadeCheck:true,//层叠选中  
			 lines:true,//显示虚线效果  
			 onLoadSuccess :function(data){
                            var childNode = $("#tt").tree('getChildren', data[0].target);
                            alert(childNode.length);
                        },  
			 onCheck:function(node, checked)  
			 {  
			  if (checked)  
			  {  
			      //这段逻辑自拟  
			      }   
			      else   
			      {   
			      }  
			       
			}   
			});
		})
	
	
	function getDate_Auth(){
			var nodes = $('#tt').tree('getChecked');
			var s = '';
			for(var i=0; i<nodes.length; i++){
				if (s != '') 
				s += ';';
				s += nodes[i].id;
				s += ',';
				s += nodes[i].text;
			}
			parent.window.document.getElementById("aoth_listvalue").innerHTML=s;
			parent.window.document.getElementById("aoth_list").innerHTML=s;
			parent.$('#myWindow').window('close');
		}
</script>
</html>