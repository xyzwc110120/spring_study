package com.cyx.spring._08_di_setter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class DIBySetterTest {

    @Autowired
    private GBeanValue beanValue;

    @Autowired
    private GBeanRef beanRef;

    @Autowired
    private GBeanCollection beanCollection;

    @Test
    @DisplayName("通过属性注入来实现依赖注入")
    void testDIBySetter() {
        // 属性注入：常量类型
        System.out.println(beanValue);

        // 属性注入：对象类型
        System.out.println(beanRef);

        // 属性注入：集合类型
        System.out.println(beanCollection);
    }

}
