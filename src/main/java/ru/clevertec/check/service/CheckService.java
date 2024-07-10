package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.console.util.ConsoleWriter;
import main.java.ru.clevertec.check.entity.Check;
import main.java.ru.clevertec.check.entity.DiscountCard;
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
    private static final CalculatorCheckService calculatorService = new CalculatorCheckService();
    private static final DiscountCardService cardService = new DiscountCardService();

    public void printCheck(Check check) {
        writer.write("Check Date: " + check.getDate());
        writer.write("Check Time: " + check.getTime());

        for (Products products : check.getProductList()) {
            Product product = products.getProduct();
            writer.write("Price: " + product.getPrice() + ", Quantity: " + products.getCount() + ", Description: " + product.getDescription() + ", Total: " + products.getTotal() + ", Discount: " + products.getDiscount());
        }
        writer.write("Discount card: " + check.getDiscountCard().getNumber());
        writer.write("Discount percentage: " + check.getDiscountCard().getDiscountAmount());

        writer.write("Total Price: " + check.getTotalPrice());
        writer.write("Total Discount: " + check.getTotalDiscount());
        writer.write("Total With Discount: " + check.getTotalPriceWithDiscount());
    }

    public Check createCheck(List<Product> productsList, String input, int discount, String number) {
        Map<Product, Integer> chosenProductsMap = new HashMap<>();
        double totalPrice = calculatorService.calculateTotalPrice(productsList, input);

        String[] inputArr = input.split(SPACING);
        for (String item : inputArr) {
            productService.processInputItem(productsList, item, chosenProductsMap, totalPrice);
        }
        List<Products> chosenProducts = new ArrayList<>();
        productService.createChosenProductsList(chosenProductsMap, chosenProducts, discount);
        double totalDiscount = calculatorService.calculateTotalDiscount(chosenProducts);
        double totalWithDiscount = calculatorService.calculateTotalWithDiscount(totalPrice, totalDiscount);
        DiscountCard discountCard = new DiscountCard(number, cardService.discountAmount(number));
        return new Check(LocalDate.now(), LocalTime.now(), chosenProducts, totalPrice, discountCard, totalDiscount, totalWithDiscount);
    }

}
