package com.cyx.spring._13_autowired_qualifier_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class JBean {

    // @Autowired 与 @Qualifier 注解组合，通过“类型 + bean 元素 id 属性值”组合的方式寻找 bean 对象并注入
    // （一般使用 @Autowired 注解就可以了）
    @Autowired
    @Qualifier("beanDependency")
    private JBeanDependency jBeanDependency;

    @Override
    public String toString() {
        return "JBean{" +
                "jBeanDependency=" + jBeanDependency +
                '}';
    }
}
