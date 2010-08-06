/*
 Copyright 2010 Wissen System Pvt. Ltd. All rights reserved.
 Author: Rahul Patil on 6:14:00 PM
 */
package com.wissen.NewGiskard.server.domainObjects;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rahul Patil
 * 
 *         Create Date : 06-Aug-2010
 */

@Entity
@Table(name = "invoice")
public class InvoiceDetails {

    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long      invoiceId;

    @Column(name = "invoice_no", unique = true)
    private long      invoiceNo;

    @Column(name = "description")
    private String    description;

    @Column(name = "amount")
    private String    totalAmount;

    @Column(name = "recieved")
    private Boolean   recievedFlag;

    @Column(name = "enabled")
    private Boolean   enabledFlag;

    @Column(name = "created_timestamp")
    private Timestamp createdTimeStamp;

    @Column(name = "updated_timestamp")
    private Timestamp updatedTimeStamp;

    //****************************** Get - Set Methods ***************************************

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(long invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getRecievedFlag() {
        return recievedFlag;
    }

    public void setRecievedFlag(Boolean recievedFlag) {
        this.recievedFlag = recievedFlag;
    }

    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Timestamp getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public Timestamp getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(Timestamp updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

}
