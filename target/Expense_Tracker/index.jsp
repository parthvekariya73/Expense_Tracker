<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Expense Tracker</title>
	<%@include file="component/Css.jsp"%>
</head>
<body>
	
	<%@include file="component/Navbar.jsp"%>

	
	<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="img/p2.avif" class="d-block w-100" alt="error1" height="650px">
	    </div>
	    <div class="carousel-item">
	      <img src="img/p1.jpg" class="d-block w-100" alt="error2" height="650px">
	    </div>
	    <div class="carousel-item">
	      <img src="img/p3.avif" class="d-block w-100" alt="error3" height="650px">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
	</div>

</body>
</html>