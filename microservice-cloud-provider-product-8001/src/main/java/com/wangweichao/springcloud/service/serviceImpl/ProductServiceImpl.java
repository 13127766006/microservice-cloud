package com.wangweichao.springcloud.service.serviceImpl;

import com.wangweichao.springcloud.entities.Product;
import com.wangweichao.springcloud.mapper.ProductMapper;
import com.wangweichao.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public Product findById(Long pid) {
        return productMapper.findById(pid);
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }

    @Override
    public boolean addProduct(Product product) {
        return productMapper.addProduct(product);
    }
}
