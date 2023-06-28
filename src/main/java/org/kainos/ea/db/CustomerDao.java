package org.kainos.ea.db;

import org.kainos.ea.cli.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {


    public int checkingCustomer(int customerID) {
        try (Connection c = DatabaseConnector.getConnection()) {
            Statement st = c.createStatement();

            ResultSet rs = st.executeQuery("SELECT COUNT(CustomerID) FROM `Order` WHERE CustomerID = " + customerID);

            while (rs.next()) {
                Integer result = rs.getInt(1);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

}
