package main.java.ru.clevertec.check.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class DateTimeFormatterUtils {
    private static final String DATE = "dd:MM:yyyy";
    private static final String TIME = "HH:mm:ss";

    public static String DateFormatter(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE);
        return date.format(formatter).replace("-", ".");
    }

    public static String TimeFormatter(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME);
        return time.format(formatter);
    }
}
