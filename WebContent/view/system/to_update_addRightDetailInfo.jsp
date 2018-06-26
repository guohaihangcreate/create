<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
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
		<script type="text/javascript">
			function save(){
				document.forms[0].action="<%=path%>/systemRightController/saveRightInfo.go";
				document.forms[0].submit();
			}
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="add_date">
					&nbsp;&nbsp;&nbsp;&nbsp;新增数据
				</li>
				<li id="update_date">
					&nbsp;&nbsp;&nbsp;&nbsp;修改数据
				</li>
				<li id="return_back">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<form action="" method="post" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th colspan="2">
									</th>
								</TR>
								<TR>
									<th width="20%" align="center">
										名称
									</th>
									<TD class="BGCgray">
										<input name="rightName" type="text" id="rightName"
											value="${right.rightName}">
										<input name="trId" type="hidden" id="trId"
											value="${right.trId}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										权限详细关键字
									</th>
									<TD width="80%" class="BGCgray">
										<input name="trMark" type="text" id="trMark"
											value="${right.trMark}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										权限详细描述
									</th>
									<TD width="80%" class="BGCgray">
										<textarea rows="10" cols="60" name="description"
											id="description">${right.description}</textarea>
									</TD>
								</TR>
								<TR>
									<th align="center">
										所属权限
									</th>
									<TD class="BGCgray">
										<a href="javascript:void(0)" class="easyui-linkbutton"
											iconCls="icon-search" plain="true" onclick="queryXXX();"><font
											color="bule">请选择</font> </a>
										<span id="parentTrId_Name">${right.belong_right}</span>
										<input name="parentTrId" type="hidden" id="parentTrId"
											value="${right.parentTrId}">
									</TD>
								</TR>
								<TR>
									<th colspan="2">
									</th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
		<script>
		 function queryXXX() {  
           			showMyWindow("所属权限选择",  
                    '${pageContext.request.contextPath}/rightGroupController/queryRghtList.go?page=1&rows=10&type=select',  
                    800, 400); 
        } 
        
        
         $(function() {  
        		$('body').append('<div id="myWindow" class="easyui-window" style="top: 5px;" closed="true"></div>'); 
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

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'add_date': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/saveRirhtDetail.go";
			document.forms[0].submit();
		},
		'update_date': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/rightGroupController/updateRirhtDetail.go";
			document.forms[0].submit();
		},
		'return_back': function(t) {
			window.history.go(-1);
		}
	  }

});




function openwindow()
{	
	window.showModalDialog();
	window.open("<%=path%>/view/system/addRightInfo.jsp","a","center:yes;dialogTop:20px;scroll:0;status:0;help:0;resizable:0;dialogWidth:80px;dialogHeight:100px"); 
}

</script>
	</body>
</html>