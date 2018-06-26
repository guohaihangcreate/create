<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>应收应付报表详细</title>
		<link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=path%>/js/main.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
			    $("div").animate({left:'250px'});
			});
		</script>
	</head>
	<body id="divtest" bgcolor="#98bf21">
	<form action="<%=path%>/view/finance/yingshouyingfu_detail.jsp">
		<div style="height:100px;width:100px;position:absolute;margin-top: 200px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="3">
					<tr>
						<td valign="middle" width="100%" nowrap="nowrap">
								年份
									<select>
										<option>2016</option>
										<option>2017</option>
										<option>2018</option>
									</select>
						</td>
						<td valign="middle" width="100%" nowrap="nowrap">
								月份
									<select>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
										<option>9</option>
									</select>
						</td>
						<td>
							<input name="查询" type="submit">
						</td>
					</tr>
			</table>
		</div>
		</form>
	</body>
</html>