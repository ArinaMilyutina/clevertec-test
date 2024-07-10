package main.java.ru.clevertec.check.service;

import main.java.ru.clevertec.check.storage.FileStorage;

public class DiscountCardService {
    private static final FileStorage filestorage = new FileStorage();

    public int discountAmount(String number) {
        return filestorage.readDiscountCardsFromCSVByNumber(number);
    }
}
