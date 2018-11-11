package com.ss.springcloud.service;

import com.ss.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                Dept dept = new Dept();
                dept.setDeptno(id);
                dept.setDname("该ID："+id+"没有对应信息，Comsumer客户端提供的降级信息，此时服务Provider已经关闭");
                dept.setDbSource("no this database in MySql");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
