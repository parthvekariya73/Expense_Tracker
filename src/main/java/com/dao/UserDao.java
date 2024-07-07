package com.dao;

import com.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDao {
    private SessionFactory factory = null;

    private Session session = null;

    private Transaction tx = null;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean saveUser(User user) {
        boolean flag = false;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();

            session.save(user);
            tx.commit();
            flag = true;

        } catch (Exception e) {
            if(tx != null) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }


    public User login(String email, String password) {
        User u = null;

        session = factory.openSession();
        Query query = session.createQuery("from User where email=:em and password=:ps");
        query.setParameter("em", email);
        query.setParameter("ps", password);

        u = (User)query.uniqueResult();


        return u;
    }

}
