package com.cyx.spring._20_interceptor.service;

import com.cyx.spring._20_interceptor.dao.EmployeeDAO;
import com.cyx.spring._20_interceptor.domain.Employee;
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
        System.out.println("修改成功···");
    }
}
