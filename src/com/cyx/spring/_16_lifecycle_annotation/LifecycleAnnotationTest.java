package com.cyx.spring._16_lifecycle_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class LifecycleAnnotationTest {

    @Autowired
    private LBean lBean1;
    @Autowired
    private LBean lBean2;

    @Test
    @DisplayName("使用注解来设置 bean 的作用域及初始化和销毁方法")
    void testLifecycleAnnotation() {
        lBean1.doWork();
        lBean2.doWork();
    }

}
