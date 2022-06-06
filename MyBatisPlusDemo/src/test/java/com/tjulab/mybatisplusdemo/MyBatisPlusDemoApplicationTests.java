package com.tjulab.mybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjulab.mybatisplusdemo.entity.User;
import com.tjulab.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
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
        user.setName("Shishi");
        user.setAge(24);
        user.setEmail("Shishi@163.com");
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);

        // 自动填充
        // create_time
        // update_time
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

    // 测试乐观锁
    @Test
    void testOptimisticLocker(){
        // 根据id查询数据
        User user = userMapper.selectById(1533626740629377026L);

        // 修改
        user.setAge(120);
        userMapper.updateById(user);
    }

    // 多个id的批量查询
    @Test
    public void testSelectBatchIds(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 分页查询
    @Test
    public void testPage(){
        // 1. 创建page对象
        //    传入两个参数：当前页 和 每页显示记录数
        Page<User> page = new Page<>(1, 3);

        // 2. 调用MyBatisPlus分页查询的方法
        //    调用MyBatisPlus分页查询的过程中，底层把分页的所有数据封装到page对象中
        userMapper.selectPage(page, null);

        // 3. 通过page对象获取分页数据
        System.out.println(page.getCurrent()); // 当前页
        System.out.println(page.getRecords()); // 每页数据list集合
        System.out.println(page.getSize()); // 每页显示记录数
        System.out.println(page.getTotal()); // 总记录数
        System.out.println(page.getPages()); // 总页数

        System.out.println(page.hasNext()); // 是否有下一页
        System.out.println(page.hasPrevious()); // 是否有上一页


    }
}
