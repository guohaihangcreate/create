<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
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
	
	function toSeeinfo(pId){
		document.forms[0].action="<%=path%>/mianshiYaoQingController/toAddYaoQing.go?pId="+pId;
		document.forms[0].submit();
	}
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="return_back">
					&nbsp;&nbsp;&nbsp;&nbsp;返回
				</li>
			</ul>
		</div>
		<form action="" method="post" enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th align="center" nowrap="nowrap">
										序号
										<input type="checkbox" name="checkbox" id="checkbox">
									</th>
									<th align="center" nowrap="nowrap">
										姓名
									</th>
									<th align="center" nowrap="nowrap">
										邮箱
									</th>
									<th width="100" align="center" nowrap="nowrap">
										QQ
									</th>
									<th width="100" align="center" nowrap="nowrap">
										电话
									</th>
									<th width="200" align="center" nowrap="nowrap">
										操作
									</th>
								</TR>
								<c:forEach items="${users}" var="user">
									<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											<input type="checkbox" name="checkbox2" id="checkbox2">
										</TD>
										<TD align="center" nowrap="nowrap">
											${user.username}
										</TD>
										<TD align="center" nowrap="nowrap">
											${user.email}
										</TD>
										<TD align="center" nowrap="nowrap">
											${user.telephone}
										</TD>
										<TD align="center" nowrap="nowrap">
											${user.idno}
										</TD>
										<td align="center" nowrap="nowrap">
											${user.jobName}
										</td>
									</TR>
								</c:forEach>
								<TR>
									<th align="center" colspan="7" /></th>
								</TR>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<script>
		 function queryAllCompany() {  
           			showMyWindow("请选择公司",  
                    '${pageContext.request.contextPath}/companyController/showCompanys.go?page=1&rows=10&type=select',  
                    800, 400); 
        } 
        
        
         $(function() {  
        		$('body').append('<div id="myWindow" class="easyui-window"  closed="true"></div>'); 
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
		                            shadow : false,  
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
		'return_back': function(t) {
			//执行事件
		    window.history.go(-1);
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