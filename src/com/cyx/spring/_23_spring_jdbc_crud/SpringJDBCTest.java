package com.cyx.spring._23_spring_jdbc_crud;

import com.cyx.spring._23_spring_jdbc_crud.domain.User;
import com.cyx.spring._23_spring_jdbc_crud.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
public class SpringJDBCTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("使用 Spring JDBC 保存用户资料")
    void testSaveUser() {
        userService.saveUser(new User(null, "秃噜", "1433223"));
    }

    @Test
    @DisplayName("使用 Spring JDBC 修改用户资料")
    void testUpdateUser() {
        userService.updateUser(new User(8L, "猪肉炖粉条", "145541"));
    }

    @Test
    @DisplayName("使用 Spring JDBC 删除用户资料")
    void testDeleteUser() {
        userService.deleteUser(8L);
    }

    @Test
    @DisplayName("使用 Spring JDBC 获取指定 id 的用户资料")
    void testGetUserById() {
        User user = userService.getUserById(6L);
        System.out.println(user);
    }

    @Test
    @DisplayName("使用 Spring JDBC 获取所有用户资料")
    void testGetUserList() {
        List<User> list = userService.getUserList();
        System.out.println(list);
    }

}
