package com.cyx.spring._17_static_proxy.service.impl;

import com.cyx.spring._17_static_proxy.dao.EmployeeDAO;
import com.cyx.spring._17_static_proxy.domain.Employee;
import com.cyx.spring._17_static_proxy.service.EmployeeService;
import lombok.Setter;

public class EmployeeServiceImpl implements EmployeeService {

    @Setter
    private EmployeeDAO employeeDAO;

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
        System.out.println("保存成功···");
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
        // 手动抛出异常
        throw new RuntimeException("出现异常···");
    }
}
