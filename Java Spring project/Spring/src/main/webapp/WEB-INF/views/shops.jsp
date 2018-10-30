<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<jsp:include page="parts/header.jsp"></jsp:include>






<div class="content">

<div class="pageTitle"><h4>Shops List</h4></div>
<div class="buttons">
	<a class="btn btn-primary" href="shops/addNew">Add New</a>	
</div>
	<table id="example" class="table table-striped table-bordered" style="width:100%">
		<thead>
			<tr>
				<th>#</th>
				<th>Shop Name</th>
				<th>Shop Address</th>
				<th>Functions</th>
			</tr>
		</thead>
		<tbody>
		<c:set value="1" var="x"></c:set>
		<c:forEach items="${shops}" var="shop">
			<tr>
				<td>${x}</td>
				<td>${shop.name}</td>
				<td>${shop.address}</td>
				<td>
					<a class="btn btn-primary" href="shops/edit?id=${shop.id}">Edit Shop</a>
					<a class="btn btn-danger" href="shops/delete?id=${shop.id}">Delete Shop</a>
				</td>
			</tr>
		<c:set value="${x+1}" var="x"></c:set>
		</c:forEach>	
		</tbody>
	</table> 
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>
       