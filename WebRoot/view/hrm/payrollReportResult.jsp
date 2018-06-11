<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>薪酬福利</title>
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
		//设置月份的选择
			window.onload=function(){ 
				//设置年份的选择 
				var myDate= new Date(); 
				var startYear=myDate.getFullYear()-50;//起始年份 
				var endYear=myDate.getFullYear()+50;//结束年份 
				var obj=document.getElementById('myYear') 
				for (var i=startYear;i<=endYear;i++) 
				{ 
				  obj.options.add(new Option(i,i)); 
				} 
				obj.options[obj.options.length-51].selected=1; 
				//设置月份的选择
				var obj_month=document.getElementById('myMonth') 
				var nowmonth = myDate.getMonth();
				for (var i=0;i<=11;i++) 
				{ 
				  obj_month.options.add(new Option(i+1,i)); 
				} 
				obj_month.options[nowmonth].selected=1; 
			} 
			
			
			//合并表格第一列相同内容  tabObj（需要合并的Table的ID） colIndex（需要合并的列序号）
         function mergeTable(tabObj,colIndex){
            if(tabObj != null){
                var i,j;
                var intSpan;
                var strTemp;
                for(i = 1; i < tabObj.rows.length-1; i++){
                    intSpan = 1;
                    strTemp = tabObj.rows[i].cells[colIndex].innerText;
                    for(j = i + 1; j < tabObj.rows.length; j++){
                        if(strTemp == tabObj.rows[j].cells[colIndex].innerText){
                            intSpan++;
                            tabObj.rows[i].cells[colIndex].rowSpan = intSpan;
                            tabObj.rows[j].cells[colIndex].style.display = "none";
                        }else{
                            break;
                        }
                    }
                    i = j - 1;
                }
            }
        }
      
          
        function kaoqinresult(userid,username){
			   	var month = $('#myMonth option:selected') .val();
			   	var myYear = $('#myYear option:selected') .val();
			    document.form0.action="<%=path%>/AttendanceController/queryKaoQinReultByUserId.go?userid="+userid+"&username="+username+"&month="+month+"&myYear="+myYear;
        }
        
        function shijifafang_detail(userid,username){
			   	var month = $('#myMonth option:selected') .val();
			   	var myYear = $('#myYear option:selected') .val();
			    document.form0.action="<%=path%>/view/hrm/yingfaxinziDetail.jsp?userid="+userid+"&username="+username+"&month="+month+"&myYear="+myYear;
        }
        
		</script>
	</head>
	<body id="divtest"  onload="mergeTable(tab1,1);">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="importData">
					&nbsp;&nbsp;&nbsp;&nbsp;导入考勤表
				</li>
			</ul>
		</div>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
					<td
						style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="10%" align="center">
									客户名称
								</th>
								<td width="15%" class="BGCgray">
									<input type="text" name="username" style="width: 200px;">
								</td>
								<th width="10%" align="center">
									员工姓名
								</th>
								<td width="15%" class="BGCgray">
									<select name="status">
										<option value="0" selected="selected">正式员工</option>
										<option value="2">正式员工</option>
									</select>
								</td>
								<th width="10%" align="center">
									年份
								</th>
								<td width="15%" class="BGCgray">
									<select id="myYear" name="myYear">
									</select>
								</td>
								<th width="10%" align="center">
									月份
								</th>
								<td width="15%" class="BGCgray">
									<select id="myMonth" name="myMonth">
										<option></option>
									</select>
								</td>
							</TR>
						</table>
					</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<form action="" method="post" name="form0" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1" id="tab1">
									<tr>
										<th  align="center" nowrap="nowrap">
											序号<input type="checkbox" name="checkbox1"  value="" id="all"/>
										</th>
										<th  align="center" nowrap="nowrap">
											客户名称
										</th>
										<th  align="center" nowrap="nowrap">
											项目名称
										</th>
										<th  align="center" nowrap="nowrap">
											工程师姓名
										</th>
										<th  align="center" nowrap="nowrap">
											全勤薪资
										</th>
										<th align="center" nowrap="nowrap">
											实发详细
										</th>
										<th align="center" nowrap="nowrap">
											考勤详细
										</th>
										<th  align="center" nowrap="nowrap">
											应发薪资
										</th>
										<th  align="center" nowrap="nowrap">
											实发薪资
										</th>
										<th  align="center" nowrap="nowrap">
											入职日期
										</th>
										<th  align="center" nowrap="nowrap">
											转正日期
										</th>
									</tr>
									<c:forEach items="${payrollReportList}" var="payrollReport" varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
										id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox1" title="${payrollReport.id}"
												value="${payrollReport.id}" onselect="mouseOver(this)"> 
										</TD>
										<TD align="center"  nowrap="nowrap">
											<c:if test="${payrollReport.customerInfo.customername eq null}">总部</c:if>
											<c:if test="${payrollReport.customerInfo.customername ne null}">${payrollReport.customerInfo.customername}</c:if>
										</TD>
										<TD align="center" nowrap="nowrap">
											<c:if test="${payrollReport.customerInfo.customername eq null}">昌平总部</c:if>
											<c:if test="${payrollReport.customerInfo.customername ne null}">${payrollReport.zcproject.projectname}</c:if>
											
										</TD>
										<TD align="center" nowrap="nowrap">
											${payrollReport.user.username}
										</TD>
										<TD align="center" nowrap="nowrap">
											${payrollReport.wage}
										</TD>
										<TD align="center" nowrap="nowrap">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="shijifafang_detail('${payrollReport.user.id}','${payrollReport.user.username}');">
												实发详细
											</BUTTON>
										</TD>
										<TD align="center" nowrap="nowrap">
											<BUTTON style="height: 21px; font-size: 12px"
												onClick="kaoqinresult('${payrollReport.user.id}','${payrollReport.user.username}');">
												考勤详细
											</BUTTON>
										</TD>
										<TD align="center" nowrap="nowrap">
											链接地址
										</TD>
										<TD align="center" nowrap="nowrap">
											链接地址
										</TD>
										<TD align="center" nowrap="nowrap">
											<fmt:formatDate value="${payrollReport.enterdate}" pattern="yyyy-MM-dd" />
										</TD>
										<TD align="center" nowrap="nowrap">
											<fmt:formatDate value="${payrollReport.zzdate}" pattern="yyyy-MM-dd" />
										</TD>
									</TR>
								</c:forEach>
									<TR>
									<th align="center" colspan="9"/></th>
									</TR>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<jsp:include page="/page/page.jsp">
											<jsp:param name="url"
												value="" />
										</jsp:include>
									</table>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
<script>

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
		'importData': function(t) {
			showMyWindow("导入数据",  
                    '${pageContext.request.contextPath}/view/hrm/importAttendanceData.jsp?',  
                    500, 200); 
		}
	  }

});
</script>
	</body>
</html>