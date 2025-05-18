package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args){

        Product orange = new Product("Апельсин" , 30);
        Product cheese = new Product("Сыр", 170);
        Product buckwheat = new Product("Гречка", 60);
        Product sausage = new Product("Колбаса", 250);
        Product chicken = new Product("Курица", 260);
        Product cabbage = new Product("Капуста", 100);
        System.out.println();


        ProductBasket add1 = new ProductBasket();
        add1.add (orange , 0);
        add1.add(cheese, 1);
        add1.add(buckwheat, 2);
        add1.add(sausage, 3);
        add1.add(chicken, 4);
        add1.add(cabbage, 5);
        System.out.println();

        ProductBasket add = new ProductBasket();
        add.add (orange , 0);
        add.add(cheese, 1);
        add.add(buckwheat, 2);
        add.add(sausage, 3);
        add.printProducts();
        System.out.println();

        add.checkProducts();
        System.out.println();

        ProductBasket add2 = new ProductBasket();
        add2.printProducts();
        System.out.println();

        ProductBasket add3 = new ProductBasket();
        add3.add (orange , 0);
        add3.add(cheese, 1);
        add3.add(buckwheat, 2);
        add3.add(sausage, 3);
        add3.add(chicken , 4);
        add3.noProduct();
    }
}
