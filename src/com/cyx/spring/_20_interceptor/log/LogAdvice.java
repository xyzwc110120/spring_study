package com.cyx.spring._20_interceptor.log;

import lombok.Setter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 日志增强
// 实现方法拦截器接口：org.aopalliance.intercept.MethodInvocation，该接口继承了 public interface Callback 接口
public class LogAdvice implements MethodInterceptor {

    // 真实对象
    @Setter
    private Object target;

    @Setter
    private LogUtil logUtil;

    public <T> T getProxyObject() {
        // 创建代理对象
        return (T) Enhancer.create(target.getClass(), this);
    }


    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Exception {
        logUtil.writeLog(method.getDeclaringClass().getName(), method.getName());
        return method.invoke(target, args);
    }
}
