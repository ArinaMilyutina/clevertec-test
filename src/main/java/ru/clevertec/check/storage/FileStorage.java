package main.java.ru.clevertec.check.storage;

import main.java.ru.clevertec.check.console.util.ConsoleWriter;
import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.WholesaleProduct;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileStorage {
    private static final String FILENAME = "src/result.csv";
    private static final String FILENAME_CARD = "./src/main/resources/discountCards.csv";
    private static final String SPLITTER_CSV = ";";
    private static final String WHOLESALE = "+";
    private static final String POINT = ".";
    private static final String COMMA = ",";
    private static final int DEFAULT_DISCOUNT = 2;
    private static final ConsoleWriter writer = new ConsoleWriter();


    public void createFile() {
        File file = new File(FILENAME);

        try {
            if (file.createNewFile()) {
                writer.write("Файл " + FILENAME + " был успешно создан.");
            } else {
                writer.write("Файл " + FILENAME + " уже существует.");
            }
        } catch (IOException e) {
            writer.write("Ошибка при создании файла " + FILENAME);
            e.printStackTrace();
        }
    }

    public List<Product> readProductsFromCSV(String filename) {
        List<Product> productsList;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            productsList = br.lines()
                    .skip(1)
                    .map(line -> line.trim().split(SPLITTER_CSV))
                    .filter(data -> data.length >= 5)
                    .map(data -> {
                        int id = Integer.parseInt(data[0].trim());
                        double price = Double.parseDouble(data[2].trim().replace(COMMA, POINT));
                        int quantityInStock = Integer.parseInt(data[3].trim());
                        WholesaleProduct wholesaleProduct = data[4].trim().equals(WHOLESALE) ? WholesaleProduct.WHOLESALE : WholesaleProduct.REGULAR;
                        String description = data.length > 5 ? data[1].trim() + SPLITTER_CSV + data[5].trim() : data[1].trim();
                        return new Product(id, price, quantityInStock, wholesaleProduct, description);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productsList;
    }

    public int readDiscountCardsFromCSVByNumber(String cardNumber) {
        String line = "";
        int discount = DEFAULT_DISCOUNT;

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME_CARD))) {
            while ((line = br.readLine()) != null) {
                String[] card = line.split(SPLITTER_CSV);
                if (card[1].equals(cardNumber)) {
                    discount = Integer.parseInt(card[2]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return discount;
    }
}

