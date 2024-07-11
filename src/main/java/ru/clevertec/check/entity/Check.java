package main.java.ru.clevertec.check.entity;

import main.java.ru.clevertec.check.entity.user.DiscountCard;

import java.util.List;


public class Check {
    private String date;
    private String time;
    private List<Products> productList;
    private double totalPrice;
    private DiscountCard discountCard;
    private double totalDiscount;
    private double totalPriceWithDiscount;

    public Check() {
    }
    public static Check.CheckBuilder builder() {
        return new Check().new CheckBuilder();
    }

    public class CheckBuilder {
        public CheckBuilder() {
        }
        public Check.CheckBuilder setDate(String date) {
            Check.this.date = date;
            return this;
        }
        public Check.CheckBuilder setListProducts(List<Products> productList) {
            Check.this.productList = productList;
            return this;
        }
        public Check.CheckBuilder setTime(String time) {
            Check.this.time = time;
            return this;
        }
        public Check.CheckBuilder setTotalPrice(double totalPrice) {
            Check.this.totalPrice = totalPrice;
            return this;
        }
        public Check.CheckBuilder setDiscountCard(DiscountCard discountCard) {
            Check.this.discountCard = discountCard;
            return this;
        }
        public Check.CheckBuilder setTotalDiscount(double totalDiscount) {
            Check.this.totalDiscount = totalDiscount;
            return this;
        }
        public Check.CheckBuilder setTotalWithDiscount(double totalPriceWithDiscount) {
            Check.this.totalPriceWithDiscount = totalPriceWithDiscount;
            return this;
        }
        public Check build() {
            return Check.this;
        }
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
