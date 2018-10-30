<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    
<jsp:include page="parts/header.jsp"></jsp:include>

<div class="content">

	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Username</th>
				<th scope="col">Email</th>
				<th scope="col">Status</th>
				<th scope="col">Roles</th>
			</tr>
		</thead>
		<tbody>
		<c:set value="1" var="x"></c:set>
		<c:forEach items="${usersList}" var="user">
			<tr>
				<th scope="row">${x}</th>
				<td>${user.username}</td>
				<td>${user.email}</td>
				<td>${user.enabled}</td>
				<td><a class="btn btn-primary" href="/spring/admin/roles?id=${user.id}">Roles</a></td>
			</tr>
			<c:set value="${x+1}" var="x"></c:set>
		</c:forEach>	
		</tbody>
	</table>



</div>
<jsp:include page="parts/footer.jsp"></jsp:include>