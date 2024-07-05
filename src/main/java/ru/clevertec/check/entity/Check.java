package main.java.ru.clevertec.check.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Check {
    private LocalDate date;
    private LocalTime time;
    List<Product>productList;
    private double total;
    private double discount;
    private double totalWithDiscount;
}
