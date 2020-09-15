<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Add Product
	<br />
	<form action="/addProduct" method="post">
		<input type="hidden" name="id" value="${prod.id }"> Name <input type="text" value="${prod.name }"
			name="name"><br /> Price <input type="number" name="price" value="${prod.price }"><br />
		Quantity <input type="number" name="quantity" value="${prod.quantity }"> <input
			type="submit" value="Add">
	</form>

	List of Products
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Price</td>
			<td>Quantity</td>
		</tr>
		<c:forEach var="product" items="${productList }">
		<tr>
			<td><a href="/productById/${product.id }">${product.id }</a></td>
			<td>${product.name }</td>
			<td>${product.price }</td>
			<td>${product.quantity }</td>

		</tr>
		</c:forEach>
	</table>
</body>
</html>