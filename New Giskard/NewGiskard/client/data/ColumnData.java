/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 5:48:01 PM
 */
package com.wissen.NewGiskard.client.data;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 09-Aug-2010
 */
public class ColumnData {

    String values;

    int    type;

    public ColumnData() {
        setType(0);
    }

    //********************************** Get Set Methods ****************************************    

    public int getType() {
        return type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

}
