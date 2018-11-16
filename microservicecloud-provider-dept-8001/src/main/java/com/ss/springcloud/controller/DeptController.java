package com.ss.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.ss.springcloud.entities.Dept;
import com.ss.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;
    @Autowired
    private DiscoveryClient client;


    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.getById(id);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list(new QueryWrapper<>());
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("*****" + list);
        List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : instances){
            System.out.println(
                    element.getServiceId()
                            +"\t"+ element.getHost()
                            +"\t"+element.getPort()
                            +"\t"+element.getUri()
            );
        }
        return this.client;
    }

}
