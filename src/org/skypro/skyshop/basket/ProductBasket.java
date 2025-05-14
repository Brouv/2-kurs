package org.skypro.skyshop.basket;


import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private int size = 0;
    private Product[] products = new Product[5];
    public void add(Product product){
        if(size == products.length) {
            System.out.println("корзина переполнена");
        }
        for (int i = 0; i < products.length; i++) {
            if(products[i] == null){
                products[i] = product;
                size++;
            }
        }
    }
    public int sum(){
        int sum = 0;
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null){
                sum += products[i].getPrice();
            }

        }
        return sum;
    }
    public  void  printProducts(){
        for (int i = 0; i < products.length; i++) {
            if(products[i] != null){
                System.out.println( products[i].getName() + ":" + products[i].getPrice());
            }
        }
        System.out.println("итого: " + sum());
    }
    public void checkProducts(){
        boolean check = products != null;
        for (int i = 0; i < products.length; i++) {
            if (check){
                System.out.println("В корзине есть продукт");
            } else {
                System.out.println("Это место свободно, можно положить продукт");
            }

        }
    }
    public void noProducts(){
        for (int i = 0; i < products.length; i++) {
            if(products[i] != null && size > 5){
                System.out.println("null");
            }
        }
    }
}

