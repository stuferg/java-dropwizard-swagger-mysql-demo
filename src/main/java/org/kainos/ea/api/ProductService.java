package org.kainos.ea.api;

import org.kainos.ea.cli.Product;
import org.kainos.ea.cli.ProductRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.CustomerDao;
import org.kainos.ea.db.ProductDao;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {

    private ProductDao productDao = new ProductDao();
    public List<Product> getAllProducts() throws FailedToGetProductsException {
        try {
            List<Product> productList = productDao.getAllProducts();

            return productList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProductsException();
        }
    }


    public Product getProductById(int id) throws FailedToGetProductsException, ProductDoesNotExistException {
        try {
            Product product = productDao.getProductById(id);

            if (product == null) {
                throw new ProductDoesNotExistException();
            }

            return product;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProductsException();
        }
    }

    public int createProduct(ProductRequest product) throws FailedToCreateProductException, InvalidProductException {
        try {
            String validation = ProductValidator.isValidProduct(product);

            if (validation != null) {
                throw new InvalidProductException(validation);
            }


            int id = productDao.createProduct(product);

            if (id ==1) {
                throw new FailedToCreateProductException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateProductException();
        }
    }



    public void updateProduct(int id, ProductRequest product) throws InvalidProductException,
            ProductDoesNotExistException, FailedToUpdateProductException {
        try {
            String validation = ProductValidator.isValidProduct(product);

            if (validation !=null) {
                throw new InvalidProductException(validation);
            }

            Product productToUpdate = productDao.getProductById(id);

            if (productToUpdate == null) {
                throw new ProductDoesNotExistException();
            }
            productDao.updateProduct(id, product);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProductException();
        }
    }




}
















//        List<Product> cheapProducts =
//                productList.stream().filter(product -> product.getPrice() < 50).collect(Collectors.toList());
//
//        cheapProducts.forEach(System.out::println);
//

        //System.out.println(Collections.min(productList));

//        Collections.sort(productList);
//        productList.stream().forEach(System.out::println);


//        List<Integer> intList = Arrays.asList(1, 2, 2, 4, 5);
//        Set<Integer> intSet = new HashSet<>(intList);
//
//        intSet.stream().forEach(System.out::println);

        // List<Integer> intList = Arrays.asList(1, 2, 2, 4, 5);
        //intList.stream().forEach(System.out::println);

//        for (Product product : productList) {
//            switch (product.getName()) {
//                case ("Good product"):
//                    System.out.println("This good product is: £" + product.getPrice());
//                    break;
//                case ("Great product"):
//                    System.out.println("This great product is: £" + product.getPrice());
//                    break;
//                case ("Amazing product"):
//                    System.out.println("This amazing product is: £" + product.getPrice());
//                    break;
//                case ("Meh product"):
//                    System.out.println("This meh product is: £" + product.getPrice());
//                    break;
//            }
//        }


        //double totalPriceOfProduct = 0;

        //totalPriceOfProduct = productList.stream().mapToDouble(product -> product.getPrice()).sum();

//        double totalPriceOfCheapProducts = 0;
//        double totalPriceOfExpensiveProducts = 0;
//
//        for (Product product : productList) {
//            if (product.getPrice() < 100) {
//                totalPriceOfCheapProducts += product.getPrice();
//            } else {
//                totalPriceOfExpensiveProducts += product.getPrice();
//            }
//        }
//        System.out.println("Total price of all cheap products: £" + totalPriceOfCheapProducts);
//        System.out.println("Total price of all expensive products: £" + totalPriceOfExpensiveProducts);

//        while (productIterator.hasNext()) {
//            Product product = productIterator.next();
//            totalPriceOfProduct += product.getPrice();
//        }

//        for (Product product : productList) {
//            totalPriceOfProduct += product.getPrice();
//        }

        // System.out.println("Total price of all products: £" + totalPriceOfProduct);



