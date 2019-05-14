package com.cyx.spring._22_aop_annotation.service;

import com.cyx.spring._22_aop_annotation.domain.Employee;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

}
