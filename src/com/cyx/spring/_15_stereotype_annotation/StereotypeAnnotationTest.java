package com.cyx.spring._15_stereotype_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class StereotypeAnnotationTest {

    @Autowired
    private KBean kBean;

    @Test
    @DisplayName("使用 IoC 注解来将创建 bean")
    void testStereotypeAnnotation() {
        System.out.println(kBean);
    }

}
