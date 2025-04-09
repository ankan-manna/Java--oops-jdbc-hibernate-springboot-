package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Alien alien1 = new Alien();
        alien1.setId(103);
        alien1.setName("Test");
        alien1.setTech("Spring");

        Configuration config=new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Alien.class);
        SessionFactory factory = config.buildSessionFactory();
        Session session=factory.openSession();

//CREATE
        //session.save(alien1); previouly used
//        Transaction tx=session.beginTransaction();
//        session.persist(alien1);
//        tx.commit();

//READ
// eger loading =>it means if we dont print a1 it must trigger a query
       Alien a1= session.find(Alien.class, 101);

        System.out.println(a1);
// lagy loading => it means if we dont print a1 it not trigger a query
       Alien a2= session.byId(Alien.class).load(101);
       Alien a3= session.byId(Alien.class).load(102);
       System.out.println(a2);

//UPDATE
        Alien alien2 = new Alien();
        alien2.setId(101);
        alien2.setName("alien1");
        alien2.setTech("Cloud");

        session.merge(alien2);// see here it just select the row in query but not update
        //because we not start any transaction
 System.out.println("see above and down");
        Transaction tx1=session.beginTransaction();
        session.merge(alien2);// if not found any data it will create new row
        tx1.commit();
//DELETE
        Transaction tx2=session.beginTransaction();
        Alien ax=session.find(Alien.class, 0);
        session.remove(ax);
        tx2.commit();

        session.close();
        factory.close();
    }
}