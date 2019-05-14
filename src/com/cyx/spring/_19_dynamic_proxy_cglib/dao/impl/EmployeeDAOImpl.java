package com.cyx.spring._19_dynamic_proxy_cglib.dao.impl;

import com.cyx.spring._19_dynamic_proxy_cglib.dao.EmployeeDAO;
import com.cyx.spring._19_dynamic_proxy_cglib.domain.Employee;

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
