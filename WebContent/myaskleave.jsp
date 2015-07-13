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
  &nbsp; &nbsp; &nbsp;
  <input class="btn btn-default" type="button" value="关于我的请假记录" />
</div>
<div>
	<form>
	   <div style="margin-top: 10px;border-top: 1px solid green;padding-top: 20px" >
		   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   	类别：<select style="width: 174px;height: 26px">
		   			<option  value="bj"  selected>病假
		   			<option  value="sj" >事假
		   			<option  value="cc" >出差
		   			<option  value="hj" >婚假
		   			<option  value="qt" >其他
		   		</select>
			申请时间：<input type="text" name="application_start" /> 
			到<input type="text" name="application_end" /> 
	   </div>
	   <div style="margin-top: 20px">
			申请备注：<input type="text" name="remark" /> 
			开始时间：<input type="text" name="start_time" /> 
			到<input type="text" name="end_time" /> 
	   </div>
	
	
	</form>
</div>




<%@ include file="footer.jsp" %>