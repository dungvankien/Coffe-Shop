package vnVkCoffeeShop.model;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public static Role parseRole(String value) {
        Role[] values = values();
        for (Role role : values) {
            if (role.value.equals(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("invalid");
    }
}
