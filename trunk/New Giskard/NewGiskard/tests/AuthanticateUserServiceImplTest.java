/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 1:06:40 PM
 */
package com.wissen.NewGiskard.server.impl.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wissen.NewGiskard.server.impl.AuthanticateUserServiceImpl;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 05-Aug-2010
 * 
 *         Desrcription:- A Class Created To Test the AuthanticateUserServiceImpl Service.
 */
public class AuthanticateUserServiceImplTest {

    private AuthanticateUserServiceImpl service;

    Connection                          connection = null;

    Statement                           statement;

    ResultSet                           resultSet;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        service = new AuthanticateUserServiceImpl();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewGiskard", "root", "wissen");
            statement = connection.createStatement();
            statement.execute("insert into GiskardLoginData values(1,'Rahul' ,'Swapnil')");
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        try {
            statement = connection.createStatement();
            statement.execute("delete from GiskardLoginData where LoginId = 1");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*
     * Test Case for a Vaild User name and Password
     */

    @Test
    public void testAuthUserBothCorrect() {
        Boolean result;

        result = service.authanticateUser("Rahul", "Rahul");

        assertTrue("The Result is: " + result + "  Instead of True", result = true);

    }

    /*
     * Test Case for a InVaild User name.
     */

    @Test
    public void testAuthUserWrongUsername() {
        Boolean result;
        result = service.authanticateUser("Ra", "Rahul");
        assertFalse("The Result is: " + result + " Instead of True", result = false);

    }

    /*
     * Test Case for a InVaild Password.
     */
    @Test
    public void testAuthUserWrongPassword() {
        Boolean result;
        result = service.authanticateUser("Rahul", "Ra");
        assertFalse("The Result is:" + result + "  Instead of True", result = false);

    }

}
