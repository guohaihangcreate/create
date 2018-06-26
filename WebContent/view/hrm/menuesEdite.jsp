<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ include file="/view/system/init.jsp"%>
<HTML>
	<HEAD>
		<TITLE>左侧菜单编辑</TITLE>
		<meta http-equiv="content-type" content="text/html; charset=GBK">

		<link rel="stylesheet" href="<%=path%>/css/demo.css" type="text/css">
		<link rel="stylesheet" href="<%=path%>/css/zTreeStyle/zTreeStyle.css"
			type="text/css">
		<script type="text/javascript" src="<%=path%>/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.ztree.excheck-3.5.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jQuery/jquery.mask.js"></script>
		<SCRIPT LANGUAGE="JavaScript">
		<!--
		var setting = {
			check: {  
                enable: true,  
                nocheckInherit: false  
            },
			async: {
				enable: true,
				url:"<%=path%>/treeNodeController/queryAllTreeNodes.go",
				autoParam:["id", "name=n","url"],
				expandSpeed:false,				
				dataFilter: filter
			},
			callback: {
			    onCheck: onCheck,
				beforeAsync: beforeAsync,
				onCollapse: onCollapse,
				onExpand: onExpand
			}
		};
		
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}
		
		function onCollapse(event, treeId, treeNode) {
			//alert("onCollapse: " + treeId + "," + treeNode.name + "," + treeNode.id+ "," + treeNode.url);
		}		
		
		function onExpand(event, treeId, treeNode) {
			//alert("onExpand: " + treeId + "," + treeNode.name+ "," + treeNode.id+ "," + treeNode.url);
		}
		
		function onCheck(event, treeId, treeNode, clickFlag) {
			var val_dotype = $('#wrap input[name="dotype"]:checked').val();
			if(val_dotype==0){
				$("#parentMenuName").html(treeNode.name);
				$("#currentname").val(treeNode.name);
				$("#id").val(treeNode.id);
				$("#pid").val(treeNode.pid);
				$("#url").val(treeNode.url);
			}else{
				$("#name").val(treeNode.name);
				$("#url").val(treeNode.url);
			}
		}		

		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeAsync(treeId, treeNode) {
			return treeNode ? treeNode.level < 5 : true;
		}
		
		///动态设置zTree的所有节点有checkbox  
        function DynamicUpdateNodeCheck() {  
            var zTree = $.fn.zTree.getZTreeObj("treeDemo");  
            //根据过滤机制获得zTree的所有节点              
            var nodes = zTree.getNodesByFilter(filter);  
            //遍历每一个节点然后动态更新nocheck属性值  
            for (var i = 0; i < nodes.length; i++) {  
                var node = nodes[i];  
                node.nocheck = false; //表示显示checkbox  
                zTree.updateNode(node);  
            }  
        } 
		
		 ///页面加载后初始化zTree数据且默认展开所有节点  
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"),setting).expandAll(true); ;
		});
		//-->
		
		function  saveMenue(){
<%--			显示加载页面等待--%>
			XXX();
			var val_dotype = $('#wrap input[name="dotype"]:checked').val();
				if(val_dotype==0){
					document.forms[0].action="<%=path%>/treeNodeController/addTreeNode.go?type=0";
				}
				if(val_dotype==3){
<%--					增加菜单--%>
					document.forms[0].action="<%=path%>/treeNodeController/addTreeNode.go?type=1";
				}
				if(val_dotype==1){
					document.forms[0].action="<%=path%>/treeNodeController/editeTreeNode.go?type=0";
				}
				if(val_dotype==2){
					document.forms[0].action="<%=path%>/treeNodeController/deleteTreeNode.go?type=0";
				}
				document.forms[0].submit();
		}
		
		
		function  showParent(){  
				$("[name=addshow]").css("display","");//显示
				$("[name=menu_url]").css("display","");//显示
				$("[name=button_url]").css("display","none");//不显示
				$("[name=editeOrdelet]").css("display","none");//不显示
				$("[name=button_name]").css("display","none");//显示
		}
		
		function  showCurren(){
				$("[name=editeOrdelet]").css("display","");//显示
				$("[name=button_name]").css("display","none");//不显示
				$("[name=button_url]").css("display","none");//不显示
				$("[name=addshow]").css("display","none");//不显示
				$("[name=menu_url]").css("display","");//显示
				
		}
		
		
		//显示添加按钮的选项
		function showButtonInsertItem(){
					$("[name=p_menue_name]").css("display","");//显示
					$("[name=button_name]").css("display","");//显示
					$("[name=button_url]").css("display","");//显示
					$("[name=sub_menue_name]").css("display","none");//不显示
					$("[name=editeOrdelet]").css("display","none");//不显示
					$("[name=menu_url]").css("display","none");//不显示
					$("[name=addshow]").css("display","none");//不显示
		}
		



