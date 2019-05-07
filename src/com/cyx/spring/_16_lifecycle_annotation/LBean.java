package com.cyx.spring._16_lifecycle_annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
    XML 配置：
        <bean id="lBean" class="com.cyx.spring._16_lifecycle_annotation.LBean"
              scope="singleton" init-method="init" destroy-method="close" />
*/
@Component
// @Scope 注解：设置 bean 的作用域（ConfigurableBeanFactory 类中有常量参数可供使用）
@Scope("singleton")
public class LBean {

    private LBean() {
        System.out.println("实例化 LBean···");
    }

    public void doWork() {
        System.out.println("开始工作···");
    }

    // @PostConstruct 注解：构建对象之后，用于贴在初始化方法上
    @PostConstruct
    public void init() {
        System.out.println("初始化方法···");
    }

    // @PreDestroy 注解：销毁之前，用于贴在销毁方法上
    @PreDestroy
    public void close() {
        System.out.println("释放资源···");
    }

}
