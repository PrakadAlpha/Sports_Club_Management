<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>  
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>	
<div class="main-5">
	<form action="ground" method="POST">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="event">Event</label>
				<div class="col-md-3" class="form-control input-sm">
						<input type="text" name="event" class="form-control input-sm"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="date">Date</label>
				<div class="col-md-3" class="form-control input-sm">
						<input type="date" pattern="dd/MM/yyyy" name="date" class="form-control input-sm"/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="description">Description</label>
				<div class="col-md-3" class="form-control input-sm">
						<textarea rows="5" cols="30" name="desc" class="form-control input-sm"></textarea>
				</div>
		</div>
		</div>
		<input type="hidden" id="user" name="userid" value="${sessionScope.userid}"/>
		<br>
			<div class="reg_btn">
				<input type="submit" value="REGISTER" class="btn btn-primary btn-sm">
			</div>
	</form>
</div>
<%@include file="footer.jsp" %>
    