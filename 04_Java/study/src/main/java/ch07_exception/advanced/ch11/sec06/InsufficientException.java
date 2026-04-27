package main.java.ch07_exception.advanced.ch11.sec06;

public class InsufficientException extends Exception{
    public InsufficientException() {
    }

    public InsufficientException(String message) {
        super(message);
    }
}
