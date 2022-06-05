package com.tjulab.mybatisplusdemo;

import com.tjulab.mybatisplusdemo.entity.User;
import com.tjulab.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MyBatisPlusDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    // 查询user表中的所有数据
    @Test
    void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Test
    void addUser(){
        User user = new User();
        user.setName("Lilei");
        user.setAge(30);
        user.setEmail("Lilei@163.com");
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);

        // 自动填充

    }

    // 修改操作
    @Test
    void updateUser(){
        User user = new User();
        user.setId(1533423645521641473L);
        user.setAge(120);

        int row = userMapper.updateById(user);
        System.out.println(row);

    }

}
