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
	function toEditeInfo(Id){
		document.forms[0].action="<%=path%>/customerInfoController/toEditeCustomerInfo.go?&type=1&id="+Id;
		document.forms[0].submit();
	}
	
	function todeletInfo(Id){
		document.forms[0].action="<%=path%>/customerInfoController/editeCustomerInfo.go?id="+Id;
		document.forms[0].submit();
	}
	
   function mouseOver(obj){
        $(obj).css("background-color","green");
   }
   
   
   function mouseOut(obj){
      if(obj.id%2==0){
      	 $(obj).css("background-color","#e3efff");
      }else{
      	 $(obj).css("background-color","#ffffff");
      }
   }
   
   function download(){
		document.forms[0].action="<%=path%>/template/template_customer.xls";
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
				<li id="download">
					&nbsp;&nbsp;&nbsp;&nbsp;导入模板下载
				</li>
				<li id="importData">
					&nbsp;&nbsp;&nbsp;&nbsp;导入数据
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data"
			name="form0">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="20%" align="center">
									客户名称
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="customername" style="width: 200px;">
								</td>
								<th width="20%" align="center">
									通讯地址
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="address" style="width: 200px;">
								</td>
							</TR>
							<tr>
								<th width="20%" align="center">
									客户性质
								</th>
								<td width="30%" class="BGCgray">
									<select name="customerproperty">
											<option value="">
												全部
											</option>
											<option value="1">
												开发中
											</option>
											<option value="2">
												合作中
											</option>
											<option value="3">
												意向中
											</option>
											<option value="4">
												已合作客户
											</option>
										</select>
								</td>
								<th width="20%" align="center">
									招聘类型
								</th>
								<td width="30%" class="BGCgray">
									<input type="text" name="needproducts" style="width: 200px;">
								</td>
							</tr>
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
									</th>
									<th align="center">
										客户名称
									</th>
									<th align="center">
										地址
									</th>
									<th width="200" align="center">
										需求
									</th>
									<th width="200" align="center">
										客户性质
									</th>
									<th width="200" align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${customerInfoList}" var="customerInfo"
									varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)" id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox2" id="checkbox2" onselect="mouseOver(this)">
										</TD>
										<TD align="center" nowrap="nowrap" title="${customerInfo.customername}">
											<c:if test="${fn:length(customerInfo.customername)>8}">
												 ${fn:substring(customerInfo.customername, 0, 8)}......
											</c:if>
											<c:if test="${fn:length(customerInfo.customername)<=8}">
												 ${customerInfo.customername}
											 </c:if>
										</TD>
										<TD align="center" nowrap="nowrap" title="${customerInfo.address}">
											<c:if test="${fn:length(customerInfo.address)>8}">
												 ${fn:substring(customerInfo.address, 0, 8)}......
											</c:if>
											<c:if test="${fn:length(customerInfo.address)<=8}">
												 ${customerInfo.address}
											 </c:if>
										</TD>
										<TD align="center" nowrap="nowrap"  title="${customerInfo.needproducts}">
											<c:if test="${fn:length(customerInfo.needproducts)>8}">
												 ${fn:substring(customerInfo.needproducts, 0, 8)}......
											</c:if>
											<c:if test="${fn:length(customerInfo.needproducts)<=8}">
												 ${customerInfo.needproducts}
											 </c:if>
										</TD>
										<TD align="center" nowrap="nowrap">
											<c:if test="${customerInfo.customerproperty eq 1}">
												开发中
											</c:if>
											<c:if test="${customerInfo.customerproperty eq 2}">合作中</c:if>
											<c:if test="${customerInfo.customerproperty eq 3}">意向中</c:if>
											<c:if test="${customerInfo.customerproperty eq 4}">已合作客户</c:if>
										</TD>
										<TD width="200" align="center" nowrap="nowrap">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="toEditeInfo('${customerInfo.id}');">
												修改
											</BUTTON>
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="todeletInfo('${customerInfo.id}');">
												删除
											</BUTTON>
										</TD>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="6" /></th>
								</TR>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<jsp:include page="/page/page.jsp">
										<jsp:param name="url"
											value="/customerInfoController/queryCustomerInfoList.go?1=1" />
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
			document.form0.action="<%=path%>/customerInfoController/queryCustomerInfoList.go";
			document.form0.submit();
		},
		'refresh': function(t) {
			//执行事件
		  window.location.reload();
		},
		'download': function(t) {
			//执行事件
		  document.forms[0].action="<%=path%>/template/template_customer.xls";
		  document.forms[0].submit();
		},
		'importData': function(t) {
			//执行事件
		  window.location.href="<%=path%>/view/crm/importCustomerData.jsp";
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