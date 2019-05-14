package com.cyx.spring._18_dynamic_proxy_jdk.tx;

import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 事务增强操作
public class TransactionManagerAdvice implements InvocationHandler {

    // 真实对象
    @Setter
    private Object target;

    // 事务管理器
    @Setter
    private TransactionManager transactionManager;

    public <T> T getProxyObject() {
        /*
            java.lang.reflect.Proxy 类：
                Proxy 提供用于创建动态代理类和实例的静态方法。

                Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 方法：
                    返回一个指定接口的代理类实例。
                    参数：
                        loader：定义代理类的类加载器，一般跟上真实对象的类加载器；
                        interfaces：代理类要实现的接口列表，真实对象所实现的接口（JDK 动态代理必须要求真实对象有接口）；
                        h：InvocationHandler 的实现类，在里面做代理对象需要做的详细操作。
        */
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }


    /**
        定义一个内部类实现 InvocationHandler 接口，在覆盖 invoke 方法在里面做具体的增强操作：
            class TransactionManagerHandler implements InvocationHandler {

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return null;
            }

        但是我们可以直接实现 InvocationHandler 接口，这样就不用创建一个内部类。
    }*/

    // 如何为真实对象做增强的具体操作
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Object ret = null;
        transactionManager.begin();
        try {
            /* 调用真实对象的方法 */
            ret = method.invoke(target, args);
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback();
        }
        return ret;
    }
}
