package main.java.ru.clevertec.check.entity;

public class Product {
    private long id;
    private double price;
    private int quantityInStock;
    private WholesaleProduct wholesaleProduct;
    private String description;


    public String getDescription() {
        return description;
    }

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

    public Product(long id, double price, int quantityInStock, WholesaleProduct wholesaleProduct, String description) {
        this.id = id;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.wholesaleProduct = wholesaleProduct;
        this.description = description;
    }

    public void decreaseQuantity(int quantity) {
        quantityInStock -= quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                ", wholesaleProduct=" + wholesaleProduct +
                ", description='" + description + '\'' +
                '}';
    }
}
