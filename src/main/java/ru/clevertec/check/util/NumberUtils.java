package main.java.ru.clevertec.check.util;

public class NumberUtils {
    public static double roundNumber(double number){
        number=Math.round(number*100);
        number=number/100;
        return number;
    }
}
