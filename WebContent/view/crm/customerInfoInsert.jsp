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
						<c:if test="${customerInfo.id ne null}">
							<li id="editeCustomer">
								&nbsp;&nbsp;&nbsp;&nbsp;修改客户
							</li>
						</c:if>
						<c:if test="${contactInfro.id eq null}">
							<li id="saveContact">
								&nbsp;&nbsp;&nbsp;&nbsp;新增联系人
							</li>
						</c:if>
						<c:if test="${contactInfro.id ne null}">
							<li id="editeContact">
								&nbsp;&nbsp;&nbsp;&nbsp;修改联系人
							</li>
						</c:if>
						<c:if test="${customerBankInfro.id eq null}">
							<li id="saveBankInfo">
								&nbsp;&nbsp;&nbsp;&nbsp;新增开户行
							</li>
						</c:if>
						<c:if test="${customerBankInfro.id ne null}">
							<li id="editeBankInfo">
								&nbsp;&nbsp;&nbsp;&nbsp;修改开户行
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
										客户信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										客户名称
									</th>
									<TD class="BGCgray" width="40%">
										<input name="customername" id="customername"
											value="${customerInfo.customername}" style="width: 300px">
										<span id="customername_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										所属区域
									</th>
									<TD class="BGCgray" width="40%">
										<select id="s_province" name="s_province">
											<option value="${customerInfo.s_province}">
												${customerInfo.s_province}
											</option>
										</select>
										<select id="s_city" name="s_city">
											<option value="${customerInfo.s_city}">
												${customerInfo.s_province}
											</option>
										</select>
										<select id="s_county" name="s_county">
											${customerInfo.s_province}
										</select>
										<span id="s_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										<span class="BGCgray">通讯地址</span>
									</th>
									<TD class="BGCgray" width="40%">
										<input name="address" value="${customerInfo.address}"
											style="width: 350px">
										<span id="address_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										公司网址
									</th>
									<TD class="BGCgray" width="40%">
										<input name="website" value="${customerInfo.website}"
											style="width: 300px">
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
											value="${customerInfo.needproducts}" style="width: 300px">
									</TD>
									<th align="center" width="10%">
										行业分类
									</th>
									<TD class="BGCgray" width="40%">
										<input name="industry" value="${customerInfo.industry}"
											style="width: 300px">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										销售人员
									</th>
									<TD class="BGCgray" colspan="3">
										<input name="sale_view" value="${user.username}"
											id="sale_view" readonly="readonly">
										&nbsp;&nbsp;
										<a href="javascript:void(0)" class="easyui-linkbutton"
											iconCls="icon-search" plain="true"
											onclick="$('#myWindow_2').window('open');"><font
											color="bule">选择销售人员</font> </a>
										<input id="sale" name="sale" value="${user.id}" type="hidden">
									</TD>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form1" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
										联系人信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										姓名
									</th>
									<TD class="BGCgray" width="40%">
										<input name="contactsname"
											value="${contactInfro.contactsname}">
										<input name="id" value="${contactInfro.id}"
											id="contactInfro_id" type="hidden">
										<span id="contactsname_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										性别
									</th>
									<TD width="80%" class="BGCgray" width="40%">
										男
										<input type="radio"
											<c:if test="${customerInfo.customerproperty eq 0 or customerInfo.customerproperty eq null}">checked="checked"</c:if>
											name="sex" value="0">
										&nbsp;女
										<input type="radio" name="sex" value="1"
											<c:if test="${customerInfo.customerproperty eq 1 or customerInfo.customerproperty eq null}">checked="checked"
										</c:if>>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										<span class="BGCgray">电话</span>
									</th>
									<TD class="BGCgray" width="40%">
										<input name="telephone" type="text"
											value="${contactInfro.telephone}" id="telephone">
										<span id="telephone_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										手机号
									</th>
									<TD class="BGCgray" width="40%">
										<input name="phone" value="${contactInfro.phone}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										传真
									</th>
									<TD class="BGCgray" width="40%">
										<input name="fax" value="${contactInfro.fax}">
									</TD>
									<th align="center" width="10%">
										电子邮件
									</th>
									<TD class="BGCgray" width="40%">
										<input name="email" value="${contactInfro.email}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										角色
									</th>
									<TD class="BGCgray" width="40%">
										<input name="role" value="${contactInfro.role}">
									</TD>
									<th align="center" width="10%">
										部门
									</th>
									<TD class="BGCgray" width="40%">
										<input name="dept" value="${contactInfro.dept}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										职务
									</th>
									<TD class="BGCgray" width="40%">
										<input name="post" value="${contactInfro.post}">
									</TD>
									<th align="center" width="10%">
										生日
									</th>
									<TD class="BGCgray" width="40%">
										<input type="text" name="shengri" class="laydate-icon"
											id="shengri" value="${contactInfro.brithday}"
											style="width: 100px;">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										msn
									</th>
									<TD class="BGCgray" width="40%">
										<input name="msn" value="${contactInfro.msn}">
									</TD>
									<th align="center" width="10%">
										联系人级别
									</th>
									<TD class="BGCgray" width="40%">
										<input name="level" value="${contactInfro.level}">
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										英文姓名
									</th>
									<TD class="BGCgray" width="40%">
										<input name="englishname" value="${contactInfro.englishname}">
									</TD>
									<th align="center" width="10%">
										QQ
									</th>
									<TD class="BGCgray" width="40%">
										<input name="qq" value="${contactInfro.qq}">
										<input value="${customerInfo.id}" name="customerid"
											id="contact_customerid" type="hidden">
										<span id="contact_customerid_check" style="color: red;"
											style="width: 400px;"></span>
									</TD>
								</TR>
							</table>
						</form>
						<div id="myWindow_2" class="easyui-window" title="选择销售人员"
							data-options="modal:true,closed:true,iconCls:'icon-save'"
							style="width: 65%; height: 60%; padding: 0px;">
							<iframe name="authIframe" id="authIframe"
								src="<%=path%>/userController/select_userData.go?type=selectUser"
								width="100%" height="150%" scrolling="no"></iframe>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; width: 100%">
						<form name="form2" action="" method="post"
							enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								class="table1">
								<TR height="5%">
									<th colspan="4" style="text-align: left; color: black;">
										开户行信息
									</th>
								</TR>
								<TR>
									<th width="10%" align="center">
										开户行名称
									</th>
									<TD class="BGCgray" width="40%">
										<input name="bankname" value="${customerBankInfro.bankname}"
											style="width: 400px;">
										<span id="bankname_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										开户行
									</th>
									<TD class="BGCgray" width="40%">
										<input name="customerbank"
											value="${customerBankInfro.customerbank}"
											style="width: 400px;">
										<span id="customerbank_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th align="center" width="10%">
										账户
									</th>
									<TD width="40%" class="BGCgray">
										<input name="account" value="${customerBankInfro.account}"
											style="width: 400px;">
										<span id="account_check" style="color: red;">*</span>
									</TD>
									<th align="center" width="10%">
										备注
									</th>
									<TD width="40%" class="BGCgray">
										<textarea rows="3" cols="60">${customerBankInfro.beizhu}</textarea>
										<input value="${customerInfo.id}" name="customerid"
											id="bank_customerid" type="hidden">
										<span id="bank_customerid_check" style="color: red;"
											style="width: 400px;"></span>
									</TD>
								</TR>
								<TR height="5%">
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