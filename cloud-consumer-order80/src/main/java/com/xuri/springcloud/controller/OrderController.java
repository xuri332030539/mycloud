package com.xuri.springcloud.controller;

import com.xuri.springcloud.entities.CommonResult;
import com.xuri.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xuri
 * @date 2020/3/19 10:08 上午
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;


    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        System.out.println("调用消费者create接口");
        System.out.println();
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
        //getForEntity其中包括响应头，响应体，状态码
//       return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment,CommonResult.class).getBody();
    }

    @PostMapping("/consumer/payment/get")
    public CommonResult<Payment> getPaymentById(long id) {
        System.out.println("调用消费者get接口");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @PostMapping("test")
    public void test(){
        System.out.println("测试成功");
    }


}



