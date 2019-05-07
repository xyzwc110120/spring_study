package com.cyx.spring._12_imitate_register.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {

    private Long id;
    private String account;
    private String password;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
