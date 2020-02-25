package com.wangweichao.springcloud.controller;
import com.wangweichao.springcloud.entities.Product;
import com.wangweichao.springcloud.service.ProductClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController_Consumer {
    @Autowired
    private ProductClientService service;
    @RequestMapping(value = "/consumer/product/add")
    public boolean add(Product product) {
        return service.add(product);
    }
    @RequestMapping(value = "/consumer/product/get/{id}")
    public Product get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    @RequestMapping(value = "/consumer/product/list")
    public List<Product> list() {
        return service.list();
    }
}