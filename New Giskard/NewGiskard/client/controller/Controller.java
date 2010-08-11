/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:13:09 PM
 */
package com.wissen.NewGiskard.client.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.wissen.NewGiskard.client.data.ColumnData;
import com.wissen.NewGiskard.client.data.InvoiceDTO;
import com.wissen.NewGiskard.client.observers.DisplayObserver;
import com.wissen.NewGiskard.client.observers.LoginObserver;
import com.wissen.NewGiskard.client.services.AuthanticateUserService;
import com.wissen.NewGiskard.client.services.AuthanticateUserServiceAsync;
import com.wissen.NewGiskard.client.services.GetEnabledInvoice;
import com.wissen.NewGiskard.client.services.GetEnabledInvoiceAsync;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010
 */
public class Controller {

    /**
     * Create a remote service proxy to talk to the server-side AuthanticateUser service.
     */

    private final AuthanticateUserServiceAsync authService     = GWT.create(AuthanticateUserService.class);

    private final GetEnabledInvoiceAsync       geEnbInvService = GWT.create(GetEnabledInvoice.class);

    private static Controller                  _instance;

    private Controller() {
    }

    public static synchronized Controller getInstance() {
        if (_instance == null) {
            _instance = new Controller();
        }
        return _instance;
    }

    // ---------------------- Observers -------------------------------
    private List<LoginObserver>   loginObservers   = new ArrayList<LoginObserver>();

    private List<DisplayObserver> displayObservers = new ArrayList<DisplayObserver>();

    public void addLoginObserver(LoginObserver observer) {
        loginObservers.add(observer);
    }

    public void removeLoginObserver(LoginObserver observer) {
        loginObservers.remove(observer);
    }

    public void addDisplayObserver(DisplayObserver observer) {
        displayObservers.add(observer);
    }

    public void removeDisplayObserver(DisplayObserver observer) {
        displayObservers.remove(observer);
    }

    // ---------------------- Controller's Methods ---------------------
    public void userAuthantication(String userName, String password) {
        authService.authanticateUser(userName, password, loginCallback);
    }

    public void displayEnabledInvoices() {
        geEnbInvService.getEnabledInvoice(getInvoiceCallback);
    }

    List<ColumnData[]>                            listColumnData;

    InvoiceDTO                                    dto;

    // -------------------- Call Back classes ---------------------------
    private final AsyncCallback<List<InvoiceDTO>> getInvoiceCallback = new AsyncCallback<List<InvoiceDTO>>() {

                                                                         @Override
                                                                         public void onSuccess(List<InvoiceDTO> result) {
                                                                             if (result == null) {
                                                                                 Window.alert("There Are No Records in Database");
                                                                             } else {
                                                                                 listColumnData = new ArrayList<ColumnData[]>();
                                                                                 ColumnData[] columnDatas;
                                                                                 for (InvoiceDTO invoiceDTO : result) {
                                                                                     columnDatas = invoiceDTO.GetColumnData();
                                                                                     listColumnData.add(columnDatas);
                                                                                 }

                                                                                 String[] columnHeader = InvoiceDTO.GetColumnHeader();

                                                                                 for (DisplayObserver observer : displayObservers) {
                                                                                     observer.notifyDisplaySucceeded(columnHeader, listColumnData);
                                                                                 }

                                                                             }
                                                                         }

                                                                         @Override
                                                                         public void onFailure(Throwable caught) {
                                                                             Window.alert("Server Error....!!!");
                                                                             for (DisplayObserver observer : displayObservers) {
                                                                                 observer.notifyDisplayFailed("Operation Failed: " + caught);
                                                                             }
                                                                         }
                                                                     };

    AsyncCallback<Boolean>                        loginCallback      = new AsyncCallback<Boolean>() {

                                                                         @Override
                                                                         public void onFailure(Throwable caught) {
                                                                             GWT.log("Error in user validation", caught);
                                                                             for (LoginObserver observer : loginObservers) {
                                                                                 observer.notifyLoginFailed("Login Failed: " + caught);
                                                                             }
                                                                         }

                                                                         @Override
                                                                         public void onSuccess(Boolean isValid) {
                                                                             if (isValid) {
                                                                                 for (LoginObserver observer : loginObservers) {
                                                                                     observer.notifyLoginSucceeded();
                                                                                 }
                                                                             } else {
                                                                                 for (LoginObserver observer : loginObservers) {
                                                                                     observer
                                                                                             .notifyLoginFailed(" Invalid User Name Or Password...!!!");
                                                                                 }
                                                                             }
                                                                         }
                                                                     };

}
