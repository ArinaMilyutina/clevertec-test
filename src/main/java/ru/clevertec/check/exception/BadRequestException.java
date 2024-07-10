package main.java.ru.clevertec.check.exception;

public class BadRequestException extends Exception{
    private String message;
    private String description;
    public BadRequestException(String message, String description) {
        super(message);
        this.message=message;
        this.description=description;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
