package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Order;

public interface InterfaceOrder {
    void add(Order order);

    String getdateNow(Order order);

     boolean find(Order order);

     Double sumPriceOrder(Order order);

    void returnQuantilyProduct(String idOrder);

   void printAllOrder();

   void printItemOrder(Order order);

     void removeItemOrder(String idOrder);
}
