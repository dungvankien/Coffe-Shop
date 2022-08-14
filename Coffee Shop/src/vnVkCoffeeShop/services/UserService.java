package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Role;
import vnVkCoffeeShop.model.User;
import vnVkCoffeeShop.utlis.DataConvertUtlis;
import vnVkCoffeeShop.utlis.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public final static String PATH = "data/user.csv";
    private static UserService instance;

    public UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public List<User> listUser() {
        List<User> users = new ArrayList<>();
        List<String> records = DataConvertUtlis.read(PATH);
        for (String record : records) {
            users.add(User.parseUser(record));
        }
        return users;
    }

    public boolean checkUserName(String userName) {
        if (ValidateUtils.isUserNameVaild(userName)) {
            List<User> users = listUser();
            for (User item : users) {
                if ((item.getUsername()).equals(userName)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean checkPassword(String password) {
        if (ValidateUtils.isPasswordVaild(password)) {
            List<User> users = listUser();
            for (User item : users) {
                if ((item.getPassword()).equals(password)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }
    public Role checkRole(String userName){
        List<User> users = listUser();
        for(User item: users){
            if(item.getUsername().equals(userName)){
                return item.getRole();
            }
        }
        return null;
    }

    public void add(User user) {
        List<User> users = listUser();
        users.add(user);
        DataConvertUtlis.write(PATH, users);
    }

    public void edit(User user, int number, String parameters) {
        List<User> users = listUser();
        for (User item : users) {
            if (item.equals(user)) {
                switch (number) {
                    case 1:
                        item.setIdEmployee(parameters);
                        break;
                    case 2:
                        item.setFullName(parameters);
                        break;
                    case 3:
                        item.setPhoneNumber(parameters);
                        break;
                    case 4:
                        item.setEmail(parameters);
                        break;
                    case 5:
                        item.setRole(Role.parseRole(parameters));
                    default:
                        System.out.println("Error");
                        break;
                }
                DataConvertUtlis.write(PATH, users);
                break;
            }
        }
    }

    public User remove(User user) {
        List<User> users = listUser();
        users.remove(user);
        DataConvertUtlis.write(PATH, users);
        return user;
    }

    public boolean find(User user) {
        List<User> users = listUser();
        return users.contains(user);
    }

    public void print() {
        List<User> users = listUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void printItemProduc(User user) {
        List<User> users = listUser();
        for (User item : users) {
            if (item.equals(user)) {
                System.out.println(item);
                break;
            }
        }
    }

    public void clear() {
        List<User> users = listUser();
        users.clear();
        DataConvertUtlis.write(PATH, users);
    }
}
