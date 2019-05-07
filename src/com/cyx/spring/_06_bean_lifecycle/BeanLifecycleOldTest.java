package com.cyx.spring._06_bean_lifecycle;

import lombok.Cleanup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleOldTest {

    @Test
    @DisplayName("使用 JUnit5")
    void testBeanLifecycle() {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/cyx/spring/_06_bean_lifecycle/BeanLifecycleTest-context.xml");
        EBean eBean = context.getBean("eBean", EBean.class);
        eBean.doWork();
    }


    @Test
    @DisplayName("方式一：手动执行释放资源方法")
    void testBeanLifecycleByManually() {
        // 因为 ApplicationContext 接口中没有 close() 方法，所以要使用 ClassPathXmlApplicationContext 类。
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/cyx/spring/_06_bean_lifecycle/BeanLifecycleTest-context.xml");
        EBean eBean = context.getBean("eBean", EBean.class);
        eBean.doWork();
        // 手动调用扫尾方法
        context.close();
    }

    @Test
    @DisplayName("方式二：使用 Lombok 的 @Cleanup 注解")
    void testBeanLifecycleByLombok() {
        @Cleanup
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/cyx/spring/_06_bean_lifecycle/BeanLifecycleTest-context.xml");
        EBean eBean = context.getBean("eBean", EBean.class);
        eBean.doWork();
    }

    @Test
    @DisplayName("方式三：把 Spring 线程作为 JVM 的子线程（最好的方式）")
    void testBeanLifecycleByHook() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/cyx/spring/_06_bean_lifecycle/BeanLifecycleTest-context.xml");
        EBean eBean = context.getBean("eBean", EBean.class);
        eBean.doWork();
        context.registerShutdownHook();
}

}
