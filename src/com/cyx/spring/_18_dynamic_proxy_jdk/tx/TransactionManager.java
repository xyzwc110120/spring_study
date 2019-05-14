package com.cyx.spring._18_dynamic_proxy_jdk.tx;

// 事务管理器
public class TransactionManager {

    public void begin() {
        System.out.println("开始事务···");
    }

    public void commit() {
        System.out.println("提交事务···");
    }

    public void rollback() {
        System.out.println("回滚事务···");
    }

}
