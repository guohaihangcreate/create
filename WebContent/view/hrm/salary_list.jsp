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
				obj_month.options[nowmonth-1].selected=1;
			} 
			
			function sendSalaryEmail(sid){
	  			var columnSelect = "";  
				$('input[name="columnSelect"]:checked').each(function(){    
	   				columnSelect = columnSelect + $(this).val()+";";
	  			});
				//执行事件
				document.form0.action="<%=path%>/SalaryDetailController/wageStripEmail.go?sId="+sid+"&sentAll=2&selectcolum="+columnSelect;
				document.form0.submit();
			}
			
			function toEdite(sid){
	  			var columnSelect = "";  
				$('input[name="columnSelect"]:checked').each(function(){    
	   				columnSelect = columnSelect + $(this).val()+";";
	  			});
				document.form0.action="<%=path%>/SalaryDetailController/toEditeSalary.go?type=0&sId="+sid+"&sentAll=2&selectcolum="+columnSelect;
				document.form0.submit();
			}
		</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<li id="selectData">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
				<li id="importData">
					&nbsp;&nbsp;&nbsp;&nbsp;导入工资表
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
								<th colspan="1" width="1%" align="left">
									&nbsp;&nbsp;&nbsp;姓名 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									&nbsp;<input type="text" name="staffname" id="staffname">
									&nbsp;&nbsp;&nbsp;岗位 &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="yl3" id="yl3">
								</th>
							</TR>
							<TR>
								<th colspan="1" width="1%" align="left">
									&nbsp;&nbsp;&nbsp;职务（项目地址） &nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="position" id="position">
								</th>
							</TR>
							<TR>
								<th colspan="1" width="1%" align="left">
									&nbsp;&nbsp;&nbsp;所在年份 &nbsp;&nbsp;&nbsp;&nbsp;<select id="myYear" name="yl1"></select>&nbsp;&nbsp;年
								</th>
							</TR>
							<TR>
								<th colspan="1" width="1%" align="left">
									&nbsp;&nbsp;&nbsp;所在月份 &nbsp;&nbsp;&nbsp;&nbsp;<select id="myMonth" name="yl2"></select>&nbsp;&nbsp;月
								</th>
							</TR>
						</table>
					</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<form action="" method="post" name="form0" enctype="multipart/form-data">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
									<tr>
										<th  align="center" nowrap="nowrap">
											序号<input type="checkbox" name="checkbox1"  value="" id="all"/>
										</th>
										<th  align="center" nowrap="nowrap">
											操作
										</th>
										<th  align="center" nowrap="nowrap">
											职员姓名
										</th>
										<th  align="center" nowrap="nowrap">
											月份
										</th>
										<th  align="center" nowrap="nowrap">
											职  务
										</th>
										<th  align="center" nowrap="nowrap">
											HR负责人
										</th>
										<th  align="center" nowrap="nowrap">
											岗位
										</th>
										<th  align="center" nowrap="nowrap">
											身份证号码
										</th>
										<th  align="center" nowrap="nowrap">
											入职日期
										</th>
										<th  align="center" nowrap="nowrap">
											转正后金额
										</th>
										<th  align="center" nowrap="nowrap">
											计薪天数
										</th>
										<th  align="center" nowrap="nowrap">
											发全额薪水日期
										</th>
										<th  align="center" nowrap="nowrap">
											当月应发工资金额
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											上保险时间及状态
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											电脑押金情况（蓝字已扣押金）
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											各项目计薪天数
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											计薪天数
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											加班费、补贴、扣款
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											补贴说明
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											报销费用
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											代扣社保
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											代扣公积金
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											考勤应发工资（考勤工资+调整补贴）
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											应发-报销款（抵税报销）
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											计算个税金额（减去社保和公积金）
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											个人所得税
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											实发工资
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											已发
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											补发
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											账号
										</th>
										<th  align="center" nowrap="nowrap" style="display:none;">
											开户行名称
										</th>
									</tr>
									<c:forEach items="${salaryDetails}" var="salaryDetail" varStatus="status">
									<TR onMouseOver="mouseOver(this)" onMouseOut="mouseOut(this)"
										id="${page.everyPage*(page.currentPage-1)+status.index+1}"
										<c:if test="${(page.everyPage*(page.currentPage-1)+status.index+1)%2 eq 0}">class="BGCgray"</c:if>>
										<TD align="center" nowrap="nowrap">
											${page.everyPage*(page.currentPage-1)+status.index+1}&nbsp;&nbsp;
											<input type="checkbox" name="checkbox1" title="${salaryDetail.id}"
												value="${salaryDetail.id}" onselect="mouseOver(this)"> 
										</TD>
										<TD align="center" nowrap="nowrap">
												<a onclick="toEdite('${salaryDetail.id}');"
													class="easyui-linkbutton"
													iconCls="icon-search" plain="true"><font color="black">修改</font>
												</a>
<%--												<a onclick="sendSalaryEmail('${salaryDetail.id}');"--%>
<%--													class="easyui-linkbutton"--%>
<%--													iconCls="icon-search" plain="true"><font color="black">发送工资条</font>--%>
<%--												</a>--%>
										</TD>
										<TD align="center" id="${salaryDetail.id}" nowrap="nowrap">
											${salaryDetail.staffname}
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.yl1} 年${salaryDetail.yl2+1}月
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.position}
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.hr_Str}
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.yl3}
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.idno}
										</TD>
										<TD align="center" nowrap="nowrap">
											<fmt:formatDate value="${salaryDetail.entrydate}" type="date" dateStyle="full"/>
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.fullsalary}
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.actualpayday} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.fullsalarydate}
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.paymentwage}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.insurancestatus}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.pcdeposit}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.payday}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.actualpayday}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.subsidydebit}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.subsidydebitexplain}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.reimbursement}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.socialsecurity}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.accumulationfund}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.wages}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.actualwages}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.selftax}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.incometax}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.shifagongzi}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.yifa}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.bufa}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.zhanghu}
										</TD>
										<TD align="center" nowrap="nowrap" style="display:none;">
											${salaryDetail.kaihuhangname}
										</TD>
									</TR>
								</c:forEach>
									<TR>
									<th align="center" colspan="13"/></th>
									<td>
									<input type="hidden" value="${companys}" name="companys" id="companys">
									</td>
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
		$("#all").click(function(){    
		    if(this.checked){    
		          $('input[name="checkbox1"]').each(function(){
						$(this).attr("checked", true); 
			   		});
		    }else{    
		        $('input[name="checkbox1"]').each(function(){
						$(this).attr("checked", false); 
			   		}); 
		    }    
		});
		
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
                    '${pageContext.request.contextPath}/view/hrm/importFinacnceData.jsp?companys=${companys}',  
                    500, 200); 
		},'selectData': function(t) {
			//执行事件
			var position = $("#position").val();
			var yl3 = $("#yl3").val();
			var staffname = $("#staffname").val();
			var myYear = $("#myYear").val();
			var myMonth = $("#myMonth").val(); 
		   	document.form0.action="<%=path%>/SalaryDetailController/querySalarys.go?position="+position+"&staffname="+staffname+"&yl3="+yl3+"&myYear="+myYear+"&myMonth="+myMonth;
			document.form0.submit();
		}
	  }

});

</script>
	</body>
</html>