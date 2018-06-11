<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
<head>
<title></title>
<link href="<%=path%>/login_b/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path%>/login_b/js/main.js"></script>
</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">
    &nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="<%=path%>/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;系统管理&nbsp;&nbsp;
    <img src="<%=path%>/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;系统设置&nbsp;&nbsp;
    <img src="<%=path%>/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;人力管理</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(<%=path%>/create/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20" height="34"><img src="<%=path%>/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="<%=path%>/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>人员信息管理</strong></td>
          <td align="right" class="white" style="padding-right:20px"><a href="<%=path%>/view/user_add.jsp" class="barBtn" onClick="location.href='<%=path%>/view/user_add.jsp'"><img src="<%=path%>/images/5.png" align="absmiddle"> 新增</a> <a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img src="<%=path%>/images/btn_left.gif" align="absmiddle"> 后退</a> <a href="#" class="barBtn" onClick="javascript:history.go(+1);"><img src="<%=path%>/images/btn_right.gif" align="absmiddle"> 前进</a> <a href="#" class="barBtn"><img src="<%=path%>/images/btn_refresh.gif" align="absmiddle"> 刷新</a></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
      <TR>
        <th width="10%" align="center">员工名称</th>
        <td width="20%" class="BGCgray"><input type="text" name="textfield" id="textfield"></td>
        <th width="10%" align="center">所属部门</th>
        <td width="20%" class="BGCgray"><input type="text" name="textfield2" id="textfield2"></td>
        <th width="10%" align="center"><STRONG>性别</STRONG></th>
        <td width="20%" class="BGCgray"><select name="select2" id="select2">
          <option>全部</option>
          <option>信息服务</option>
          <option>男</option>
          <option>女</option>
        </select></td>
        <th width="10%" align="center"><BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('查询数据？')) location.href='#';else return;"><img src="<%=path%>/images/btn_search.gif" width="16" height="16" align="absmiddle"> 查询</BUTTON></th>
        </TR>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1">
        <TR>
          <th align="center"><input type="checkbox" name="checkbox" id="checkbox"></th>
          <th align="center">员工姓名</th>
          <th align="center">所属部门</th>
          <th align="center">联系电话</th>
          <th align="center">上级领导</th>
          <th align="center">在职状态</th>
          <th width="200" align="center">操作</th>
          </TR>
         <c:forEach items="${users}" var="user">
	        <TR>
	          <TD align="center"><input type="checkbox" name="checkbox2" id="checkbox2"></TD>
	          <TD align="center">${user.username}</TD>
	          <TD align="center">${user.departid}</TD>
	          <TD align="center">${user.telephone}</TD>
	          <TD align="center">${user.email}</TD>
	          <TD align="center">通过</TD>
	          <TD width="200" align="center"><BUTTON style="height:21px; font-size:12px" onClick="javascript:if (confirm('查看该信息？')) location.href='01_detail.html';else return;">查看</BUTTON> <BUTTON style="height:21px; font-size:12px" onClick="javascript:if (confirm('编辑该信息？')) location.href='01_edit.html';else return;">编辑</BUTTON> <BUTTON style="height:21px; font-size:12px" onClick="javascript:if (confirm('通过审核？')) location.href='#';else return;">审核</BUTTON> <BUTTON style="height:21px; font-size:12px" onClick="javascript:if (confirm('合同报备？')) location.href='#';else return;">报备</BUTTON></TD>
	        </TR>
        </c:forEach>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="20%" height="25"><table border="0" cellspacing="0" cellpadding="3">
            <tr>
              <td><a href="#"><img src="<%=path%>/images/prev_top.gif" width="16" height="16" border="0"></a></td>
              <td><a href="#"><img src="<%=path%>/images/prev.gif" width="16" height="16" border="0"></a></td>
              <td><a href="#"><img src="<%=path%>/images/next.gif" width="16" height="16" border="0"></a></td>
              <td><a href="#"><img src="<%=path%>/images/prev_end.gif" width="16" height="16" border="0"></a></td>
            </tr>
          </table></td>
          <td width="20%" align="center"><table border="0" cellspacing="0" cellpadding="3">
            <tr>
              <td><a href="#"><img src="<%=path%>/images/next.gif" width="16" height="16" border="0"></a></td>
              <td><input name="textfield23" type="text" size="3" style="width:25;height:18">
                /页</td>
            </tr>
          </table></td>
          <td width="20%" align="right">共10条记录显示到1/1</td>
        </tr>
      </table>
    </div>
  </td>
  </tr>
</table>
</body>
</html>