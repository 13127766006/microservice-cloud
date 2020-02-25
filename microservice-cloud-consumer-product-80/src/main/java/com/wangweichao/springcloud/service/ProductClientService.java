package com.wangweichao.springcloud.service;

import com.wangweichao.springcloud.entities.Product;
import com.wangweichao.springcloud.service.ipml.ProductClientServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
@FeignClient(value = "microservice-product", fallback = ProductClientServiceFallBack.class)
public interface ProductClientService {
    @RequestMapping(value = "/product/get/{id}",method = RequestMethod.GET)
    Product get(@PathVariable("id") Long id);
    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    List<Product> list();
    @RequestMapping(value = "/product/add",method = RequestMethod.POST)
    boolean add(@RequestBody Product product);
}