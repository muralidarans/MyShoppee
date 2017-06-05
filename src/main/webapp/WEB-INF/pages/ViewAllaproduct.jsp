<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Shoppee View All Products</title>
<script> 
	$(document).ready(function() {
		var searchCondition = '${searchCondition}';
		$('.table').DataTable({
			"lengthMenu" : [ [ 3, 5, 7, -1 ], [ 3, 5, 7, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition
			}
		})
	});
</script>

</head>
<body>


	<table class="table table-striped" border="1">
		<thead>
			<tr>
				<th>Image</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			

			<c:forEach items="${productList}" var="product">
				<tr>

					<url:url
						value="data:image/jpeg;base64,${product.encodedImageString}"
						var="imageurl"></url:url>
					<td><img src="${imageurl}" height="50" width="50"></td>
					<td>${product.productName}</td>
					<td>${product.price }</td>
					<td>${product.category.categoryDetails }</td>

					<url:url value="viewProduct/${product.prodcutID}" var="url1"></url:url>

					<td><a href="${url1}"><span
							class="glyphicon glyphicon-info-sign"></span></a> <url:url
							value="/admin/product/editproduct/${product.prodcutID}"
							var="url2"></url:url> <a href="${url2}"><span
							class="glyphicon glyphicon-pencil"></span></a> <url:url
							value="deleteproduct/${product.prodcutID}" var="value1"></url:url>
						<a href="${value1}"><span class="glyphicon glyphicon-trash"></span></a></td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<%@ include file="footer.jsp"%>
</body>
</html>