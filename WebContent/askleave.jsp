<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>

<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    	关于我的考勤
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">我的签到</a></li>
    <li><a href="${pageContext.request.contextPath}/myaskleave">我的请假</a></li>
    <li><a href="#">我的奖惩</a></li>
  </ul>
</div>

<%@ include file="footer.jsp" %>