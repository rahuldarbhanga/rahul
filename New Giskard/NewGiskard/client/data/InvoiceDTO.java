/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:06:45 PM
 */
package com.wissen.NewGiskard.client.data;

import java.sql.Timestamp;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 */
public class InvoiceDTO implements IsSerializable {

    private Long    id;

    private String  description;

    private Long    invoice_no;

    private double  amount;

    private Boolean recieved;

    private Boolean enabled;

    private Timestamp createdTimeStamp, updatedTimestamp;

    //******************************** Get - Set Methods ******************************************

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(Long invoiceNo) {
        invoice_no = invoiceNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Boolean getRecieved() {
        return recieved;
    }

    public void setRecieved(Boolean recieved) {
        this.recieved = recieved;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    //****************************************** Methods *****************************************

    public ColumnData[] GetColumnData(InvoiceDTO dto) {
        ColumnData[] columns = new ColumnData[4];

        columns[0] = new ColumnData();
        columns[0].setValues(dto.getId().toString());

        columns[1] = new ColumnData();
        columns[1].setValues(dto.getDescription());

        columns[2] = new ColumnData();
        columns[2].setValues(dto.getAmount() + "");

        columns[3] = new ColumnData();
        columns[3].setValues(dto.getEnabled().toString());
        columns[3].setType(1);

        columns[4] = new ColumnData();
        columns[4].setValues(dto.getRecieved().toString());
        columns[4].setType(1);

        return columns;

    }

    public static String[] GetColumnHeader() {

        String[] columnHeader = new String[4];

        columnHeader[0] = "Invoice ID";
        columnHeader[1] = "Description";
        columnHeader[2] = "Total Amount";
        columnHeader[3] = "Enabled";
        columnHeader[4] = "Recieved";

        return columnHeader;

    }

}
