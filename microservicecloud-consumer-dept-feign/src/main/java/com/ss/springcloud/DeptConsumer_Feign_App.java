package com.ss.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
// 在启动时该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
public class DeptConsumer_Feign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign_App.class,args);
    }
}