package com.cyx.spring._05_bean_scopes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class BeanScopesTest {

    @Autowired
    private DBean1 dBean1_1;
    @Autowired
    private DBean1 dBean1_2;
    @Autowired
    private DBean1 dBean1_3;


    @Autowired
    private DBean2 dBean2_1;
    @Autowired
    private DBean2 dBean2_2;
    @Autowired
    private DBean2 dBean2_3;

    @Test
    @DisplayName("测试 bean 的作用域（单例和多例）")
    void testBeanScopes() {
        // 测试作用域为单例时
        System.out.println(dBean1_1);
        System.out.println(dBean1_2);
        System.out.println(dBean1_3);

        System.out.println("------------------------------------");

        // 测试作用域为多例时
        System.out.println(dBean2_1);
        System.out.println(dBean2_2);
        System.out.println(dBean2_3);
    }

}
