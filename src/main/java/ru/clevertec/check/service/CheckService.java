package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.console.util.ConsoleWriter;
import main.java.ru.clevertec.check.entity.Check;
import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;
import main.java.ru.clevertec.check.entity.user.DiscountCard;
import main.java.ru.clevertec.check.exception.BadRequestException;
import main.java.ru.clevertec.check.exception.NotEnoughMoneyException;
import main.java.ru.clevertec.check.util.DateTimeFormatterUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckService {
    private static final ConsoleWriter writer = new ConsoleWriter();
    private static final String SPACING = " ";
    private static final String ERROR = "ERROR ";
    private static final String BAD_REQUEST = "BAD REQUEST";
    private static final String NOT_ENOUGH_MONEY = "NOT ENOUGH MONEY";
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

    public Check createCheck(List<Product> productsList, String input, int discount, String number, double balance) throws BadRequestException, NotEnoughMoneyException {
        Map<Product, Integer> chosenProductsMap = new HashMap<>();
        double totalPrice = calculatorService.calculateTotalPrice(productsList, input);

        String[] inputArr = input.split(SPACING);
        if (inputArr.length == 0 || productsList.isEmpty()) {
            throw new BadRequestException(ERROR, BAD_REQUEST);
        }
        for (String item : inputArr) {
            productService.processInputItem(productsList, item, chosenProductsMap, totalPrice);
        }
        List<Products> chosenProducts = new ArrayList<>();
        productService.createChosenProductsList(chosenProductsMap, chosenProducts, discount);
        double totalDiscount = calculatorService.calculateTotalDiscount(chosenProducts);
        double totalWithDiscount = calculatorService.calculateTotalWithDiscount(totalPrice, totalDiscount);
        double accountBalance = balance - totalWithDiscount;
        if (accountBalance >= 0) {
            DiscountCard discountCard = DiscountCard.builder().setNumber(number).setDiscountAmount(cardService.discountAmount(number)).build();
            return Check.builder().setDate(DateTimeFormatterUtils.DateFormatter(LocalDate.now())).setTime(DateTimeFormatterUtils.TimeFormatter(LocalTime.now())).setListProducts(chosenProducts).setTotalPrice(totalPrice).setDiscountCard(discountCard).setTotalDiscount(totalDiscount).setTotalWithDiscount(totalWithDiscount).build();
        } else {
            throw new NotEnoughMoneyException(ERROR, NOT_ENOUGH_MONEY);
        }

    }

}
