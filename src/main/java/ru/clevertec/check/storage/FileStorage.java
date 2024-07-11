package main.java.ru.clevertec.check.storage;

import main.java.ru.clevertec.check.entity.Check;
import main.java.ru.clevertec.check.entity.Product;
import main.java.ru.clevertec.check.entity.Products;
import main.java.ru.clevertec.check.entity.WholesaleProduct;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileStorage {
    private static final String FILENAME = "src/result.csv";
    private static final String FILENAME_CARD = "./src/main/resources/discountCards.csv";
    private static final String FILENAME_PRODUCT = "./src/main/resources/products.csv";
    private static final String SPLITTER_CSV = ";";
    private static final String WHOLESALE = "+";
    private static final String POINT = ".";
    private static final String CURRENCY = "$";
    private static final String COMMA = ",";
    private static final String ESCAPE_SEQUENCE = "\n";
    private static final int DEFAULT_DISCOUNT = 2;
    private static final StringBuilder sb = new StringBuilder();


    private FileWriter createFileCsv() {
        try {
            return new FileWriter(FILENAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> readProductsFromCSV() {
        List<Product> productsList;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME_PRODUCT))) {
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

                        return Product.builder().setId(id).setPrice(price).setQuantityInStock(quantityInStock).setWholesaleProduct(wholesaleProduct).setDescription(description).build();
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productsList;
    }

    public int readDiscountCardsFromCSVByNumber(String cardNumber) {
        String line;
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

    public void writeCheckToCsv(Check check) {
        try (Writer writer = createFileCsv()) {
            sb.append("Date;Time" + ESCAPE_SEQUENCE);
            sb.append(check.getDate()).append(SPLITTER_CSV)
                    .append(check.getTime()).append(ESCAPE_SEQUENCE);
            sb.append(ESCAPE_SEQUENCE + "QTY;DESCRIPTION;PRICE;DISCOUNT;TOTAL" + ESCAPE_SEQUENCE);
            for (Products product: check.getProductList()) {
                sb.append(product.getCount()).append(SPLITTER_CSV)
                        .append(product.getProduct().getDescription()).append(SPLITTER_CSV)
                        .append(product.getProduct().getPrice()).append(CURRENCY + SPLITTER_CSV)
                        .append(product.getDiscount()).append(CURRENCY + SPLITTER_CSV)
                        .append(product.getTotal()).append(CURRENCY + ESCAPE_SEQUENCE);
            }
            sb.append(ESCAPE_SEQUENCE + "DISCOUNT CARD;DISCOUNT PERCENTAGE" + ESCAPE_SEQUENCE);
            sb.append(check.getDiscountCard().getNumber()).append(SPLITTER_CSV)
                    .append(check.getDiscountCard().getDiscountAmount()).append(CURRENCY + ESCAPE_SEQUENCE);
            sb.append(ESCAPE_SEQUENCE + "TOTAL PRICE;TOTAL DISCOUNT;TOTAL WITH DISCOUNT" + ESCAPE_SEQUENCE);
            sb.append(check.getTotalPrice()).append(CURRENCY + SPLITTER_CSV)
                    .append(check.getTotalDiscount()).append(CURRENCY + SPLITTER_CSV)
                    .append(check.getTotalPriceWithDiscount()).append(CURRENCY + ESCAPE_SEQUENCE);
            writer.write(sb.toString());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeExceptionToCsv(String message, String description) {
        try (Writer writer = createFileCsv()) {
            sb.append(message).append(ESCAPE_SEQUENCE).append(description);
            writer.write(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

