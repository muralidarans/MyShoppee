<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp" %>
<body>


<url:url value="data:image/jpeg;base64,${product.encodedImageString}" var="imageurl"></url:url>

PRICE       :   <c:out value="${product.price}"/>         <br>
MANUFACTURER:   ${product.manufacturer}         <br>
DESCRIPTION :	${product.description}		<Br>
Unit In Stock :	${product.unitInStock}		<Br>

<img src="${imageurl}" width="200" height="200">
<url:url value="/all/product/productlist" var="url"></url:url>
<a href="${url }">View All Products</a>
</body>
</html>