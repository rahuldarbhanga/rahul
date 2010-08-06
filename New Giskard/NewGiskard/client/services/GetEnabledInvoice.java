/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:41:52 PM
 */
package com.wissen.NewGiskard.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 */
@RemoteServiceRelativePath("invoice")
public interface GetEnabledInvoice extends RemoteService {

    Boolean getEnabledInvoice() throws IllegalArgumentException;

}
