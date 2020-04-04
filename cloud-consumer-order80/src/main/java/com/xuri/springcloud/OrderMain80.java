package com.xuri.springcloud;

import com.xuri.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author xuri
 * @Date 2020/3/18 16:56
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//不使用默认轮询，换成自定义配置
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
            SpringApplication.run(OrderMain80.class, args);
        }
}
