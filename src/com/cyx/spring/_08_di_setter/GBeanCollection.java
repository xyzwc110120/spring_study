package com.cyx.spring._08_di_setter;

import lombok.Setter;

import java.util.*;

@Setter
public class GBeanCollection {

    private Set<String> set;
    private List<String> list;
    private String[] arrays;
    private Map<String, Object> map;
    private Properties properties;

    @Override
    public String toString() {
        return "GBeanCollection{" +
                "\n    set=" + set +
                ",\n    list=" + list +
                ",\n    arrays=" + Arrays.toString(arrays) +
                ",\n    map=" + map +
                ",\n    properties=" + properties +
                "\n}";
    }
}
