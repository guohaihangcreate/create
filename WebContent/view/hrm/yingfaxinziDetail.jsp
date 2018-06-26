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
						<c:if test="${customerInfo.id eq null}">
							<li id="saveCustomer">
								&nbsp;&nbsp;&nbsp;&nbsp;新增客户
							</li>
						</c:if>
					</ul>
				</div>
				<!--右键代码结束-->
				<td valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form0" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR>
									<th colspan="4" style="text-align: left; color: black;">
										应发薪资详细
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										员工姓名
									</th>
									<TD class="BGCgray" width="40%">
									</TD>
									<th align="center" width="10%">
										员工身份证号
									</th>
									<TD class="BGCgray" width="40%">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										<span class="BGCgray">应发工资</span>
									</th>
									<TD class="BGCgray" width="40%">
										<input name="address" value="${customerInfo.address}"
											style="width: 350px">
										<span id="address_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										实发工资
									</th>
									<TD class="BGCgray" width="40%">
										<input name="website" value="${customerInfo.website}"
											style="width: 300px">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										补发工资
									</th>
									<TD class="BGCgray" width="40%">
									</TD>
									<th align="center" width="10%">
										基本工资
									</th>
									<TD class="BGCgray" width="40%">
										
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										加班薪资
									</th>
									<TD class="BGCgray" width="40%">
									</TD>
									<th align="center" width="10%">
										其他薪资
									</th>
									<TD class="BGCgray" width="40%">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										其他薪资说明
									</th>
									<TD class="BGCgray" colspan="3">
										
									</TD>
								</TR>
								<TR>
									<th colspan="4" style="text-align: left; color: black;">
									</th>
								</TR>
							</table>
						</form>
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
		'saveCustomer': function(t) {
			var state = 0;
			if($("input[name=customername]").val()==""){
				$("#customername_check").text("客户名称不能为空")
				state = 1;
			}
			var s_province = $("#s_province :selected");
			var s_city = $("#s_city :selected");
			var s_county = $("#s_county :selected");
			
			if(s_province.val()=="省份"||s_city.val()=="地级市"||s_county.val()=="市、县级市"){
				$("#s_check").text("所属区域不能为空")
				state = 1;
			}
			if($("input[name=address]").val()==""){
				$("#address_check").text("通讯地址不能为空")
				state = 1;
			}
		    jQuery.ajax({
		        type : 'GET',
		        contentType : 'text/json;charset=utf-8',
		        url : '<%=path%>/customerInfoController/validate.go',
		        data : {
		               customername : encodeURI($("#customername").val())
		           },
		        dataType : 'json',
		        success : function(data) {
		        	if(data.message==1){
		        		state = 1;
		        		alert("系统中已经存在该客户");
		        	}
		        },
		        error : function() {
		        	alert("请求错误");
		        }
		      });
			
			
			if(state == 1){
				return false;
			}
		    document.form0.action="<%=path%>/customerInfoController/insertContactInfro.go";
			document.form0.submit();
		},
		'editeCustomer': function(t) {
			//执行事件
			var state = 0;
			if($("input[name=customername]").val()==""){
				$("#customername_check").text("客户名称不能为空")
				state = 1;
			}
			var s_province = $("#s_province :selected");
			var s_city = $("#s_city :selected");
			var s_county = $("#s_county :selected");
			
			if(s_province.val()=="省份"||s_city.val()=="地级市"||s_county.val()=="市、县级市"){
				$("#s_check").text("所属区域不能为空")
				state = 1;
			}
			if($("input[name=address]").val()==""){
				$("#address_check").text("通讯地址不能为空")
				state = 1;
			}
			if(state == 1){
				return false;
			}
		    document.form0.action="<%=path%>/customerInfoController/editeCustomerInfo.go";
			document.form0.submit();
		}
		,
		'saveContact': function(t) {
			//执行事件
			var state = 0;
			if($("#contact_customerid").val()==""){
				$("#contact_customerid_check").text("请先新增客户信息，再进行本项操作！")
				state = 1;
			}
			if($("input[name=contactsname]").val()==""){
				$("#contactsname_check").text("联系人姓名不能为空")
				state = 1;
			}
			if($("input[name=telephone]").val()==""){
				$("#telephone_check").text("电话不能为空")
				state = 1;
			}
			if(state == 1){
				return false;
			}
<%--			return_type=01跳转到客户新增页面--%>
		    document.form1.action="<%=path%>/contactInfroController/insertContactInfro.go?type=0&return_type=1";
			document.form1.submit();
		},
		'editeContact': function(t) {
			//执行事件
			var state = 0;
			if($("#contact_customerid").val()==""){
				$("#contact_customerid_check").text("请先新增客户信息，再进行本项操作！")
				state = 1;
			}
			if($("input[name=contactsname]").val()==""){
				$("#contactsname_check").text("联系人姓名不能为空")
				state = 1;
			}
			if($("input[name=telephone]").val()==""){
				$("#telephone_check").text("电话不能为空")
				state = 1;
			}
			if(state == 1){
				return false;
			}
		    document.form1.action="<%=path%>/contactInfroController/insertContactInfro.go?type=1";
			document.form1.submit();
		}
		,
		'saveBankInfo': function(t) {
			//执行事件
			var state = 0;
			if($("#bank_customerid").val()==""){
				$("#bank_customerid_check").text("请先新增客户信息，再进行本项操作！")
				state = 1;
			}
			if($("input[name=bankname]").val()==""){
				$("#bankname_check").text("开户行名称不能为空")
				state = 1;
			}
			if($("input[name=customerbank]").val()==""){
				$("#customerbank_check").text("开户行不能为空")
				state = 1;
			}
			if($("input[name=account]").val()==""){
				$("#account_check").text("账户不能为空")
				state = 1;
			}
			if(state == 1){
				return false;
			}
			var contactInfro_id = $("#contactInfro_id").val();
		    document.form2.action="<%=path%>/customerBankInfroController/editeOrInsertCustomerBankInfro.go?type=0&contactInfro_id="+contactInfro_id;
			document.form2.submit();
		},
		'editeBankInfo': function(t) {
			//执行事件
			var state = 0;
			if($("#bank_customerid").val()==""){
				$("#bank_customerid_check").text("请先新增客户信息，再进行本项操作！")
				state = 1;
			}
			if($("input[name=bankname]").val()==""){
				$("#bankname_check").text("开户行名称不能为空")
				state = 1;
			}
			if($("input[name=customerbank]").val()==""){
				$("#customerbank_check").text("开户行不能为空")
				state = 1;
			}
			if($("input[name=account]").val()==""){
				$("#account_check").text("账户不能为空")
				state = 1;
			}
			if(state == 1){
				return false;
			}
			var contactInfro_id = $("#contactInfro_id").val();
		    document.form2.action="<%=path%>/customerBankInfroController/editeOrInsertCustomerBankInfro.go?type=1&contactInfro_id="+contactInfro_id;
			document.form2.submit();
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
		<script type="text/javascript">
		var Gid  = document.getElementById ;
		var showArea = function(){
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
			Gid('s_city').value + " - 县/区" + 
			Gid('s_county').value + "</h3>"
									}
		Gid('s_county').setAttribute('onchange','showArea()');
</script>
	</body>
</html>