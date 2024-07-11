package main.java.ru.clevertec.check.entity.user;

public class DiscountCard {
    private long id;
    private String number;
    private int discountAmount;

    public DiscountCard() {

    }

    public static DiscountCardBuilder builder() {
        return new DiscountCard().new DiscountCardBuilder();
    }

    public class DiscountCardBuilder {
        public DiscountCardBuilder() {
        }

        public DiscountCardBuilder setId(long id) {
            DiscountCard.this.id = id;
            return this;
        }

        public DiscountCardBuilder setDiscountAmount(int discountAmount) {
            DiscountCard.this.discountAmount = discountAmount;
            return this;
        }

        public DiscountCardBuilder setNumber(String number) {
            DiscountCard.this.number = number;
            return this;
        }

        public DiscountCard build() {
            return DiscountCard.this;
        }

    }

    public long getId() {
        return id;
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
