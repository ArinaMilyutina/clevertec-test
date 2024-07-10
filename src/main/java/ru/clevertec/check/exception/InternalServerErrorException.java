package main.java.ru.clevertec.check.exception;

public class InternalServerErrorException extends Exception{
    private String message;
    private String description;

    public InternalServerErrorException(String message, String description) {
        super(message);
        this.message = message;
        this.description = description;
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
