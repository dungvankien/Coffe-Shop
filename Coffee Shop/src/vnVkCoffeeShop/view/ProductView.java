package vnVkCoffeeShop.view;

import vnVkCoffeeShop.menu.Menu;
import vnVkCoffeeShop.model.Product;
import vnVkCoffeeShop.services.ProductService;

import java.util.Scanner;

public class ProductView {
    ProductService productService = new ProductService();
    Scanner input = new Scanner(System.in);

    public void workOfProduct() {

        String choice;
        do {
            Menu.getMenuProduc();
            System.out.println("Nhập số theo chức năng cần thực hiện:");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    addProductView();
                    break;
                case "2":
                    editProductView();
                    break;
                case "3":
                    removeProductView();
                    break;
                case "4":
                    printProductView();
                    break;
                case "5":
                    findProductView();
                    break;
                case "6":
                    productService.sortUpPrice();
                    printProductView();
                    break;
                case "7":
                    productService.sortDownPrice();
                    printProductView();
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

    public void addProductView() {
        System.out.println("Nhập ID sản phẩm: ");
        String idProduct = input.nextLine();
        Product productCheck = new Product(idProduct);
        if (!productService.find(productCheck)) {
            System.out.println("Nhập tên sản phẩm: ");
            String nameProduct = input.nextLine();
            double price = 0;
            int quantity;
            do {
                try {
                    System.out.println("Nhập tổng số lượng sản phẩm: ");
                    quantity = Integer.parseInt(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Nhập sai định dang cần nhập lại");
                    Menu.getMenuYesNo();
                }
            } while (true);
            do {
                try {
                    System.out.println("Nhập giá sản phẩm: ");
                    price = Double.parseDouble(input.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Nhập sai định dang cần nhập lại");
                    Menu.getMenuYesNo();
                }
            } while (true);
            Product product = new Product(idProduct, nameProduct, quantity, price);
            productService.add(product);
            System.out.println("Sản phẩm đã được thêm vào danh sách");
            Menu.getMenuYesNo();
        } else {
            System.out.println("ID đã có trong danh sách sản phẩm: ");
            Menu.getMenuYesNo();
        }

    }

    public void editProductView() {
        System.out.println("Nhập ID sản phẩm cần chỉnh: ");
        String idProductEdit = input.nextLine();
        Product productEdit = new Product(idProductEdit);
        if (productService.find(productEdit)) {
            Menu.getMenuEditProduct();
            do {
                System.out.println("Nhập số cần chỉnh: ");
                String number = input.nextLine();
                String value = "";
                if (number.equals("0")) {
                    Menu.getMenuYesNo();
                    break;
                }
                if (number.equals("1") || number.equals("2") || number.equals("3") || number.equals("4")) {
                    if (number.equals("1") || number.equals("2")) {
                        System.out.println("Nhập giá trị cần thay đổi: ");
                        value = input.nextLine();
                    }
                    if (number.equals("3")) {
                        do {
                            try {
                                System.out.println("Nhập giá trị cần thay đổi: ");
                                value = input.nextLine();
                                Integer.parseInt(value);
                                break;
                            } catch (Exception e) {
                                System.out.println("Nhập sai định dạng cần nhập lại");
                                Menu.getMenuYesNo();
                            }
                        } while (true);
                    }
                    if (number.equals("4")) {
                        do {
                            try {
                                System.out.println("Nhập giá trị cần thay đổi: ");
                                value = input.nextLine();
                                Double.parseDouble(value);
                                break;
                            } catch (Exception e) {
                                System.out.println("Nhập sai định dạng cần nhập lại");
                                Menu.getMenuYesNo();
                            }
                        } while (true);
                    }
                    productService.edit(productEdit, number, value);
                    System.out.println("Giá trị đã được thay đổi.");
                    Menu.getMenuYesNo();
                    break;
                } else {
                    System.out.println("Nhập không đúng giá trị");
                    Menu.getMenuYesNo();
                }
            } while (true);
        } else {
            System.out.println("ID không có trong danh sách sản phẩm");
            Menu.getMenuYesNo();
        }
    }

    public void removeProductView() {
        System.out.println("Nhập ID sản phẩm cần xóa: ");
        String idProductRemove = input.nextLine();
        Product productRemove = new Product(idProductRemove);
        if (productService.find(productRemove)) {
            productService.remove(productRemove);
            System.out.println("Đã xóa sản phẩm có: " + idProductRemove);
            Menu.getMenuYesNo();
        } else {
            System.out.println("ID không có trong danh sách sản phẩm");
            Menu.getMenuYesNo();
        }
    }

    public void printProductView() {
        System.out.println("DANH SÁCH SẢN PHẨM");
        System.out.printf("%-15s %-25s %-20s %-15s\n", "ID SẢN PHẨM", "TÊN SẢN PHẨM",
                "SỐ LƯỢNG", "GIÁ SẢN PHẨM");
        productService.print();
        Menu.getMenuYesNo();
    }

    public void findProductView() {
        System.out.println("Nhập ID sản phẩm cần tìm kiếm");
        String idProductFind = input.nextLine();
        Product productFind = new Product(idProductFind);
        if (productService.find(productFind)) {
            System.out.printf("%-15s %-25s %-20s %-15s\n", "ID SẢN PHẨM", "TÊN SẢN PHẨM",
                    "SỐ LƯỢNG", "GIÁ SẢN PHẨM");
            productService.printItemProduc(productFind);
            Menu.getMenuYesNo();
        } else {
            System.out.println("Sản ID không có trong danh sách sản phẩm");
            Menu.getMenuYesNo();
        }
    }
}
