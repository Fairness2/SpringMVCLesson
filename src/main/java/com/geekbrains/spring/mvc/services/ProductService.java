package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public Product getOne(String uuid) {
        return repository.getOne(uuid);
    }

    public Product add(String title, int cost) {
        return repository.create(title, cost);
    }

    public Product update(String uuid, String title, int cost) {
        return repository.update(uuid, title, cost);
    }

    public boolean update(String uuid) {
        return repository.delete(uuid);
    }
}
