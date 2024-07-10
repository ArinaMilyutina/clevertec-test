package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;
import main.java.ru.clevertec.check.util.NumberUtils;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorCheckService implements Calculator {
    private static final String SPACING = " ";
    private static final int WHOLESALE_DISCOUNT = 10;
    private static final ProductService productService = new ProductService();

    public double calculateTotalPrice(List<Product> productsList, String input) {
        double totalPrice = 0;
        Map<Product, Integer> chosenProductsMap = new HashMap<>();
        String[] inputArr = input.split(SPACING);

        for (String item : inputArr) {
            totalPrice = productService.processInputItem(productsList, item, chosenProductsMap, totalPrice);
        }

        return NumberUtils.roundNumber(totalPrice);
    }

    public double calculateTotalDiscount(List<Products> chosenProducts) {
        double totalDiscount = 0;
        for (Products products : chosenProducts) {
            totalDiscount += products.getDiscount();
        }
        return NumberUtils.roundNumber(totalDiscount);
    }

    public double calculateTotal(int count, double price) {
        return NumberUtils.roundNumber(count * price);
    }

    public double calculateDiscount(int discountAmount, double total) {
        return NumberUtils.roundNumber(discountAmount * total / 100);
    }

    public double calculateTotalWithDiscount(double totalPrice, double discount) {
        return NumberUtils.roundNumber(totalPrice - discount);
    }

    public double calculateDiscountWholesaleProduct(double total) {
        return NumberUtils.roundNumber(total * WHOLESALE_DISCOUNT / 100);
    }

}
