package vnVkCoffeeShop.view;

import vnVkCoffeeShop.menu.Menu;
import vnVkCoffeeShop.model.Role;
import vnVkCoffeeShop.model.User;
import vnVkCoffeeShop.services.UserService;

import java.util.Scanner;

public class LoginUserView {
    static Scanner input = new Scanner(System.in);

    public static void login() {
        boolean flag = true;
        UserService userService = new UserService();
        do {
            System.out.println("==============ĐĂNG NHẬP HỆ THỐNG COFFEE SHOP==============");
            System.out.println("Username:");
            String username = input.nextLine().toLowerCase();
            System.out.println("Password:");
            String password = input.nextLine();
            if (username.equals("admin") && password.equals("admin")) {
                AdminView adminView = new AdminView();
                adminView.workOfAdmin();
            }
            if (userService.checkUserName(username) && userService.checkPassword(password)) {
                User user = new User(username, password);
                if ((user.getRole()).equals(Role.ADMIN)) {
                    AdminView adminView = new AdminView();
                    adminView.workOfAdmin();
                }
                if ((user.getRole()).equals(Role.USER)) {
                    GuestView guestView = new GuestView();
                    guestView.workOfGuest();
                }
            } else {
                System.out.println("Tài khoản không chính xác");
                Menu.getMenuYesNo();
                flag = false;
            }
        } while (!flag);


    }
}
