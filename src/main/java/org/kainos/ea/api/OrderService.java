package org.kainos.ea.api;

import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.OrderValidator;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.CustomerDao;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.util.*;

public class OrderService {

    private OrderDao orderDao = new OrderDao();

//    Date todayDate = new Date();
//    Calendar today = Calendar.getInstance();


    public List<Order> getAllOrders() throws FailedToGetOrdersException {
        List<Order> orderList = null;
        try {
            orderList = orderDao.getAllOrders();

            return orderList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetOrdersException();
        }
    }

    public Order getOrderById(int id) throws FailedToGetOrdersException, OrderDoesNotExistException {
        try {
            Order order = orderDao.getOrderById(id);

            if (order == null) {
                throw new OrderDoesNotExistException();
            }

            return order;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetOrdersException();
        }

    }


    public int createOrder(OrderRequest order) throws FailedToCreateOrderException, InvalidOrderException {
        try {
            String validation = OrderValidator.isValidOrder(order);

            if (validation != null) {
                throw new InvalidOrderException(validation);
            }

            int id = orderDao.createOrder(order);

            if (id == 1) {
                throw new FailedToCreateOrderException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateOrderException();
        }
    }


    public void updateOrder(int id, OrderRequest order) throws InvalidOrderException,
            OrderDoesNotExistException, FailedToUpdateOrderException {
        try {
            String validation = OrderValidator.isValidOrder(order);

            if (validation !=null) {
                throw new InvalidOrderException(validation);
            }

            Order orderToUpdate = orderDao.getOrderById(id);

            if (orderToUpdate == null) {
                throw new OrderDoesNotExistException();
            }
            orderDao.updateOrder(id, order);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateOrderException();
        }
    }

    public void deleteOrder(int id) throws OrderDoesNotExistException, FailedToDeleteOrderException {
        try {
            Order orderToDelete = orderDao.getOrderById(id);

            if (orderToDelete == null) {
                throw new OrderDoesNotExistException();
            }

            orderDao.deleteOrder(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToDeleteOrderException();
        }
    }

}


//        Update your `OrderService` and `Order` classes to print out the `OrderID`, `CustomerID` and `OrderDate` of all orders
        //orderList.stream().forEach(System.out::println);

//        Update your `OrderService` and `Order` classes to print out order the list by order date descending
        //orderList.stream().sorted(Comparator.comparing(Order::getOrderDate)).forEach(System.out::println);

//        Update your `OrderService` to only show orders from the last week
//        Date today = new Date();
//        Calendar cal = new GregorianCalendar();
//        cal.add(Calendar.DAY_OF_MONTH, -7);
//        Date sevenDaysAgo = cal.getTime();
//
//        orderList.stream().filter(order -> order.getOrderDate().after(sevenDaysAgo))
//                .sorted(Comparator.comparing(Order::getOrderDate))
//                .forEach(System.out::println);
//

//        Update your `OrderService` to only show orders from customer with `CustomerID` 1
//        orderList.stream().filter(order -> order.getCustomerId() == 1)
//                .sorted(Comparator.comparing(Order::getOrderDate))
//                .forEach(System.out::println);

//        Update your `OrderService` to only show the most recent order
//        System.out.println("Newest Order date: " + Collections.max(orderList));
//
////        Update your `OrderService` to only show the oldest order
//        System.out.println("Newest Oldest date: " + Collections.min(orderList));
//
////        Update your `OrderService` to show the total count of all orders
//        System.out.println("Newest Oldest date: " + orderList.size();

//        Update your `OrderService` to show the customer ID with the most orders
//        Integer mostOrders = orderList.stream()
//                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()))
//                .entrySet().stream().max(Map.Entry.comparingByValue())
//                        .map(Map.Entry::getKey).orElse(null);
//
//        System.out.println("Customer with most orders: " + mostOrders);

        // OR

//        Map<Integer, Long> countOrderMap = orderList.stream()
//                .collect(Collectors.groupingBy(Order::getOrderId, Collectors.counting()));
//
//        System.out.println("Customer most orders: " +
//                Collections.max(countOrderMap.entrySet(), Map.Entry.comparingByKey()));


//        Update your `OrderService` to show the customer ID with the least orders
//        Integer leastOrders = orderList.stream()
//                .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.counting()))
//                .entrySet().stream().min(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey).orElse(null);
//
//        System.out.println("Customer with most orders: " + leastOrders);

//        System.out.println("Customer most orders: " +
//                Collections.min(countOrderMap.entrySet(), Map.Entry.comparingByKey()));


        //Collections.sort(orderList);


        //Most recent order
//        Date mostRecentOrder = new Date(1999-01-01);
//
//        for (Order order : orderList) {
//            if (order.getOrderDate().after(mostRecentOrder)) {
//                mostRecentOrder = order.getOrderDate();
//            }
//        }
//
//        for (Order order : orderList) {
//            if (mostRecentOrder == order.getOrderDate()) {
//                System.out.println(order);
//            }
//        }


        // Getting orders with a week
//        Date today = new Date();
//        Calendar cal = new GregorianCalendar();
//        cal.add(Calendar.DAY_OF_MONTH, -7);
//        Date sevenDaysAgo = cal.getTime();
//
//        for (Order order : orderList) {
//            if (order.getOrderDate().after(sevenDaysAgo) && order.getOrderDate().before(today)) {
//                System.out.println(order);
//            }
//        }


        //getting total orders
//        int totalOrders = 0;
//        for (Order order : orderList) {
//            totalOrders++;
//        }
//        System.out.println(totalOrders);

            //getting orders where CustomerId=1
//        for (Order order : orderList) {
//            if (order.getCustomerId() == 1) {
//                System.out.println(order);
//            }
//        }


//
//            orderList.stream().forEach(System.out::println);
//
//        Order order1 = new Order(1, 1, new Date());
//        Order order2 = new Order (2, 2, new Date());
//
//        orderList.add(order1);
//        orderList.add(order2);


