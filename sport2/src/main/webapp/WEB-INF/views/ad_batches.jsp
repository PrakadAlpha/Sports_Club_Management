<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>
<div class="main3">

<div class="ad_batches">
<h3>Batches List</h3>
			<hr>
	<table class="table table-striped">	
			<thead>
				<tr>
					<th>User Id</th>
					<th>Sport_name</th>
					<th>Sport_time</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${batch}" var="b">
					<tr>
						<td>${b.user.id}</td>
						<td>${b.sport_name}</td>
						<td>${b.sport_time}</td>
						<td>${b.desc}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>
<%@include file="footer.jsp" %>