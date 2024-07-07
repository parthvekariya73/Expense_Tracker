package com.dao;

import com.entities.Expense;
import com.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ExpenseDao{

    private SessionFactory factory = null;

    private Session session = null;

    private Transaction tx = null;

    public ExpenseDao(SessionFactory factory){
        this.factory = factory;
    }

    public boolean saveExpense(Expense ex) {
        boolean flag = false;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            session.save(ex);
            tx.commit();
            flag = true;
        }catch(Exception e) {
            if(tx != null) {
                flag = false;
                e.printStackTrace();
            }
        }
        return flag;
    }


    public List<Expense> getAllExpenseByUser(User user) {
        List<Expense> list = new ArrayList<>();
        try{
            session = factory.openSession();
            Query q = session.createQuery("from Expense where user=:u");
            q.setParameter("u", user);
            list = q.list();

        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public Expense getExpenseById(int id) {
        Expense ex = null;

        System.out.println("pic.....1");
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Expense where id=:id");

            query.setParameter("id", id);
            ex = (Expense)query.uniqueResult();
;
            System.out.println("pic.....2");
        }catch(Exception e) {
            e.printStackTrace();
        }

        return ex;
    }


    public boolean updateExpense(Expense ex) {
        boolean flag = false;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            session.saveOrUpdate(ex);
            tx.commit();
            flag = true;
        }catch(Exception e) {
            if(tx != null) {
                flag = false;
                e.printStackTrace();
            }
        }
        return flag;
    }


    public boolean deleteExpense(int id) {
        boolean flag = false;

        try{

            session = factory.openSession();
            tx = session.beginTransaction();

            Expense ex = session.get(Expense.class, id);
            session.remove(ex);

            tx.commit();
            flag = true;
        }catch(Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
}
