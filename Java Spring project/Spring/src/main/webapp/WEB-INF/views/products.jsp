<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<jsp:include page="parts/header.jsp"></jsp:include>

<div class="content">

<div class="pageTitle"><h4>Un Purchase Products List</h4></div>
<div class="shopList">
	<div class="buttons">
		<a class="btn btn-primary" href="products/addNewProduct">Add New Product To The List</a>	
	</div>
	<div class="dropdown">
  		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    	Choose Shop
  		</button>
  		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
  			<a class="dropdown-item" href="/spring/products">ALL</a>
  			<c:forEach items="${shops}" var="shop">
		  	<a class="dropdown-item" href="/spring/products/selected?id=${shop.id}">${shop.name}</a>
			</c:forEach>    
  		</div>
	</div>
</div>
	<table id="example" class="table table-striped table-bordered" style="width:100%">
		<thead>
			<tr>
				<th>#</th>
				<th>Product Description</th>
				<th>Product Amount</th>
				<th>Shop Name</th>
				<th>Functions</th>
			</tr>
		</thead>
		<tbody>
		<c:set value="1" var="x"></c:set>
		<c:forEach items="${unPurchaseProducts}" var="product">
			<tr>
				<td>${x}</td>
				<td>${product.name}</td>
				<td>${product.amount}</td>
				<td>${product.shopingShop.name}</td>
				<td>
					<a class="btn btn-primary" href="products/purchase?id=${product.id}">Purchase Product</a>
					<a class="btn btn-danger" href="products/delete?id=${product.id}">Delete Product</a>
				</td>
			</tr>
		<c:set value="${x+1}" var="x"></c:set>
		</c:forEach>	
		</tbody>
	</table> 
</div>


<jsp:include page="parts/footer.jsp"></jsp:include>