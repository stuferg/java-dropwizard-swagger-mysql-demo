package org.kainos.ea.core;

import org.kainos.ea.cli.ProductRequest;

public class ProductValidator {
    public static String isValidProduct(ProductRequest product) {
        if (product.getName().length() > 50) {
            return "Name greater than 50 characters";
        }

        if (product.getDescription().length() > 500) {
            return "Description is greater than 500 characters";
        }

        if (product.getPrice() < 10) {
            return "Price less than £10";
        }

        return null;
    }


}
