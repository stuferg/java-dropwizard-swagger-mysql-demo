package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class OrderRequest {


    private int customerId;
    private java.sql.Date orderDate;
    private java.sql.Date dispatchDate;

    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public java.sql.Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }
    public java.sql.Date getDispatchDate() {
        return dispatchDate;
    }
    public void setDispatchDate(java.sql.Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }



    @JsonCreator
    public OrderRequest(
            @JsonProperty("customerId") int customerId,
            @JsonProperty("orderDate") Date orderDate,
            @JsonProperty("dispatchDate") Date dispatchDate) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.dispatchDate = dispatchDate;

    }




}
