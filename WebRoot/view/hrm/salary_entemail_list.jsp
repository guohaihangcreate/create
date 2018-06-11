<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>工资条发放</title>
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
				for (var i=0;i<12;i++) 
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
				document.form0.action="<%=path%>/SalaryDetailController/toEditeSalary.go?type=1&sId="+sid+"&sentAll=2&selectcolum="+columnSelect;
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
				<li id="sentWageEmail">
					&nbsp;&nbsp;&nbsp;&nbsp;选择数据发送
				</li>
				<li id="allsentWageEmail">
					&nbsp;&nbsp;&nbsp;&nbsp;批量发送
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
									&nbsp;&nbsp;&nbsp;工资条发放状态 <input name="yl4" type="radio" value="1"> 已发放 <input name="yl4" type="radio" value="0" checked="checked"> 未发放
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
											职员姓名<input type="checkbox" name="columnSelect" checked="checked" value="staffname"/>
										</th>
										<th  align="center" nowrap="nowrap">
											月份
										</th>
										<th  align="center" nowrap="nowrap">
											工资条发放状态
										</th>
										<th  align="center" nowrap="nowrap">
											身份证号码<input type="checkbox" name="columnSelect" value="idno" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											转正后金额<input type="checkbox" name="columnSelect" value="fullsalary" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											发全额薪水日期<input type="checkbox" name="columnSelect" value="fullsalarydate" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											当月应发工资金额<input type="checkbox" name="columnSelect" value="paymentwage" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											各项目计薪天数<input type="checkbox" name="columnSelect" value="payday" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											计薪天数<input type="checkbox" name="columnSelect" value="actualpayday" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											加班费、补贴、扣款<input type="checkbox" name="columnSelect" value="subsidydebit" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											补贴说明<input type="checkbox" name="columnSelect" value="subsidydebitexplain" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											报销费用<input type="checkbox" name="columnSelect" value="reimbursement" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											代扣社保<input type="checkbox" name="columnSelect" value="socialsecurity" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											代扣公积金<input type="checkbox" name="columnSelect" value="accumulationfund" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											考勤应发工资（考勤工资+调整补贴)<input type="checkbox" name="columnSelect" value="wages" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											应发-报销款（抵税报销）<input type="checkbox" name="columnSelect" value="actualwages" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											计算个税金额（减去社保和公积金）<input type="checkbox" name="columnSelect" value="selftax" checked="checked"/>
										</th>
										<th  align="center" nowrap="nowrap">
											个人所得税 <input type="checkbox" name="columnSelect" checked="checked" value="incometax"/>
										</th>
										<th  align="center" nowrap="nowrap">
											实发工资<input type="checkbox" name="columnSelect" checked="checked" value="shifagongzi"/>
										</th>
										<th  align="center" nowrap="nowrap">
											已发 <input type="checkbox" name="columnSelect" value="yifa"/>
										</th>
										<th  align="center" nowrap="nowrap">
											补发 <input type="checkbox" name="columnSelect" value="bufa"/>
										</th>
										<th  align="center" nowrap="nowrap">
											账号 <input type="checkbox" name="columnSelect" value="zhanghu" checked="checked"/>
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
												<a onclick="sendSalaryEmail('${salaryDetail.id}');"
													class="easyui-linkbutton"
													iconCls="icon-search" plain="true"><font color="black">发送工资条</font>
												</a>
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.staffname} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.yl1} 年${salaryDetail.yl2+1}月
										</TD>
										<TD align="center" nowrap="nowrap">
											<c:if test="${salaryDetail.yl4 eq 1}">已经发放</c:if>
											<c:if test="${salaryDetail.yl4 ne 1}"> 未发放</c:if>
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.idno} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.fullsalary} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.fullsalarydate} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.paymentwage} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.payday} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.actualpayday} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.subsidydebit} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.subsidydebitexplain} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.reimbursement} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.socialsecurity} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.accumulationfund} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.wages} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.actualwages} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.selftax} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.incometax} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.shifagongzi} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.yifa} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.bufa} 
										</TD>
										<TD align="center" nowrap="nowrap">
											${salaryDetail.zhanghu} 
										</TD>
									</TR>
								</c:forEach>
									<TR>
									<th align="center" colspan="28" /></th>
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
		'sentWageEmail': function(t) {
			var chk_value = "";  
			$('input[name="checkbox1"]:checked').each(function(){    
   				chk_value = chk_value + $(this).val()+";";
  			});
  			var columnSelect = "";  
			$('input[name="columnSelect"]:checked').each(function(){    
   				columnSelect = columnSelect + $(this).val()+";";
  			});
  			var position = $("#position").val();
			var yl3 = $("#yl3").val();
			var staffname = $("#staffname").val();
			var myYear = $("#myYear").val();
			var myMonth = $("#myMonth").val();
			//执行事件
			document.form0.action="<%=path%>/SalaryDetailController/wageStripEmail.go?position="+position+
		   	"&staffname="+staffname+"&yl3="+yl3+"&myYear="+myYear+"&myMonth="+myMonth+"&checkId="+chk_value+"&selectcolum="+columnSelect;
			document.form0.submit();
		},'allsentWageEmail': function(t) {
			//发送本月所以人的工资条
			document.form0.action="<%=path%>/SalaryDetailController/querySalarys.go?sentAll=1";
			document.form0.submit();
		   
		},'selectData': function(t) {
			//执行事件
			var position = $("#position").val();
			var yl3 = $("#yl3").val();
			var yl4 = $("input[name='yl4']:checked").val();
			var staffname = $("#staffname").val();
			var myYear = $("#myYear").val();
			var myMonth = $("#myMonth").val(); 
		   	document.form0.action="<%=path%>/SalaryDetailController/querySalarys.go?type=1&position="+position+"&staffname="+staffname+"&yl3="+yl3+"&myYear="+myYear+"&myMonth="+myMonth+"&yl4="+yl4;
			document.form0.submit();
		}
	  }

});

</script>
	</body>
</html>