package com.cyx.spring._01_hello_world;

public class HelloWorld {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("你的名字是：" + name);
    }
}
