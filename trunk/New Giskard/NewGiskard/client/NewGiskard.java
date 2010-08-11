package com.wissen.NewGiskard.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.wissen.NewGiskard.client.controller.Controller;
import com.wissen.NewGiskard.client.data.ColumnData;
import com.wissen.NewGiskard.client.observers.DisplayObserver;
import com.wissen.NewGiskard.client.observers.LoginObserver;
import com.wissen.NewGiskard.client.widgets.DynamicTableWidget;
import com.wissen.NewGiskard.client.widgets.LoginWidget;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NewGiskard implements EntryPoint, LoginObserver, DisplayObserver {

    VerticalPanel vPanel;

    public void onModuleLoad() {
        vPanel = new VerticalPanel();
        RootPanel.get("verticalpanel").add(vPanel);
        vPanel.addStyleName("vPanel");
        vPanel.add(new LoginWidget());
        Controller.getInstance().addLoginObserver(this);
        Controller.getInstance().addDisplayObserver(this);

    }

    //****************************** Observer Methods **************************************
    @Override
    public void notifyLoginFailed(String errorMessage) {
        Window.alert(errorMessage);

    }

    @Override
    public void notifyLoginSucceeded() {
        Window.alert("Login Successfull...!!!");
        vPanel.clear();
        //   vPanel.add(new Dashboard());
        Controller.getInstance().displayEnabledInvoices();

    }

    @Override
    public void notifyDisplayFailed(String errorMessage) {
        Window.alert(errorMessage);

    }

    @Override
    public void notifyDisplaySucceeded(String[] header, List<ColumnData[]> columnData) {
        // vPanel.clear();
        vPanel.add(new DynamicTableWidget(header, columnData));
    }
}
