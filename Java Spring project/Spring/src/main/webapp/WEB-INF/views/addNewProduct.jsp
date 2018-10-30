<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<jsp:include page="parts/header.jsp"></jsp:include>

<div class="content">
<div class="container">
	<h4> Add New Product</h4>
	<form:form method="post" modelAttribute="newProduct">
		<div class="form-group" >
			<label>Product Name</label>
			<form:input placeholder="Product Name" class="form-control" path="name"/>
		</div>
		<div class="form-group">
			<label>Amount</label>
			<form:input placeholder="Amount" class="form-control" path="amount"/>
		</div>
		<div class="form-group">
			<form:select path="type" class="form-control">
				<form:option value="0" label="Maisto Prekes"/>
				<form:option value="1" label="Buitines Prekes"/>
				<form:option value="2" label="Technika"/>
			</form:select>
		</div>
		<div class="form-group">
			<select name="shopId" class="form-control">
				<c:forEach items="${shopsList}" var="shop">
					<option value="${shop.id}">${shop.name}</option>
				</c:forEach>
			</select>
		</div>
		<!--  
		<div class="form-group">
			<form:select path="shopingShop" class="form-control">
				<form:options items="${shopsList}" itemValue="id" itemLabel="name"/>
			</form:select>
		</div>
		-->
		<button type="submit" class="btn btn-primary">Save Product</button>
	</form:form>
</div>
</div>

<jsp:include page="parts/footer.jsp"></jsp:include>