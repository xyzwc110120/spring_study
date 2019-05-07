package com.cyx.spring._09_di_constructor;

import java.util.*;

public class HBeanCollection {

    private Set<String> set;
    private List<String> list;
    private String[] arrays;
    private Map<String, Object> map;
    private Properties properties;

    public HBeanCollection(Set<String> set, List<String> list, String[] arrays, Map<String, Object> map, Properties properties) {
        this.set = set;
        this.list = list;
        this.arrays = arrays;
        this.map = map;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "HBeanCollection{" +
                "\n    set=" + set +
                ",\n    list=" + list +
                ",\n    arrays=" + Arrays.toString(arrays) +
                ",\n    map=" + map +
                ",\n    properties=" + properties +
                "\n}";
    }
}
