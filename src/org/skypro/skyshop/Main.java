package org.skypro.skyshop;


import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

public class Main {
    public static void main(String[] args) {
        //SimpleProduct orange = new SimpleProduct("Апельсин", 100);
        //DiscountedProduct cucumber = new DiscountedProduct("Огурец",100,10);
       // FixPriceProduct cabbage = new FixPriceProduct("Капуста");
       // ProductBasket basket = new ProductBasket();
       // basket.add(orange);
       // basket.add(cucumber);
       // basket.add(cabbage);
       // System.out.println(basket);
   // }
    SearchEngine searchEngine = new SearchEngine(6);
    SimpleProduct orange = new SimpleProduct("Апельсин" , 30);
    Product cheese = new SimpleProduct("Сыр", 170);
    Product buckwheat = new SimpleProduct("Гречка", 60);
    Article orange1 = new Article("Польза апельсина", "Содержит много витамина С");
    Article cheese1 = new Article("Из чего делают сыр", "Из молока");
    Article buckwheat1 = new Article("Сколько ккал в гречке","В гречке 97 ккал");
    searchEngine.add(orange);
    searchEngine.add(cheese);
    searchEngine.add(buckwheat);
    searchEngine.add(orange1);
    searchEngine.add(cheese1);
    searchEngine.add(buckwheat1);
    Searchable[] results = searchEngine.search("Содержит");
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getStringRepresentation());
            }
        }
    }
}


