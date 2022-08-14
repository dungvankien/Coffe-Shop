package vnVkCoffeeShop.model;

import java.util.Objects;

public class Product {
    private String idProduct;
    private String nameProduct;
    private Integer quantity;
    private Double price;

    public Product() {
    }

    public Product(String idProduct) {
        this.idProduct = idProduct;
    }

    public Product(String idProduct, String nameProduct, Integer quantity, Double price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public static Product parseProduct(String record) {
        String[] arrayProduct = record.split(",");
        String idProduct = arrayProduct[0];
        String nameProduct = arrayProduct[1];
        Integer quantity = Integer.parseInt(arrayProduct[2]);
        Double price = Double.parseDouble(arrayProduct[3]);
        return new Product(idProduct, nameProduct, quantity, price);
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return idProduct + "," + nameProduct + "," + quantity + "," + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct.equals(product.idProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct);
    }
}
