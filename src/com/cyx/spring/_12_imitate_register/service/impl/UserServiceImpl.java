package com.cyx.spring._12_imitate_register.service.impl;

import com.cyx.spring._12_imitate_register.dao.UserDAO;
import com.cyx.spring._12_imitate_register.domain.User;
import com.cyx.spring._12_imitate_register.service.UserService;
import lombok.Setter;

public class UserServiceImpl implements UserService {

    @Setter
    private UserDAO userDAO;

    @Override
    public void register(User user) {
        userDAO.insertUser(user);
    }
}
