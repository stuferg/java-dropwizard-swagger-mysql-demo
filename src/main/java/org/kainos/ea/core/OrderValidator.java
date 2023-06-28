package org.kainos.ea.core;

import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.db.CustomerDao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class OrderValidator {


    public static String isValidOrder(OrderRequest order) throws SQLException {

        CustomerDao customer = new CustomerDao();

        if (customer.checkingCustomer(order.getCustomerId()) == 0) {
            return "Customer does not exist";
        }


//        Calendar cal = new GregorianCalendar();
//        cal.add(Calendar.YEAR, -1);
//        Date oneYearAgo = (Date) cal.getTime();
//
//        java.sql.Date sqlDate = new java.sql.Date(oneYearAgo.getTime());
//
//        //Date sqlDate = Date.valueOf(oneYearAgo.toLocalDate());
//
//
//        if (!order.getOrderDate().after(sqlDate))  {
//            return "Date must not be over a year ago";
//        }


        return null;
    }
}

