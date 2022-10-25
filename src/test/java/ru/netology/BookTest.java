package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    public void shouldNotMatchesByName() {
        Book product1 = new Book(1, "Fantastic Mr Fox", 1000, "Roald Dahl");
        boolean expected = false;
        boolean actual = product1.matches("Apple");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesByName() {
        Book product1 = new Book(1, "Fantastic Mr Fox", 1000, "Roald Dahl");
        boolean expected = true;
        boolean actual = product1.matches("Mr Fox");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesByAuthor() {
        Book product1 = new Book(1, "Fantastic Mr Fox", 1000, "Roald Dahl");
        boolean expected = true;
        boolean actual = product1.matches("Roald");
        assertEquals(expected, actual);
    }
}