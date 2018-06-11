<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>增加权限组</title>
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
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="return_back">
					&nbsp;&nbsp;&nbsp;&nbsp;返 回
				</li>
			</ul>
		</div>

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
										标识
									</th>
									<TD class="BGCgray">
										<input name="rightName" type="text" id="rightName"
											value="${group.tgMark}">
										<input name="tgId" type="hidden" id="tgId"
											value="${group.tgId}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										说明
									</th>
									<TD width="80%" class="BGCgray">
										<input name="groupName" type="text" id="groupName"
											value="${group.groupName}">
									</TD>
								</TR>
								<TR>
									<th align="center">
										备注
									</th>
									<TD class="BGCgray">
										<textarea rows="3" cols="60" name="tgMark" id="tgMark"
											value="${group.descrption}"></textarea>
									</TD>
								</TR>
								<TR>
									<th colspan="2">
										<input name="trId" type="hidden" id="parentTrId" value="">
									</th>
								</TR>
							</table>
						</form>
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
											 plain="true" iconcls="icon-add" data-options="plain:true,iconCls:'icon-add'"
											onclick="queryXXX();"><font
													color="black">加 入</font></a>
													
									</th>
								</tr>
								<TR>
									<th align="center">
										序号
									</th>
									<th align="center">
										标识
									</th>
									<th align="center">
										名称
									</th>
									<th width="200" align="center">
										描述
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${group_rights}" var="group_right" varStatus="status">
									<TR class="BGCgray">
										<TD align="center">
											${(page.currentPage-1)*page.everyPage + status.index + 1}
										</TD>
										<TD align="center">
											${group_right.trMark}
										</TD>
										<TD align="center">
											${group_right.rightName}
										</TD>
										<TD align="center">
											${group_right.description}
										</TD>
										<TD align="center">
											<a
													href="<%=path%>/rightGroupController/updaterightGroupRelation.go?trId=${group_right.trId}&tg_id=${group.tgId}"
													class="easyui-linkbutton"
													data-options="plain:true,iconCls:'icon-remove'"><font
													color="black">删除</font> </a>
										</TD>
									</TR>
								</c:forEach>
								<tr>
									<th align="center" colspan="7">
									</th>
								</tr>
							</table>
						</div>
					</div>
				</td>
			</tr>
		</table>


		<script>
<%--		trId=-1表示查詢所有權限--%>
         function queryXXX() {  
           			showMyWindow("选择权限",  
                    '${pageContext.request.contextPath}/rightGroupController/queryRghtList.go?page=1&detail=is not null&rows=10&type=select&methed=savedata',  
                    800, 500); 
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
		'return_back': function(t) {
			window.history.go(-1);
		}
	  }

});

</script>
	</body>
</html>