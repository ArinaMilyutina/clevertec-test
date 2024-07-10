package main.java.ru.clevertec.check.entity;

public class Products {
    private Product product;
    private int count;
    private double total;
    private double discount;


    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Products(Product product, int count, double total, double discount) {
        this.product = product;
        this.count = count;
        this.total = total;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return total;
    }

}
