package com.ss.springcloud.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ss.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeptDao extends BaseMapper<Dept> {

    void addDept(@Param("dept") Dept dept);
}
