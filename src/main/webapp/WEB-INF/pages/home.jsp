
<html lang="en">
<head>
<title>MyShoppee Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style>
	.img-responsive{
	margin:0 auto;}
	</style>

</head>

<body>
<%@ include file="header.jsp" %>
<!--<jsp:include page="WEB-INF/pages/header.html"></jsp:include> -->
<center><h2 style="color:orange">Welcome to MyShoppee World</h2></center>
<img src="image/formal.jpg" alt="test" />
<div class="container-fluid">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="resources/images/formal.jpg" alt="first slide" >
                    <div class="container">
                        <div class="carousel-caption">
                            <h1 style="color:black">NEW ARRIVALS</h1>
                            <p>Here You Can Browse And Buy Some cool casuals</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="resources/images/shirt.jpg" alt="Second slide">
                    <div class="container">
                        <div class="carousel-caption">
                           
                            <p>online shopping can make your life more easier</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="resources/images/sports.jpg" alt="Third slide">
                    <div class="container">
                        <div class="carousel-caption">
            
                           <p style="color:yellow">BUY NOW AND ORDER NOW!!</p>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img class="forth-slide home-image " src="resources/images/summer2.jpg" alt="forth slide">
                    <div class="container">
                        <div class="carousel-caption">
                           
                            <p>your shoe,your life...run the race!!</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->

</div>


</body>
<%@ include file="footer.jsp" %>
</html>
