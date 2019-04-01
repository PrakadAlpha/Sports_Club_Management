<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>
<div class="main2">
<div class="ad_usr_table">
<h3>Users Registered List</h3>
			<hr>
	<table class="table table-striped">	
			<thead>
				<tr>
					<th>User Id</th>
					<th>FullName</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>UserName</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${user}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.fullname}</td>
						<td>${user.mobile}</td>
						<td>${user.email}</td>
						<td>${user.username}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="footer.jsp" %>