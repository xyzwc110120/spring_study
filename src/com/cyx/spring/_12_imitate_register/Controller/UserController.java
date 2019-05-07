package com.cyx.spring._12_imitate_register.Controller;

import com.cyx.spring._12_imitate_register.domain.User;
import com.cyx.spring._12_imitate_register.service.UserService;
import lombok.Setter;

// 模拟 SpringMVC 的 Controller
public class UserController {

    @Setter
    private UserService userService;

    public void register() {
        User user = new User("小叮铛铛响", "321321");
        userService.register(user);
    }

}
