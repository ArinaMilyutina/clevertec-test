package main.java.ru.clevertec.check.console;

import main.java.ru.clevertec.check.console.util.ConsoleWriter;
import main.java.ru.clevertec.check.entity.Check;
import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.user.DebitCard;
import main.java.ru.clevertec.check.exception.BadRequestException;
import main.java.ru.clevertec.check.exception.NotEnoughMoneyException;
import main.java.ru.clevertec.check.service.CheckService;
import main.java.ru.clevertec.check.service.DiscountCardService;
import main.java.ru.clevertec.check.storage.FileStorage;

import java.util.List;

public class ConsoleApplication implements Application {
    private final static CheckService checkService = new CheckService();
    private final static DiscountCardService cardService = new DiscountCardService();
    private final static FileStorage fileStorage = new FileStorage();
    private static final ConsoleWriter writer = new ConsoleWriter();


    public void run(String[] args) {

        if (args.length < 3) {
            writer.write("Минимальное количество аргументов не было передано");
            return;
        }

        String idQuantity = args[0];
        String[] otherArgs = new String[args.length - 1];
        System.arraycopy(args, 1, otherArgs, 0, otherArgs.length);
        String discountCard = "";
        String balanceDebitCard = "";
        for (String arg : otherArgs) {
            if (arg.startsWith("discountCard=")) {
                discountCard = arg.substring("discountCard=".length());
            } else if (arg.startsWith("balanceDebitCard=")) {
                balanceDebitCard = arg.substring("balanceDebitCard=".length());
            }
        }
//String idQuantity="1-2 3-2 1-3";
//String discountCard="1111";
//double balanceDebitCard=100;
        DebitCard debitCard = new DebitCard();
        debitCard.setBalance(Double.parseDouble(balanceDebitCard));
        List<Product> productsList = fileStorage.readProductsFromCSV();

        try {
            Check check = checkService.createCheck(productsList, idQuantity, cardService.discountAmount(discountCard), discountCard, debitCard.getBalance());
            checkService.printCheck(check);
            fileStorage.writeCheckToCsv(check);
        } catch (BadRequestException e) {
            fileStorage.writeExceptionToCsv(e.getMessage(), e.getDescription());
        } catch (NotEnoughMoneyException e) {
            fileStorage.writeExceptionToCsv(e.getMessage(), e.getDescription());
        }
    }
}
