package ru.netology;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone(int id, String name, int cost, String manufacture) {
        super(id, name, cost);
        this.manufacture = manufacture;
    }
}