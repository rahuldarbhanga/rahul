package com.wissen.NewGiskard.client.services;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wissen.NewGiskard.client.data.InvoiceDTO;

public interface GetEnabledInvoiceAsync {

    void getEnabledInvoice(AsyncCallback<List<InvoiceDTO>> callback);

}
