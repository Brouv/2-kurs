package org.skypro.skyshop;


import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class Main {
    public static void main(String[] args) {
        SimpleProduct orange = new SimpleProduct("Апельсин", 100);
        DiscountedProduct cucumber = new DiscountedProduct("Огурец",100,10);
        FixPriceProduct cabbage = new FixPriceProduct("Капуста");
        ProductBasket basket = new ProductBasket();
        basket.add(orange);
        basket.add(cucumber);
        basket.add(cabbage);
        System.out.println(basket);
    }
}


