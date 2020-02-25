package com.wangweichao.springcloud.service;


import com.wangweichao.springcloud.entities.Product;

import java.util.List;

public interface ProductService {
    Product findById(Long pid);
    List<Product> findAll();
    boolean addProduct(Product product);
}
