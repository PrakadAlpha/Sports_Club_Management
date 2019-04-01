<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>
<div class="main1">
	<div class="users">
		<p>Click here to get the users list..!</p>
			<a href="usr_list"><button class="btn btn-success button">User List</button></a>	
	</div>
	<div class="batches">
	<p>Click here to check the batches..!</p>
			<a href="usr_batches"><button class="btn btn-success button">Batches</button></a>
	</div>
	
	<div class="grounds">
	<p>Click here for the ground request..!</p>
			<a href="usr_grounds"><button class="btn btn-success button">Ground Request</button></a>
	</div>	
</div>
<%@include file="footer.jsp" %>
