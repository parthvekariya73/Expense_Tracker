<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

	<!-- narbar -->
	<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e0fde0 !important; box-shadow: 0 0 3px 0 rgba(0,0,0,0.3);">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="index.jsp">Expense Tracker</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">

	      <c:if test="${ empty loginuser }">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" href="index.jsp"><i class="fa-solid fa-house"></i> Home</a>
                  </li>
                </ul>
          </c:if>

	      <c:if test="${not empty loginuser }">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                      <a class="nav-link active" href="home.jsp"><i class="fa-solid fa-house"></i> Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="add_Expense.jsp">
                            <i class="fa-solid fa-plus"></i> Add Expense
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="view_Expense.jsp">
                            <i class="fa-solid fa-list"></i> View Expense
                        </a>
                    </li>
                </ul>
	      </c:if>

	      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <c:if test="${not empty loginuser }">
                  <li class="nav-item">
                      <a class="nav-link active" href="#"><i class="fa-solid fa-circle-user"></i> ${loginuser.fullname }</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="../LogoutServlet"><i class="fa-solid fa-right-to-bracket"></i> Logout</a>
                    </li>
                </c:if>

                <c:if test="${ empty loginuser }">
                    <li class="nav-item">
                      <a class="nav-link active" href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i> Login</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link active" href="register.jsp"><i class="fa-solid fa-user-plus"></i> Register</a>
                    </li>
                </c:if>
	      </ul>

	    </div>
	  </div>
	</nav>
