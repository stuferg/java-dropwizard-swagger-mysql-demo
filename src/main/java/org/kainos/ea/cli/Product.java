package org.kainos.ea.cli;

public class Product implements Comparable<Product>{
    private int productId;
    private String name;
    private String description;
    private int price;

    public Product(int productId, String name, String description, int price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public int compareTo(Product product) {
        return Double.compare(this.getPrice(), product.getPrice());
    }

    @Override
    public String toString() {
        return "Product name: " + this.name + ", Product price: £" + this.getPrice();
    }


}
