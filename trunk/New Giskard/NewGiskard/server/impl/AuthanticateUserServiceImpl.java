/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 5:57:20 PM
 */
package com.wissen.NewGiskard.server.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.wissen.NewGiskard.client.services.AuthanticateUserService;
import com.wissen.NewGiskard.server.UserAuthantication;
import com.wissen.NewGiskard.server.constants.HttpSessionsConstants;
import com.wissen.NewGiskard.server.domainObjects.LoginDetails;

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

        HttpServletRequest request = this.getThreadLocalRequest();
        UserAuthantication userAuthanticate = new UserAuthantication();
        LoginDetails logDetails = userAuthanticate.AuthUser(userName, password);
        if (logDetails != null) {
            Tag = true;
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute(HttpSessionsConstants.USER_ID, logDetails.getId());
        }
        return Tag;
    }

}
