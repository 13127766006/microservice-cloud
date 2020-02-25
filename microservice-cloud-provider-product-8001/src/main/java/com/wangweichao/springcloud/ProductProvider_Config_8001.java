package com.wangweichao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix //开启 Hystrix 熔断机制的支持
@EnableEurekaClient
@SpringBootApplication
public class ProductProvider_Config_8001 {
    public static void main(String[] args) {
        SpringApplication.run(ProductProvider_Config_8001.class,args);
    }
}
