<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import="com.tusheng.oa.AbsenceBean"%> 
<%@page import="java.util.*"%>
<%@ include file="header.jsp" %>


<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
    	关于我的考勤
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">我的签到</a></li>
    <li><a href="#">我的请假</a></li>
    <li><a href="#">我的奖惩</a></li>
  </ul>
  &nbsp; &nbsp; &nbsp;
  <button class="btn btn-default" id="bb" type="button"  onclick="showOrHidden()">hide我的请假记录</button>
  <div style="margin-right: 10px;float: right">
  	 <button type="button" class="btn btn-success" onclick="openwin()"><font size="3">紧急请假申请</font></button>
  </div>
 
</div>
<div class="divv">
	<form action="" method="get">
	<div>
	   <div style="margin-top: 10px;border-top: 1px solid green; padding-top:20px;" >
		   	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   	类别：<select style="width:174px;height:26px" name="select">
		   			<option  value=""  selected>
		   			<option  value="病假" >病假
		   			<option  value="事假" >事假
		   			<option  value="出差" >出差
		   			<option  value="婚假" >婚假
		   			<option  value="其他" >其他
		   		</select>
		</div>
		<div style="float: right" >
	 	  <div class="divv">
	   		<table>
	   			<tr>
	   				<td>申请备注：</td>
	   			</tr>
	   			<tr>
	   				<td><textarea rows="2" cols="50" name="remark"></textarea></td>
	   			</tr>
	   		</table>
	   </div>
	 </div>
		<div class="divv">
			申请时间：<input  type="text" name="application_start" id="d241" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
			到<input type="text" name="application_end" id="d241" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
		</div>
	   <div class="divv" >
			开始时间：<input type="text" name="start_time" id="d241" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
			到<input type="text" name="end_time" id="d241" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> 
	   </div>
	   <div align="center" style="width: 200px">
	   	  <input class="btn btn-primary"  style="margin-top: 20px" type="submit" value="申请" />
	   </div>
	  
	 </div>
	 <div>
		  <hr style="border:1px solid blue"/>
	 </div>
	</form>
</div>
<div style="border-top: 2px solid blue" id="display">
	<table class="table table-striped table-hover">
		<tr>
  			<td>申请时间</td>
			<td>申请人</td>
			<td>类别</td>
			<td>请假天数</td>
			<td>开始时间</td>
			<td>结束时间</td>
			<td>申请备注</td>
			<td>当前状态</td>
			<td>审核人</td>
		</tr>
	 	<c:choose>
      	<c:when test="${is_logged}">
      		
	      	<c:forEach items="${ arrList }" var="abb">  
            <tr>  
                <td>${ abb.getCreated_at() }</td>  
                <td>${ user_name  }</td>  
                <td>${ abb.getType() }</td>  
                <td>${ abb.getDays() }</td>  
                <td>${ abb.getStart_time() }</td>  
                <td>${ abb.getEnd_time() }</td>  
                <td>${ abb.getRemark() }</td>  
                <td>${ abb.getStatus() }</td>  
                <td></td>  
            </tr>  
        </c:forEach>  
			
      	</c:when>
      	<c:otherwise>
      		<tr>
      			<td colspan="9" align="center">没有符合条件的数据记录。</td>
      		</tr>
      	</c:otherwise>
        </c:choose>
	</table>
</div>

<div  id="divFloat" align="center" style="position: absolute; z-index: 3; display: none; background-color: #fff;">
	<div  >
		开始时间：<input type="text" name="start_time" id="d241" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> <br />
		返回时间<input type="text" name="end_time" id="d241" class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> 
   </div>
   <div align="center" style="width: 200px">
   	  <input class="btn btn-primary"  style="margin-top: 20px" type="submit" value="申请" />
   </div>
</div>






<%@ include file="footer.jsp" %>