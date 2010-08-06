/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:49:30 PM
 */
package com.wissen.NewGiskard.server.impl;

import java.util.List;

import com.wissen.NewGiskard.client.data.InvoiceInfo;
import com.wissen.NewGiskard.client.services.GetEnabledInvoice;
import com.wissen.NewGiskard.server.GetEnabledInvoices;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010 Description:- Service To Get The Enabled Invoice.
 */
public class GetEnabledInvoiceImpl implements GetEnabledInvoice {

    @Override
    public Boolean getEnabledInvoice() throws IllegalArgumentException {

        Boolean Tag = false;

        GetEnabledInvoices getEnabledInvoices = new GetEnabledInvoices();
        List<InvoiceInfo> Ilist = getEnabledInvoices.getInvoices();

        if (Ilist != null) {
            Tag = true;
        }
        return Tag;

    }

}
