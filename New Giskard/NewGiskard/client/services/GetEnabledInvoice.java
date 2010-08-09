/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:41:52 PM
 */
package com.wissen.NewGiskard.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.wissen.NewGiskard.client.data.InvoiceDTO;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 */
@RemoteServiceRelativePath("invoice")
public interface GetEnabledInvoice extends RemoteService {

    List<InvoiceDTO> getEnabledInvoice() throws IllegalArgumentException;

}
