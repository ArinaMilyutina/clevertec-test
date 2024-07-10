package main.java.ru.clevertec.check.entity.user;

public class DiscountCard {
    private long id;
    private String number;
    private int discountAmount;

    public long getId() {
        return id;
    }

    public DiscountCard(String number, int discountAmount) {
        this.number = number;
        this.discountAmount = discountAmount;
    }

    public String getNumber() {
        return number;
    }

    public int getDiscountAmount() {
        return discountAmount;
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
