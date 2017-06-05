<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Shoppee Add Product here</title>
 
</head>
<body>
<%@ include file="header.jsp" %> 

<div class="container-wrapper">
<div class="container">
<url:url var="url1" value="/admin/product/addProduct"></url:url>
<form:form action="${url1}" modelAttribute="productObj" method="post" enctype="multipart/form-data">

<div class="form-group">
<label for="productID"></label>
<form:hidden path="productID" ></form:hidden>
<form:errors path="productID" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="productName">Enter Product name</label>
<form:input path="productName"></form:input>
<form:errors path="productName" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="description">Enter Description</label>
<form:input path="description"></form:input>
<form:errors path="description" cssStyle="color:red"></form:errors>
</div>


<div class="form-group">
<label for="Manufacturer">Product Manufacturer</label>
<form:input  path="manufacturer"></form:input>
<form:errors path="manufacturer" cssStyle="color:red"></form:errors>
</div>


<div class="form-group">
<label for="Price">Product Price</label>
<form:input  path="price"></form:input>
<form:errors path="price" cssStyle="color:red"></form:errors>
</div>


<div class="form-group">
<label for="unitInStock">Unit In Stock</label>
<form:input  path="unitInStock"></form:input>
<form:errors path="unitInStock" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="category">Select Category</label>
<c:forEach items="${categorydetails}" var="c">
 
<form:radiobutton path="category.cid" value="${c.cid }"/>${c.categoryDetails }

</c:forEach>
<form:errors path="category" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="image">Upload Image</label>
<input type="file" name="image" >
</div>


<input type="submit" value="addProduct">

</form:form>
<%@ include file="footer.jsp" %>
</div>

</div>
</body>
</html>