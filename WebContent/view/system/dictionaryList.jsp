<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>




<script type="text/javascript">
	
	function toSeeDictionary(id){
		document.form0.action="<%=path%>/dictionaryController/toDictionaryOperation.go?dotype=2&id="+id;
		document.form0.submit();
	}
	
	function toUpdateDictionary(id){
		document.form0.action="<%=path%>/dictionaryController/toDictionaryOperation.go?dotype=1&id="+id;
		document.form0.submit();
	}
	
	function toDeleteDictionary(id){
		document.form0.action="<%=path%>/dictionaryController/upDateDictionary.go?isdeleted=1&id="+id;
		document.form0.submit();
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
				<li id="toadd">
					&nbsp;&nbsp;&nbsp;&nbsp;新增
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" name="form0" method="post"
			enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									字典类型名称
								</th>
								<td width="25%" class="BGCgray">
									<input type="text" name="dictName" style="width: 100px;">
								</td>
								<th width="10%" align="center">
									备注说明
								</th>
								<td width="25%" class="BGCgray">
									<input name="describe_dict">
								</td>
								<th width="8%" align="center">
									创建者
								</th>
								<td width="10%" class="BGCgray">
									<input type="text" name="createdby" id="createdby">
								</td>
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
										序号
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center">
										字典类型名称
									</th>
									<th align="center">
										描述说明
									</th>
									<th width="200" align="center">
										创建者
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${dictionaryInfoList}" var="dictionary">
									<TR class="BGCgray">
										<TD align="center">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center">
											<a href="<%=path%>/dictionaryController/queryDictionaryDataList.go?dictValue=${dictionary.id}">
												<font color="blue">${dictionary.dictName}</font></a>
										</TD>
										<TD align="center">
											${dictionary.describe_dict}
										</TD>
										<TD align="center">
											${dictionary.createdby}
										</TD>
										<TD width="200" align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toSeeDictionary('${dictionary.id}');">
												查看详细
											</BUTTON>
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toUpdateDictionary('${dictionary.id}');">
												修改
											</BUTTON>
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toDeleteDictionary('${dictionary.id}');">
												删除
											</BUTTON>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="dictionaryController/queryDictionaryList.go" />
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
		'query': function(t) {
			//执行事件
		    document.form0.action="<%=path%>/dictionaryController/queryDictionaryList.go";
			document.form0.submit();
		},
		'toadd': function(t) {
			//执行事件
		    document.form0.action="<%=path%>/dictionaryController/toDictionaryOperation.go?dotype=0";
			document.form0.submit();
		}
	  }

});


<%--日期框架--%>

var start = {
    elem: '#start',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var end = {
    elem: '#end',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(start);
laydate(end);

var msstart = {
    elem: '#msstart',
    format: 'YYYY/MM/DD hh:mm:ss',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var msend = {
    elem: '#msend',
    format: 'YYYY/MM/DD hh:mm:ss',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(msstart);
laydate(msend);
<%--日期框架--%>

</script>
	</body>
</html>