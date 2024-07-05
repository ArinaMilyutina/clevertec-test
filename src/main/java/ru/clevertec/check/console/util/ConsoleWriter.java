package main.java.ru.clevertec.check.console.util;

public class ConsoleWriter implements Writer{

    @Override
    public void write(String msg) {
        System.out.println(msg);
    }
}
