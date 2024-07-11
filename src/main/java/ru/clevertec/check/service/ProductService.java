package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;
import main.java.ru.clevertec.check.entity.WholesaleProduct;

import java.util.List;
import java.util.Map;

public class ProductService {
    private static final String N_DASH = "-";
    private static final CalculatorCheckService calculatorService = new CalculatorCheckService();

    public Product getProductById(List<Product> productsList, int id) {
        for (Product product : productsList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    double processInputItem(List<Product> productsList, String item, Map<Product, Integer> chosenProductsMap, double totalPrice) {
        String[] pair = item.split(N_DASH);

        int id = Integer.parseInt(pair[0]);
        int quantity = Integer.parseInt(pair[1]);

        Product chosenProduct = getProductById(productsList, id);

        if (chosenProduct != null && chosenProduct.getQuantityInStock() >= quantity) {
            chosenProduct.decreaseQuantity(quantity);
            totalPrice += chosenProduct.getPrice() * quantity;

            updateChosenProductsMap(chosenProduct, quantity, chosenProductsMap);
        } else {

        }

        return totalPrice;
    }

    void updateChosenProductsMap(Product chosenProduct, int quantity, Map<Product, Integer> chosenProductsMap) {
        if (chosenProductsMap.containsKey(chosenProduct)) {
            chosenProductsMap.put(chosenProduct, chosenProductsMap.get(chosenProduct) + quantity);
        } else {
            chosenProductsMap.put(chosenProduct, quantity);
        }
    }

    void createChosenProductsList(Map<Product, Integer> chosenProductsMap, List<Products> chosenProducts, int discountAmount) {
        chosenProductsMap.forEach((product, quantity) -> {
            double total = calculatorService.calculateTotal(quantity, product.getPrice());
            double discount = calculatorService.calculateDiscount(discountAmount, total);
            double discountWholesaleProduct = calculatorService.calculateDiscountWholesaleProduct(total);

            Products products;
            if (quantity >= 5 && product.getWholesaleProduct() == WholesaleProduct.WHOLESALE) {
                products = Products.builder().setProduct(product).setCount(quantity).setTotal(total).setDiscount(discountWholesaleProduct).build();
            } else {
                products = Products.builder().setProduct(product).setCount(quantity).setTotal(total).setDiscount(discount).build();
            }

            chosenProducts.add(products);
        });
    }

}
