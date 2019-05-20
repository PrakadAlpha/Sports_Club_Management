<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>  
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>	
<div class="main-5">
	<form:form action="ground_reg" method="POST" modelAttribute="ground">
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" path="event">Event</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:input type="text" name="event" path="event" class="form-control input-sm"/>
						<form:errors path="event" class="error"/>				
						
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="date" path="date">Date</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:input type="date" pattern="yyyy/mm/dd" name="date" path="date" class="form-control input-sm"/>
						<form:errors path="date" class="error"/>				
						
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" path="desc">Description</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:textarea rows="5" cols="30" name="desc" path="desc" class="form-control input-sm"></form:textarea>
						<form:errors path="desc" class="error"/>				
				
				</div>
		</div>
		</div>
		<br>
			<div class="reg_btn">
				<input type="submit" value="REGISTER" class="btn btn-primary btn-sm">
			</div>
	</form:form>
</div>
<%@include file="footer.jsp" %>
    