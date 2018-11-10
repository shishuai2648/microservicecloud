package com.ss.springcloud.controller;

import com.ss.springcloud.entities.Dept;
import com.ss.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return service.get(id);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return service.list();
    }

    @PostMapping("/consumer/dept/add")
    public Object add(Dept dept){
        return service.add(dept);
    }
}
