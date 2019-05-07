package com.cyx.spring._17_static_proxy.proxy;

import com.cyx.spring._17_static_proxy.domain.Employee;
import com.cyx.spring._17_static_proxy.service.EmployeeService;
import com.cyx.spring._17_static_proxy.tx.TransactionManager;
import lombok.Setter;

// 静态代理类
public class EmployeeServiceProxy implements EmployeeService {

    // 事务管理器
    @Setter
    private TransactionManager transactionManager;

    // 真实对象 / 委托对象
    @Setter
    private EmployeeService employeeService;

    @Override
    public void saveEmployee(Employee employee) {
        transactionManager.begin();
        try {
            employeeService.saveEmployee(employee);
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        transactionManager.begin();
        try {
            employeeService.updateEmployee(employee);
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
    }
}
