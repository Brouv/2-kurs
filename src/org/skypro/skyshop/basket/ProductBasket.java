package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        return products.stream()
              .mapToInt(Product::getPrice)
              .sum();
    }

    public int getSpecialProductsCount() {
        return (int) products.stream()
                .filter(Product::isSpecial)
                .count();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Product product : products) {
            result.append(product.toString()).append("\n");
        }

        result.append("Итого: ").append(getTotalPrice()).append("\n");
        result.append("Специальных товаров: ").append(getSpecialProductsCount());

        return result.toString();
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        java.util.Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;

    }
}