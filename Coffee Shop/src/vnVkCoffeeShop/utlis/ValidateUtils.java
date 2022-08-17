package vnVkCoffeeShop.utlis;

import java.util.regex.Pattern;

public class ValidateUtils {
    public static final String PASSWORD_REGEX = "^[A-Za-z0-9@&]{8,}$";
    public static final String USERNAME_REGEX = "^[a-z][a-z0-9_]{3,12}$";
    public static final String PHONE_REGEX = "^[0][1-9]\\d{8}$";
    public static final String EMAIL_REGRX = "^[a-z]+[a-z0-9]*@[a-z]+\\.[a-z]{2,3}$";

    public static boolean isPasswordVaild(String password) {
        return Pattern.compile(PASSWORD_REGEX).matcher(password).matches();
    }

    public static boolean isUserNameVaild(String userName) {
        return Pattern.compile(USERNAME_REGEX).matcher(userName).matches();
    }

    public static boolean isPhoneVaild(String phone) {
        return Pattern.compile(PHONE_REGEX).matcher(phone).matches();
    }

    public static boolean isEmailVaild(String email) {
        return Pattern.compile(EMAIL_REGRX).matcher(email).matches();
    }
}
