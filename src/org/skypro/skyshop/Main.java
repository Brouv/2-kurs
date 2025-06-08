package org.skypro.skyshop;


import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws BestResultNotFound {

        System.out.println("--- 1 ---");

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Сыр", 170));
        basket.addProduct(new SimpleProduct("Гречка", 60));
        basket.addProduct(new DiscountedProduct("Колбаса", 250, 20));
        basket.addProduct(new SimpleProduct("Курица", 260));
        System.out.println("Исходное содержимое корзины:");
        System.out.println(basket);



        System.out.println("--- 2 ---");

        List<Product> removedCheese = basket.removeProductsByName("Сыр");

        System.out.println("------");

        System.out.println("Удалённые продукты:");
        for (Product p : removedCheese) {
            System.out.println(p);
        }

        System.out.println("------");

        System.out.println("Содержимое корзины после удаления сыра:");
        System.out.println(basket);

        List<Product> removedOranges = basket.removeProductsByName("Говядина");

        System.out.println("------");

        if (removedOranges.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("------");

        System.out.println("Содержимое корзины после попытки удаления говядины:");
        System.out.println(basket);

        System.out.println("--- 3 ---");

        try {
            SimpleProduct Product1 = new SimpleProduct("Апельсин ", -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            SimpleProduct Product2 = new SimpleProduct("", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            DiscountedProduct Discounted = new DiscountedProduct("Товар", -50, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("------");

        SearchEngine searchEngine = new SearchEngine();
        List<Searchable> products = new ArrayList<>();
        products.add(new SimpleProduct("Сыр", 170));
        products.add(new SimpleProduct("Гречка", 60));
        products.add(new DiscountedProduct("Колбаса", 250, 20));
        products.add(new SimpleProduct("Курица", 260));
        products.add(new SimpleProduct("Масло сливочное", 270));
        products.add(new DiscountedProduct("Морковь", 50, 5));
        System.out.println(products);

        System.out.println("------");

        try {
            Searchable result = searchEngine.findBestMatch("Сыр" , products);
            System.out.println("Найден лучший результат поиска: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
        try {
            Searchable result = searchEngine.findBestMatch("Капуста", products);
            System.out.println("Найден лучший результат поиска: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}


