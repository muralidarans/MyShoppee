<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Shoppee View All Products</title>

  
</head>
<body>
<%@ include file="header.jsp" %> 
<div class="container-wrapper">
<div class="container">
	<table >
		<tr>
			<th>Product Name</th><th>Price</th><th>Manufacturer</th><th>Action</th>
		</tr>

		<c:forEach items="${productList}" var="product" >
		<tr>
			<url:url value="/resources/images/${product.prodcutID}.png" var="url"></url:url>			
			
			<td><img src="${url}" height="50" width="50" ></td>
			<td>${product.productName}</td>
			<td>${product.price }</td>
			<td>${product.manufacturer }</td>
			
			<url:url value="viewProduct/${product.prodcutID}" var="url1"></url:url>
			
			<td><a href="${url1}"><span class="glyphicon glyphicon-info-sign"></span></a></td>

			<url:url value="editproduct/${product.prodcutID}" var="url2"></url:url>
			<td><a href="${url2}"><span class="glyphicon glyphicon-pencil"></span></a>


			<url:url value="deleteproduct/${product.prodcutID}" var="value1"></url:url>
			<td>  <a href="${value1}"><span class="glyphicon glyphicon-trash"></span></a></td>		
		</tr>

</c:forEach>
</table>
</div></div>
</body>
</html>