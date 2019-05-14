package com.cyx.spring._18_dynamic_proxy_jdk;

import com.cyx.spring._18_dynamic_proxy_jdk.domain.Employee;
import com.cyx.spring._18_dynamic_proxy_jdk.service.EmployeeService;
import com.cyx.spring._18_dynamic_proxy_jdk.tx.TransactionManagerAdvice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class DynamicProxyByJDKTest {

    @Autowired
    private TransactionManagerAdvice advice;

    @Test
    @DisplayName("使用静态代理模拟事务管理：保存操作")
    void testSaveEmployee() {
        // 获取代理对象
        EmployeeService employeeService = advice.getProxyObject();
        employeeService.saveEmployee(new Employee());

    }

    @Test
    @DisplayName("使用静态代理模拟事务管理：保存操作")
    void testUpdateEmployee() {
        EmployeeService employeeService = advice.getProxyObject();
        employeeService.updateEmployee(new Employee());
    }

}
