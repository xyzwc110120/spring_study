package com.cyx.spring._06_bean_lifecycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class BeanLifecycleTest {

    @Autowired
    private EBean eBean;

    @Test
    @DisplayName("使用 Spring 配置来调用初始化和销毁方法")
    void testBeanLifecycle() {
        eBean.doWork();
    }

}
