package com.xuri.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xuri
 * @date 2020-04-03 15:18
 */
@Component
public class PaymentFallbackService implements  PaymentHystrixService{
    //实现了接口，80接口中出错会到这里

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_OK,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_TimeOut,o(╥﹏╥)o";
    }
}