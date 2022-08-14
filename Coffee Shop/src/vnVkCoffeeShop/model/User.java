package vnVkCoffeeShop.model;

import java.util.Objects;

public class User {
    private String idEmployee;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String address;
    private Role role;
    private String username;
    private String password;

    public User() {
    }

    public User(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String idEmployee, String fullName, String phoneNumber,
                String email, String address, Role role, String username, String password) {
        this.idEmployee = idEmployee;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public static User parseUser(String record) {
        User user = new User();
        String[] arrayUser = record.split(",");
        user.idEmployee = arrayUser[0];
        user.fullName = arrayUser[1];
        user.phoneNumber = arrayUser[2];
        user.email = arrayUser[3];
        user.address = arrayUser[4];
        user.role = Role.parseRole(arrayUser[5]);
        user.username = arrayUser[6];
        user.password = arrayUser[7];
        return user;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return idEmployee + "," + fullName + "," + phoneNumber + "," + email + "," +
                address + "," + role + "," + username + "," + password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idEmployee, user.idEmployee) && Objects.equals(fullName,
                user.fullName) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email)
                && Objects.equals(address, user.address) && role == user.role && Objects.equals(username, user.username)
                && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, fullName, phoneNumber, email, address, role, username, password);
    }
}
