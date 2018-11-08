package com.ss.springcloud.controller;

import com.ss.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

    private static final String RSET_URL_PREFIX="http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(RSET_URL_PREFIX + "/dept/add",dept,Boolean.class);
    }
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(RSET_URL_PREFIX + "/dept/get/"+id,Dept.class);
    }
    @GetMapping("/list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(RSET_URL_PREFIX + "/dept/list",List.class);
    }

    @GetMapping("/dept/dosconvery")
    public Object discovery(){
        return restTemplate.getForObject(RSET_URL_PREFIX + "/dept/discovery",Object.class);
    }
}
