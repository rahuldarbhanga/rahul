/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 5:23:56 PM
 */
package com.wissen.NewGiskard.server.domainObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 04-Aug-2010
 */
@Entity
@Table(name = "GiskardLoginData")
public class LoginDetails {

    @Id
    @Column(name = "LoginId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int    id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;

    //*************************************** Get - Set Methods **********************************

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
