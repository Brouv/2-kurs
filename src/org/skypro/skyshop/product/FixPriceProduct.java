package org.skypro.skyshop.product;

public class FixPriceProduct extends Product{
    final int fixPrice;
    public FixPriceProduct(String name,int fixPrice){
        super(name);
        this.fixPrice = fixPrice;
    }
    @Override
    public int getPrice(){
        return fixPrice;
    }
    @Override
    public String toString(){
        return getName() + ": Фиксированная цена " + fixPrice;
    }
}
