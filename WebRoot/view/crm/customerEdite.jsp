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
	<body id="divtest">
		<table width="100%" border="0" cellspacing="0" cellpadding="3">
			<tr>
				<!--右键代码开始-->
				<div class="contextMenu" id="myMenu1" style="background-color: ">
					<ul>
						<!--图片地址为右键时，显示在菜单左边的小图标-->
						<li id="edteCustomer">
							&nbsp;&nbsp;&nbsp;&nbsp;修改客户
						</li>
						<li id="refresh">
							&nbsp;&nbsp;&nbsp;&nbsp;刷新
						</li>
						<li id="return_back">
							&nbsp;&nbsp;&nbsp;&nbsp;返回
						</li>
					</ul>
				</div>
				<!--右键代码结束-->
				<td valign="top" width="100%">
					<div style="overflow: auto; width: 100%">
						<form name="form0" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR>
									<th colspan="4" style="text-align: left; color: black;">
										客户信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										客户名称
									</th>
									<TD class="BGCgray" width="40%">
										<input name="customername"
											value="${customerInfo.customername}" style="width:300px;">
										<input name="id" id="customerid"  type="hidden" value="${customerInfo.id}">
									</TD>
									<th align="center" width="10%">
										所属区域
									</th>
									<TD class="BGCgray" width="40%">
										<select id="s_province" name="s_province">
											<option value="${customerInfo.s_province}"
												selected="selected">
												${customerInfo.s_province}
											</option>
										</select>
										<select id="s_city" name="s_city">
											<option value="${customerInfo.s_city}" selected="selected">
												${customerInfo.s_city}
											</option>
										</select>
										<select id="s_county" name="s_county" selected="selected">
											<option value="${customerInfo.s_county}" selected="selected">
												${customerInfo.s_county}
											</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										<span class="BGCgray">通讯地址</span>
									</th>
									<TD class="BGCgray" width="40%">
										<input name="address" value="${customerInfo.address}" style="width:400px;">
									</TD>
									<th align="center" width="10%">
										公司网址
									</th>
									<TD class="BGCgray" width="40%">
										<input name="website" value="${customerInfo.website}" style="width:300px;">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										客户信用等级
									</th>
									<TD class="BGCgray" width="40%">
										<select name="creditrating">
											<option value="0"
												<c:if test="${customerInfo.creditrating eq 0}">selected="selected"</c:if>>
												一级
											</option>
											<option value="1"
												<c:if test="${customerInfo.creditrating eq 1}">selected="selected"</c:if>>
												二级
											</option>
										</select>
									</TD>
									<th align="center" width="10%">
										客户等级
									</th>
									<TD class="BGCgray" width="40%">
										A类
										<input type="radio" name="customrate" value="1"
											checked="checked">
										&nbsp;B类
										<input type="radio" value="2" name="customrate">
										&nbsp;C类
										<input type="radio" name="type">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										客户性质
									</th>
									<TD class="BGCgray" width="40%">
										<select name="customerproperty">
											<option value="1"
												<c:if test="${customerInfo.customerproperty eq 1}">selected="selected"</c:if>>
												开发中
											</option>
											<option value="2"
												<c:if test="${customerInfo.customerproperty eq 2}">selected="selected"</c:if>>
												合作中
											</option>
											<option value="3"
												<c:if test="${customerInfo.customerproperty eq 3}">selected="selected"</c:if>>
												意向中
											</option>
											<option value="4"
												<c:if test="${customerInfo.customerproperty eq 4}">selected="selected"</c:if>>
												已合作客户
											</option>
										</select>
									</TD>
									<th align="center" width="10%">
										主要经营
									</th>
									<TD class="BGCgray" width="40%">
										<textarea rows="3" cols="60" name="business">${customerInfo.business}</textarea>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										需要工程师类型
									</th>
									<TD class="BGCgray" width="40%">
										<input name="needproducts"
											value="${customerInfo.needproducts}" style="width:300px;">
									</TD>
									<th align="center" width="10%">
										行业分类
									</th>
									<TD class="BGCgray" width="40%">
										<input name="industry" value="${customerInfo.industry}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										销售人员
									</th>
										<TD class="BGCgray" colspan="3">
										<input id="sale_view" name="sale_view"  value="${customerInfo.att5}" readonly="readonly">
										&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton"
													iconCls="icon-search" plain="true"
													onclick="$('#myWindow_2').window('open');"><font
													color="bule">选择销售人员</font> </a>
										<input id="sale" name="sale" value="${customerInfo.sale}" type="hidden">
									</TD>
								</TR>
							</table>
						</form>
						<div id="myWindow_2" class="easyui-window" title="选择销售人员"
							data-options="modal:true,closed:true,iconCls:'icon-save'"
							style="width: 65%; height: 60%; padding: 0px;">
							<iframe name="authIframe" id="authIframe"
								src="<%=path%>/userController/select_userData.go?type=selectUser" width="100%"
								height="150%" scrolling="no"></iframe>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td valign="top" width="100%">
					<div style="overflow: auto; width: 100%; height: 100%;">
						<iframe style='width: 100%; height: 300%'
							src="<%=path%>/view/crm/customerRelevantInformation.jsp?customerId=${customerInfo.id}"
							class=tabs-iframe frameborder="no" border="0" marginwidth="0"
							marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
					</div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		_init_area();
		//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'edteCustomer': function(t) {
			//执行事件
		    document.form0.action="<%=path%>/customerInfoController/editeCustomerInfo.go?type=1";
			document.form0.submit();
		},
		'return_back': function(t) {
			//执行事件
		  document.form0.action="<%=path%>/customerInfoController/queryCustomerInfoList.go?customerInfo=null";
		  document.form0.submit();
<%--			  window.history.go(-1);--%>
		},
		'refresh': function(t) {
			//执行事件
		  window.location.reload();
		}
	  }

});


<%--日期框架--%>
var birthday = {
    elem: '#brithday',
    format: 'YYYY-MM-DD',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
laydate(birthday);	
</script>
		<script type="text/javascript">
		var Gid  = document.getElementById("");
		var showArea = function(){
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
			Gid('s_city').value + " - 县/区" + 
			Gid('s_county').value + "</h3>"
									}
		Gid('s_county').setAttribute('onchange','showArea()');
		
		
</script>
	</body>
</html>