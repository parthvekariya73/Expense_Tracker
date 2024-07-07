package com.servlets;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteExpenseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
        boolean ans = dao.deleteExpense(id);

        HttpSession session = req.getSession();

        if(ans) {
            session.setAttribute("msg", "Expense Delete Successfully");
            resp.sendRedirect("user/view_Expense.jsp");
        }else {
            session.setAttribute("msg", "Something want wrong");
            resp.sendRedirect("user/view_Expense.jsp");
        }
    }
}
