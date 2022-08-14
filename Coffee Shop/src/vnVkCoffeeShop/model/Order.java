package vnVkCoffeeShop.model;

import java.util.Objects;

public class Order {
    private long idOrder;
    private String idProduct;
    private String nameProduct;
    private int quantity;
    private double price;
    private double total;
    private String date;

    public Order(long idOrder) {
        this.idOrder = idOrder;
    }

    public Order(long idOrder, String idProduct, String nameProduct,
                 int quantity, double price, String date) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    public static Order parseOrder(String record) {
        String[] arrayOrder = record.split(",");
        Long idOrder = Long.parseLong(arrayOrder[0]);
        String idProduct = arrayOrder[1];
        String nameProduct = arrayOrder[2];
        Integer quantity = Integer.parseInt(arrayOrder[3]);
        Double price = Double.parseDouble(arrayOrder[4]);
        String date = arrayOrder[5];
        return new Order(idOrder, idProduct, nameProduct, quantity, price, date);
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return idOrder + "," + idProduct + "," + nameProduct + "," + quantity + "," + price + "," + date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder);
    }
}
