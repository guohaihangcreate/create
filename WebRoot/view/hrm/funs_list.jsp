<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ include file="/view/system/init.jsp"%>
<!DOCTYPE html>
<HTML>
	<HEAD>
		<TITLE>系统左侧菜单维护</TITLE>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<%=path%>/css/demo.css" type="text/css">
		<link rel="stylesheet" href="<%=path%>/css/zTreeStyle/zTreeStyle.css"
			type="text/css">
		<script type="text/javascript" src="<%=path%>/js/jquery-1.4.4.min.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.ztree.core-3.5.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.ztree.excheck-3.5.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.ztree.exedit-3.5.js"></script>
		<SCRIPT type="text/javascript">
			var status = 1;
			function switchSysBar(){
				var switchPoint=document.getElementById("switchPoint");
				var frmTitle=document.getElementById("leftdiv");
			     if (1 == window.status){
					  window.status = 0;
			          switchPoint.style.backgroundImage = 'url(../../images/left.gif)';
			          frmTitle.style.display="none"
			     }
			     else{
					  window.status = 1;
			          switchPoint.style.backgroundImage = 'url(../../images/right.gif)'; 
			          frmTitle.style.display=""
			     }
			}
		<!--
		var setting = {
			async: {
				enable: true,
				url:"<%=path%>/sysfunController/editMenues.go",
				autoParam:["id", "name=n","url"],
				expandSpeed:false,				
				dataFilter: filter
			},
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom,
				selectedMulti: false
			},
			edit: {
				enable: true,
				editNameSelectAll: true,
				showRemoveBtn: showRemoveBtn,
				showRenameBtn: showRenameBtn
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeEditName: beforeEditName,
				beforeRemove: beforeRemove,
				beforeRename: beforeRename,
				onRemove: onRemove,
				onRename: onRename
			}
		};
		
		function onClick(event, treeId, treeNode, clickFlag) {
			alert(1111);
		}	
		function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		
		var log, className = "dark";
		function beforeDrag(treeId, treeNodes) {
			return false;
		}
		function beforeEditName(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			alert(treeNode.name);
			return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
		}
		function beforeRemove(treeId, treeNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除节点 -- " + treeNode.name + " 吗？");
		}
		function onRemove(e, treeId, treeNode) {
			showLog("[ "+getTime()+" onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
		}
		function beforeRename(treeId, treeNode, newName, isCancel) {
			className = (className === "dark" ? "":"dark");
			showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				setTimeout(function(){zTree.editName(treeNode)}, 10);
				return false;
			}
			return true;
		}
		function onRename(e, treeId, treeNode, isCancel) {
			showLog((isCancel ? "<span style='color:red'>":"") + "[ "+getTime()+" onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name + (isCancel ? "</span>":""));
		}
		function showRemoveBtn(treeId, treeNode) {
			return !treeNode.isFirstNode;
		}
		function showRenameBtn(treeId, treeNode) {
			return !treeNode.isLastNode;
		}
		function showLog(str) {
			if (!log) log = $("#log");
			log.append("<li class='"+className+"'>"+str+"</li>");
			if(log.children("li").length > 8) {
				log.get(0).removeChild(log.children("li")[0]);
			}
		}
		function getTime() {
			var now= new Date(),
			h=now.getHours(),
			m=now.getMinutes(),
			s=now.getSeconds(),
			ms=now.getMilliseconds();
			return (h+":"+m+":"+s+ " " +ms);
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};
		function selectAll() {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.setting.edit.editNameSelectAll =  $("#selectAll").attr("checked");
		}
		
	$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
		});
		//-->
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

.ztree li span.button.add {
	
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

.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top; *
	vertical-align: middle
}

.picBox {
	width: 0.6%;
	background: #337ABB url(../../images/right.gif) no-repeat center center;
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
</style>
	</HEAD>
	<body>
		<div
			style="width: 100%;; height: 34px; background-image: url(../../images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="20" height="34">
						<img src="../../images/main_headerL.gif" width="20" height="34">
					</td>
					<td style="color: #90c8e8;">
						<img src="../../images/icon_card.gif" width="16" height="16"
							align="absmiddle">
						&nbsp;&nbsp;
						<strong>左侧菜单维护</strong>
					</td>
					<td align="right" class="white" style="padding-right: 20px;">
						<a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
								src="../../images/btn_left.gif" align="absmiddle"
								style="margin-top: 0;"> 后退</a>
						<a href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
								src="../../images/btn_right.gif" align="absmiddle"> 前进</a>
						<a href="#" class="barBtn"><img
								src="../../images/btn_refresh.gif" align="absmiddle"> 刷新</a>
					</td>
				</tr>
			</table>
		</div>
		<div class="main">
			<div class="main_left" id="frmTitle">
				<ul id="treeDemo" class="ztree"></ul>
			</div>
			<div class="picBox" onclick="switchSysBar()" id="switchpoint"></div>
			<div class="main_right">
				<table width="100%" border="0" cellpadding="3" cellspacing="1"
					class="table1">
					<TR>
						<th width="10%" align="center" colspan="2">
							系统菜单编辑
						</th>
					</TR>
					<TR>
						<th align="center">
							菜单名称
						</th>
						<TD width="80%" class="BGCgray">
							<input name="textfield3" type="text" id="textfield3">
						</TD>
					</TR>
					<TR>
						<th align="center">
							<span class="BGCgray">菜单名称(英文)</span>
						</th>
						<TD class="BGCgray">
							<input name="textfield15" type="text" id="textfield15">
						</TD>
					</TR>
					<TR>
						<th align="center">
							链接地址
						</th>
						<TD class="BGCgray">
							<input name="textfield2" type="text" id="textfield2">
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
							<input type="file">
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
				<div style="width: 100%; text-align: center; padding: 5px">
					<BUTTON style="HEIGHT: 25px"
						onClick="javascript:if (confirm('保存信息？')) location.href='02_list.html';else return;">
						<img src="../../images/btn_save.gif" width="16" height="16"
							align="absmiddle">
						保存
					</BUTTON>
				</div>
				<div style="width: 100%; text-align: center; padding: 5px">
					<BUTTON style="HEIGHT: 25px"
						onClick="javascript:if (confirm('修改信息？')) location.href='02_list.html';else return;">
						<img src="../../images/btn_save.gif" width="16" height="16"
							align="absmiddle">
						编辑
					</BUTTON>
				</div>
			</div>
		</div>
	</body>
</HTML>