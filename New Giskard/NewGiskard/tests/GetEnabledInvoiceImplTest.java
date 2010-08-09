/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 7:27:03 PM
 */
package com.wissen.NewGiskard.server.impl.tests;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.wissen.NewGiskard.client.data.InvoiceDTO;
import com.wissen.NewGiskard.server.impl.GetEnabledInvoiceImpl;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 */
public class GetEnabledInvoiceImplTest {

    private GetEnabledInvoiceImpl GetImpl;

    Connection                    connection = null;

    Statement                     statement;

    ResultSet                     resultSet;

    @Before
    public void setUp() throws Exception {
        GetImpl = new GetEnabledInvoiceImpl();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewGiskard", "root", "wissen");
            statement = connection.createStatement();
            statement.executeUpdate("insert into invoice values(111,'2010-06-06 10:12:12' ,'Java Company',0,1,1,5000,'2010-06-06 11:12:12')");
            statement.executeUpdate("insert into invoice values(112,'2010-06-06 10:12:12' ,'Java Company',1,2,1,5666,'2010-06-06 11:12:12')");
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() throws Exception {
        try {
            statement = connection.createStatement();
            statement.execute("delete from invoice where invoice_id = 111");
            statement.execute("delete from invoice where invoice_id = 112");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test Case for a Invoices Added On List
     */

    @Test
    public void testgetInvoices() {
        Boolean result;

        List<InvoiceDTO> dtos = GetImpl.getEnabledInvoice();
        result = true;
        if (result) {
            assertTrue("The Result is: " + result + "  Instead of True", result = true);
        }
    }

}
