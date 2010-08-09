/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 5:57:20 PM
 */
package com.wissen.NewGiskard.server.impl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wissen.NewGiskard.client.services.AuthanticateUserService;
import com.wissen.NewGiskard.server.UserAuthantication;
import com.wissen.NewGiskard.server.domainObjects.Login;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010
 * 
 *         The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AuthanticateUserServiceImpl extends RemoteServiceServlet implements AuthanticateUserService {

    @Override
    public Boolean authanticateUser(String userName, String password) throws IllegalArgumentException {
        Boolean Tag = false;

        UserAuthantication userAuthanticate = new UserAuthantication();
        Login logDetails = userAuthanticate.authUser(userName, password);

        if (logDetails != null) {
            Tag = true;
        }
        return Tag;
    }

}
