package com.cyx.spring._04_bean_instantiation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*
    @SpringJUnitConfig 注解中本上就包含无参数的 @ContextConfiguration 注解，
    所以它会找到同目录的 BeanInstantiationTest-context.xml 配置文件。
*/
@SpringJUnitConfig
public class BeanInstantiationTest {

    @Test
    @DisplayName("原始的方式创建 Bean 对象")
    void testCreateBeanByOld() {
        // 方式一：构造器
        CBean1 bean1 = new CBean1();

        // 方式二：静态工厂方法
        CBean2 bean2 = CBean2Factory.createInstance();

        // 方式三：实力工厂方法
        CBean3 bean3 = new CBean3Factory().createInstance();
    }



    @Autowired
    private CBean1 cBean1;
    @Autowired
    private CBean2 cBean2;
    @Autowired
    private CBean3 cBean3;
    @Autowired
    private CBean4 cBean4;
    @Autowired
    private CBean4 cBean4_1;

    @Test
    @DisplayName("使用 Spring 创建 Bean 对象")
    void testCreateBeanBySpring() {
        System.out.println(cBean1);
        System.out.println(cBean2);
        System.out.println(cBean3);
        /* cBean4 与 cBean4_1 是相同对象，这是因为 Spring 容器创建的 bean 默认为单例模式 */
        System.out.println(cBean4);
        System.out.println(cBean4_1);
    }
}
