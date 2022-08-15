package vnVkCoffeeShop.view;

import vnVkCoffeeShop.menu.Menu;
import vnVkCoffeeShop.model.Role;
import vnVkCoffeeShop.services.UserService;

import java.util.Scanner;

public class LoginUserView {
    static Scanner input = new Scanner(System.in);

    public static void login() {
        boolean flag = true;
        UserService userService = new UserService();
        do {
            System.out.println("======================ĐĂNG NHẬP HỆ THỐNG COFFEE SHOP======================");
            System.out.println("Username:");
            String username = input.nextLine().toLowerCase();
            System.out.println("Password:");
            String password = input.nextLine();
            if (username.equals("admin") && password.equals("admin")) {
                AdminView adminView = new AdminView();
                adminView.workOfAdmin();
            } else if (userService.checkUserName(username) && userService.checkPassword(password)) {
                if ((userService.checkRole(username)).equals(Role.ADMIN)) {
                    AdminView adminView = new AdminView();
                    adminView.workOfAdmin();
                } else {
                    GuestView guestView = new GuestView();
                    guestView.workOfGuest();
                }
            } else {
                System.out.println("Tài khoản không chính xác");
                Menu.getMenuReturn();
                flag = false;
            }
        } while (!flag);
    }
}
