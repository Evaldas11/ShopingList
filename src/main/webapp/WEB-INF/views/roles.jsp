<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     
<jsp:include page="parts/header.jsp"></jsp:include>

<div class="content">
<a class="btn btn-primary" href="/spring/admin/">Back To Users</a>
	
	
	<h4>${user}</h4>
	<p>This User Has This Roles:</p>
	<c:set value="1" var="x"></c:set>
	<c:forEach items="${rolesList}" var="role">
		<p>${x}. <span>${role.authority}</span></p>
		<c:set value="${x+1}" var="x"></c:set>
	</c:forEach>
	

	<form action="roles" method="POST">
		<input type="hidden" name="userId" value="${user.id}"/>
		<select name="roleId">
		<c:forEach items="${roles}" var="role">
			<option value="${role.id}">${role.authority}</option>
		</c:forEach>
		</select>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit" class="btn btn-primary">Add New Role</button>
	</form>

</div>
<jsp:include page="parts/footer.jsp"></jsp:include>