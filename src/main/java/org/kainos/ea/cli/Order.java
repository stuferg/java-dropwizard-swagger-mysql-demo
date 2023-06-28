package org.kainos.ea.cli;

import java.util.Date;

public class Order implements Comparable<Order>{
    private int orderId;
    private int customerId;
    private Date orderDate;
    private Date dispatchDate;


    public Order(int orderId, int customerId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerID) {
        this.customerId = customerID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }


    @Override
    public int compareTo(Order order) {
        return orderDate.compareTo(order.getOrderDate());
    }

    @Override
    public String toString() {
        return "Order ID: " + this.orderId + ". Customer ID: " + this.customerId + ". Order Date: " + this.orderDate;
    }

}
