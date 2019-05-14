package com.cyx.spring._21_aop_xml;

import com.cyx.spring._21_aop_xml.domain.Employee;
import com.cyx.spring._21_aop_xml.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class AOPByXMLTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @DisplayName("使用 XML 配置 AOP")
    void testSaveEmployee() {
        employeeService.saveEmployee(new Employee());
    }

    @Test()
    @DisplayName("使用 XML 配置 AOP")
    void testUpdateEmployee() {
        // 使用断言确认发生异常
        Assertions.assertThrows(RuntimeException.class, () -> employeeService.updateEmployee(new Employee()));
    }

}
