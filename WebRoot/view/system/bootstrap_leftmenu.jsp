<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>
<html>
	<head>
		<title>Bootstrap菜单</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
		<!-- Bootstrap -->
		<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="<%=path%>/css/font-awesome.min.css">
		<script src="<%=path%>/js/jquery-1.8.2.min.js"></script>
		<script src="<%=path%>/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
				var $document = $(window.parent.frames["maipage"].document);
           		$document.find("#tabs li").removeClass("current");
	            $document.find("#content iframe").hide();
	            // add new tab and related content
	            $document.find("#tabs").append("<li class='current'><a class='tab' id='welcome' href='#'>系统首页</a><a href='#' class='remove'>x <label style='color: black;'>|</label></a></li>");
				$document.find("#content").append("<div><iframe  style='width: 100%;'  src='<%=path%>/noticeController/queryNotice.go' id='welcome_content' class=tabs-iframe></iframe></div>");
        });
		
        $(document).ready(function() {
            $("ul a").click(function() {
            	if ($('#tabs li.current a#'+this.rel).length == 0) {
                    addOrEditeTab($(this));
                }
            });
        });
        
        
        
        function addOrEditeTab(link) { 
         	var $document = $(window.parent.frames["maipage"].document);
         	if ($document.find("#" + $(link).attr("rel")).length != 0){
         		 		$document.find("#" + $(link).attr("rel")).each(function(){
				    	 var contentname = $(this).attr("id") + "_content";
		                // hide all other tabs
		                $document.find("#content iframe").hide();
		                $document.find("#tabs li").removeClass("current");
		                // show current tab
		                $document.find("#" + contentname).show();
		                $document.find(this).parent().addClass("current");
				  });
         	}else{
         		  // hide other tabs
	            $document.find("#tabs li").removeClass("current");
	            $document.find("#content iframe").hide();
	            // add new tab and related content
	            $document.find("#tabs").append("<li class='current'><a class='tab' id='" +
                $(link).attr("rel") + "' href='#'>" + $(link).html() + 
                "</a><a href='#' class='remove'>x <label style='color: black;'>|</label></a></li>");
				$document.find("#content").append("<div><iframe  style='width: 100%;'  src='<%=path%>"+link.attr("rev")+"' id='"+$(link).attr("rel") + "_content' class=tabs-iframe></iframe></div>");
         	}
        }
</script>

		<style type="text/css">
body {
	color: #000;
	font-size: 12px;
	font-family: "Helvetica Neue", Helvetica, STheiti, 微软雅黑, 宋体, Arial,
		Tahoma, sans-serif, serif;
}

/*左侧菜单*/
.sidebar-menu {
	border-right: 1px solid #c4c8cb;
}

/*一级菜单*/
.menu-first {
	height: 45px;
	line-height: 45px;
	background-color: #0DA3DA;
	border-top: 1px solid #efefef;
	border-bottom: 1px solid #e1e1e1;
	padding: 0;
	font-size: 14px;
	font-weight: normal;
	text-align: center;
}

/*一级菜单鼠标划过状态*/
.menu-first:hover {
	text-decoration: none;
	background-color: #e9e9e9;
	border-top: 1px solid #b7b7b7;
	border-bottom: 1px solid #acacac;
}

/*二级菜单*/
.menu-second li a {
	background-color: #f6f6f6;
	color: #9788FC;
	height: 31px;
	line-height: 31px;
	border-top: 1px solid #efefef;
	border-bottom: 1px solid #efefef;
	font-size: 12px;
	text-align: center;
	height: 31px;
}

/*二级菜单鼠标划过样式*/
.menu-second li a:hover {
	text-decoration: none;
	background-color: #66c3ec;
	border-top: 1px solid #83ceed;
	border-bottom: 1px solid #83ceed;
	border-right: 3px solid #f8881c;
	border-left: 3px solid #66c3ec;
}

/*二级菜单选中状态*/
.menu-second-selected {
	background-color: #66c3ec;
	height: 31px;
	line-height: 31px;
	border-top: 1px solid #83ceed;
	border-bottom: 1px solid #83ceed;
	border-right: 3px solid #f8881c;
	border-left: 3px solid #66c3ec;
	text-align: center;
}

/*覆盖bootstrap的样式*/
.nav-list,.nav-list li a {
	padding: 0px;
	margin: 0px;
}
</style>
	</head>
	<body>
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="offset1 span2" style="margin-left: 0px; width: 100%;">
						<!--Sidebar content-->
						<div class="sidebar-menu" id="sidebar-menu">
							<c:forEach items="${userMenus}" var="menuedate" varStatus="m">
								<a href="#menue${menuedate.id}"
									class="nav-header menu-first collapsed" data-toggle="collapse">${menuedate.name}</a>
								<%--被注释的部分									<i--%>
								<%--									class="icon-user-md icon-large"></i>${menuedate.name}--%>
								<ul id="menue${menuedate.id}"
									class="nav nav-list collapse menu-second">
									<c:forEach items="${menuedate.sunTreeNodes}" var="sundate"
										varStatus="sun">
										<li>
											<a rev="${sundate.url}" rel="menue${sundate.id}" onclick="javascrpte:showTagByClick('menue${sundate.id}');">${sundate.name}</a>
											<%--被注释的部分  <i class="icon-user"></i>${sundate.name}--%>
										</li>
									</c:forEach>
								</ul>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
