package com.cyx.spring._20_interceptor.dao.impl;

import com.cyx.spring._20_interceptor.dao.EmployeeDAO;
import com.cyx.spring._20_interceptor.domain.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

    // 模拟保存操作
    @Override
    public void insertEmployee(Employee employee) {
        System.out.println("保存员工···");
    }

    // 模拟修改操作
    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("修改员工···");
    }
}
