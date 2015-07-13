<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>

<c:if test="${ hasAlert }">
				<div class="alert alert-warning alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					${ alert }
				</div>
			</c:if>

<div class="row">
<div class='col-md-8'>
<form class="form-horizontal" method="post">
  <div class="form-group" style="margin-top: 30px">
    <label for="username" class="col-sm-2 control-label"><font size="4">u</font><font size="3">sername</font></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="username" name="username" placeholder="user name">
    </div>
  </div>
  <div class="form-group" style="margin-top: 20px">
    <label for="password" class="col-sm-2 control-label"><font size="4">p</font><font size="3">assword</font></label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" name="password" placeholder="pass word">
    </div>
  </div>
  <div class="form-group" style="margin-top: 20px">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox" name="remember" > remember me .
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success btn-lg">登录</button>
    </div>
  </div>
</form>
</div>
<div class="col-md-4" style="border-right:1px solid blue;margin-top: 40px;">
	<div style="margin-left: 100px">
			<h4>完成登陆后</h4>
		<ul>
			<li>考勤</li>
			<li>查看公司公告</li>
			<li>其他</li>
		</ul>
	</div>
</div>
</div>
<%@ include file="footer.jsp" %>