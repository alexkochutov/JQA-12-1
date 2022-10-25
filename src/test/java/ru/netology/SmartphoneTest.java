package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    public void shouldNotMatchesByName() {
        Smartphone product1 = new Smartphone(8, "iPhone SE (2022)", 120000, "Apple");
        boolean expected = false;
        boolean actual = product1.matches("Samsung");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesByName() {
        Smartphone product1 = new Smartphone(8, "iPhone SE (2022)", 120000, "Apple");
        boolean expected = true;
        boolean actual = product1.matches("iPhone");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesByManufacture() {
        Smartphone product1 = new Smartphone(8, "iPhone SE (2022)", 120000, "Apple");
        boolean expected = true;
        boolean actual = product1.matches("Apple");
        assertEquals(expected, actual);
    }
}