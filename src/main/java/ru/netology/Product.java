package ru.netology;

public class Product {
    protected int id;
    protected String name;
    protected int cost;

    public Product(int id, String name, int cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public boolean matches(String search) {
        return getName().contains(search);
    }
}