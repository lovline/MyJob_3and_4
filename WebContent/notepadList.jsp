<%@page import="com.tusheng.oa.NotepadBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<% ArrayList<NotepadBean> arrayList =  (ArrayList<NotepadBean>) request.getAttribute("resultSet");%>
 <ul >
 <c:choose>
      	<c:when test="${is_logged}" >
      	<li><a href="${pageContext.request.contextPath}/notepadDetails/">记事本详情</a></li>
      	<li><a href="${pageContext.request.contextPath}/editNotepad/">记事本编辑</a></li>
      	</c:when>
      	<c:otherwise>
      	<li><a href="${pageContext.request.contextPath}/register/">注册</a></li>
      	<li><a href="${pageContext.request.contextPath}/login/">登录</a></li>
      	</c:otherwise>
        </c:choose>
 </ul>

<%@ include file="footer.jsp" %>
