package store.model;

import java.util.ArrayList;

public class Sale {

    private Product product;
    private Integer productQuantity;
    private Integer month;

    ArrayList<Sale> sales = new ArrayList<>();

    public Sale() {
    }

    public Sale(Product product, Integer productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void addSale(Sale venta) {
        this.sales.add(venta);
    }

    public ArrayList<Sale> getSales() {
        return this.sales;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Integer getMonth() {
        return this.month;
    }

}
