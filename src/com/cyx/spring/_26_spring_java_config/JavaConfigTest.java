package com.cyx.spring._26_spring_java_config;

import com.cyx.spring._26_spring_java_config.service.TransferService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

// 寻找配置类
@SpringJUnitConfig(classes = ApplicationConfig.class)
public class JavaConfigTest {

    @Autowired
    private TransferService transferService;

    @Test
    @DisplayName("使用 Java 代码配置的方式配置 Spring 框架")
    void testJavaConfig() {
        transferService.transfer(11L, 9L, 50);
    }
}
