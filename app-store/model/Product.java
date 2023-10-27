package store.model;

import java.util.ArrayList;

public class Product {

    private String code;
    private String name;
    private Integer price;
    private Integer stock;

    private final ArrayList<Product> products = new ArrayList<>();

    public Product() {
    }

    public Product(String code, String name, Integer price, Integer stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void updateStock(int quantity) {
        this.setStock(this.getStock() - quantity);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

}
