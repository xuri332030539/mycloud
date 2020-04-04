package com.xuri.springcloud.controller;

import com.xuri.springcloud.entities.CommonResult;
import com.xuri.springcloud.entities.Payment;
import com.xuri.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xuri
 * @date 2020-04-01 14:53
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;


    @PostMapping("/consumer/payment/get")
    public CommonResult<Payment> getPaymentById(Long id){
        System.out.println("调用Feign");
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //客户端默认等待1秒钟
        return paymentFeignService.paymentFeignTimeOut();
    }
}
