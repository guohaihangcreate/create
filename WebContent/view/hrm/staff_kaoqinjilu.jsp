<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>员工考勤结果</title>
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
		var firstday;
		var lastday;
		window.onload=function(){ 
                  firstday='<%=request.getAttribute("firstday")%>';
                  lastday='<%=request.getAttribute("lastday")%>';
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
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
					<li id="query" style="border-bottom-style: dotted">
						&nbsp;&nbsp;&nbsp;&nbsp;查询
					</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form name="form0" action="">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									考勤日期
								</th>
								<td width="40%" class="BGCgray">
									<input type="text" name="kq_start" class="laydate-icon" id="kq_start" value="${firstday}"
										style="width: 200px;">
									&nbsp;至&nbsp;
									<input type="text" class="laydate-icon" name="kq_end" id="kq_end"  value="${lastday}"
										style="width: 200px;">
								</td>
								<th width="10%" align="center">
									查询类型
								</th>
								<td width="40%" class="BGCgray">
									查询全部<input type="radio" name="cx_type"  checked="checked"  value="0"
										style="width: 100px;">
									&nbsp;&nbsp;
									仅查询异常<input type="radio"  name="cx_type"   value="1"
										style="width: 100px;">&nbsp;&nbsp;
										<input type="hidden" name="myYear" value="${myYear}">
										<input type="hidden" name="userid" value="${userid}">
										<input type="hidden" name="month" value="${month}">
										<input type="hidden" id="firstday" name="firstday" value="${firstday}">
										<input type="hidden" id="lastday" name="lastday" value="${lastday}">
								</td>
							</TR>
							<TR>
								<th colspan="4">
									<div style="width: 80px;height: 20px;float: left;margin-right: 0px;background: yellow;">迟到-早退</div><div style="width: 80px;height: 20px;float: left;margin-right: 20px;background: red;">旷工</div>
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
										<input type="checkbox" name="checkbox2" id="checkbox">
									</th>
									<th align="center">
										员工姓名
									</th>
									<th align="center">
										考勤日期
									</th>
									<th align="center">
										考勤时间
									</th>
									<th align="center">
										打卡时间
									</th>
									<th align="center">
										打卡结果
									</th>
									<th align="center">
										操作
									</th>
								</TR>
								<c:forEach items="${list_kqdetail}" var="kaoqinDetail" varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
										<c:if test="${kaoqinDetail.state eq 2 || kaoqinDetail.state eq 3}">style="background: yellow;"</c:if> 
										<c:if test="${kaoqinDetail.state eq 4}">style="background: red;"</c:if>
										id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox2" title="${user.id}"
												value="${user.id}" onselect="mouseOver(this)">
										</TD>
										<TD align="center" id="${kaoqinDetail.userid}">
											${kaoqinDetail.userName}
										</TD>
										<TD align="center">
											<fmt:formatDate value="${kaoqinDetail.kqdate}" pattern="yyyy-MM-dd" />&nbsp;${kaoqinDetail.yl2}
										</TD>
										<TD align="center">
											<fmt:formatDate value="${kaoqinDetail.kqtime}" pattern="yyyy-MM-dd HH:mm" />
										</TD>
										<TD align="center">
											<fmt:formatDate value="${kaoqinDetail.dktime}" pattern="yyyy-MM-dd HH:mm" />
										</TD>
										<TD align="center">
											${kaoqinDetail.state_str}
										</TD>
										<TD align="center">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="shijifafang_detail('${payrollReport.user.id}','${payrollReport.user.username}');">
												查看考勤打卡情況
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
											value="/AttendanceController/queryKaoQinReultByUserId.go?type=1" />
									</jsp:include>
								</table>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>

	<script type="text/javascript">
	//样式一JS代码
	 $('#divtest').contextMenu('myMenu1', 
	 {
	 	
		  bindings: 
		  {
			'query': function(t) {
<%--				获取数据--%>
				var kq_start = $('#kq_start').val();
				var kq_end = $('#kq_end').val();
				  if(kq_start!=""&&kq_end!="")  
					 {  
					 	var firstday = $('#firstday').val();
					 	var lastday = $('#lastday').val();
					 	if(firstday>kq_start){
					 		alert("开始时间越界,请选择 "+firstday+"到 "+lastday+" 进行查询");
					 		return false;
					 	}
					 	if(lastday<kq_end){
					 		alert("结束时间越界,请选择 "+firstday+"到 "+lastday+" 进行查询");
					 		return false;
					 	}
					 }
				var cx_type = $('input[name="cx_type"]:checked ').val();
				//执行事件
			    document.form0.action="<%=path%>/AttendanceController/queryKaoQinReultByParamter.go?kq_start="+kq_start+"&kq_end="+kq_end+"&cx_type="+cx_type;
				document.form0.submit();
			}
		  }
	});
	
	<%--日期框架--%>
	var kq_start = {
	    elem: '#kq_start',
	    format: 'YYYY-MM-DD',
	    min: firstday,  // 最小日期
        max: lastday, // 最大日期
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	         kq_end.min = datas; //开始日选好后，重置结束日的最小日期
	         kq_end.start = datas //将结束日的初始值设定为开始日
	    }
	};
	var kq_end = {
	    elem: '#kq_end',
	    format: 'YYYY-MM-DD',
	    min: firstday,  // 最小日期
        max: lastday, // 最大日期
	    istime: true,
	    istoday: false,
	    choose: function(datas){
	        kq_end.max = datas; //结束日选好后，重置开始日的最大日期
	    }
	};
	laydate(kq_start);
	laydate(kq_end);
	</script>
</html>