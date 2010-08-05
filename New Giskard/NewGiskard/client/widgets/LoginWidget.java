/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 12:07:09 PM
 */
package com.wissen.NewGiskard.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.wissen.NewGiskard.client.controller.Controller;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 05-Aug-2010 Description:- A Widget For Taking Login Information From User.
 */
public class LoginWidget extends Composite {

    private AbsolutePanel   mainabsPanel  = new AbsolutePanel();

    private AbsolutePanel   loginPanel    = new AbsolutePanel();

    private TextBox         userNameText  = new TextBox();

    private PasswordTextBox passwordText  = new PasswordTextBox();

    private Label           userNameLabel = new Label("User Name ");

    private Label           passwordLabel = new Label("Password ");

    private Button          signInButton  = new Button("Sign In");

    private Button          cancelButton  = new Button("Cancel");

    private Label           warningLabel  = new Label();

    public LoginWidget() {
        init();
        initWidget(mainabsPanel);
        signInButton.setEnabled(false);

        signInButton.addClickHandler(new buttonClickHandler());

        userNameText.addKeyUpHandler(new keyupHandler());
        passwordText.addKeyUpHandler(new keyupHandler());

        cancelButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                userNameText.setText("");
                passwordText.setText("");
                userNameText.setFocus(true);

            }
        });

    }

    /*
     *   This method Initialise all widgets
     */

    private void init() {

        mainabsPanel.setSize("300px", "170px");
        mainabsPanel.addStyleName("panel");

        userNameText.setWidth("120px");
        passwordText.setWidth("120px");

        loginPanel.setSize("250px", "160px");
        loginPanel.add(userNameLabel, 0, 10);
        loginPanel.add(userNameText, 90, 10);
        loginPanel.add(passwordLabel, 0, 40);
        loginPanel.add(passwordText, 90, 40);
        loginPanel.add(signInButton, 0, 70);
        loginPanel.add(warningLabel, 0, 100);
        loginPanel.add(cancelButton, 90, 70);

        mainabsPanel.add(loginPanel, 60, 40);

    }

    /*
     *  Enable Sign In Button Only If Both Text Boxes Are Filled...
     */
    public class keyupHandler implements KeyUpHandler {

        @Override
        public void onKeyUp(KeyUpEvent event) {
            warningLabel.setText("");

            if (userNameText.getText().equals("") || passwordText.getText().equals("")) {
                signInButton.setEnabled(false);
            } else {
                signInButton.setEnabled(true);
            }
        }

    }

    public class buttonClickHandler implements ClickHandler {

        @Override
        public void onClick(ClickEvent event) {

            /*
             * Call To Controllers Method For User Autharization.
             */
            Controller.getInstance().userAuthantication(userNameText.getText(), passwordText.getText());
        }

    }

}
