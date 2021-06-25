package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        create("Some product 1", 123);
        create("Some product 2", 123);
        create("Some product 3", 123);
    }

    public boolean add(Product product) {
        return productList.add(product);
    }

    public boolean delete(String uuid) {
        Product product = Product.builder()
                .uuid(UUID.fromString(uuid))
                .build();
        //Product product = productList.stream().filter((Product item) -> item.getId() == id).findFirst().orElse(null);

        return productList.remove(product);
    }

    public List<Product> getAll() {
        return productList;
    }

    public Product getOne(String uuid) {
        Product product = Product.builder()
                .uuid(UUID.fromString(uuid))
                .build();
        int index = productList.indexOf(product);
        return index != -1 ? productList.get(index) : null;
    }

    public Product create(String title, int cost) {
        Product product = Product.builder()
                .uuid(UUID.randomUUID())
                .title(title)
                .cost(cost)
                .build();

        return productList.add(product) ? product : null;
    }

    public Product update(String uuid, String title, int cost) {
        Product product = Product.builder()
                .uuid(UUID.fromString(uuid))
                .build();
        int index = productList.indexOf(product);
        if (index == -1) {
            return null;
        }
        product = productList.get(index);
        product.setTitle(title);
        product.setCost(cost);
        return product;
    }

    public int size() {
        return productList.size();
    }

    public double avgCost() {
        int cost = productList.stream().mapToInt(Product::getCost).sum();
        return cost / (double) productList.size();
    }


}
