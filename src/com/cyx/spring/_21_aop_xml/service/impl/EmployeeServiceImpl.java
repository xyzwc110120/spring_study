package com.cyx.spring._21_aop_xml.service.impl;

import com.cyx.spring._21_aop_xml.domain.Employee;
import com.cyx.spring._21_aop_xml.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void saveEmployee(Employee employee) {
        System.out.println("保存操作···");
        System.out.println("保存成功···");
    }

    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("修改操作···");
        // 手动抛出异常
        throw new RuntimeException("出现异常···");
    }
}
