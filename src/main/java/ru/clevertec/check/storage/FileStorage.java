package main.java.ru.clevertec.check.storage;

import main.java.ru.clevertec.check.console.util.ConsoleWriter;
import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.WholesaleProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private static final String FILENAME = "src/result.csv";
    private static final String SPLITTER_CSV = ";";
    private static final String WHOLESALE = "+";
    private static final String POINT = ".";
    private static final String COMMA = ",";
    private static final ConsoleWriter writer=new ConsoleWriter();


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
        List<Product> productsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] data = line.trim().split(SPLITTER_CSV);

                if (data.length >= 5) {
                    int id = Integer.parseInt(data[0].trim());
                    double price = Double.parseDouble(data[2].trim().replace(COMMA, POINT));
                    int quantityInStock = Integer.parseInt(data[3].trim());
                    WholesaleProduct wholesaleProduct = data[4].trim().equals(WHOLESALE) ? WholesaleProduct.WHOLESALE : WholesaleProduct.REGULAR;

                    String description;
                    if (data.length > 5) {
                        description = data[1].trim() + SPLITTER_CSV + data[5].trim();
                    } else {
                        description = data[1].trim();
                    }
                    Product product = new Product(id, price, quantityInStock, wholesaleProduct, description);
                    productsList.add(product);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productsList;
    }
}