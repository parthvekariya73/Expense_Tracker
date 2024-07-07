<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%@page import="com.entities.User" %>
<%@page import="com.entities.Expense" %>
<%@page import="com.dao.ExpenseDao" %>
<%@page import="com.db.HibernateUtil" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<%@include file="../component/Css.jsp"%>
    <style>
		.card-sh{
			box-shadow: 0 0 6px 0 rgba(0,0,0,0.3);
		}
	</style>
</head>
<body class="bg-light">

    <c:if test="${empty loginuser}">
        <c:redirect url="../login.jsp"></c:redirect>
    </c:if>

    <%@include file="../component/Navbar.jsp" %>

    <div class="container p-5">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card card-sh">

                    <div class="card-header text-center">
                        <p class="fx-3">All Expenses</p>
                        <c:if test="${not empty msg}">
						    <p class="text-center text-success fs-4" >${msg}</p>
						    <c:remove var="msg" />
						</c:if>
                    </div>

                    <div class="card-body">
                        <table class="table">
                          <thead>
                            <tr>
                              <th scope="col">Title</th>
                              <th scope="col">Description</th>
                              <th scope="col">Date</th>
                              <th scope="col">Time</th>
                              <th scope="col">Price</th>
                              <th scope="col">Action</th>
                            </tr>
                          </thead>
                          <tbody>

                            <%
                                User user = (User)session.getAttribute("loginuser");
                                ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
                                List<Expense> list = dao.getAllExpenseByUser(user);
                                for(Expense ex : list) {
                            %>
                            <tr>
                              <th scope="row"><%= ex.getTitle() %></th>
                              <td><%= ex.getDescription() %></td>
                              <td><%= ex.getDate() %></td>
                              <td><%= ex.getTime() %></td>
                              <td><%= ex.getPrice() %></td>
                              <td>
                                <a href="edit_Expense.jsp?id=<%= ex.getId() %>" class="btn btn-sm btn-primary me-1">Edit</a>
                                <a href="../DeleteExpenseServlet?id=<%= ex.getId() %>" class="btn btn-sm btn-danger me-1">Delete</a>
                              </td>
                            </tr>
                            <%
                                }
                            %>

                          </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>