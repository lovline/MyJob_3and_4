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
	.divv{
			margin-top: 20px;
		}
</style>







<script type="text/javascript">
	function openwin(){
		
	}
	function showOrHidden(){
		//点击按钮  就显示请假信息 默认不显示。。
		var dis = document.getElementById("display");
		if(dis.style.display!="none"){
			dis.style.display="none";
			var button= document.getElementById("bb");
			button.innerHTML = "show我的请假记录";
		}
		else{
			dis.style.display="block";
			var button= document.getElementById("bb");
			button.innerHTML = "hide我的请假记录"

		}
	}
</script>

</head>
<body>
<div class="row" style="margin-top: 50px">
	<div class="col-md-2"></div>
	<div class="col-md-8">
	


