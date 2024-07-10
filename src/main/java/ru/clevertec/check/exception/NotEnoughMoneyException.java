package main.java.ru.clevertec.check.exception;

public class NotEnoughMoneyException extends Exception{
    private String message;
    private String description;
    public NotEnoughMoneyException(String message,String description) {
        super(message);
        this.description=description;
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
