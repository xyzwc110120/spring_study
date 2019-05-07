package com.cyx.spring._07_di_xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class DIByXMLTest {

    @Autowired
    private FBean fBean;

    @Test
    @DisplayName("使用 XML 配置实现自动注入")
    void testDIUseByName() {
        System.out.println(fBean);
    }

}
