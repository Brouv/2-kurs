package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


public class ProductBasket {
    private int size = 0;
    private Product[] products = new Product[5];

    public void add(Product product, int index) {
        if (size == products.length ) {
            System.out.println("Эта корзина переполнена");
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null && index == i) {
                products[i] = product;
                size++;
            }
        }
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                sum += products[i].getPrice();
            }
        }
        return sum;
    }

    public void printProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i].getName() + ":" + products[i].getPrice());
            }else {
                System.out.println((String) null);
            }
        }
        System.out.println("итого: " + sum());
    }

    public boolean checkProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println("В корзине есть продукт " + products[i].getName());
            } else {
                System.out.println("Это место свободно, можно положить продукт");
            }
        }return false;
    }
    
    public void noProduct(){
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products.length > 0){
                products[i] = null;
                System.out.println((String) null);

            }
        }
        System.out.println("Итого: " + sum());
    }
}
