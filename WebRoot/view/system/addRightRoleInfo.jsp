<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title></title>
		<link href="../../css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../../js/main.js"></script>
	</head>
	<body>
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3">
			<tr>
				<td
					style="height: 25px; background-color: #f3f3f3; font-weight: bold"
					valign="top">
					&nbsp;&nbsp;&nbsp;&nbsp;��ǰλ�ã�
					<img src="../../images/arrow.gif" align="absmiddle">
					&nbsp;&nbsp;�ɶ�����ҵ�����������&nbsp;&nbsp;
					<img src="../../images/arrow.gif" align="absmiddle">
					&nbsp;&nbsp;������Ŀר��&nbsp;&nbsp;
					<img src="../../images/arrow.gif" align="absmiddle">
					&nbsp;&nbsp;����ȯ����
				</td>
			</tr>
			<tr>
				<td
					style="height: 34px; background-image: url(../../images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20" height="34">
								<img src="../../images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color: #90c8e8;">
								<img src="../../images/icon_card.gif" width="16" height="16"
									align="absmiddle">
								&nbsp;&nbsp;
								<strong>��ͬ��Ϣ����</strong>
							</td>
							<td align="right" class="white" style="padding-right: 20px">
								<a href="#" class="barBtn" onClick="javascript:history.go(-1);"><img
										src="../../images/btn_left.gif" align="absmiddle"> ����</a>
								<a href="#" class="barBtn" onClick="javascript:history.go(+1);"><img
										src="../../images/btn_right.gif" align="absmiddle"> ǰ��</a>
								<a href="#" class="barBtn"><img
										src="../../images/btn_refresh.gif" align="absmiddle"> ˢ��</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1">
							<TR>
								<th width="20%" align="center">
									��ҵ����
								</th>
								<TD class="BGCgray">
									�ɶ��д�ҵ�ڻ��������ι�˾
								</TD>
							</TR>
							<TR>
								<th align="center">
									��ͬ���
								</th>
								<TD width="80%" class="BGCgray">
									<input name="textfield3" type="text" id="textfield3">
								</TD>
							</TR>
							<TR>
								<th align="center">
									<span class="BGCgray">��ͬ����</span>
								</th>
								<TD class="BGCgray">
									<input name="textfield15" type="text" id="textfield15">
								</TD>
							</TR>
							<TR>
								<th align="center">
									�������
								</th>
								<TD class="BGCgray">
									<input name="textfield2" type="text" id="textfield2">
								</TD>
							</TR>
							<TR>
								<th align="center">
									<span class="BGCgray">��������</span>
								</th>
								<TD class="BGCgray">
									<select name="select2" id="select">
										<option>
											��Ϣ����
										</option>
										<option>
											��ҵ����
										</option>
										<option>
											������ѯ
										</option>
										<option>
											��Ա��ѵ
										</option>
										<option>
											��������
										</option>
										<option>
											�г���չ
										</option>
										<option>
											��������
										</option>
										<option>
											��˰����
										</option>
										<option>
											�˲Ŵ���
										</option>
									</select>
								</TD>
							</TR>
							<TR>
								<th align="center">
									��ͬ���
								</th>
								<TD class="BGCgray">
									<input name="textfield6" type="text" id="textfield6">
								</TD>
							</TR>
							<TR>
								<th align="center">
									ǩ��ʱ��
								</th>
								<TD class="BGCgray">
									<input name="textfield" type="text" id="textfield">
								</TD>
							</TR>
						</table>
						<div style="width: 100%; text-align: center; padding: 5px">
							<BUTTON style="HEIGHT: 25px"
								onClick="javascript:if (confirm('������Ϣ��')) location.href='02_list.html';else return;">
								<img src="../../images/btn_save.gif" width="16" height="16"
									align="absmiddle">
								����
							</BUTTON>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</body>
</html>