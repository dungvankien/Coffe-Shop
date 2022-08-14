package vnVkCoffeeShop.view;

import vnVkCoffeeShop.menu.Menu;
import vnVkCoffeeShop.model.Order;
import vnVkCoffeeShop.model.Product;
import vnVkCoffeeShop.services.OrderService;
import vnVkCoffeeShop.services.ProductService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OrderView {
    OrderService orderService = new OrderService();
    ProductService productService = new ProductService();
    Scanner input = new Scanner(System.in);
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    public void workOFOrder() {
        String choice;
        do {
            Menu.getMenuGuest();
            System.out.println("Nhập số theo chức năng cần thực hiện: ");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    productService.print();
                    addOrder();
                    Menu.getMenuYesNo();
                    break;
                case "2":
                    removerOrderItem();
                    Menu.getMenuYesNo();
                    break;
                case "3":
                    printItemOrder();
                    Menu.getMenuYesNo();
                    break;
                case "4":
                    printAllOrderView();
                    Menu.getMenuYesNo();
                    break;
                case "0":
                    Menu.getMenuYesNo();
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng chức năng");
                    Menu.getMenuYesNo();
            }
        } while (!choice.equals("0"));
    }

    public void addOrder() {
        boolean flag;
        Integer amount = null;
        long idOrder = System.currentTimeMillis() / 1000;
        String dateNow = formatter.format(date);
        do {
            System.out.println("Nhập ID sản phẩm cần bán: ");
            String idProduct = input.nextLine();
            Product product = new Product(idProduct);
            String nameProduct = productService.getName(product);
            Double priceProduct = productService.getPrice(product);

            if (productService.find(product)) {
                do {
                    try {
                        System.out.println("Nhập số lượng cần mua");
                        amount = Integer.parseInt(input.nextLine());
                        if (productService.getQuality(product) >= amount && productService.getQuality(product) > 0) {
                            productService.subtractAddition(product, -amount);
                            flag = false;
                        } else {
                            System.out.println("Kiểm tra lại và chọn số lượng phù hợp: ");
                            flag = true;
                            Menu.getMenuYesNo();
                        }
                    } catch (Exception e) {
                        System.out.println("Nhập đúng số lượng cần mua");
                        flag = true;

                    }
                } while (flag);
                Order order = new Order(idOrder, idProduct, nameProduct, amount, priceProduct, dateNow);
                orderService.add(order);
                do {
                    System.out.println("Nhập 'Y' để tiếp tục mua thêm <==> Nhập 'C' để tạo Order <==> Nhập 'N' để hủy Order");
                    String choice = input.nextLine().toUpperCase();
                    flag = false;
                    switch (choice) {
                        case "Y":
                            break;
                        case "C":
                            printOrderView(idOrder);
                            return;
                        case "N":
                            try {
                                removerOrderView(idOrder);
                            }catch (Exception e){
                                System.out.println("Đã hủy đơn hàng");
                            }
                            return;
                        default:
                            System.out.println("Vui lòng chọn đúng chức năng");
                            Menu.getMenuYesNo();
                            flag = true;
                    }
                } while (flag);
            } else {
                System.out.println("Id sản phẩm không có trong danh sách cần nhập lại");
                Menu.getMenuYesNo();
            }
        } while (true);
    }

    public void printOrderView(long idOrder) {
        Order order = new Order(idOrder);
        String dateNow = orderService.getdateNow(order);
        System.out.println("---------------------------------- SẢN PHẨM ORDER ----------------------------------------------");
        System.out.println("ID ORDER: " + idOrder + "-------------------------" + "DATE ORDER: " + dateNow);
        System.out.printf("%-15s %-25s %-20s %-15s\n", "ID SẢN PHẨM", "TÊN SẢN PHẨM",
                "SỐ LƯỢNG", "GIÁ SẢN PHẨM");
        orderService.printItemOrder(order);
        System.out.println("<<<<<<======Tổng số tiền cần trả: " + orderService.sumPriceOrder(order) + "<<<<<<======");
    }

    public void removerOrderView(long idOrder) {
        Order order = new Order(idOrder);
        orderService.remove(order);
        System.out.println("Đã hủy Oder: ");
    }

    public void removerOrderItem() {
        do {
            try {
                System.out.println("Nhập ID Order cần xóa: ");
                long idOrder = Long.parseLong(input.nextLine());
                Order order = new Order(idOrder);
                if (orderService.find(order)) {
                    orderService.removeItemOrder(order);
                    System.out.println(" Đã xóa Order có ID: " + idOrder);
                } else {
                    System.out.println("ID Order không tồn tại:");
                    Menu.getMenuYesNo();
                }
                break;
            } catch (Exception e) {
                System.out.println("Nhập ID Order bị sai cần nhập lại");
                Menu.getMenuYesNo();
            }
        } while (true);
    }

    public void printItemOrder() {
        do {
            try {
                System.out.println("Nhập ID Order cần in: ");
                long idOrder = Long.parseLong(input.nextLine());
                Order order = new Order(idOrder);
                if (orderService.find(order)) {
                    printOrderView(idOrder);
                    break;
                } else {
                    System.out.println("ID Order không tồn tại:");
                    Menu.getMenuYesNo();
                }
            } catch (Exception e) {
                System.out.println("Nhập ID Order bị sai cần nhập lại");
                Menu.getMenuYesNo();
            }
        } while (true);
    }

    public void printAllOrderView() {
        System.out.println("------------------------------------------------ SẢN PHẨM ORDER --------------------------------------------");
        System.out.printf("%-15s %-15s %-20s %-15s %-15s %-20s\n", "ID ORDER", "ID SẢN PHẨM", "TÊN SẢN PHẨM",
                "SỐ LƯỢNG", "GIÁ SẢN PHẨM", "NGÀY ORDER");
        orderService.printAllOrder();
        System.out.println("------------------------------------------------------------------------------------------------------------");
    }

}
