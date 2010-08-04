/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 7:28:59 PM
 */
package com.wissen.NewGiskard.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010
 */
public class Dashboard extends Composite {

    private FlowPanel dashboardPanel;

    private Button    payrollButton, teamButton, invoiceButton, customerButton, logoutButton;

    public Dashboard() {

        init();

        initWidget(dashboardPanel);
    }

    /**
     * Description:- Method To Display Dashboard Widget on Screen.
     * */
    private void init() {

        dashboardPanel = new FlowPanel();
        payrollButton = new Button("Payroll");
        teamButton = new Button("Team");
        invoiceButton = new Button("Invoice");
        customerButton = new Button("Customer");
        logoutButton = new Button("Logout");

        dashboardPanel.add(customerButton);
        dashboardPanel.add(teamButton);
        dashboardPanel.add(payrollButton);
        dashboardPanel.add(invoiceButton);
        dashboardPanel.add(logoutButton);

        logoutButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {

            }
        });

    }

}
