package com.cyx.spring._12_imitate_register.dao.impl;

import com.cyx.spring._12_imitate_register.dao.UserDAO;
import com.cyx.spring._12_imitate_register.domain.User;
import lombok.Cleanup;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDAOImpl implements UserDAO {

    @Setter
    private DataSource dataSource;

    @SneakyThrows
    @Override
    public void insertUser(User user) {
        @Cleanup
        Connection connection = dataSource.getConnection();
        @Cleanup
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (account, password) VALUE (?, ?)");
        preparedStatement.setString(1, user.getAccount());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();
    }
}
