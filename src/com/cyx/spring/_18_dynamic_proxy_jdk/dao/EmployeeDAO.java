package com.cyx.spring._18_dynamic_proxy_jdk.dao;

import com.cyx.spring._18_dynamic_proxy_jdk.domain.Employee;

public interface EmployeeDAO {

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

}
