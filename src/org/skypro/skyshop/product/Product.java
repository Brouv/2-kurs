package org.skypro.skyshop.product;


import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

   protected String name;


    public Product (String name){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract String toString();
    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm(){
        return name;
    }

    @Override
    public String getContentType(){
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}
