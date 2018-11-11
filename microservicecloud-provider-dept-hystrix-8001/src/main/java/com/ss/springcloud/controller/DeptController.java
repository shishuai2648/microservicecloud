package com.ss.springcloud.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.ss.springcloud.entities.Dept;
import com.ss.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

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
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.getById(id);
        if(dept == null){
            throw new RuntimeException("该ID："+id+"没有对应信息");
        }
        return dept;
    }


    public Dept processHystrix_Get(@PathVariable("id")Long id){
        System.out.println("异常时处理异常被调用");
        Dept dept = new Dept();
        dept.setDeptno(id);
        dept.setDname("该ID："+id+"没有对应信息");
        dept.setDbSource("no this database in MySql");
        return dept;
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
