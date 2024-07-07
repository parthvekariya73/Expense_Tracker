package com.servlets;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entities.Expense;
import com.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UpdateExpenseServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String date = req.getParameter("date");
        String time = req.getParameter("time");
        String description = req.getParameter("description");
        String price = req.getParameter("price");

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("loginuser");

        Expense ex = new Expense(title, date, time, description, price, user);
        ex.setId(id);
        ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
        boolean ans = dao.updateExpense(ex);

        if(ans) {
            session.setAttribute("msg", "Expense Update Successfully");
            resp.sendRedirect("user/view_Expense.jsp");
        }else {
            session.setAttribute("msg", "Something want wrong");
            resp.sendRedirect("user/view_Expense.jsp");
        }

    }
}
