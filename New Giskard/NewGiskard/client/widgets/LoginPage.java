/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 4:52:07 PM
 */
package com.wissen.NewGiskard.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.wissen.NewGiskard.client.controller.Controller;

/**
 * @author Rahul Patil Create Date : 04-Aug-2010 Description:- A Widget For Taking Login Information From User.
 */
public class LoginPage extends Composite {

    private VerticalPanel   loginVerticalPanel;

    private Grid            loginGrid;

    private TextBox         userNameTB;

    private PasswordTextBox passwordTB;

    private Button          loginButton, cancelButton;

    private Label           enterName, enterPassword;

    public LoginPage() {
        init();

        loginButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                authanticateUserByData();
            }
        });

        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                userNameTB.setText("");
                passwordTB.setText("");
                userNameTB.setFocus(true);

            }
        });

        initWidget(loginVerticalPanel);
    }

    // Method To Authanticate The User Information From The Database.
    protected void authanticateUserByData() {
        Controller.getInstance().userAuthantication(userNameTB.getText(), passwordTB.getText());
    }

    /**
     * Description:- Method To Display Login Widget on Screen.
     * */

    private void init() {

        loginVerticalPanel = new VerticalPanel();
        loginGrid = new Grid(5, 5);
        userNameTB = new TextBox();
        passwordTB = new PasswordTextBox();
        loginButton = new Button("Login");
        cancelButton = new Button("Cancel");
        enterName = new Label("User Name:");
        enterPassword = new Label("Password:");

        loginGrid.setWidget(0, 0, enterName);
        loginGrid.setWidget(0, 1, userNameTB);
        loginGrid.setWidget(1, 0, enterPassword);
        loginGrid.setWidget(1, 1, passwordTB);
        loginGrid.setWidget(2, 0, loginButton);
        loginGrid.setWidget(2, 1, cancelButton);

        loginButton.setEnabled(false);

        KeyPressHandler keyPressHandler = new KeyPressHandler() {

            @Override
            public void onKeyPress(KeyPressEvent event) {
                if (userNameTB.getText().equals("") || passwordTB.getText().equals("")) {
                    loginButton.setEnabled(false);
                } else {
                    loginButton.setEnabled(true);
                }

            }
        };

        userNameTB.addKeyPressHandler(keyPressHandler);
        passwordTB.addKeyPressHandler(keyPressHandler);

        loginVerticalPanel.add(loginGrid);

    }
}
