/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:50:59 PM
 */
package com.wissen.NewGiskard.server;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wissen.NewGiskard.client.data.InvoiceInfo;
import com.wissen.NewGiskard.server.hibernate.HibernateUtill;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 * 
 *         Description:- Method For Getting Only Enabled Invoices From Invoice Database.
 */

public class GetEnabledInvoices {

    public List<InvoiceInfo> getInvoices() {

        HibernateUtill hibernateUtill = new HibernateUtill();

        Session session = hibernateUtill.getSession();

        Query userAuthanticationQuery = session.createQuery("from InvoiceDetails invoice where invoice.enabledFlag = '1' ");

        List<InvoiceInfo> Ilist = userAuthanticationQuery.list();

        return Ilist;

    }

}
