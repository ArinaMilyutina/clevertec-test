package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.entity.Product;

import java.util.List;

public interface Calculator {
    double calculateTotalPrice(List<Product> productsList, String input);

    double calculateTotal(int count, double price);

    double calculateDiscount(int discountAmount, double total);

}
