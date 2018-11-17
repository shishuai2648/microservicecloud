package com.ss.springcloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ss.springcloud.entities.Dept;

public interface DeptService extends IService<Dept> {

    boolean add(Dept dept);
}
