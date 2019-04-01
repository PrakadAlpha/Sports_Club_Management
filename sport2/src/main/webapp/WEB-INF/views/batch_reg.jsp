<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>	
<div class="main-4">
<form:form method="POST" action="batch" class="batch_form" modelAttribute="batch">
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" path="sport_name" for="sportname">Sport Name</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:select path="sport_name" name="sport_name" class="form-control">
							<option>Cricket</option>
							<option>Football</option>
						</form:select>
						<form:errors path="sport_name" class="error"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label path="sport_time" class="col-md-3 control-lable" for="slottime">Slot Time</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:select path="sport_time" name="sport_time" class="form-control">
							<option>05.00 - 06.00</option>
							<option>06.00 - 07.00</option>
							<option>17.00 - 18.00</option>
							<option>18.00 - 19.00</option>
						</form:select>
						<form:errors path="sport_time" class="error"/>				
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<form:label class="col-md-3 control-lable" for="description" path="desc">Description</form:label>
				<div class="col-md-3" class="form-control input-sm">
						<form:textarea rows="5" cols="30" name="desc" class="form-control input-sm" path="desc"></form:textarea>
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
