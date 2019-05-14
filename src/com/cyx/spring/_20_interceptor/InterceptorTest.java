package com.cyx.spring._20_interceptor;

import com.cyx.spring._20_interceptor.domain.Employee;
import com.cyx.spring._20_interceptor.log.LogAdvice;
import com.cyx.spring._20_interceptor.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class InterceptorTest {

    @Autowired
    private LogAdvice advice;

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
