package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    int basePrice;
    int discountInPercent;
    public DiscountedProduct(String name, int basePrice, int discountInPercent){
        super(name);
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }
    public void changedPrice(){
        this.basePrice = basePrice + (basePrice*discountInPercent);
    }
    @Override
    public int getPrice() {
        return basePrice;
    }
    @Override
    public String toString(){
        return getName() + ": " + basePrice + (discountInPercent + "%");
    }
}
