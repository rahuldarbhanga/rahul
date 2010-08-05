package com.wissen.NewGiskard.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.wissen.NewGiskard.client.controller.Controller;
import com.wissen.NewGiskard.client.observers.LoginObserver;
import com.wissen.NewGiskard.client.widgets.Dashboard;
import com.wissen.NewGiskard.client.widgets.LoginWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NewGiskard implements EntryPoint, LoginObserver {

    VerticalPanel vPanel;

    public void onModuleLoad() {
        vPanel = new VerticalPanel();
        RootPanel.get("verticalpanel").add(vPanel);
        vPanel.addStyleName("vPanel");
        vPanel.add(new LoginWidget());
        Controller.getInstance().addLoginObserver(this);

    }

    //****************************** Observer Methods **************************************
    @Override
    public void notifyLoginFailed(String errorMessage) {
        Window.alert("Login Failed...!!!" + errorMessage);

    }

    @Override
    public void notifyLoginSucceeded() {
        Window.alert("Login Successfull...!!!");
        vPanel.clear();
        vPanel.add(new Dashboard());

    }
}
