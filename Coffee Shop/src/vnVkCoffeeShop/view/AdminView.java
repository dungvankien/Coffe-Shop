package vnVkCoffeeShop.view;

import vnVkCoffeeShop.menu.Menu;

import java.util.Scanner;

public class AdminView {
    public void workOfAdmin(){
        Scanner input=new Scanner(System.in);
        String choice;
        do{
            Menu.getMenuAdmin();
            System.out.println("Nhập số theo chức năng cần thực hiện:");
            choice=input.nextLine();
            switch (choice){
                case "1":
                    ProductView productView=new ProductView();
                    productView.workOfProduct();
                    break;
                case "2":
                    UserView userView=new UserView();
                    userView.workOfUser();
                    break;
                case "3":
                    OrderView orderView=new OrderView();
                      orderView.workOFOrder();
                    break;
                case "0":
                    Menu.getMenuYesNo();
                    break;
                default:
                    System.out.println("Vui lòng chọn đúng chức năng");
                    Menu.getMenuYesNo();
            }

        }while (!choice.equals("0"));
    }

}
