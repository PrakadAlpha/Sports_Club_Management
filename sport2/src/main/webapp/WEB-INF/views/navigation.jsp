<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page isELIgnored="false" %>
 
 <c:if test="${sessionScope.userid == null}">
	<div class="navbars">
	<nav role="navigation" class="navbar">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><div><a href="home" class="navbar-brand">ADMIN PORTAL</a></div></li>	
			</ul>
		</div>
	</nav>
</div> 	
 </c:if> 

 <c:if test="${sessionScope.userid != null && sessionScope.role == 1}">
	<div class="navbars">
	<nav role="navigation" class="navbar">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><div><a href="ad_portal" class="navbar-brand">HOME</a></div></li>
				<li><div><a href="logout" class="navbar-brand" id="logout">LOGOUT</a></div></li>
			</ul>
		</div>
	</nav>
</div> 	
 </c:if> 
 <c:if test="${sessionScope.userid != null && sessionScope.role == 2}">
	<div class="navbars">
	<nav role="navigation" class="navbar">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><div><a href="usr_home" class="navbar-brand">HOME</a></div></li>
				<li><div><a href="logout" class="navbar-brand">ADMIN PORTAL</a></div></li>	
				<li><div><a href="status/${sessionScope.userid}" class="navbar-brand">REQUEST STATUS</a></div></li>	
				<li><div><a href="logout" class="navbar-brand" id="logout">LOGOUT</a></div></li>
			</ul>
		</div>
	</nav>	
</div> 	
 </c:if> 

			
			