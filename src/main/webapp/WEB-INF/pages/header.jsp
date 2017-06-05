<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<!-- JQuery -->
 <script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<style>
.navbar {
      margin-bottom: 0;
      background-color: #850FFA;
      z-index: 9999;
      border: 0;
      font-size: 12px !important;
      line-height: 1.42857143 !important;
      letter-spacing: 4px;
      border-radius: 0;
      font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
      color: #fff !important;
  }
  /*.navbar-nav li a:hover, .navbar-nav li.active a {
      color: #850FFA !important;
      background-color: #fff !important;
  }*/
  .navbar-nav li a:link{
  	  color: #fff !important;
      background-color: transparent !important;
  }
  .navbar-nav li a:hover, .navbar-nav li a:active{
      color: #850FFA !important;
      background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
      border-color: transparent;
      /*color: #fff !important;*/
  }
</style>

</head>
<body>                     
      <nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="nav navbar-header">
				<a class="navbar-brand" href="#">MY SHOPPEE</a></div>
			
		
			<ul class="nav navbar-nav navbar-right">
				<url:url value="/home" var="homeUrl"></url:url>
				<li class="active"><a href="${homeUrl}">HOME</a></li>
				<url:url value="/Aboutus" var="url"></url:url>
					<li><a href="${url }">ABOUT US</a></li>
				<url:url value="/admin/product/productform" var="addUrl"></url:url>
			<li><a href="${addUrl}">ADD PRODUCT</a></li>
			<url:url value="/all/product/productlist" var="viewUrl"></url:url>
			<li><a href="${viewUrl}">VIEW ALL PRODUCTS</a></li>
			<li class="dropdown"><a href="" class="dropdown-toggle"
				data-toggle="dropdown">CATEGORIES<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<c:forEach var="c" items="${categories}">
						<li><a
							href="<c:url value="/all/product/productsByCategory?searchCondition=${c.categoryDetails}"></c:url>">
								${c.categoryDetails}</a></li>
					</c:forEach>
				</ul>
			</li>
			
			<c:if test="${pageContext.request.userPrincipal.name!=null}">
				<li><a href="">Welcome
						${pageContext.request.userPrincipal.name }</a></li>
			</c:if>
			<url:url value="/all/registrationform" var="url"></url:url>

			<c:if test="${pageContext.request.userPrincipal.name==null }">
				<li><a href="${url }">REGISTER</a></li>
				<url:url value="/login" var="url"></url:url>
				<li><a href="${url }">LOGIN</a></li>


			</c:if>

			<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li><a href="<c:url value="/j_spring_security_logout"></c:url>">logout</a>
				</li>
			</c:if> 
		</ul>
	</div>
	</nav>
</body>
</html>


