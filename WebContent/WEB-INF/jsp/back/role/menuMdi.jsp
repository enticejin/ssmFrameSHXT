<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
<head>

<base href="${basePath}">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="jquery,select,双向选择,列表框" />
<meta name="description" content="Helloweba演示平台，演示XHTML、CSS、jquery、PHP案例和示例" />
<title>jQuery实现列表框双向选择操作-Helloweba演示平台</title>
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
	<style type="text/css">
		#main{
			width: 500px;
		}
		.demo{width:450px; margin:20px auto}
		.select_side{float:left; width:200px}
		 select{width:200px; height:200px;border: 1px solid #404040;font-weight: bold}
		.select_opt{float:left; width:40px; height:15%; padding-top: 80px;padding-left: 10px;}
		.select_opt p{width:26px; height:26px; margin-top:6px; background:url(arr.gif) no-repeat; cursor:pointer; text-indent:-999em}
		.select_opt p#toright{background-position:2px 0}
		.select_opt p#toleft{background-position:2px -22px}
		.sub_btn{clear:both; height:42px; line-height:42px; padding-top:10px; text-align:center}
	</style>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript">
$(function(){
    var leftSel = $("#selectL");
	var rightSel = $("#selectR");
	$("#toright").bind("click",function(){		
		leftSel.find("option:selected").each(function(){
			$(this).remove().appendTo(rightSel);
		});
	});
	$("#toleft").bind("click",function(){		
		rightSel.find("option:selected").each(function(){
			$(this).remove().appendTo(leftSel);
		});
	});
	leftSel.dblclick(function(){
		$(this).find("option:selected").each(function(){
			$(this).remove().appendTo(rightSel);
		});
	});
	rightSel.dblclick(function(){
		$(this).find("option:selected").each(function(){
			$(this).remove().appendTo(leftSel);
		});
	});

});
</script>
</head>

<body>
	<form id="forms" action="back/menuMdiDo" method="post">
		<input type="hidden" name="role_id" value="${role_id }">
	<div id="main">
	  <h2 align="center">分配权限</h2>
	  <div class="demo">
		 <div class="select_side">
		 <p align="center">未拥有权限</p>
		 <select id="selectL" name="selectL" multiple="multiple">
		 	<c:forEach items="${noList }" var="menu">
			 	<option value="${menu.menu_id }">${menu.menu_name }</option>
			 </c:forEach>
			
		 </select>
		 </div>
		 <div class="select_opt">
			<p id="toright" title="添加">&gt;</p>
			<p id="toleft" title="移除">&lt;</p>
		 </div>
		 <div class="select_side">
		 <p align="center">已拥有权限</p>
		 <select id="selectR" name="selectR" multiple="multiple">
		 	<c:forEach items="${havList }" var="rlm">
			 	<option name="roles" value="${rlm.menu.menu_id }">${rlm.menu.menu_name }</option>
			 </c:forEach>
		 </select>
		 </div>
		 <div class="sub_btn"><input type="button" onclick="f()" class="btn btn-primary radius" id="sub" value="确认" /></div>
	  </div>

	</div>
	</form>
	<script type="text/javascript">
		function f() {
			$("option[name='roles']").attr("selected","selected");
			$("#forms").submit();
		}
	</script>

</body>
</html>