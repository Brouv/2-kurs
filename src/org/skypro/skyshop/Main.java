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

        List<Searchable> products = new ArrayList<>();
        products.add(new SimpleProduct("Сыр", 170));
        products.add(new SimpleProduct("Гречка", 60));
        products.add(new DiscountedProduct("Колбаса", 250, 20));
        products.add(new SimpleProduct("Курица", 260));

        System.out.println("--- 2 ---");
        SearchEngine searchEngine = new SearchEngine(5);

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


