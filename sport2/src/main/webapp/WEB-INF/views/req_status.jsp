<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>
<div class="main-s">

<div class="req_status">
<h3>Request List</h3>
			<hr>
	<table class="table table-striped">	
			<thead>
				<tr>
					<th>Event</th>
					<th>Date</th>
					<th>Description</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ground}" var="g">
					<tr>
						<td>${g.event}</td>
						<td>${g.date}</td>
						<td>${g.desc}</td>
						<td>${g.status}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="footer.jsp" %>