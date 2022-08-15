package vnVkCoffeeShop.menu;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    public static boolean getMenuYesNo() {
        String choice;
        do {
            System.out.println("========================================================================");
            System.out.println("Chọn 'R' => Quay lại                Chọn 'E' => Thoát chương trình");
            choice = input.nextLine().toLowerCase();
            if (choice.equals("e")) {
                System.out.println("========================================================================");
                System.exit(0);
            } else if (choice.equals("r")) {
                System.out.println("========================================================================");
                return true;
            }  else {
                System.out.println("Nhập Không chính xác vui lòng nhập lại");
            }
        } while (true);
    }

    public static void getMenuGuest() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^SALE MENU^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Tạo đơn hàng\n" +
                "2. Xóa đơn hàng theo ID\n" +
                "3. In đơn hảng theo ID\n" +
                "4. In toàn bộ đơn hàng\n" +
                "0. Thoát chương trình");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static void getMenuAdmin() {
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^MAIN MENU^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("1. Quản lý sản phẩm\n" +
                "2. Quản lý User\n" +
                "3. Thực hiện bán hàng\n" +
                "0. Thoát chương trình");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static void getMenuUser() {
        System.out.println("****************************** QUẢN LÝ USER ******************************");
        System.out.println("1. Thêm User vào thư viện\n" +
                "2. Chỉnh sửa User trong thư viện theo ID\n" +
                "3. Xóa User trong thư viện\n" +
                "4. In danh sách các User\n" +
                "5. Tìm kiếm User trong thứ viện theo ID\n" +
                "0. Thoát chương trình");
        System.out.println("******************************************************************************");
    }
    public static void getMenuEditUser(){
        System.out.println("****************************** CHỌC MỤC CẦN CHỈNH ******************************");
        System.out.println("1. Chỉnh lại phân quyền\n" +
                "2. Chỉnh lại số điện thoại\n" +
                "3. Thay đổi username\n" +
                "4. Thay đổi mật khấu\n" +
                "0. Thoát chương trình ");
        System.out.println("******************************************************************************");
    }

    public static void getMenuProduc() {
        System.out.println("****************************** QUẢN LÝ SẢN PHẨM ******************************");
        System.out.println("1. Thêm sản phẩm vào danh sách\n" +
                "2. Chỉnh sửa sản phẩm trong danh sách\n" +
                "3. Xóa sản phẩm trong danh sách theo ID\n" +
                "4. In danh sách sản phẩm\n" +
                "5. Tìm kiếm sản phẩm theo ID\n" +
                "6. Sắp xếp danh sách theo giá tăng dần\n" +
                "7. Sắp xếp danh sách theo giá giảm dần\n" +
                "0. Thoát chương trình ");
        System.out.println("******************************************************************************");
    }

    public static void getMenuEditProduct() {
        System.out.println("****************************** CHỌC MỤC CẦN CHỈNH ******************************");
        System.out.println("1. Chỉnh ID sản phẩm\n" +
                "2. Chỉnh tên sản phẩm\n" +
                "3. Chỉnh lại số lượng\n" +
                "4. Chỉnh giá bán\n" +
                "0. Thoát chương trình ");
        System.out.println("******************************************************************************");

    }
}
