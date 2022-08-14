package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Order;
import vnVkCoffeeShop.utlis.DataConvertUtlis;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public final static String PATH = "data/order.csv";
    private static OrderService instance;

    public OrderService() {
    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    public List<Order> listOrder() {
        List<Order> orders = new ArrayList<>();
        List<String> records = DataConvertUtlis.read(PATH);
        for (String record : records) {
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }

    public void add(Order order) {
        List<Order> orders = listOrder();
        orders.add(order);
        DataConvertUtlis.write(PATH, orders);
    }

    public Order remove(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.equals(order)) {
                orders.remove(order);
            }
        }
        DataConvertUtlis.write(PATH, orders);
        return order;
    }

    public void printItemOrder(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.equals(order)) {
                System.out.println(item);
            }
        }
    }

    public void clear() {
        List<Order> orders = listOrder();
        orders.clear();
        DataConvertUtlis.write(PATH, orders);
    }

}
