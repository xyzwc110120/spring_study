package com.cyx.spring._12_imitate_register;

import com.cyx.spring._12_imitate_register.Controller.UserController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ImitateRegisterTest {

    @Autowired
    private UserController userController;

    @Test
    @DisplayName("使用 Spring IoC 和 DI 模拟注册")
    void testImitateRegister() {
        userController.register();
    }

}
