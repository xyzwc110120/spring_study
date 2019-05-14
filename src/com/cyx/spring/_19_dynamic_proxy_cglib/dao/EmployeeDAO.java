package com.cyx.spring._19_dynamic_proxy_cglib.dao;

import com.cyx.spring._19_dynamic_proxy_cglib.domain.Employee;

public interface EmployeeDAO {

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

}
