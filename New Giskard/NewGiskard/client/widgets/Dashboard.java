/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 7:28:59 PM
 */
package com.wissen.NewGiskard.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010
 */
public class Dashboard extends Composite {

    private AbsolutePanel dashboardPanel;

    private Button        payrollButton, teamButton, invoiceButton, customerButton, logoutButton;

    public Dashboard() {

        init();

        initWidget(dashboardPanel);
    }

    /**
     * Description:- Method To Display Dashboard Widget on Screen.
     * */
    private void init() {

        dashboardPanel = new AbsolutePanel();
        payrollButton = new Button("Payroll");
        teamButton = new Button("Team");
        invoiceButton = new Button("Invoice");
        customerButton = new Button("Customer");
        logoutButton = new Button("Logout");

        dashboardPanel.setSize("630px", "170px");

        dashboardPanel.add(customerButton, 100, 20);
        dashboardPanel.add(teamButton, 200, 20);
        dashboardPanel.add(payrollButton, 270, 20);
        dashboardPanel.add(invoiceButton, 360, 20);
        dashboardPanel.add(logoutButton, 450, 20);

        logoutButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.alert("You are Successfully Logged Out...!!!");
                dashboardPanel.clear();

            }
        });

    }

}
