package main.java.ru.clevertec.check.entity;

public class Products {
    private Product product;
    private int count;

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Products(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    public Products() {
    }
}
