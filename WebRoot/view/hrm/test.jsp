<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>

		<title>JQuery进度条插件——progressbar</title>
		<span style="font-family: SimSun;"><script
				type="text/javascript">
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
</script>
		</span>
		<span style="font-family: SimSun;"><style type="text/css">
#massage_box {
	position: absolute;
	left: expression((   body . clientWidth-350)/ 2 );
	top: expression(body . scrollTop +(            
		  body . clientHeight-this . offsetHeight)/ 2 );
	width: 400px;
	height: 190px;
	filter: dropshadow(color =   #666666, offx = 3, offy =   3, positive =   2)
		;
	z-index: 2;
	visibility: hidden
}

#mask {
	position: absolute;
	top: 0;
	left: 0;
	width: expression(body . clientWidth);
	height: expression(body . scrollHeight >               body . clientHeight ?
		        
		     body . scrollHeight :       
		       body . clientHeight);
	background: #666;
	filter: ALPHA(opacity = 60);
	z-index: 1;
	visibility: hidden
}

.massage {
	border: #036 solid;
	border-width: 1 1 3 1;
	width: 95%;
	height: 95%;
	background: #fff;
	margin-left: 500px;
	margin-top: 200px;
	color: #036;
	font-size: 12px;
	line-height: 150%
}

.header {
	background: #554295;
	height: 15%;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	padding: 3 5 0 5;
	color: #fff
}
</style>
		</span>
	</head>
	<span style="font-family: SimSun;">
		<body>
			<div id="massage_box" onclick="hiddenMessage();">
				<div class="massage">
					<div class="header" onmousedown="MDown(massage_box);">
						<div style="display: inline; width: 250px; position: absolute">
							正在加载中 ... ...喝杯茶休息一刻....
						</div>
						<span
							onClick="massage_box.style.visibility='hidden'; mask.style.visibility='hidden'"
							style="float: right; display: inline; cursor: hand"><img
								src="images/guanbi.png" height="30px" width="30px" />
						</span>
					</div>
					<div
						style="margin-top: 20px; margin-left: 20px; width: 10px; height: 10px; float: left;">
						<img src="images/cxz_ly.gif" />
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
		</body> </span>
	<input type="button" onclick="XXX()" value="显示等待信息">
</html>