package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Product;

import java.util.List;


public interface InterfaceProduct {
  List<Product> listProducts();

    void add(Product product);

     Product remove(Product product);

    void edit(Product product, String number, String parameters);

    int size();

    void clear();

    void print();

    void printItemProduc(Product product);

    boolean find(Product product);
}
