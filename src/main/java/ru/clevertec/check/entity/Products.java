package main.java.ru.clevertec.check.entity;

public class Products {
    private Product product;
    private int count;
    private double total;
    private double discount;

    public Products() {
    }

    public static Products.ProductsBuilder builder() {
        return new Products().new ProductsBuilder();
    }

    public class ProductsBuilder {
        public ProductsBuilder() {
        }

        public Products.ProductsBuilder setProduct(Product product) {
            Products.this.product= product;
            return this;
        }
        public Products.ProductsBuilder setCount(int count) {
            Products.this.count= count;
            return this;
        }

        public Products.ProductsBuilder setTotal(double total) {
           Products.this.total = total;
            return this;
        }

        public Products.ProductsBuilder setDiscount(double discount) {
            Products.this.discount =discount;
            return this;
        }

        public Products build() {
            return Products.this;
        }
    }

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotal() {
        return total;
    }

}
