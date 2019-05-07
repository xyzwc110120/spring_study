package com.cyx.spring._03_container;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ContainerTest {

    /*
        注意：这里不使用 Spring test 框架是因为 Spring test 框架使用的 ApplicationContext。
    */

    @Test
    @DisplayName("使用 BeanFactory 获取 bean 对象，并查看 bean 对象的创建时机")
    void testBeanFactory() {
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        System.out.println("--------------------------");
        BBean bBean = factory.getBean("bBean", BBean.class);
        bBean.doWork();
    }

    @Test
    @DisplayName("使用 ApplicationContext 获取 bean 对象，并查看 bean 对象的创建时机")
    void testApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("--------------------------");
        BBean bBean = context.getBean("bBean", BBean.class);
        bBean.doWork();
    }

}
