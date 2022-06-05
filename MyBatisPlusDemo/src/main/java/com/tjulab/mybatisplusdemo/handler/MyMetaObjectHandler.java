package com.tjulab.mybatisplusdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 使用MyBatisPlus实现添加操作，该方法就会执行
    @Override
    public void insertFill(MetaObject metaObject){
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    // 使用MyBatisPlus实现修改操作，该方法就会执行
    @Override
    public void updateFill(MetaObject metaObject){
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}