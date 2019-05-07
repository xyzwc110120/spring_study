package com.cyx.spring._02_spring_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

// 运行 Spring 的 JUnit5
@SpringJUnitConfig
// 上下文配置对象（寻找配置文件的）
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTestTest {

    // 表示自动按照类型去 Spring 容器中找到 bean 对象，并注入到该字段
    @Autowired
    private ABean aBean;

    @Test
    @DisplayName("测试 Spring Test 框架")
    void testSpringTest() {
        aBean.doWork();
    }

}