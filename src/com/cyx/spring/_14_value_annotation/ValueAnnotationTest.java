package com.cyx.spring._14_value_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class ValueAnnotationTest {

    @Autowired
    private PropertiesBean propertiesBean;

    @Test
    @DisplayName("使用 @Value 注解和属性占位从配置文件中符注入常量类型")
    void testValueAnnotation() {
        System.out.println(propertiesBean);
    }

}
