package com.cyx.spring._23_spring_jdbc_crud.service;

import com.cyx.spring._23_spring_jdbc_crud.domain.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getUserList();

}
