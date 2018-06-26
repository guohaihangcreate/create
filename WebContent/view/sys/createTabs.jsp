<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/view/system/init.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>导航栏</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
        $(document).ready(function() {
            $('#tabs a.tab').live('click', function() {
                // Get the tab name
                var contentname = $(this).attr("id") + "_content";
                // hide all other tabs
                $("#content iframe").hide();
                $("#tabs li").removeClass("current");

                // show current tab
                $("#" + contentname).show();
                $(this).parent().addClass("current");
            });

            $('#tabs a.remove').live('click', function() {
                // Get the tab name
                var tabid = $(this).parent().find(".tab").attr("id");

                // remove tab and related content
                var contentname = tabid + "_content";
                $("#" + contentname).remove();
                $(this).parent().remove();

                // if there is no current tab and if there are still tabs left, show the first one
                if ($("#tabs li.current").length == 0 && $("#tabs li").length > 0) {
                    // find the first tab    
                    var firsttab = $("#tabs li:first-child");
                    firsttab.addClass("current");
                    // get its link name and show related content
                    var firsttabid = $(firsttab).find("a.tab").attr("id");
                    $("#" + firsttabid + "_content").show();
                }
            });
        });
        
</script>

<style type="text/css">
body {
	font-family: Lucida Sans, Lucida Sans Unicode, Arial, Sans-Serif;
	font-size: 13px;
	margin: 0px auto;
}

#tabs {
	margin: 0;
	padding: 0;
	list-style: none;
	overflow: hidden;
}

#tabs li {
	float: left;
	display: block;
	padding: 5px;
	margin-right: 5px;
}

#tabs li a {
	color: #67A1F7;
	text-decoration: none;
}

#tabs li.current {
	background-color: #8FDBFA;
}

#tabs li.current a {
	color: #000;
	text-decoration: none;
}

#tabs li a.remove {
	color: #f00;
	margin-left: 10px;
}

#content {
	background-color: #E0E8FA;
}

#content p {
	margin: 0;
	padding: 20px 20px 100px 20px;
}

#main {
	width: 900px;
	margin: 0px auto;
	overflow: hidden;
	background-color: #F6F6F6;
	margin-top: 20px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	padding: 30px;
}

#wrapper,#doclist {
	float: left;
	margin: 0 0px 0 0;
}

#doclist {
	width: 150px;
	border-right: solid 1px #dcdcdc;
}

#doclist ul {
	margin: 0;
	list-style: none;
}

#doclist li {
	margin: 10px 0;
	padding: 0;
}

#documents {
	margin: 0;
	padding: 0;
}

#documents a {
	color: red;
}

#wrapper {
	width: 700px;
	margin-top: 20px;
}

#header {
	background-color: #F6F6F6;
	width: 900px;
	margin: 0px auto;
	margin-top: 20px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
	padding: 30px;
	position: relative;
}

#header h2 {
	font-size: 16px;
	font-weight: normal;
	margin: 0px;
	padding: 0px;
}

.content {
	border-bottom: 1px solid #B4C9C6;
	border-left: 1px solid #B4C9C6;
	border-right: 1px solid #B4C9C6;
	float: left;
	padding: 5px 0 0;
	width: 500%;
}

.content div {
	display: block;
	height: 100%;
	margin-left: 0px;
	margin-right: 0px;
	padding-left: 0;
	padding-right: 0;
	width: 100%;
	height: 100%;
}

.tabs-iframe {
	display: block;
	width: 100%;
	height: 100%;
}

.tabs {
	float: left;
	background-image: url(themes/images/nav_bg.jpg);
	width: 100%;
}

</style>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">

       
    </script>

	</head>

	<body>
		<div id="wrapper" style="width: 100%;margin: 0;padding: 0;">
				<ul id="tabs" class="tabs">
				</ul>
				<div id="content"  style="width: 100%;"></div>
	</div>
	</body>
</html>
