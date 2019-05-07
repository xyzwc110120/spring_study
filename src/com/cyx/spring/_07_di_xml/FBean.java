package com.cyx.spring._07_di_xml;

public class FBean {

    private FBeanDependency dependency;

    public FBean(FBeanDependency dependency) {
        this.dependency = dependency;
    }

    public void setDependency(FBeanDependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return "FBean{" +
                "dependency=" + dependency +
                '}';
    }
}
