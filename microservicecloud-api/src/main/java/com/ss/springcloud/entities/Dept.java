package com.ss.springcloud.entities;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("dept")
public class Dept implements Serializable {

    @TableId
    private Long deptno; // 主键

    private String dname; // 部门名称

    private String dbSource; // 来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库

}
