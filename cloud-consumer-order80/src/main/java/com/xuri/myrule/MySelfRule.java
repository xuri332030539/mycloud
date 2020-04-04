package com.xuri.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuri
 * @date 2020-03-31 15:44
 */
@Configuration
@EnableEurekaClient
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义随机
    }
}
