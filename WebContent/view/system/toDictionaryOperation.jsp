<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
	</head>
	<body id="divtest">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<!--右键代码开始-->
				<div class="contextMenu" id="myMenu1" style="background-color: ">
					<ul>
						<!--图片地址为右键时，显示在菜单左边的小图标-->
						<c:if test="${dotype eq 0}">
							<li id="saveDictionary">
								&nbsp;&nbsp;&nbsp;&nbsp;新增
							</li>
						</c:if>
						<c:if test="${dotype eq 1}">
							<li id="updateDictionary">
								&nbsp;&nbsp;&nbsp;&nbsp;修改
							</li>
						</c:if>
						<li id="returnBack">
							&nbsp;&nbsp;&nbsp;&nbsp;返回
						</li>
					</ul>
				</div>
				<!--右键代码结束-->
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form1" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
										字典类信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										字典名称
									</th>
									<TD class="BGCgray" width="40%">
										<input name="dictName"
											<c:if test="${dotype eq 0}">value="${dictValue}"</c:if>
											value="${dictionary.dictName}"
											<c:if test="${dotype eq 2}">readonly="readonly"</c:if>>

									</TD>
									<th align="center" width="10%">
										字典数值
									</th>
									<TD width="80%" class="BGCgray" width="40%">
										<input name="dictValue" value="${dictionary.dictValue}"
											<c:if test="${dotype eq 2}">readonly="readonly"</c:if>>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										字典编码编码
									</th>
									<TD width="80%" class="BGCgray" width="40%">
										<input name="att1" value="${dictionary.att1}"
											<c:if test="${dotype eq 2}">readonly="readonly"</c:if>>
									</TD>
									<th align="center" width="10%">
										<span class="BGCgray">描述</span>
									</th>
									<TD class="BGCgray" width="40%">
										<input name="describe_dict"
											value="${dictionary.describe_dict}" type="text"
											id="describe_dict" size="50px;"
											<c:if test="${dotype eq 2}">readonly="readonly"</c:if>>
										<input name="id" value="${dictionary.id}"
											type="hidden" id="id">
									</TD>
									<th align="center" width="10%">
										<span class="BGCgray"></span>
									</th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'saveDictionary': function(t) {
			//执行事件
		    document.form1.action="<%=path%>/dictionaryController/saveDictionary.go?type=1";
			document.form1.submit();
		},
		'updateDictionary': function(t) {
			//执行事件
		    document.form1.action="<%=path%>/dictionaryController/upDateDictionary.go";
			document.form1.submit();
		},
		'returnBack': function(t) {
			//执行事件
		    window.history.go(-1);
		}
	  }

});


<%--日期框架--%>
var shengri = {
    elem: '#shengri',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
laydate(shengri);	
</script>
	</body>
</html>