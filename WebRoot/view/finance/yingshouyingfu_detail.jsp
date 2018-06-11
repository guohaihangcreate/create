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
	
</script>
	</head>
	<body id="divtest">
		<!--右键代码开始-->
		<div class="contextMenu" id="myMenu1" style="background-color: ">
			<ul>
				<!--图片地址为右键时，显示在菜单左边的小图标-->
				<li id="selectdata">
					&nbsp;&nbsp;&nbsp;&nbsp;选择数据
				</li>
				<li id="select">
					&nbsp;&nbsp;&nbsp;&nbsp;查询
				</li>
			</ul>
		</div>
		<!--右键代码结束-->
		<form action="" method="post" enctype="multipart/form-data"
			name="form0">
			<table width="100%" height="100%" border="0" cellspacing="0"
				cellpadding="3">
				<TR class="BGCgray">
				<th align="center" colspan="5">月营收支出报表</th>
				</TR>
				<tr>
					<td height="100%" valign="top">
						<div style="overflow: auto; height: 100%; width: 100%">
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1">
								<TR>
									<th align="center" nowrap="nowrap">
										类目
									</th>
									<th align="center" nowrap="nowrap">
										类目详细
									</th>
									<th align="center" nowrap="nowrap">
										客户名称
									</th>
									<th width="200" align="center" nowrap="nowrap">
										项目		
									</th>
								</TR>
								<TR class="BGCgray">
										<TD align="center" nowrap="nowrap" rowspan="3">
											收入
										</TD>
										<TD align="center" nowrap="nowrap" rowspan="2">
											项目收入
										</TD>
										<TD align="center" nowrap="nowrap">
											美林数据
										</TD>
										<TD align="center" nowrap="nowrap">
											國網想
										</TD>
								</TR>
								<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											美林数据
										</TD>
										<TD align="center" nowrap="nowrap">
											國網
										</TD>
								</TR>
								<TR class="BGCgray">
										<TD align="center" nowrap="nowrap">
											理财
										</TD>
										<TD align="center" nowrap="nowrap">
											
										</TD>
										<TD align="center" nowrap="nowrap">
											
										</TD>
								</TR>
								<TR class="BGCgray">
										<TD align="center" nowrap="nowrap" colspan="2">
											月支出：
										</TD>
										<TD align="center" nowrap="nowrap" colspan="2">
											月收入：
										</TD>
								</TR>
								<TR class="BGCgray">
										<TD align="center" nowrap="nowrap" colspan="4">
											月盈利：
										</TD>
								</TR>
								<TR>
									<th align="center" colspan="5" /></th>
								</TR>
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
		'selectdata': function(t) {
			//执行事件
		   			var values="";
					var title = "";
					if($('input[name="checkbox2"]:checked').length==1){
			   			window.parent.document.getElementById("deptName").value =$('input[name="checkbox2"]:checked')[0].title;
				   		window.parent.document.getElementById("dept_name").innerHTML =$('input[name="checkbox2"]:checked')[0].title;
				   		window.parent.document.getElementById("deptId").value=$('input[name="checkbox2"]:checked')[0].value;
						parent.$('#myWindow').window('close');
					}
					else{
						alert("本次操作是单选");
						return false;
					}
		},
		'select': function(t) {
			//执行事件
		   	document.form0.action="<%=path%>/companyController/showCompanys.go";
			document.form0.submit();
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