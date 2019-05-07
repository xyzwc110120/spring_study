package com.cyx.spring._10_bean_inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class BeanInheritanceTest {

    @Autowired
    private IBean_1 bean_1;
    @Autowired
    private IBean_2 bean_2;

    @Test
    @DisplayName("bean 元素的集成")
    void testBeanInheritance() {
        System.out.println(bean_1);
        System.out.println(bean_2);
    }
}
