<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %> 
<%@include file="header.jsp" %>
<%@include file="navigation.jsp" %>
<div class="main4">

	<div class="ad_grounds">
<h3>Ground Request List</h3>
			<hr>
	<table class="table table-striped">	
			<thead>
				<tr>
					<th>Id</th>
					<th>Event</th>
					<th>Date</th>
					<th>Description</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ground}" var="g">
					<tr>
						<td>${g.user.id}</td>
						<td>${g.event}</td>
						<td>${g.date}</td>
						<td>${g.desc}</td>
						<c:if test="${g.status == '' || g.status == NULL}">
							<td><a class="btn btn-success" href="approved/${g.id}">Approve</a>&nbsp;
							    <a class="btn btn-danger" href="reject/${g.id}">Reject</a></td>
						</c:if>
						<c:if test="${g.status == 'APPROVED'}">
							<td>APPROVED</td>
						</c:if>
						<c:if test="${g.status == 'REJECTED'}">
							<td>REJECTED</td>
						</c:if></tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
 </div>
<%@include file="footer.jsp" %>