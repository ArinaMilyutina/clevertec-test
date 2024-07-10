package main.java.ru.clevertec.check.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Check {
    private LocalDate date;
    private LocalTime time;
    List<Products> productList;
    private double totalPrice;
    private DiscountCard discountCard;
    private double totalDiscount;
    private double totalPriceWithDiscount;


    public Check(LocalDate date, LocalTime time, List<Products> productList, double totalPrice, DiscountCard discountCard, double totalDiscount, double totalPriceWithDiscount) {
        this.date = date;
        this.time = time;
        this.productList = productList;
        this.totalPrice = totalPrice;
        this.discountCard = discountCard;
        this.totalDiscount = totalDiscount;
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
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
