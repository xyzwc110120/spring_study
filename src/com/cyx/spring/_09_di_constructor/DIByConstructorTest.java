package com.cyx.spring._09_di_constructor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class DIByConstructorTest {

    @Autowired
    private HBeanValue beanValue;

    @Autowired
    private HBeanRef beanRef;

    @Autowired
    private HBeanCollection beanCollection;

    @Test
    @DisplayName("通过构造器注入来实现依赖注入")
    void testDIByConstructor() {
        // 构造器注入：常量类型
        System.out.println(beanValue);

        // 构造器注入：对象类型
        System.out.println(beanRef);

        // 构造器注入：集合类型
        System.out.println(beanCollection);
    }

}
