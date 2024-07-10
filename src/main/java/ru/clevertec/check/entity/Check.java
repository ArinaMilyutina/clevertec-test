package main.java.ru.clevertec.check.entity;

import main.java.ru.clevertec.check.entity.user.DiscountCard;

import java.util.List;


public class Check {
    private String date;
    private String time;
    List<Products> productList;
    private double totalPrice;
    private DiscountCard discountCard;
    private double totalDiscount;
    private double totalPriceWithDiscount;


    public Check(String date, String time, List<Products> productList, double totalPrice, DiscountCard discountCard, double totalDiscount, double totalPriceWithDiscount) {
        this.date = date;
        this.time = time;
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.discountCard = discountCard;
        this.totalDiscount = totalDiscount;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }

    public Check(String date, String time, List<Products> productList, double totalPrice, double totalDiscount, double totalPriceWithDiscount) {
        this.date = date;
        this.time = time;
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public List<Products> getProductList() {
        return productList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


    public DiscountCard getDiscountCard() {
        return discountCard;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalPriceWithDiscount() {
        return totalPriceWithDiscount;
    }


    @Override
    public String toString() {
        return "Check{" +
                "date=" + date +
                ", time=" + time +
                ", productList=" + productList +
                ", totalPrice=" + totalPrice +
                ", discountCard=" + discountCard +
                ", totalDiscount=" + totalDiscount +
                ", totalPriceWithDiscount=" + totalPriceWithDiscount +
                '}';
    }
}
