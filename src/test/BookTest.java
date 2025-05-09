
package com.example.demo;

import main.java.com.example.demo.Book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void shouldApplyDiscountCorrectly() {
        Book book = new Book("TDD mit Java", 100.0);
        double result = book.applyDiscount(15); // 15% Rabatt
        assertEquals(85.0, result);
    }
}
