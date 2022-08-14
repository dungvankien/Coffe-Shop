package vnVkCoffeeShop.view;

import vnVkCoffeeShop.menu.Menu;
import vnVkCoffeeShop.model.Role;
import vnVkCoffeeShop.model.User;
import vnVkCoffeeShop.services.UserService;
import vnVkCoffeeShop.utlis.ValidateUtils;

import java.util.Scanner;

public class UserView {
    UserService userService = new UserService();
    Scanner input = new Scanner(System.in);

    public void workOfUser() {
        String choice;
        do {
            Menu.getMenuUser();
            System.out.println("Nhập số theo chức năng cần thực hiện:");
            choice = input.nextLine();
            switch (choice) {
                case "1":
                    addUserView();
                    break;
                case "2":


            }

        } while (!choice.equals("0"));
    }

    public void addUserView() {
        String phoneNumber;
        String email;
        String username;
        String password;
        Role role;
        System.out.println("Nhâp ID User: ");
        String idEmployee = input.nextLine();
        User usercheck = new User(idEmployee);
        if (!userService.find(usercheck)) {
            System.out.println("Nhập Họ và Tên User: ");
            String fullName = input.nextLine();
            do {
                System.out.println("Nhập số điện thoại: ");
                phoneNumber = input.nextLine();
                if (ValidateUtils.isPhoneVaild(phoneNumber)) {
                    break;
                } else {
                    System.out.println("Nhập lại đúng số điện thoại: ");
                    Menu.getMenuYesNo();
                }
            } while (true);
            do {
                System.out.println("Nhâp Email: ");
                email = input.nextLine();
                if (ValidateUtils.isEmailVaild(email)) {
                    break;
                } else {
                    System.out.println("Nhập lại đúng email: ");
                    Menu.getMenuYesNo();
                }
            } while (true);
            System.out.println("Nhập địa chỉ: ");
            String address = input.nextLine();
            do{
                try {
                    System.out.println("Nhập phân quyền sử dụng:");
                    role = Role.parseRole(input.nextLine().toUpperCase());
                    break;
                }catch (Exception e){
                    System.out.println("Nhập lại đúng phân quền admin hoặc user");
                    Menu.getMenuYesNo();
                }
            }while (true);
            do {
                System.out.println("Nhập tên username: ");
                username = input.nextLine().toLowerCase();
                if (ValidateUtils.isUserNameVaild(username)) {
                    break;
                } else {
                    System.out.println("Nhập lại username có 4-12 ký tự" +
                            " không có ký tự đặc biệt ");
                    Menu.getMenuYesNo();
                }
            } while (true);
            do {
                System.out.println("Nhập password: ");
                password = input.nextLine();
                if (ValidateUtils.isPasswordVaild(password)) {
                    break;
                } else {
                    System.out.println("Nhập lại password có trên 8 ký tự " +
                            " không có ký tự đặc biệt ");
                    Menu.getMenuYesNo();
                }
            } while (true);
            User user = new User(idEmployee, fullName, phoneNumber, email, address, role, username, password);
            userService.add(user);
            System.out.println("User được thêm vào phân quyền");
            Menu.getMenuYesNo();
        } else {
            System.out.println("ID đã có trong danh sách sử dụng: ");
            Menu.getMenuYesNo();
        }
    }
}
