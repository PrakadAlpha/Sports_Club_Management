<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>
<div class="main-2">	
<div class="form">
	<h3>User Registration Form</h3><br>
	<form:form method="POST" action="register" modelAttribute="users">
	
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="fullname" path="fullname">Full Name</form:label>
				<div class="col-md-3">
					<form:input type="text" class="form-control input-sm" name="fullname" path="fullname"></form:input>
					<form:errors class="error" path="fullname"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="mobile" path="mobile">Mobile Number</form:label>
				<div class="col-md-3">
					<form:input type="tel" class="form-control input-sm" name="mobile" path="mobile"></form:input>
				<form:errors class="error" path="mobile"/>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="email" path="email">Email</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:input type="email" class="form-control input-sm" name="email" path="email"></form:input>
						<form:errors class="error" path="email"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="address" path="address">Address</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:input type="text" class="form-control input-sm" name="address" path="address"></form:input>
						<form:errors class="error" path="address"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="username" path="username">Username</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:input type="text" class="form-control input-sm" name="username" path="username"></form:input>
						<form:errors class="error" path="username"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="password" path="password">Password</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:input type="password" class="form-control input-sm" name="password" path="password"></form:input>
						<form:errors class="error" path="password"/>
				</div>
			</div>
		</div><br>
		
			<div class="row buttons">
				<input type="submit" value="REGISTER" class="btn btn-primary btn-sm">
				<button type="reset" class="btn btn-sm btn-light">CLEAR</button>
			</div>
			
			
	</form:form><br>
	</div>
</div>																																																																																																																																																																																																																																																																		
<%@include file="footer.jsp" %>