package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;

import java.util.List;

public interface Calculator {
    double calculateTotalPrice(List<Product> productsList, String input);

    double calculateTotal(int count, double price);

    double calculateDiscount(int discountAmount, double total);

    double calculateTotalDiscount(List<Products> chosenProducts);

    double calculateTotalWithDiscount(double totalPrice, double discount);

    double calculateDiscountWholesaleProduct(double total);

}
