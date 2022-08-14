package vnVkCoffeeShop.services;

import vnVkCoffeeShop.model.Product;
import vnVkCoffeeShop.utlis.DataConvertUtlis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductService implements InterfaceProduct {
    public final static String PATH = "data/products.csv";
    private static ProductService instance;

    public ProductService() {
    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    @Override
    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        List<String> records = DataConvertUtlis.read(PATH);
        for (String record : records) {
            products.add(Product.parseProduct(record));
        }
        return products;
    }

    @Override
    public void add(Product product) {
        List<Product> products = listProducts();
        products.add(product);
        DataConvertUtlis.write(PATH, products);
    }

    public String getName(Product product) {
        List<Product> products = listProducts();
        for (Product item : products) {
            if (item.equals(product)) {
                return item.getNameProduct();
            }
        }
        return null;
    }

    public Integer getQuality(Product product) {
        List<Product> products = listProducts();
        for (Product item : products) {
            if (item.equals(product)) {
                return item.getQuantity();
            }
        }
        return null;
    }

    public void subtractAddition(Product product, int amount) {
        List<Product> products = listProducts();
        for (Product item : products) {
            if (item.equals(product)) {
                item.setQuantity((item.getQuantity() + amount));
                DataConvertUtlis.write(PATH, products);
                return;
            }
        }
    }

    public Double getPrice(Product product) {
        List<Product> products = listProducts();
        for (Product item : products) {
            if (item.equals(product)) {
                return item.getPrice();
            }
        }
        return null;
    }

    @Override
    public boolean find(Product product) {
        List<Product> products = listProducts();
        return products.contains(product);
    }

    @Override
    public Product remove(Product product) {
        List<Product> products = listProducts();
        products.remove(product);
        DataConvertUtlis.write(PATH, products);
        return product;
    }

    @Override
    public void edit(Product product, String number, String parameters) {
        List<Product> products = listProducts();
        for (Product item : products) {
            if (item.equals(product)) {
                switch (number) {
                    case "1":
                        item.setIdProduct(parameters);
                        break;
                    case "2":
                        item.setNameProduct(parameters);
                        break;
                    case "3":
                        item.setQuantity(Integer.parseInt(parameters));
                        break;
                    case "4":
                        item.setPrice(Double.parseDouble(parameters));
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                DataConvertUtlis.write(PATH, products);
                break;
            }
        }
    }

    @Override
    public int size() {
        List<Product> products = listProducts();
        return products.size();
    }

    @Override
    public void clear() {
        List<Product> products = listProducts();
        products.clear();
        DataConvertUtlis.write(PATH, products);
    }

    @Override
    public void print() {
        List<Product> products = listProducts();
        for (Product product : products) {
            System.out.printf("%-15s %-25s %-20s %-15s\n", product.getIdProduct(), product.getNameProduct(),
                    product.getQuantity(), product.getPrice());
        }
    }

    @Override
    public void printItemProduc(Product product) {
        List<Product> products = listProducts();
        for (Product item : products) {
            if (item.equals(product)) {
                System.out.printf("%-15s %-25s %-20s %-15s\n", item.getIdProduct(), item.getNameProduct(),
                        item.getQuantity(), item.getPrice());
                break;
            }
        }
    }

    public void sortDownPrice() {
        List<Product> products = listProducts();
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getPrice() < product2.getPrice()) {
                    return 1;
                } else if (product1.getPrice() > product2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        DataConvertUtlis.write(PATH, products);
    }

    public void sortUpPrice() {
        List<Product> products = listProducts();
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product product1, Product product2) {
                if (product1.getPrice() > product2.getPrice()) {
                    return 1;
                } else if (product1.getPrice() < product2.getPrice()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        DataConvertUtlis.write(PATH, products);
    }
}
