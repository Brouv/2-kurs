package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    int basePrice;
    int discountInPercent;
    public DiscountedProduct(String name, int basePrice, int discountInPercent){
        super(name);
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }
    @Override
    public int getPrice() {
        return basePrice= basePrice - (basePrice*discountInPercent);
    }
    @Override
    public  String toString(){
        return name + ": " + basePrice + (discountInPercent + "%");
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}
