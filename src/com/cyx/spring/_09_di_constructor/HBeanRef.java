package com.cyx.spring._09_di_constructor;

public class HBeanRef {

    private HBeanDependency dependency;

    public HBeanRef(HBeanDependency hBeanDependency) {
        dependency = hBeanDependency;
    }

    @Override
    public String toString() {
        return "HBeanRef{" +
                "dependency=" + dependency +
                '}';
    }
}
