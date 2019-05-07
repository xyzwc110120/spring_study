package com.cyx.spring._17_static_proxy;

import com.cyx.spring._17_static_proxy.domain.Employee;
import com.cyx.spring._17_static_proxy.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class StaticProxyTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @DisplayName("使用静态代理模拟事务管理：保存操作")
    void testSaveEmployee() {
        employeeService.saveEmployee(new Employee());
    }

    @Test
    @DisplayName("使用静态代理模拟事务管理：保存操作")
    void testUpdateEmployee() {
        employeeService.updateEmployee(new Employee());
    }

}
