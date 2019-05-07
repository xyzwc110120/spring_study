package com.cyx.spring._08_di_setter;

import lombok.Setter;

@Setter
public class GBeanValue {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "GBeanValue{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
