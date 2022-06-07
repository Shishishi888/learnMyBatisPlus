package com.tjulab.mybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    void findAll() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    @Test
    void addUser(){
        User user = new User();
        user.setName("Shishishi");
        user.setAge(24);
        user.setEmail("Shishishi@163.com");
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

    // 删除操作：物理删除
    @Test
    void testDeleteById(){
        int result = userMapper.deleteById(1533995206691545089L);
        System.out.println(result);
    }

    // 删除操作：批量删除
    @Test
    void testDeleteBatchIds(){
        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    // 删除操作：条件删除
    @Test
    void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Tom");
        map.put("age", 28);
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    // 删除操作：逻辑删除


    // MyBatisPlus 实现复杂查询操作
    @Test
    void testSelectQuery(){
        // 创建QuerryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // 1. ge gt le lt >= > <= <

        // 查询 age >= 30 的记录
//        wrapper.ge("age", 30);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 2. eq ne == != <>

        // 查询 name == "LiLei" 的记录
//        wrapper.eq("name", "Lilei");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 查询 name != "LiLei" 的记录
//        wrapper.ne("name", "Lilei");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 3. between 范围

        // 查询 age 在 20 到 30 之间的记录
//        wrapper.between("age", 20, 30);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 4. like 模糊查询

        // 查询 name 中带 "shi" 的记录
//        wrapper.like("name", "shi");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 5. orderByAsc orderByDesc 排序

        // 将记录按照 id 进行降序排序
//        wrapper.orderByDesc("id");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 6. last 拼接 sql 语句

        // 在 sql 语句后拼上指定的内容
//        wrapper.last("limit 1");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // 7. select 查询指定的列

        // 查询所有记录的 id 和 name 属性值
        wrapper.select("id", "name");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);
    }

}
