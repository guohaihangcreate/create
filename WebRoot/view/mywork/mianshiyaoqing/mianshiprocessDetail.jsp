<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>面试过程跟踪</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript">
<%--			面试通过，显示是否发送offer--%>
			$(document).ready(function(){
			  $("p").click(function(){
			  	$(this).hide();
			  });
			});
<%--			面试不通过，隐藏是否发送offer--%>
			$(document).ready(function(){
			  $("#msjg").change(function(){
<%--			  面试通过--%>
			  	if(this.value==0){
			  		$("input[name=att4]").attr("checked",'1');
			  		$("tr#sfxyoffer").css("display","");
			  	}else{
			  		hiddenMessageDetail();
			  		$("tr#sfxyoffer").css("display","none");
			  	}
			  	
			  });
			});
			
<%--			显示offer信息--%>
			function showMessageDetail(){
				$("tr [title=offeratt]").css("display",'');
			}
<%--			隐藏offer信息--%>
			function hiddenMessageDetail(){
				$("tr [title=offeratt]").css("display",'none');
			}
			
			function getsyqgz(){
				var sqgz = $("input[name=sqgz]").val();
				var syqgzbl = $("input[name=syqgzbl]").val();
				$("input[name=syqgz]").val(parseFloat(sqgz)*parseFloat(syqgzbl)/100);
			}
			
		</script>
	</head>
	<body id="divtest">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<!--右键代码开始-->
			<div class="contextMenu" id="myMenu1" style="background-color: ">
				<ul>
					<li id="save">
						&nbsp;&nbsp;&nbsp;&nbsp;保存
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
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%"
						class="table1">
						<form action="" method="post" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th width="20%" align="center">
										客户名称
									</th>
									<TD class="BGCgray">
										<input type="hidden" name="khid" value="${customerInfo.id}">
										${customerInfo.customername}
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										面试官
									</th>
									<TD class="BGCgray">
										<input type="text" name="yl1">
										<input type="hidden" name="yqid"
											value="${InterviewInvitation_id}">
									</TD>
								</TR>
								<TR>
									<th width="20%" align="center">
										面试结果
									</th>
									<TD class="BGCgray">
										<select id="msjg" name="msjg">
											<option value="0">
												通过
											</option>
											<option value="1" selected="selected">
												待定
											</option>
											<option value="2">
												淘汰
											</option>
										</select>
									</TD>
								</TR>
								<TR>
									<th align="center">
										备注
									</th>
									<TD width="80%" class="BGCgray">
										<textarea rows="8" cols="60" name="bz"></textarea>
										(输入工作年限，毕业年限等补充信息)
									</TD>
								</TR>
								<TR style="display: none;" title="canoffer" id="sfxyoffer">
									<th width="20%" align="center">
										是否发offer
									</th>
									<TD class="BGCgray">
										<input name="att4" type="radio" value="1" checked="checked"
											onchange="showMessageDetail();">
										是
										<input name="att4" type="radio" value="0"
											onchange="hiddenMessageDetail();">
										否&nbsp;&nbsp;&nbsp;&nbsp;(offer会以邮件形式发送到面试通过者的邮箱)
									</TD>
								</TR>
								<TR style="display: none" title="offeratt" id="email_att">
									<th width="20%" align="center">
										应聘者邮箱
									</th>
									<TD class="BGCgray">
										<input type="text" name="email" value="${jianli.email}"
											style="width: 600px;">
										<span id="email_check" style="color: red;">*</span>(多个邮件地址请用;号分开)
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										抄送邮箱
									</th>
									<TD class="BGCgray">
										<input type="text" name="email_cc" value=""
											style="width: 600px;">
										<span id="email_cc_check" style="color: red;"></span>(多个邮件地址请用;号分开)
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										密送邮箱
									</th>
									<TD class="BGCgray">
										<input type="text" name="email_mm" value=""
											style="width: 600px;">
										<span id="email_mm_check" style="color: red;"></span>(多个邮件地址请用;号分开)
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										offer模版
									</th>
									<TD class="BGCgray">
										<select name="offerTemplate">
											<option selected="selected" value="0">
												offer模版1
											</option>
											<option value="1">
												offer模版2
											</option>
											<option value="2">
												offer模版1
											</option>
										</select>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										入职部门
									</th>
									<TD class="BGCgray">
										<select id="rzbm" name="rzbm_str">
											<option selected="selected" value="人事部">
												人事部
											</option>
											<option value="项目部">
												项目部
											</option>
											<option value="财务部">
												财务部
											</option>
										</select>
										<span id="rzbm_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										岗位
									</th>
									<TD class="BGCgray">
										<input name="gw_str" value="">
										<span id="gw_str_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										身份证号码
									</th>
									<TD class="BGCgray">
										<input name="id_no" value=""  style="width:300px;">
									</TD>
								</TR>
								<TR style="display: none" title="internalstaff">
									<th width="20%" align="center">
										是否内部员工
									</th>
									<TD class="BGCgray">
										内部员工<input name="internalstaff" value="1" type="radio" checked="checked">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										外部员工<input name="internalstaff" value="0" type="radio">
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										入职时间
									</th>
									<TD class="BGCgray">
										<input class="laydate-icon" value="${ruzhishijian}"
											readonly="readonly" name="rzstartDatetime"
											id="rzstartDatetime">
										到
										<input class="laydate-icon" value="${ruzhishijian}"
											readonly="readonly" name="rzendDatetime" id="rzendDatetime">
										<span id="rzstartDatetime_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										入职联系人
									</th>
									<TD class="BGCgray">
										<input type="text" name="lianxiren">
										<span id="lianxiren_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										入职联系人电话
									</th>
									<TD class="BGCgray">
										<input type="text" name="rzlxrtele"  style="width:200px;">
										<span id="rzlxrtele_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										薪资税前
									</th>
									<TD class="BGCgray">
										<input type="text" name="sqgz" onchange="getsyqgz()">
										<span id="sqgz_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										试用期工资比例
									</th>
									<TD class="BGCgray">
										<input type="text" name="syqgzbl" onchange="getsyqgz()"
											value="80">
										%
										<span id="syqgzbl_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										试用期工资
									</th>
									<TD class="BGCgray">
										<input type="text" name="syqgz" readonly="readonly">
										<label>
											<font color="red">（系统自动生成） 
										</label>
									</TD>
								</TR>
								<TR style="display: none" title="offeratt">
									<th width="20%" align="center">
										试用期
									</th>
									<TD class="BGCgray">
										<input type="text" name="syq" value="3">
										月
										<span id="syq_check" style="color: red;">*</span>
									</TD>
								</TR>
								<TR>
									<th align="center" colspan="2"></th>
								</TR>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</body>

	<script>

