package com.cyx.spring._22_aop_annotation.tx;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component      // 该类交由 Spring 容器管理
@Aspect         // 配置一个切面
public class TransactionManager {

    // 配置切入点
    // XML 配置：<aop:pointcut id="txManagerPoint" expression="execution(* com.cyx.spring._21_aop_xml.service.*Service.*(..))" />
    @Pointcut(value = "execution(* com.cyx.spring._22_aop_annotation.service.*Service.*(..))")
    public void txManager() {
    }

    @Before("txManager()")
    public void begin() {
        System.out.println("开始事务···");
    }

    @AfterReturning("txManager()")
    public void commit() {
        System.out.println("提交事务···");
    }

    @AfterThrowing(value = "txManager()", throwing = "exception")
    public void rollback(Throwable exception) {
        System.out.println("回滚事务···");
        System.out.println("异常信息：" + exception.getMessage());
    }

    @After("txManager()")
    public void close() {
        System.out.println("释放资源···");
    }

    /*
        @Around("txManager()")
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
    */

}
