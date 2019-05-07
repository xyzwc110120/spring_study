package com.cyx.spring._14_value_annotation;

import org.springframework.beans.factory.annotation.Value;

public class PropertiesBean {

    // 使用 @Value 注解及属性占位符获取配置文件中的值并注入到字段
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${test.username}")
    private String testUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;
    @Value("${test.password}")
    private String testPassword;

    @Override
    public String toString() {
        return "PropertiesBean{" +
                "jdbcUsername='" + jdbcUsername + '\'' +
                ", testUsername='" + testUsername + '\'' +
                ", jdbcPassword='" + jdbcPassword + '\'' +
                ", testPassword='" + testPassword + '\'' +
                '}';
    }
}
