package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Book product1 = new Book(1, "Fantastic Mr Fox", 1000, "Roald Dahl");
    Book product2 = new Book(2, "The Old Man and the Sea", 1500, "Ernest Hemingway");
    Smartphone product3 = new Smartphone(3, "iPhone SE (2022)", 120000, "Apple");
    Smartphone product4 = new Smartphone(4, "Galaxy Z Fold 4", 84500, "Samsung");
    Smartphone product5 = new Smartphone(5, "Galaxy Z Flip 4", 69800, "Samsung");

    @Test
    public void shouldAddIntoEmptyRepository() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(product1);
        Product[] expected = {product1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddIntoNonEmptyRepository() {
        Repository repo = new Repository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        Manager manager = new Manager(repo);
        manager.add(product4);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalse() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        boolean expected = false;
        boolean actual = manager.matches(product2, "Galaxy");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnTrue() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        boolean expected = true;
        boolean actual = manager.matches(product3, "iPhone");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchByInEmptyRepository() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByInNonEmptyRepository() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] expected = {};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        Product[] expected = {product3};
        Product[] actual = manager.searchBy("iPhone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByForFewResult() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        Product[] expected = {product4, product5};
        Product[] actual = manager.searchBy("Galaxy");
        assertArrayEquals(expected, actual);
    }
}