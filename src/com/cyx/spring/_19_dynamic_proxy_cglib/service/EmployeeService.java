package com.cyx.spring._19_dynamic_proxy_cglib.service;

import com.cyx.spring._19_dynamic_proxy_cglib.dao.EmployeeDAO;
import com.cyx.spring._19_dynamic_proxy_cglib.domain.Employee;
import lombok.Setter;

public class EmployeeService {

    @Setter
    private EmployeeDAO employeeDAO;

    public void saveEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
        System.out.println("保存成功···");
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
        // 手动抛出异常
        throw new RuntimeException("出现异常···");
    }
}
