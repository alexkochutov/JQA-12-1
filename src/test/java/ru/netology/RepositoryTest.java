package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Book product1 = new Book(1, "Fantastic Mr Fox", 1000, "Roald Dahl");
    Book product2 = new Book(2, "The Old Man and the Sea", 1500, "Ernest Hemingway");
    Smartphone product3 = new Smartphone(3, "iPhone SE (2022)", 120000, "Apple");
    Smartphone product4 = new Smartphone(4, "Galaxy Z Fold 4", 84500, "Samsung");

    @Test
    public void shouldFindAllInEmptyArray() {
        Repository repo = new Repository();
        Product[] expected = {};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveIntoEmptyArray() {
        Repository repo = new Repository();
        repo.save(product1);
        Product[] expected = {product1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveIntoNonEmptyArray() {
        Repository repo = new Repository();
        repo.save(product1);
        repo.save(product2);
        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdInEmptyArray() {
        Repository repo = new Repository();
        repo.removeById(5);
        Product[] expected = {};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdInArrayWithoutMatch() {
        Repository repo = new Repository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(5);
        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromFirstPosition() {
        Repository repo = new Repository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(1);
        Product[] expected = {product2, product3, product4};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdFromLastPosition() {
        Repository repo = new Repository();
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.removeById(4);
        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }
}