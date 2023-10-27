package store.controller;

import store.model.Product;
import store.model.Sale;

public class ControllerStore {

    private Product product = new Product();
    private Sale sale = new Sale();
    

    public ControllerStore() {

    }

    public ControllerStore(Product product, Sale sale) {
        this.product = product;
        this.sale = sale;
    }

    public Product getProduct() {
        return this.product;
    }

    public Sale getSale() {
        return this.sale;
    }

    public void printSale() {
        
        Integer quantity = 0;
        Integer price = 0;

        System.out.format("%15s%15s%15s%15s%15s", "CÓDIGO", "NOMBRE", "CANTIDAD", "P.U.", "P.U.+CANT.");
        System.out.println(" ");

        for (Sale productInSale : this.getSale().getSales()) {

            System.out.format("%15s%15s%15s%15s%15s", productInSale.getProduct().getCode(),
                    productInSale.getProduct().getName(), productInSale.getProductQuantity(),
                    ControllerUtil.format.format(productInSale.getProduct().getPrice()),
                    ControllerUtil.format.format(productInSale.getProductQuantity() * productInSale.getProduct().getPrice()));
            quantity = quantity + productInSale.getProductQuantity();
            price = price
                    + productInSale.getProduct().getPrice() * productInSale.getProductQuantity();
                    System.out.println(" ");

        }

        System.out.println(" ");
        System.out.format("%75s", ControllerUtil.format.format(price));
        System.out.println(" ");
        System.out.format("%75s", " 19% " + ControllerUtil.format.format((price*19)/100));
        System.out.println(" ");
        System.out.format("%75s", " total+19% " + ControllerUtil.format.format(price+(price*19)/100) );
        System.out.println(" ");

    }
    
    public void printProduct() {
        System.out.format("%15s%15s%15s%15s", "CÓDIGO", "NOMBRE", "PRECIO", "STOCK");
        System.out.println(" ");
        for (Product product : this.getProduct().getProducts()) {
            System.out.format("%15s%15s%15s%15s\n", product.getCode(), product.getName(), ControllerUtil.format.format(product.getPrice()), product.getStock());
            System.out.println(" ");
        }
    }

}
