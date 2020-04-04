package com.xuri.springcloud;

import com.xuri.springcloud.entities.CommonResult;
import com.xuri.springcloud.entities.Payment;
import com.xuri.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        long id = payment.getId();
        log.info("插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,端口号:"+serverPort,id);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果:" + paymentById);
        if (paymentById != null) {
            return new CommonResult(200, "查询成功,端口号:"+serverPort, paymentById);
        } else {
            return new CommonResult(444, "没有对应记录，查询id:" + id, null);
        }
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