//样式一JS代码
 $('#divtest').contextMenu('myMenu1', 
 {
	  bindings: 
	  {
		'refresh': function(t) {
			//执行事件
			window.location.reload();
		},
		'return_back': function(t) {
			//执行事件
			window.history.go(-1);
		},
		'save': function(t) {
			//执行事件
			var state = 0;
			var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			var msjg = $("#msjg :selected");
<%--		只有面试通过才可以验证--%>
			if(msjg.val()==0&&$("input[name=att4]:checked").val()==1){
					if($("input[name=email]").val()!=""){
						var message_="";
						var emails = $("input[name=email]").val().split(";");
						if(emails.length>1){
							for(var e=0;e<emails.length;e++){
								if(!reg.test(emails[e])) {
									    message_ ="请输入有效的邮箱地址！";
									    state = 1;
									}
							}
						}else{
							if(!reg.test(emails[0])) {
									    message_ ="请输入有效的邮箱地址！";
									    state = 1;
									}
						}
						$("#email_check").text(message_);
					}
					
					if($("input[name=email_cc]").val()!=""){
						var message_="";
						var email_ccs = $("input[name=email_cc]").val().split(";");
						if(email_ccs.length>1){
							for(var c=0;c<email_ccs.length;c++){
								if(!reg.test(email_ccs[c])) {
									    message_ ="请输入有效的邮箱地址！";
									    state = 1;
									}
							}
						}else{
							if(!reg.test(email_ccs[0])) {
									    message_ ="请输入有效的邮箱地址！";
									    state = 1;
									}
						}
						$("#email_cc_check").text(message_);
					}
					  
					if($("input[name=email_mm]").val()!=""){
						var message_="";
						var mms = $("input[name=email_mm]").val().split(";");
						if(emails.length>1){
							for(var m=0;m<mms.length;m++){
								if(!reg.test(mms[m])) {
									    message_ ="请输入有效的邮箱地址！";
									    state = 1;
									}
							}
						}else{
							if(!reg.test(mms[0])) {
									    message_ ="请输入有效的邮箱地址！";
									    state = 1;
									}
						}
						$("#email_mm_check").text(message_);
					}
					var rzbmcheckbox = $("#rzbm :selected");
					if(rzbmcheckbox.val()==""){
						state = 1;
						$("#rzbm_check").text("入职部门不能为空")
					}
					if($("input[name=gw_str]").val()==""){
						$("#gw_str_check").text("岗位不能为空")
						state = 1;
					}
					
					if($("input[name=rzstartDatetime]").val()==""){
						$("#rzstartDatetime_check").text("入职开始时间不能为空")
						state = 1;
					}
					if($("input[name=rzendDatetime]").val()=="请选择面试时间"){
						$("#rzstartDatetime_check").text("入职时间不能为空")
						state = 1;
					}
					if($("input[name=lianxiren]").val()==""){
						$("#lianxiren_check").text("入职联系人不能为空")
						state = 1;
					}
					if($("input[name=rzlxrtele]").val()==""){
						$("#rzlxrtele_check").text("入职联系人电话不能为空")
						state = 1;
					}
					if($("input[name=sqgz]").val()==""){
						$("#sqgz_check").text("薪资税前不能为空")
						state = 1;
					}
					if($("input[name=syq]").val()==""){
						$("#syq_check").text("试用期不能为空")
						state = 1;
					}
				}
			if(state == 1){
				return false;
			}
			var s = window.confirm("本次邀约如果已经面试通过只保存一次记录offer可以正常发送,是否要下一步？");
			if(!s){
				return false;
			}
		    document.forms[0].action="<%=path%>/mianshiProcessDetailController/saveProcessDetail.go?pId="+${jlID};
			document.forms[0].submit();
		}
	  }

});


<%--日期框架--%>

var rzstartDatetime = {
    elem: '#rzstartDatetime',
    format: 'YYYY/MM/DD hh:mm',
    max: '2099-06-16 23:59:59', //最大日期
    istime: true,
    istoday: false,
    choose: function(datas){
         end.min = datas; //开始日选好后，重置结束日的最小日期
         end.start = datas //将结束日的初始值设定为开始日
    }
};
var rzendDatetime = {
    elem: '#rzendDatetime',
    format: 'YYYY/MM/DD hh:mm',
    max: '2099-06-16 23:59:59',
    istime: true,
    istoday: false,
    choose: function(datas){
        start.max = datas; //结束日选好后，重置开始日的最大日期
    }
};
laydate(rzstartDatetime);
laydate(rzendDatetime);
<%--日期框架--%>

</script>
</html>