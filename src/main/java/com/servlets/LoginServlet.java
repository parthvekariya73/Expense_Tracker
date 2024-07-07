package com.servlets;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entities.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDao dao = new UserDao(HibernateUtil.getSessionFactory());
        User u = dao.login(email, password);

        HttpSession session = req.getSession();

        if(u == null) {
            session.setAttribute("msg", "Invaild Email or Password");
            resp.sendRedirect("login.jsp");
        }else{
            session.setAttribute("loginuser", u);
            resp.sendRedirect("user/home.jsp");

        }

    }
}
