package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    public void shouldGetNameOfBook() {
        Product product = new Book(4, "Empty World", 1900, "John Christopher");
        String expected = "Empty World";
        String actual = product.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetNameOfSmartphone() {
        Product product = new Smartphone(8, "iPhone SE (2022)", 120000, "Apple");
        String expected = "iPhone SE (2022)";
        String actual = product.getName();
        assertEquals(expected, actual);
    }

}