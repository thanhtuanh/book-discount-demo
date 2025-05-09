package com.example.demo;

public class Book {
    private final String title;
    private final double price;

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public double applyDiscount(double percent) {
        return price - (price * percent / 100);
    }
}
