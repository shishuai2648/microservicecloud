package com.ss.springcloud.service;

import com.ss.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("MICROSERVICECLOUD-DEPT")
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id")Long id);

    @GetMapping("/dept/list")
    List<Dept> list();

    @PostMapping("/dept/add")
    boolean add(Dept dept);

}
