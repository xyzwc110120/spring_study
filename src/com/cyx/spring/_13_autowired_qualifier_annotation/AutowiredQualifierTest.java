package com.cyx.spring._13_autowired_qualifier_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class AutowiredQualifierTest {

    @Autowired
    private JBean jBean;

    @Test
    @DisplayName("使用 @Autowired 注解自动注入")
    void testAutowired() {
        System.out.println(jBean);
    }

}
