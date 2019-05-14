package com.cyx.spring._19_dynamic_proxy_cglib.tx;

import lombok.Setter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

// 事务增强操作
// Spring 已经集成了 CGLIB，并且为了容易上手，也提供了一个与 JDK 动态代理一样的接口 org.springframework.cglib.proxy.InvocationHandler
// 该接口继承了 public interface Callback 接口
public class TransactionManagerAdvice implements InvocationHandler {

    // 真实对象
    @Setter
    private Object target;

    // 事务管理器
    @Setter
    private TransactionManager transactionManager;

    public <T> T getProxyObject() {
        // 创建一个代理对象
        Enhancer enhancer = new Enhancer();
        // 继承哪一个类去做增强（CGLIB原理：动态生成一个要代理类的子类，子类重写要代理的类的所有不是final的方法。）
        enhancer.setSuperclass(target.getClass());
        // 设置增强对象（InvocationHandler 接口继承的 Callback 接口：public interface InvocationHandler extends Callback）
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object ret = null;
        transactionManager.begin();
        try {
            ret = method.invoke(target, args);
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
        return ret;
    }
}
