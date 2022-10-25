package ru.netology;

public class Repository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void removeById(int id) {
        boolean isFounded = false;
        for (Product product : products) {
            if (product.id == id) {
                isFounded = true;
                break;
            }
        }
        if (!isFounded) {
            return;
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.id != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }
}