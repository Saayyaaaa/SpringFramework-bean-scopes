package com.example.springbeanscopes;

public class HelloMessageGenerator {

    private String message;

    // Стандартный конструктор
    public HelloMessageGenerator() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
