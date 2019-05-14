package com.cyx.spring._26_spring_java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration                                          // 标注当前类为配置类
@Import(DataSourceConfig.class)                         // 引入其他配置类，另一个注解 @ImportResource：引入其他配置文件
@ComponentScan("com.cyx.spring._26_spring_java_config") // IoC 注解解析器
@EnableTransactionManagement                            // 事务注解解析器
public class ApplicationConfig {

    // 创建事务管理器 bean，并注入数据库连接池 bean
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
