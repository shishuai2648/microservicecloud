package com.ss.myrule;


import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule RandomRule(){
        return new RandomRule_Self();
    }
}
