package com.db;

import com.entities.Expense;
import com.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory factory;

    public static SessionFactory getSessionFactory() {
        if(factory == null) {
            Configuration conf = new Configuration();
            Properties pro =new Properties();

            pro.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            pro.put(Environment.URL, "jdbc:mysql://localhost:3306/expense_tracker");
            pro.put(Environment.USER, "root");
            pro.put(Environment.PASS, "");
            pro.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
            pro.put(Environment.HBM2DDL_AUTO, "update");
            pro.put(Environment.SHOW_SQL, true);
            pro.put(Environment.FORMAT_SQL, true);

            conf.setProperties(pro);
            conf.addAnnotatedClass(User.class);
            conf.addAnnotatedClass(Expense.class);

            StandardServiceRegistry build = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            factory = conf.buildSessionFactory(build);
        }


        return factory;
    }
}
