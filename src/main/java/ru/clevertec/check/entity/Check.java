package main.java.ru.clevertec.check.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Check {
    private LocalDate date;
    private LocalTime time;
    List<Products> productList;
    private double totalPrice;
    private double discount;
    private DiscountCard discountCard;
    private double totalDiscount;
    private double totalPriceWithDiscount;

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

    public double getDiscount() {
        return discount;
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setTotalPriceWithDiscount(double totalPriceWithDiscount) {
        this.totalPriceWithDiscount = totalPriceWithDiscount;
    }

    @Override
    public String toString() {
        return "Check{" +
                "date=" + date +
                ", time=" + time +
                ", productList=" + productList +
                ", totalPrice=" + totalPrice +
                ", discount=" + discount +
                ", discountCard=" + discountCard +
                ", totalDiscount=" + totalDiscount +
                ", totalPriceWithDiscount=" + totalPriceWithDiscount +
                '}';
    }
}
