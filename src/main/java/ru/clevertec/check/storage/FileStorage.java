package main.java.ru.clevertec.check.storage;

import java.io.File;
import java.io.IOException;

public class FileStorage {
    private static final String FILENAME = "src/result.csv";

    public  void createFile() {
        File file = new File(FILENAME);

        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + FILENAME + " был успешно создан.");
            } else {
                System.out.println("Файл " + FILENAME + " уже существует.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла " + FILENAME);
            e.printStackTrace();
        }
    }
}
