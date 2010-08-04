/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 5:17:34 PM
 */
package com.wissen.NewGiskard.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010
 */
public class LoginData implements IsSerializable {

    private String userName, password;

    //********************************** Get - Set Methods *********************************************

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
