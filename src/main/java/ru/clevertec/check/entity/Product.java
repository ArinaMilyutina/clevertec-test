package main.java.ru.clevertec.check.entity;

public class Product {
    private long id;
    private double price;
    private int quantityInStock;
    private WholesaleProduct wholesaleProduct;
    private String description;

    public Product() {

    }

    public static ProductBuilder builder() {
        return new Product().new ProductBuilder();
    }

    public class ProductBuilder {
        public ProductBuilder() {
        }

        public ProductBuilder setId(long id) {
            Product.this.id = id;
            return this;
        }

        public ProductBuilder setQuantityInStock(int quantityInStock) {
            Product.this.quantityInStock = quantityInStock;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            Product.this.price = price;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            Product.this.description = description;
            return this;
        }

        public ProductBuilder setWholesaleProduct(WholesaleProduct wholesaleProduct) {
            Product.this.wholesaleProduct = wholesaleProduct;
            return this;
        }

        public Product build() {
            return Product.this;
        }
    }

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



