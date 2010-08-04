package com.wissen.NewGiskard.client.services;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AuthanticateUser Service</code>.
 */
public interface AuthanticateUserServiceAsync {

    void authanticateUser(String userName, String password, AsyncCallback<Boolean> callback);

}
