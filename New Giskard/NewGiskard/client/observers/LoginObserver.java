package com.wissen.NewGiskard.client.observers;

public interface LoginObserver {

    /**
     * Notify the observer that login is successfull.
     */
    void notifyLoginSucceeded();

    /**
     * Notify the observer that login is failed with error message.
     * */
    void notifyLoginFailed(String errorMessage);

}
