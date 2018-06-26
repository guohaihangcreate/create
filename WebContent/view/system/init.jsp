<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	response.setHeader("cache-control", "no-cache");
	response.setHeader("pragma", "no-cache");
	response.setHeader("expires", "Mon 1 Jan 1990 00:00:00 GMT");
	response.setContentType("text/html;charset=UTF-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/login_a/js/main.js"></script>
		
		<script type="text/javascript" src="<%=path%>/js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="<%=path%>/js/laydate/laydate.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.contextmenu.r2.js"></script>
		<script type="text/javascript" src="<%=path%>/js/area.js"></script>
		<%--	日期格式化--%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<script type="text/javascript">
		$("#checkAll").click(function(){    
		    if(this.checked){    
		          $('input[name="checkbox2"]').each(function(){
						$(this).attr("checked", true); 
			   		});
		    }else{    
		        $('input[name="checkbox2"]').each(function(){
						$(this).attr("checked", false); 
			   		}); 
		    }    
		});
		
		
		function GetQueryString(name)
			{
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  unescape(r[2]); return null;
			}
	</script>

	</head>
</html>
