package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Order;
import vnVkCoffeeShop.model.Product;
import vnVkCoffeeShop.utlis.DataConvertUtlis;

import java.util.ArrayList;
import java.util.List;

public class OrderService implements InterfaceOrder {
    public final static String PATH = "data/order.csv";

    public OrderService() {
    }

    public List<Order> listOrder() {
        List<Order> orders = new ArrayList<>();
        List<String> records = DataConvertUtlis.read(PATH);
        for (String record : records) {
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }

    @Override
    public void add(Order order) {
        List<Order> orders = listOrder();
        orders.add(order);
        DataConvertUtlis.write(PATH, orders);
    }

    @Override
    public String getdateNow(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.equals(order)) {
                return item.getDate();
            }
        }
        return null;
    }

    @Override
    public Double sumPriceOrder(Order order) {
        List<Order> orders = listOrder();
        double sumPrice = 0.0;
        for (Order item : orders) {
            if (item.getIdOrder().equals(order.getIdOrder())) {
                sumPrice += (item.getPrice()) * (item.getQuantity());
            }
        }
        return sumPrice;
    }

    @Override
    public boolean find(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.getIdOrder().equals(order.getIdOrder())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void returnQuantilyProduct(String idOrder) {
        List<Order> orders = listOrder();
        ProductService productService = new ProductService();
        for (Order item : orders) {
            if (item.getIdOrder().equals(idOrder)) {
                Product product = new Product(item.getIdProduct());
                productService.subtractAddition(product, item.getQuantity());
            }
        }
    }

    @Override
    public void printAllOrder() {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            System.out.printf("%-15s %-15s %-20s %-15s %-15s %-20s\n", item.getIdOrder(), item.getIdProduct(),
                    item.getNameProduct(), item.getQuantity(), item.getPrice(), item.getDate());
        }
    }

    @Override
    public void printItemOrder(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.getIdOrder().equals(order.getIdOrder())) {
                System.out.printf("%-15s %-25s %-20s %-15s\n", item.getIdProduct(), item.getNameProduct(),
                        item.getQuantity(), item.getPrice());
            }
        }
    }

    @Override
    public void removeItemOrder(String idOrder) {
        List<Order> orders = listOrder();
        orders.removeIf(item -> item.getIdOrder().equals(idOrder));
        DataConvertUtlis.write(PATH, orders);
    }
}