function XXX() {
	displayMessage();
}

function displayMessage() {
	if (navigator.userAgent.indexOf("Firefox") == -1) {
		var obj = document.getElementsByTagName('SELECT');
		for ( var i = 0; i < obj.length; i++) {
			if (obj[i].type.indexOf("select") != -1)
				obj[i].style.visibility = 'hidden';
		}
		mask.style.visibility = 'visible';
		massage_box.style.visibility = 'visible';
	}
}
function hiddenMessage() {
	mask.style.visibility = 'hidden';
	massage_box.style.visibility = 'hidden';
}
var Obj = ''
document.onmouseup = MUp
document.onmousemove = MMove
function MDown(Object) {
	Obj = Object.id
	document.all(Obj).setCapture()
	pX = event.x - document.all(Obj).style.pixelLeft;
	pY = event.y - document.all(Obj).style.pixelTop;
}

function MMove() {
	if (Obj != '') {
		document.all(Obj).style.left = event.x - pX;
		document.all(Obj).style.top = event.y - pY;
	}
}

function MUp() {
	if (Obj != '') {
		document.all(Obj).releaseCapture();
		Obj = '';
	}
}
		
	</SCRIPT>
		<style type="text/css">
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	width: 100%;
	border: none;
	background-color: #a4bed4;
}

.main {
	width: 100%;
	height: 100%;
	text-align: left;
}

.main_left {
	width: 18%;
	height: 100%;
	background: white;
}

.picBox {
	width: 0.6%;
	background: #337ABB url(<%=path%>/images/right.gif) no-repeat center
		center;
	margin-left: 0;
	padding-left: 0;
	text-align: left;
	float: left;;
}

.main_left,.picBox {
	float: left;
	height: 100%;
	_margin-right: -3px;
}

.main_right {
	width: 81.4%;
	height: 100%;
	background-color: #e3efff;
	margin: 0;
	padding: 0;
	float: left;;
}




<%--页面加载等待开始--%>
#massage_box {
	position: absolute;
	left: expression(( body.clientWidth-350)/ 2 );
	top: expression(body.scrollTop +(           
		 body.clientHeight-this.offsetHeight)/ 2 );
	width: 400px;
	height: 190px;
	filter: dropshadow(color = #666666, offx =3, offy = 3, positive = 2);
	z-index: 2;
	visibility: hidden
}

#mask {
	position: absolute;
	top: 0;
	left: 0;
	width: expression(body.clientWidth);
	height: expression(body.scrollHeight >             body.clientHeight ?        
		    body.scrollHeight :      
		      body.clientHeight);
	background: #666;
	filter: ALPHA(opacity =             60);
	z-index: 1;
	visibility: hidden
}

.massage {
	border: #036 solid;
	border-width: 1 1 3 1;
	width: 95%;
	height: 95%;
	background: #fff;
	margin-left: 550px;
	margin-top: 100px;
	color: #036;
	font-size: 12px;
	line-height: 150%
}

.header {
	background: #554295;
	height: 18%;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	text-align:left;
	padding: 3 5 0 5;
	color: #fff
}
<%--页面加载等待结束--%>
</style>
	</HEAD>

	<body>
<%--页面导航区域开始--%>
<%--页面导航区域结束--%>
		<div class="main">
			<div class="main_left">
				<ul id="treeDemo" class="ztree" style="height: 100%;"></ul>
			</div>
