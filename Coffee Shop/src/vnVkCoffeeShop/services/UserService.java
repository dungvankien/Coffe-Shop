package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Role;
import vnVkCoffeeShop.model.User;
import vnVkCoffeeShop.utlis.DataConvertUtlis;
import vnVkCoffeeShop.utlis.ValidateUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService implements InterfaceUser {
    public final static String PATH = "data/user.csv";

    public UserService() {
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

    public Role checkRole(String userName) {
        List<User> users = listUser();
        for (User item : users) {
            if (item.getUsername().equals(userName)) {
                return item.getRole();
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        List<User> users = listUser();
        users.add(user);
        DataConvertUtlis.write(PATH, users);
    }

    @Override
    public void edit(User user, String number, String parameters) {
        List<User> users = listUser();
        for (User item : users) {
            if (item.equals(user)) {
                switch (number) {
                    case "1":
                        item.setRole(Role.parseRole(parameters));
                        break;
                    case "2":
                        item.setPhoneNumber(parameters);
                        break;
                    case "3":
                        item.setUsername(parameters);
                        break;
                    case "4":
                        item.setPassword(parameters);
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                DataConvertUtlis.write(PATH, users);
                break;
            }
        }
    }

    @Override
    public void remove(User user) {
        List<User> users = listUser();
        users.remove(user);
        DataConvertUtlis.write(PATH, users);
    }

    @Override
    public boolean find(User user) {
        List<User> users = listUser();
        return users.contains(user);
    }

    @Override
    public void print() {
        List<User> users = listUser();
        for (User user : users) {
            System.out.printf("%-15s %-15s %-15s %-25s %-25s %-15s %-15s %-15s\n", user.getIdEmployee(),
                    user.getFullName(), user.getPhoneNumber(), user.getEmail(), user.getAddress(),
                    user.getRole(), user.getUsername(), user.getPassword());
        }
    }

    @Override
    public void printItemUser(User user) {
        List<User> users = listUser();
        for (User item : users) {
            if (item.equals(user)) {
                System.out.printf("%-15s %-15s %-15s %-25s %-25s %-15s %-15s %-15s\n", item.getIdEmployee(),
                        item.getFullName(), item.getPhoneNumber(), item.getEmail(), item.getAddress(),
                        item.getRole(), item.getUsername(), item.getPassword());
                break;
            }
        }
    }

    @Override
    public void clear() {
        List<User> users = listUser();
        users.clear();
        DataConvertUtlis.write(PATH, users);
    }
}
