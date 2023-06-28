package org.kainos.ea.db;

import com.mysql.cj.jdbc.Driver;
import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.kainos.ea.db.DatabaseConnector.getConnection;

public class OrderDao {

    public List<Order> getAllOrders() throws SQLException {
        try (Connection c = getConnection()) {
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate FROM `Order`;");

            List<Order> orderList = new ArrayList<>();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("OrderID"),
                        rs.getInt("CustomerID"),
                        rs.getDate("OrderDate")
                );
                orderList.add(order);
            }
            return orderList;
        }
    }

    public Order getOrderById (int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT OrderID, CustomerID, OrderDate" +
                " FROM `Order` WHERE OrderID=" + id);

        while (rs.next()) {
            return new Order(
                    rs.getInt("OrderID"),
                    rs.getInt("CustomerID"),
                    rs.getDate("OrderDate")
            );
        }

        return null;
    }


    public int createOrder(OrderRequest order) throws SQLException {
        try (Connection c = DatabaseConnector.getConnection()) {
            String insertStatement = "INSERT INTO `Order` (CustomerID, OrderDate, DispatchDate) VALUES (?,?,?)";

            PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, order.getCustomerId());
            st.setDate(2, order.getOrderDate());
            st.setDate(3, order.getDispatchDate());


            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return -1;
        }
    }

    public void updateOrder(int id, OrderRequest order) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "UPDATE `Order` SET CustomerID = ?, OrderDate = ?, DispatchDate = ? WHERE OrderID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, order.getCustomerId());
        st.setDate(2, order.getOrderDate());
        st.setDate(3, order.getDispatchDate());
        st.setInt(4, id);

        st.executeUpdate();
    }

    public void deleteOrder(int id) throws SQLException {
        Connection c = DatabaseConnector.getConnection();

        String updateStatement = "DELETE FROM `Order` WHERE OrderID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, id);

        st.executeUpdate();
    }

}
