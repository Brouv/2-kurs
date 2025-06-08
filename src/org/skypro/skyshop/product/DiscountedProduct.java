package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    int basePrice;
    int discountInPercent;
    public DiscountedProduct(String name, int basePrice, int discountInPercent){
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть строго больше 0");
        }
        if (discountInPercent < 0 || discountInPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
        this.basePrice = basePrice;
        this.discountInPercent = discountInPercent;
    }
    @Override
    public int getPrice() {
        return basePrice= basePrice - ( 1- (basePrice / discountInPercent));
    }
    @Override
    public  String toString(){
        return name + ": " + basePrice + " рублей." + (" Скидка " + discountInPercent + " %.");
    }
    @Override
    public boolean isSpecial() {
        return true;
    }
}
