package org.kainos.ea.client;

import java.sql.SQLException;

public class FailedToGetProductsException extends Throwable {
   @Override
    public String getMessage() {
       return "Failed to get products from Database";
   }
}
