package main.java.ru.clevertec.check.entity;

public class DiscountCard {
    private long id;
    private int number;
    private int discountAmount;

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public DiscountCard(long id, int number, int discountAmount) {
        this.id = id;
        this.number = number;
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "DiscountCard{" +
                "id=" + id +
                ", number=" + number +
                ", discountAmount=" + discountAmount +
                '}';
    }

}
