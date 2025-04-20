package org.skypro.skyshop.product;

public class Product {
    String name;
    int price;
    public void infoProduct(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
