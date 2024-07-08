package main.java.ru.clevertec.check.entity;

public class Product {
    private long id;
    private double price;
    private int quantityInStock;
    private WholesaleProduct wholesaleProduct;

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public WholesaleProduct getWholesaleProduct() {
        return wholesaleProduct;
    }

    public Product(long id, double price, int quantityInStock, WholesaleProduct wholesaleProduct) {
        this.id = id;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.wholesaleProduct = wholesaleProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", wholesaleProduct=" + wholesaleProduct +
                '}';
    }
}
