package vnVkCoffeeShop.model;

public class Order {
    private String idOrder;
    private String idProduct;
    private String nameProduct;
    private int quantity;
    private double price;
    private double total;
    private String date;

    public Order() {
    }

    public Order(String idOrder, String idProduct, String nameProduct,
                 int quantity, double price, double total, String date) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.date = date;
    }

    public static Order parseOrder(String record) {
        String[] arrayOrder = record.split(",");
        String idOrder = arrayOrder[0];
        String idProduct = arrayOrder[1];
        String nameProduct = arrayOrder[2];
        Integer quantity = Integer.parseInt(arrayOrder[3]);
        Double price = Double.parseDouble(arrayOrder[4]);
        Double total = Double.parseDouble(arrayOrder[5]);
        String date = arrayOrder[6];
        return new Order(idOrder, idProduct, nameProduct, quantity, price, total, date);
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return idOrder + "," + idProduct + "," + nameProduct + "," + quantity + "," + price + "," +
                total + "," + date;
    }
}
