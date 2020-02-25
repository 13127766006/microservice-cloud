package com.wangweichao.springcloud.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangweichao.springcloud.entities.Product;
import com.wangweichao.springcloud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    //当get方法出现异常时，则会调用hystrixGet方法处理
    @HystrixCommand(fallbackMethod = "getFallback")
    @GetMapping(value = "/product/get/{id}")
   public Product findById(@PathVariable("id") Long pid){
        Product product = productService.findById(pid);
        if(product == null) {
            throw new RuntimeException("ID=" + pid + "无效");
        }
        return product;
    }
    //当get方法出现异常时，则会调用此方法. 注意此方法的返回值，参数列表与原方法一致
    public Product getFallback(@PathVariable("id") Long id) {
        return new Product(id, "ID=" + id + "无效--@HystrixCommand", "无有效数据库");
    }
    @GetMapping("/product/list")
    List<Product> findAll(){
        return productService.findAll();
    }
    @RequestMapping(value = "/product/add")//,method = RequestMethod.POST RequestMapping ,@RequestBody String productName
    boolean addProduct(@RequestBody(required = false) Product product){

        System.out.println();
        return productService.addProduct(product);
    }
}
