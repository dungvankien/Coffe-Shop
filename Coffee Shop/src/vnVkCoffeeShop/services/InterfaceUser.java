package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.User;

public interface InterfaceUser {
    void add(User user);

    void edit(User user, String number, String parameters);

     void remove(User user);

     boolean find(User user);

     void print();

     void printItemUser(User user);

     void clear();

}
