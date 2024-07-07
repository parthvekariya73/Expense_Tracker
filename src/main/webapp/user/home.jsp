<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<%@include file="../component/Css.jsp"%>
   <style>
        /* footer */
        #footer{
         width: 100%;
         height: 40px;
         text-align: center;
         background-color: #e0fde0 !important; box-shadow: 0 0 3px 0 rgba(0,0,0,0.3);
        }
        #footer .copyrite p{
           font-weight: 200;
           font-size: 17px;
           color: black;
        }
   </style>
</head>
<body class="bg-light">

    <c:if test="${empty loginuser}">
        <c:redirect url="../login.jsp"></c:redirect>
    </c:if>

    <%@include file="../component/Navbar.jsp" %>

    <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
    	  <div class="carousel-inner">
    	    <div class="carousel-item active">
    	      <img src="../img/p4.png" class="d-block w-100" alt="error1" height="650px">
    	    </div>
    	  </div>
    </div>

    <!--footer-->
    <footer class="footer mt-5" id="footer">
        <div class="conatiner copyrite pt-2">
            <p>copyright; 2024 @ParthVekariya - Expense Tracker, India</p>
        </div>
    </footer>


</body>
</html>