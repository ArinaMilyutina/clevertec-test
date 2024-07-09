package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.console.util.ConsoleWriter;
import main.java.ru.clevertec.check.entity.Check;
import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckService {
    private static final ConsoleWriter writer = new ConsoleWriter();
    private static final String SPACING = " ";
    private static final ProductService productService = new ProductService();
    private static final CalculatorService calculatorService = new CalculatorService();

    public void printCheck(Check check) {
        writer.write("Check Date: " + check.getDate());
        writer.write("Check Time: " + check.getTime());

        for (Products products : check.getProductList()) {
            Product product = products.getProduct();
            int count = products.getCount();
            writer.write("Product ID: " + product.getId() + ", Price: " + product.getPrice() + ", Quantity: " + count + ", Description: " + product.getDescription());
        }

        writer.write("Total Price: " + check.getTotalPrice());
    }

    public Check createCheck(List<Product> productsList, String input) {
        double totalPrice = calculatorService.calculateTotalPrice(productsList, input);

        Map<Product, Integer> chosenProductsMap = new HashMap<>();
        String[] inputArr = input.split(SPACING);

        for (String item : inputArr) {
            productService.processInputItem(productsList, item, chosenProductsMap, totalPrice);
        }

        List<Products> chosenProducts = new ArrayList<>();
        productService.createChosenProductsList(chosenProductsMap, chosenProducts);

        return new Check(LocalDate.now(), LocalTime.now(), chosenProducts, totalPrice);
    }

}
