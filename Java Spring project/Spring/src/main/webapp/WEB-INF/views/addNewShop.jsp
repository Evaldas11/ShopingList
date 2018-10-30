<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<jsp:include page="parts/header.jsp"></jsp:include>

<div class="content">
<div class="container">
	<h4> Add New Shop</h4>
	<form:form method="post" modelAttribute="shop">
		<div class="form-group" >
			<label>Shop Name</label>
			<form:input placeholder="Name" class="form-control" path="name" required="required"/>
		</div>
		<div class="row"><form:errors path="name" class="alert alert-danger"/></div> 
		<div class="form-group">
			<label>Shop Address</label>
			<form:input placeholder="Address" class="form-control" path="address" required="required"/>
			<form:errors path="address"/>
		</div>
		<div class="row"><form:errors path="address" class="alert alert-danger"/></div> 
		<button type="submit" class="btn btn-primary">Save Shop</button>
	</form:form>
</div>
</div>
<jsp:include page="parts/footer.jsp"></jsp:include>