package com.cyx.spring._03_container;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:applicationContext.xml")
public class LazyInitTest {

    // @Autowired 注解除了能注入 Spring 容器中的 bean 之外，还可以注入容器对象。
    @Autowired
    private BeanFactory factory;
    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("ApplicationContext 实现延迟初始化")
    void testLazyInit() {
        System.out.println("------------------");
        BBean bBean = factory.getBean("bBean", BBean.class);
        bBean.doWork();
    }

}
