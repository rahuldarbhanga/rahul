/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 5:33:17 PM
 */
package com.wissen.NewGiskard.server.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010 Description :- This class Manages The Hibernet Session.
 */
public class HibernateUtill {

    private Session               session;

    private Transaction           transaction;

    private static SessionFactory sessionFactory;

    static {
        try {

            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Constructor
    public HibernateUtill() {
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    /**
     * Commit transaction and close the session
     */
    public void commit() {
        try {
            if (transaction.isActive()) {
                transaction.commit();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        closeSession();

    }

    /**
     * Close Session
     */
    private void closeSession() {
        try {
            if (session.isOpen()) {
                session.close();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Transction will be rollbacked and session will be closed.
     */
    public void rollback() {
        try {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        closeSession();
    }

    //********************************* Get - Set Methods *********************************

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

}
