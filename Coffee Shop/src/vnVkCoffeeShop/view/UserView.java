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
                    editUserView();
                    break;
                case "3":
                    removeUserView();
                    break;
                case "4":
                    printUserView();
                    break;
                case "5":
                    findUserView();
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
            do {
                try {
                    System.out.println("Nhập phân quyền sử dụng:");
                    role = Role.parseRole(input.nextLine().toUpperCase());
                    break;
                } catch (Exception e) {
                    System.out.println("Nhập lại đúng phân quền admin hoặc user");
                    Menu.getMenuYesNo();
                }
            } while (true);
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

    public void editUserView() {
        System.out.println("Nhập ID User cần chỉnh: ");
        String idUserEdit = input.nextLine();
        User userEdit = new User(idUserEdit);
        if (userService.find(userEdit)) {
            Menu.getMenuEditUser();
            do {
                System.out.println("Nhập số cần chỉnh: ");
                String number = input.nextLine();
                String value = "";
                if (number.equals("0")) {
                    Menu.getMenuYesNo();
                    break;
                }
                if (number.equals("1") || number.equals("2") || number.equals("3") || number.equals("4")) {
                    if (number.equals("1")) {
                        do {
                            try {
                                System.out.println("Nhập phân quyền cần thay đổi:");
                                value = input.nextLine().toUpperCase();
                                Role.parseRole(value);
                                break;
                            } catch (Exception e) {
                                System.out.println("Nhập lại đúng phân quền admin hoặc user");
                                Menu.getMenuYesNo();
                            }
                        } while (true);
                    }
                    if (number.equals("2")) {
                        do {
                            System.out.println("Nhập số điện thoại cần thay đổi: ");
                            value = input.nextLine();
                            if (ValidateUtils.isPhoneVaild(value)) {
                                break;
                            } else {
                                System.out.println("Nhập lại đúng số điện thoại: ");
                                Menu.getMenuYesNo();
                            }
                        } while (true);
                    }
                    if (number.equals("3")) {
                        do {
                            System.out.println("Nhập tên username cần thay đổi: ");
                            value = input.nextLine().toLowerCase();
                            if (ValidateUtils.isUserNameVaild(value)) {
                                break;
                            } else {
                                System.out.println("Nhập lại username có 4-12 ký tự" +
                                        " không có ký tự đặc biệt ");
                                Menu.getMenuYesNo();
                            }
                        } while (true);
                    }
                    if (number.equals("4")) {
                        do {
                            System.out.println("Nhập password: ");
                            value = input.nextLine();
                            if (ValidateUtils.isPasswordVaild(value)) {
                                break;
                            } else {
                                System.out.println("Nhập lại password có trên 8 ký tự " +
                                        " không có ký tự đặc biệt ");
                                Menu.getMenuYesNo();
                            }
                        } while (true);
                    }
                    userService.edit(userEdit, number, value);
                    System.out.println("Giá trị đã được thay dổi: ");
                    Menu.getMenuYesNo();
                    break;
                } else {
                    System.out.println("Nhập không đúng giá trị");
                    Menu.getMenuYesNo();
                }
            } while (true);
        } else {
            System.out.println("ID User không tồn tại");
            Menu.getMenuYesNo();
        }
    }

    public void removeUserView() {
        System.out.println("Nhập ID user cần xóa: ");
        String idUserRemove = input.nextLine();
        User userRemove = new User(idUserRemove);
        if (userService.find(userRemove)) {
            userService.remove(userRemove);
            System.out.println("Đã xóa User có ID :" + idUserRemove);
            Menu.getMenuYesNo();
        } else {
            System.out.println("ID User không có trong thư viện");
            Menu.getMenuYesNo();
        }
    }

    public void printUserView() {
        System.out.println("DANH SÁCH CÁC USER");
        System.out.printf("%-15s %-15s %-15s %-25s %-25s %-15s %-15s %-15s\n", "ID USER", "TÊN NHÂN VIÊN",
                "SỐ ĐIỆN THOẠI", "EMAIL", "ĐỊA CHỈ", "PHÂN QUYỀN", "USERNAME", "PASSWORD");
        userService.print();
        Menu.getMenuYesNo();
    }

    public void findUserView() {
        System.out.println("Nhập ID User cần tìm kiếm");
        String idUserFind = input.nextLine();
        User userFind = new User(idUserFind);
        if (userService.find(userFind)) {
            System.out.printf("%-15s %-15s %-15s %-25s %-25s %-15s %-15s %-15s\n", "ID USER", "TÊN NHÂN VIÊN",
                    "SỐ ĐIỆN THOẠI", "EMAIL", "ĐỊA CHỈ", "PHÂN QUYỀN", "USERNAME", "PASSWORD");
            userService.printItemUser(userFind);
            Menu.getMenuYesNo();
        } else {
            System.out.println("ID User không tồn tại");
            Menu.getMenuYesNo();
        }
    }
}

