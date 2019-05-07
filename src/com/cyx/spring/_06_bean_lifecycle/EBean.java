package com.cyx.spring._06_bean_lifecycle;

public class EBean {

    public EBean() {
        System.out.println("实例化 EBean···");
    }

    public void init() {
        System.out.println("初始化方法···");
    }

    public void doWork() {
        System.out.println("开始工作···");
    }

    public void close() {
        System.out.println("释放资源···");
    }
}