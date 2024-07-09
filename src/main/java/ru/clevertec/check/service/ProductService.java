package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;

import java.util.List;
import java.util.Map;

public class ProductService {
    private static final String N_DASH = "-";

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

    void createChosenProductsList(Map<Product, Integer> chosenProductsMap, List<Products> chosenProducts) {
        chosenProductsMap.forEach((product, quantity) -> {
            Products products = new Products(product, quantity);
            chosenProducts.add(products);
        });
    }

}
