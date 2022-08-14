package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Order;
import vnVkCoffeeShop.model.Product;
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

    public String getdateNow(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.equals(order)) {
                return item.getDate();
            }
        }
        return null;
    }

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

    public boolean find(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.getIdOrder().equals(order.getIdOrder())) {
                return true;
            }
        }
        return false;
    }

    public void remove(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.getIdOrder().equals(order.getIdOrder())) {
                ProductService productService=new ProductService();
                Product product=new Product(item.getIdProduct());
                productService.subtractAddition(product,item.getQuantity());
                orders.remove(item);
            }
        }
        DataConvertUtlis.write(PATH, orders);
    }
    public void printAllOrder(){
        List<Order> orders = listOrder();
        for (Order item : orders) {
            System.out.printf("%-15s %-15s %-25s %-20s %-15s %-20s\n",item.getIdOrder(), item.getIdProduct(),
                    item.getNameProduct(),item.getQuantity(), item.getPrice(),item.getDate());
        }
    }
    public void printItemOrder(Order order) {
        List<Order> orders = listOrder();
        for (Order item : orders) {
            if (item.getIdOrder().equals(order.getIdOrder())) {
                System.out.printf("%-15s %-25s %-20s %-15s\n", item.getIdProduct(), item.getNameProduct(),
                        item.getQuantity(), item.getPrice());
            }
        }
    }

    public void removeItemOrder(Order order) {
        List<Order> orders = listOrder();
        for (Order item:orders){
            if(item.getIdOrder().equals(order.getIdOrder())){
                orders.remove(item);
            }
        }
        DataConvertUtlis.write(PATH, orders);
    }

}
