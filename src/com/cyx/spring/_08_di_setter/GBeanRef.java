package com.cyx.spring._08_di_setter;

import lombok.Setter;

@Setter
public class GBeanRef {

    private GBeanDependency dependency;

    @Override
    public String toString() {
        return "GBeanRef{" +
                "dependency=" + dependency +
                '}';
    }
}
