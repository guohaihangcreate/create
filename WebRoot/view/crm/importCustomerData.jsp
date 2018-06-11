<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			window.onload=function(){ 
				//设置年份的选择 
				var myDate= new Date(); 
				var startYear=myDate.getFullYear()-50;//起始年份 
				var endYear=myDate.getFullYear()+50;//结束年份 
				var obj=document.getElementById('myYear') 
				for (var i=startYear;i<=endYear;i++) 
				{ 
				  obj.options.add(new Option(i,i)); 
				} 
				obj.options[obj.options.length-51].selected=1; 
				//设置月份的选择
				var obj_month=document.getElementById('myMonth') 
				var nowmonth = myDate.getMonth();
				for (var i=0;i<=11;i++) 
				{ 
				  obj_month.options.add(new Option(i+1,i)); 
				} 
				obj_month.options[nowmonth].selected=1; 
			} 
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="improttable" style="border-bottom-style: dotted">
					导入系統
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
									<th colspan="2" align="left">
										客户信息导入
									</th>
								</TR>
								<TR>
									<th width="20%" align="center">
										公司选择
									</th>
									<TD class="BGCgray">  
										<select name="companyid" id="companyid">
											 	<option value="1">
											 		北京柯锐特信息技术有限公司
												</option>
												<option value="3">
											 		柯锐特互动(北京)科技有限公司
												</option>
												<option value="4">
											 		柯锐特教育(北京)有限公司
												</option>
												<option value="5">
											 		迅达在线（北京）科技有限公司
												</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										选择文件
									</th>
									<TD class="BGCgray">
										<input type="file" name="file">
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
  $(function() {  
        		var obj = window.parent.document.getElementById("companys").value.split(",");
		    });  
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
		  bindings: 
		  {
			'improttable': function(t) {
					document.forms[0].action="<%=path%>/customerInfoController/importCustomer.go";
					document.forms[0].submit();
			},
		  }
	
	});
	</script>
</html>