package com.cyx.spring._09_di_constructor;

public class HBeanValue {

    private String name;
    private Integer age;

    public HBeanValue(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "HBeanValue{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}