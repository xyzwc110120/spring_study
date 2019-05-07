package com.cyx.spring._03_container;

public class BBean {

    private BBean() {
        System.out.println("实例化 BBean···");
    }

    public void doWork() {
        System.out.println("开始工作了");
    }
}