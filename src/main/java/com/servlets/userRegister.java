package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entities.User;

public class userRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userRegister() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String fullname = request.getParameter("fullname");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	User u = new User(fullname, email, password);

		UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
		boolean ans = dao.saveUser(u);

		HttpSession session = request.getSession();

		if(ans) {
			session.setAttribute("msg", "Register Successfully");
			response.sendRedirect("register.jsp");
		}else {
			session.setAttribute("msg", "Something want wrong");
			response.sendRedirect("register.jsp");
		}

	}

}
