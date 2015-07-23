<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${ title }</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css"></link>

<style type="text/css">
.divv {
	margin-top: 20px;
}

#popDiv {
	position: absolute;
	visibility: hidden;
	overflow: hidden;
	border: 2px solid #AAB9B4;
	background-color: #F7FAFA;
	cursor: move;
	padding: 1px;
}

#popTitle {
	background: #E0F2ED;
	height: 20px;
	line-height: 20px;
	padding: 1px;
}

#popForm {
	padding: 2px;
}

.title_left {
	font-weight: bold;
	padding-left: 5px;
	float: left;
}

.title_right {
	float: right;
}

#popTitle .title_right a {
	color: #000;
	text-decoration: none;
}

#popTitle .title_right a:hover {
	text-decoration: underline;
	color: #FF0000;
}
</style>

<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$("#imgbg").slideDown(2000);
		$("#imgbg2").slideDown(2000);
		$("#trOpacity").css("opacity", 0.7);
	})
	function openwin() {

	}
	function showOrHidden() {
		//点击按钮  就显示请假信息 默认不显示。。
		var dis = document.getElementById("display");
		if (dis.style.display == "none") {
			dis.style.display = "block";
			var button = document.getElementById("bb");
			button.innerHTML = "hide我的请假记录";
		} else {
			dis.style.display = "none";
			var button = document.getElementById("bb");
			button.innerHTML = "show我的请假记录"

		}
	}

	function hidePopup() {
		var popUp = document.getElementById("popupcontent");
		popUp.style.visibility = "hidden";
	}
	
	function showPopup() {//弹出层 
		var objDiv = document.getElementById("popDiv"); 
		objDiv.style.top = "50px";//设置弹出层距离上边界的距离 
		objDiv.style.left = "200px";//设置弹出层距离左边界的距离 
		objDiv.style.width = "500px";//设置弹出层的宽度 
		objDiv.style.height = "400px";//设置弹出层的高度 
		//objDiv.style.display = "block"; 
		objDiv.style.visibility = "visible"; 
		} 
		function hidePopup() {//关闭层 
		var objDiv = document.getElementById("popDiv"); 
		objDiv.style.visibility = "hidden"; 
		} 
	
	
</script>

</head>
<body>
<div class="row" style="margin-top: 50px">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	