<%--页面加载等待开始--%>
		<div style="width: 100%; text-align: center; padding: 0px">
						<div id="massage_box" onclick="hiddenMessage();">
							<div class="massage">
								<div class="header" onmousedown="MDown(massage_box);">
									<div style="display: inline; width: 250px; position: absolute">
										正在加载中 ... ...喝杯茶休息一刻....
									</div>
									<span
										onClick="massage_box.style.visibility='hidden'; mask.style.visibility='hidden'"
										style="float: right; display: inline; cursor: hand"><img
											src="<%=path%>/images/guanbi.png" height="30px" width="30px" /> </span>
								</div>
								<div
									style="margin-top: 20px; margin-left: 20px; width: 10px; height: 10px; float: left;">
									<img src="<%=path%>/images/cxz_ly.gif" />
								</div>
								<div
									style="margin-top: 50px; width: 136px; height: 128px; float: right;">
									查询请求已发送
									<br />
									等待返回查询结果
								</div>
							</div>
						</div>
						<div id="mask" onclick="hiddenMessage();">
						</div> 
			</div>
<%--页面加载等待结束--%>
<%--表单数据区域开始--%>
			<div class="main_right" id="wrap">
				<form action="<%=path%>/treeNodeController/addTreeNode.go"
					method="post" enctype="multipart/form-data">
					<table width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1">
						<TR>
							<th width="10%" align="center" colspan="2">
								系统菜单编辑
							</th>
						</TR>
						<TR>
							<th align="center">
								操作
							</th>
							<TD width="80%" class="BGCgray">
								<input checked="checked" type="radio" value="0" name="dotype"
									id="dotype" onclick="showParent();">
								<label>
									添加子菜单
								</label>
								<input type="radio" value="3" name="dotype" id="dotype"
									onclick="showButtonInsertItem();">
								<label>
									添加按钮
								</label>
								<input type="radio" value="1" name="dotype" id="dotype"
									onclick="showCurren();">
								<label>
									菜单编辑
								</label>
								<input type="radio" value="2" name="dotype" id="dotype"
									onclick="showCurren();">
								<label>
									菜单删除
								</label>
							</TD>
						</TR>
						<TR name="addshow">
							<th align="center"  name="p_menue_name">
								父菜单名称
							</th>
							<TD width="80%" class="BGCgray">
								<span id="parentMenuName"></span>
								<input type="hidden" id="pid" name="pid">
							</TD>
						</TR>
						<TR>
							<th align="center" name="addshow">
								子菜单名称(英文)
							</th>
							<th align="center" name="editeOrdelet" style="display: none;">
								菜单名称(英文)
							</th>
							<th align="center" name="button_name" style="display: none;">
								按钮名称
							</th>
							<TD width="80%" class="BGCgray">
								<span id="currentMenue"></span>
								<input type="text" id="currentname" name="name">
								<input type="hidden" id="id" name="id">
							</TD>
						</TR>
						<TR>
							<th align="center" name="menu_url">
								链接地址
							</th>
							<th align="center" name="button_url" style="display: none;">
								按钮标识
							</th>
							<TD class="BGCgray">
								<input name="url" type="text" id="url">
							</TD>
						</TR>
						<TR>
							<th align="center">
								<span class="BGCgray">打开位置</span>
							</th>
							<TD class="BGCgray">
								<select name="select2" id="select">
									<option>
										默认窗口
									</option>
									<option>
										弹出窗口
									</option>
								</select>
							</TD>
						</TR>
						<TR>
							<th align="center">
								菜单图标
							</th>
							<TD class="BGCgray">
								<input type="file" name="icons">
								(16*16)
							</TD>
						</TR>
						<TR>
							<th align="center" rowspan="4">
								说明：
							</th>
							<TD class="BGCgray" colspan="2">
								1.如果是外部地址，请在地址前加上 "Http://"
							</TD>
						</TR>
						<TR>
							<TD class="BGCgray" colspan="2">
								2.图标请使用(16*16)的图片

							</TD>
						</TR>
						<TR>
							<TD class="BGCgray" colspan="2">
								3.如果不设置图片系统将会默使用图片
							</TD>
						</TR>
						<TR>
							<TD class="BGCgray" colspan="2">
								4.如果要使用系统图片请访问服务器文件夹 "/images_face/ecologyFace_2/LeftMenuIcon/"
							</TD>
						</TR>
					</table>
				</form>
				<div style="width: 100%; text-align: center; padding: 5px">
					<BUTTON style="HEIGHT: 25px" id="subbtn" onclick="saveMenue();">
						<img src="<%=path%>/images/btn_save.gif" width="16" height="16"
							align="absmiddle">
						提交
					</BUTTON>
				</div>
			</div>
<%--表单数据区域结束--%>
		</div>
	</body>
</HTML>