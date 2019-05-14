package com.cyx.spring._18_dynamic_proxy_jdk.service;

import com.cyx.spring._18_dynamic_proxy_jdk.domain.Employee;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

}
