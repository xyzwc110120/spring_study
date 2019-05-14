package com.cyx.spring._21_aop_xml.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

// 事务管理器
public class TransactionManager {

    /*
        获取被增强方法信息，并传递给增强方法：
            Spring AOP 提供 org.aspectj.lang.JoinPoint 类（注意不要引错成其它包的 JoinPoint 类），并且要作为增强方法的第一个参数。

            JoinPoint 类：提供访问当前被增强方法的真实对象、代理对象、方法参数等数据。
            ProceedingJoinPoint 类：JoinPoint 的子类，只用于环绕增强中，可以处理被增强方法。
    */

    public void begin(JoinPoint point) {
        System.out.println("代理对象：" + point.getThis().getClass());
        System.out.println("真实对象：" + point.getTarget().getClass());
        System.out.println("连接点方法签名：" + point.getSignature());
        System.out.println("被增强方法的参数：" + Arrays.toString(point.getArgs()));
        System.out.println("当前连接点的类型：" + point.getKind());

        System.out.println("开始事务···");
    }

    public void commit() {
        System.out.println("提交事务···");
    }

    public void rollback(JoinPoint point, Throwable exception) {
        System.out.println("回滚事务···");
        System.out.println("异常信息：" + exception.getMessage());
    }

    public void close() {
        System.out.println("释放资源···");
    }

    public Object aroundMethod(ProceedingJoinPoint point) {
        Object ret = null;
        System.out.println("环绕增强：开始事务···");
        try {
            // 执行被增强方法
            ret = point.proceed();
            System.out.println("环绕增强：提交事务···");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕增强：回滚事务···");
        } finally {
            System.out.println("环绕增强：释放资源···");
        }
        return ret;
    }

}
