<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<jsp:include page="parts/header.jsp"></jsp:include>

<div class="content">
<div class="container">
	<h4> Update Shop</h4>
	<form:form method="post" modelAttribute="editShop">
		<div class="form-group" >
			<label>Shop Name</label>
			<form:input placeholder="Name" class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<label>Shop Address</label>
			<form:input placeholder="Address" class="form-control" path="address"/>
		</div>
		<button type="submit" class="btn btn-primary">Update Shop</button>
	</form:form>
</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>