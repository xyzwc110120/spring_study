package com.cyx.spring._11_dbcp_property_placeholder;

import lombok.Cleanup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringJUnitConfig
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Test
    @DisplayName("使用 Spring 创建数据库连接池对象")
    void testDataSource() throws SQLException {
        /*
            自己手动创建德鲁伊连接池对象：
                DruidDataSource dataSource = new DruidDataSource();
                dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                dataSource.setUrl("jdbc:mysql://localhost:3306/demo?serverTimezone=UTC");
                dataSource.setUsername("root");
                dataSource.setPassword("admin");
                dataSource.setInitialSize(2);
        */

        @Cleanup
        Connection connection = dataSource.getConnection();
        @Cleanup
        PreparedStatement statement = connection.prepareStatement("SELECT id, `name`, age FROM student");
        @Cleanup
        ResultSet set = statement.executeQuery();

        while (set.next()) {
            System.out.print(set.getLong("id") + ", ");
            System.out.print(set.getString("name") + ", ");
            System.out.print(set.getInt("age"));
            System.out.println();
        }
    }

}
