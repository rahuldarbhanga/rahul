package com.wissen.NewGiskard.client.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface AuthanticateUserService extends RemoteService {

    Boolean authanticateUser(String userName, String password) throws IllegalArgumentException;

}
