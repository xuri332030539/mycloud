package com.xuri.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

/**
 * @Author xuri
 * @date 2020/3/19 10:24 上午
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //使restTemplate注解赋予负载均衡的能力 不加会出exception is java.net.UnknownHostException错误
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
