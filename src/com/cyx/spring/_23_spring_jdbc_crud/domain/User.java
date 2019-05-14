package com.cyx.spring._23_spring_jdbc_crud.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {

    private Long id;
    private String account;
    private String password;

    public User() { }

    public User(Long id, String account, String password) {
        this.id = id;
        this.account = account;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
