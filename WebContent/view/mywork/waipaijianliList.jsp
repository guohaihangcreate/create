<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>简历管理</title>
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
	function toSeeinfo(pId){
		document.forms[0].action="<%=path%>/zhaoPinController/seeJianLi.go?pId="+pId;
		document.forms[0].submit();
	}
	function toEditeinfo(pId){
		document.forms[0].action="<%=path%>/zhaoPinController/toEditePage.go?pId="+pId;
		document.forms[0].submit();
	}
	
	function downloadinfo(pId){
		document.forms[0].action="<%=path%>/zhaoPinController/download.go?pId="+pId;
		document.forms[0].submit();
	}
	
	//电话面试邀请
	function InterViewinVitation(pId){
				//执行事件
		    document.forms[0].action="<%=path%>/mianshiYaoQingController/toAddYaoQing.go?pId="+pId;
			document.forms[0].submit();
	}
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="query">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="refresh">
					&nbsp;&nbsp;&nbsp;&nbsp;刷新
				</li>
				<li id="add">
					&nbsp;&nbsp;&nbsp;&nbsp;简历上传
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
									简历名称
								</th>
								<td width="20%" class="BGCgray">
									<input type="text" name="jianliName" id="jianliName">
								</td>
								<th width="10%" align="center">
									技术类型
								</th>
								<td width="20%" class="BGCgray">
									<select name="jishuLx">
										<option value="">
											请选择
										</option>
										<option value="0"
											<c:if test="${jl.jishuLx eq 0}">selected="selected"</c:if>>
											java
										</option>
										<option value="1"
											<c:if test="${jl.jishuLx eq 1}">selected="selected"</c:if>>
											.net
										</option>
										<option value="2"
											<c:if test="${jl.jishuLx eq 2}">selected="selected"</c:if>>
											ios
										</option>
										<option value="3"
											<c:if test="${jl.jishuLx eq 3}">selected="selected"</c:if>>
											安卓
										</option>
										<option value="4"
											<c:if test="${jl.jishuLx eq 4}">selected="selected"</c:if>>
											web前端
										</option>
										<option value="5"
											<c:if test="${jl.jishuLx eq 5}">selected="selected"</c:if>>
											php
										</option>
										<option value="6"
											<c:if test="${jl.jishuLx eq 6}">selected="selected"</c:if>>
											其他
										</option>
									</select>
								</td>
								<th width="10%" align="center">
									<STRONG>工作年限</STRONG>
								</th>
								<td width="20%" class="BGCgray">
									<select name="gznx">
										<option value="">
											请选择
										</option>
										<option value="0"
											<c:if test="${jl.gznx eq 0}">selected="selected"</c:if>>
											暂无工作经验
										</option>
										<option value="1"
											<c:if test="${jl.gznx eq 1}">selected="selected"</c:if>>
											培训无实际工作经验
										</option>
										<option value="2"
											<c:if test="${jl.gznx eq 2}">selected="selected"</c:if>>
											一年以下
										</option>
										<option value="3"
											<c:if test="${jl.gznx eq 3}">selected="selected"</c:if>>
											1-2年工作经验
										</option>
										<option value="4"
											<c:if test="${jl.gznx eq 4}">selected="selected"</c:if>>
											2-3年工作经验
										</option>
										<option value="5"
											<c:if test="${jl.gznx eq 5}">selected="selected"</c:if>>
											3-5年工作经验
										</option>
										<option value="6"
											<c:if test="${jl.gznx eq 6}">selected="selected"</c:if>>
											6年以上
										</option>
									</select>
								</td>
							</TR>
							<TR>
								<th width="10%" align="center">
									<STRONG>
										人事负责人
									</STRONG>
								</th>
								<td>
									<select name="createBy">
										<option value="">
											全部
										</option>
										<c:forEach items="${users}" var="u">
											<option value="${u.id}">
												${u.username}
											</option>
										</c:forEach>
									</select>
								</td>
								<th colspan="4">
								</th>
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
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center">
										序号
									</th>
									<th align="center">
										简历名称
									</th>
									<th align="center">
										技术类型
									</th>
									<th align="center">
										简历来源
									</th>
									<th align="center">
										工作年限
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${jianLis}" var="jl" varStatus="status">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											${(page.currentPage-1)*page.everyPage + status.index + 1}
										</TD>
										<TD align="center">
											${jl.jianliName}
										</TD>
										<TD align="center">
											<c:if test="${jl.jishuLx eq 0}">java</c:if>
											<c:if test="${jl.jishuLx eq 1}">.net</c:if>
											<c:if test="${jl.jishuLx eq 2}">ios</c:if>
											<c:if test="${jl.jishuLx eq 3}">安卓</c:if>
											<c:if test="${jl.jishuLx eq 4}">web前端</c:if>
											<c:if test="${jl.jishuLx eq 5}">php</c:if>
											<c:if test="${jl.jishuLx eq 6}">其他</c:if>
										</TD>
										<TD align="center">
											<c:if test="${jl.jianliLy eq 0}">51JOb</c:if>
											<c:if test="${jl.jianliLy eq 1}">智联招聘</c:if>
											<c:if test="${jl.jianliLy eq 2}">中华英才</c:if>
											<c:if test="${jl.jianliLy eq 3}">猎聘</c:if>
											<c:if test="${jl.jianliLy eq 4}">58同城</c:if>
											<c:if test="${jl.jianliLy eq 5}">其他</c:if>
										</TD>
										<TD align="center">
											<c:if test="${jl.gznx eq 0}">暂无工作经验</c:if>
											<c:if test="${jl.gznx eq 1}">一年以下</c:if>
											<c:if test="${jl.gznx eq 2}">培训无实际工作经验</c:if>
											<c:if test="${jl.gznx eq 3}">1-2年工作经验</c:if>
											<c:if test="${jl.gznx eq 4}">2-3年工作经验</c:if>
											<c:if test="${jl.gznx eq 5}">3-5年工作经验</c:if>
											<c:if test="${jl.gznx eq 6}">6年以上</c:if>
										</TD>
										<TD width="200" align="center">
											<a
												href="<%=path%>/mianshiYaoQingController/seeJianli.go?pId=${jl.pId}"
												class="easyui-linkbutton" iconCls="icon-search" plain="true"><font
												color="black">查看</font>
											</a>
											<a
												href="<%=path%>/zhaoPinController/download.go?pId=${jl.pId}"
												class="easyui-linkbutton" iconCls="icon-search" plain="true"><font
												color="black">下载</font>
											</a>
											<a
												href="<%=path%>/mianshiYaoQingController/toAddYaoQing.go?pId=${jl.pId}"
												class="easyui-linkbutton" iconCls="icon-search" plain="true"><font
												color="black">电话邀请</font>
											</a>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/zhaoPinController/waipaijianliList.go" />
									</jsp:include>
								</table>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<script>

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'add': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/zhaoPinController/zengjiajianliInfo.go";
			document.forms[0].submit();
		},
		'query': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/zhaoPinController/waipaijianliList.go";
			document.forms[0].submit();
		},
		'see': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/zhaoPinController/toProcessRoleInfoPage.go?opt_type=1&dateid="+dateid;
			document.forms[0].submit();
		},
		'edite': function(t) {
			//执行事件
		    document.forms[0].action="<%=path%>/zhaoPinController/toProcessRoleInfoPage.go?opt_type=2&dateid="+dateid;
			document.forms[0].submit();
		},
		'refresh': function(t) {
			window.location.href="www.baidu.com";
		}
	  }

});

</script>
	</body>
</html>