/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:50:59 PM
 */
package com.wissen.NewGiskard.server;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wissen.NewGiskard.client.data.InvoiceDTO;
import com.wissen.NewGiskard.server.domainObjects.Invoice;
import com.wissen.NewGiskard.server.hibernate.HibernateUtill;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 * 
 *         Description:- Method For Getting Only Enabled Invoices From Invoice Database.
 */

public class GetEnabledInvoices {

    @SuppressWarnings("unchecked")
    public List<InvoiceDTO> getInvoices() {

        HibernateUtill hibernateUtill = new HibernateUtill();

        Session session = hibernateUtill.getSession();

        Query userAuthanticationQuery = session.createQuery(" from Invoice invoice where invoice.enabledFlag = '1' order by invoice_id");

        return invoiceConvertToInvoiceDTO(userAuthanticationQuery.list());

    }

    /**
     * This Method Converts Client Side Object To Server Side Object.
     * 
     */
    public List<InvoiceDTO> invoiceConvertToInvoiceDTO(List<Invoice> Ilist) {

        List<InvoiceDTO> inList = new ArrayList<InvoiceDTO>();

        for (Invoice i : Ilist) {
            InvoiceDTO in = new InvoiceDTO();
            in.setDescription(i.getDescription());
            in.setEnabled(i.getEnabledFlag());
            in.setId(i.getInvoiceId());
            in.setInvoice_no(i.getInvoiceNo());
            in.setRecieved(i.getRecievedFlag());
            in.setAmount(i.getTotalAmount());
            in.setCreatedTimeStamp(i.getCreatedTimeStamp());
            in.setUpdatedTimestamp(i.getUpdatedTimeStamp());

            inList.add(in);

        }
        return inList;

    }
}
