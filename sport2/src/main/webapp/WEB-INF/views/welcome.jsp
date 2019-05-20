<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<div class="main">
			<div class="login" >
				<h2>User Login</h2><br>
				<c:if test="${err != null }">
					<p>${err}</p>
				</c:if>
				<c:if test="${logout != null }">
					<p>${logout}</p>
				</c:if>
				
				<form action="usr_login" method="POST">
					<div class="row">
					<div class="form-group col-xs-5">
						<label>Username</label>
						<input type="text" class="form-control" name="username"/>
					</div>
					</div>
					<div class="row">
					<div class="form-group col-xs-5">
						<label>Password</label>
						<input type="password" class="form-control" name="password"/>
					</div>
					</div>
					<input type="submit" class="btn btn-light"value="LOGIN"/>
					<a href="usr_register" class="btn btn-light">REGISTER</a>
				</form>
			</div>
			<div class="news">
				<h2 style="text-align: center;">News Update</h2>
				<ul class="list1">
					<li>Ground Bookings are open..!</li>
					<li>Batches for training are open for cricket</li>
				 	<li>Batches for training are open for cricket</li>
				</ul>
			</div>
</div>

<%@include file="footer.jsp" %>
