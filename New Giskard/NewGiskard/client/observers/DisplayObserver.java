/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 12:43:00 PM
 */
package com.wissen.NewGiskard.client.observers;

import java.util.List;

import com.wissen.NewGiskard.client.data.ColumnData;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 10-Aug-2010
 */
public interface DisplayObserver {

    /**
     * Notify the observer that Display is successfull.
     */
    void notifyDisplaySucceeded(String[] header, List<ColumnData[]> columnData);

    /**
     * Notify the observer that Display is failed with error message.
     * */
    void notifyDisplayFailed(String errorMessage);

}
