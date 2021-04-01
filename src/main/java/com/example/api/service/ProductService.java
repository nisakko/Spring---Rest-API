package com.example.api.service;

import com.example.api.models.Product;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface ProductService {

    List<Product> findAllProduct();
    Product findById(String product_id);
    Product insert(Product p);
    boolean delete(String product_id);
    boolean update(Product p);
}
