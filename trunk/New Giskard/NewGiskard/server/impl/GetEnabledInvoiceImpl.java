/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:49:30 PM
 */
package com.wissen.NewGiskard.server.impl;

import java.util.List;

import com.wissen.NewGiskard.client.data.InvoiceDTO;
import com.wissen.NewGiskard.client.services.GetEnabledInvoice;
import com.wissen.NewGiskard.server.GetEnabledInvoices;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010 Description:- Service To Get The Enabled Invoice.
 */
public class GetEnabledInvoiceImpl implements GetEnabledInvoice {

    @Override
    public List<InvoiceDTO> getEnabledInvoice() throws IllegalArgumentException {

        GetEnabledInvoices getEnabledInvoices = new GetEnabledInvoices();
        List<InvoiceDTO> Ilist = getEnabledInvoices.getInvoices();

        return Ilist;

    }

}
