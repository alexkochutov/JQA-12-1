package ru.netology;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone(int id, String name, int cost, String manufacture) {
        super(id, name, cost);
        this.manufacture = manufacture;
    }

    public String getManufacture() {
        return manufacture;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getManufacture().contains(search);
        }
    }
}